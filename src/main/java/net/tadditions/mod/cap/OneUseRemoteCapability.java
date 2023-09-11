package net.tadditions.mod.cap;

import net.minecraft.command.impl.LocateCommand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.concurrent.TickDelayedTask;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.tadditions.mod.config.MConfigs;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.controls.DimensionControl;
import net.tardis.mod.controls.HandbrakeControl;
import net.tardis.mod.controls.ThrottleControl;
import net.tardis.mod.helper.PlayerHelper;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.misc.SpaceTimeCoord;
import net.tardis.mod.sounds.TSounds;
import net.tardis.mod.subsystem.StabilizerSubsystem;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.world.dimensions.TDimensions;

import java.util.Objects;

public class OneUseRemoteCapability implements IOneRemote {


    private ConsoleTile tile;
    private ItemStack remote;
    private ResourceLocation tardis;
    private double dis = 70;
    
    //Client variables
    private double timeLeft = 0;
    private SpaceTimeCoord location = SpaceTimeCoord.UNIVERAL_CENTER;
    private boolean isInFlight;
    private float fuel = 0;

    public OneUseRemoteCapability(ItemStack stack) {
        this.remote = stack;
    }

    @Override
    public SpaceTimeCoord getExteriorLocation() {
        return this.location;
    }

    @Override
    public void setExteriorLocation(SpaceTimeCoord coord) {
        this.location = coord;

    }

    @Override
    public double getJourney() {
        return this.timeLeft;
    }

    @Override
    public void setJourneyTime(double time) {
        this.timeLeft = time;
    }

    @Override
    public void onClick(World world, PlayerEntity player, BlockPos pos) {
        if (!world.isRemote) {
            if (this.tardis != null) {
                this.findTardis(world);
                if (tile != null && !tile.isRemoved()) {
                    if (player.getEntityWorld() != tile.getWorld()) {
                        if (MConfigs.COMMON.OlimCallInOther.get() || WorldHelper.canTravelToDimension(player.getEntityWorld())) {
                            if (TardisHelper.isInATardis(player)) {
                                TardisHelper.getConsole(world.getServer(), world).ifPresent(tardise -> {
                                    dis = Math.sqrt(player.getDistanceSq(TardisHelper.TARDIS_POS.getX(), TardisHelper.TARDIS_POS.getY(), TardisHelper.TARDIS_POS.getZ()));
                                });
                            }
                            if (tile.canFly() && !tile.isLanding() && dis > 60) {
                                tile.setDestination(player.getEntityWorld().getDimensionKey(), pos.up());
                                tile.getControl(ThrottleControl.class).ifPresent(throttle -> throttle.setAmount(1.0F));
                                tile.getControl(HandbrakeControl.class).ifPresent(handbrake -> handbrake.setFree(true));
                                tile.getSubsystem(StabilizerSubsystem.class).ifPresent(sys -> sys.setControlActivated(true));
                                tile.setExteriorFacingDirection(player.getHorizontalFacing().getOpposite());
                                tile.takeoff();
                                tile.getWorld().getServer().enqueue(new TickDelayedTask(5, () -> {
                                    tile.setDestinationReachedTick(1);
                                }));
                                player.getEntityWorld().playSound(null, player.getPosition(), TSounds.REMOTE_ACCEPT.get(), SoundCategory.BLOCKS, 0.25F, 1F);
                            } else {
                                player.getEntityWorld().playSound(null, player.getPosition(), TSounds.CANT_START.get(), SoundCategory.BLOCKS, 0.25F, 1F);
                            }
                        }
                    }
                }
            }
        } else {
            PlayerHelper.sendMessageToPlayer(player, TardisConstants.Translations.ITEM_NOT_ATTUNED, true);
        }
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT tag = new CompoundNBT();
        if (this.tardis != null) {
            tag.putString("tardis", this.tardis.toString());
        }
        tag.putDouble("time_left", this.timeLeft);
        tag.put("loc", this.location.serialize());
        tag.putBoolean("is_flying", this.isInFlight);
        tag.putFloat("fuel", this.fuel);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        if (nbt.contains("tardis")) {
            this.tardis = new ResourceLocation(nbt.getString("tardis"));
        }
        if (nbt.contains("loc")) {
            this.location = SpaceTimeCoord.deserialize(nbt.getCompound("loc"));
        }
        this.timeLeft = nbt.getFloat("time_left");
        this.isInFlight = nbt.getBoolean("is_flying");
        this.fuel = nbt.getFloat("fuel");
    }

    @Override
    public void tick(World world, Entity ent) {
        if (!world.isRemote) {
            if (world.getGameTime() % 20 == 0) {
                this.findTardis(world);
                if (this.tile != null && tardis != null) {
                    this.setExteriorLocation(new SpaceTimeCoord(tile.getDestinationDimension(), tile.getDestinationPosition()));
                    this.setJourneyTime(tile.getPercentageJourney());
                    this.isInFlight = tile.isInFlight();
                    this.fuel = tile.getArtron();
                    this.serializeNBT();
                }
                if (tile != null && this.tardis != null) {
                    if (!WorldHelper.areDimensionTypesSame(ent.getEntityWorld(), TDimensions.DimensionTypes.TARDIS_TYPE)) { //Play an arrived sound if we aren't in the Tardis
                        if (tile.isInFlight() && tile.flightTicks == tile.getReachDestinationTick()) {
                            ent.getEntityWorld().playSound(null, ent.getPosition(), TSounds.REACHED_DESTINATION.get(), SoundCategory.BLOCKS, 1F, 1F); //Play a sound to entity if tardis has landed
                        }
                    }
                }
            }
        }

    }

    @Override
    public BlockPos getExteriorPos() {
        return this.location.getPos();
    }

    @Override
    public RegistryKey<World> getExteriorDim() {
        return this.location.getDim();
    }

    @Override
    public void findTardis(World world) {
        if(!world.isRemote) {
        	if (tile == null || tile.isRemoved()) {
                if(this.tardis != null) {
                	TardisHelper.getConsole(Objects.requireNonNull(world.getServer()), this.tardis).ifPresent(tile -> {
                		this.tile = tile;
                	});
                }
            }
        }
    }

    @Override
    public boolean isInFlight() {
        return this.isInFlight;
    }

    @Override
    public float getFuel() {
        return this.fuel;
    }

	@Override
	public ResourceLocation getTardis() {
		return this.tardis;
	}

	@Override
	public void setTardis(ResourceLocation tardis) {
		this.tardis = tardis;
	}
}
