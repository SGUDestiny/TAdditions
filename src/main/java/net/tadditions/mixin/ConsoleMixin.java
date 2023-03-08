package net.tadditions.mixin;

import com.google.common.collect.Maps;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.helper.IConsoleHelp;
import net.tadditions.mod.upgrades.FrameStabUpgrade;
import net.tadditions.mod.world.MDimensions;
import net.tardis.mod.ars.ConsoleRoom;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.config.TConfig;
import net.tardis.mod.entity.ControlEntity;
import net.tardis.mod.entity.TardisEntity;
import net.tardis.mod.exterior.AbstractExterior;
import net.tardis.mod.flight.FlightEvent;
import net.tardis.mod.flight.TardisCollideInstigate;
import net.tardis.mod.flight.TardisCollideRecieve;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.misc.*;
import net.tardis.mod.network.Network;
import net.tardis.mod.network.packets.ConsoleUpdateMessage;
import net.tardis.mod.network.packets.console.DataTypes;
import net.tardis.mod.network.packets.console.Fuel;
import net.tardis.mod.registries.*;
import net.tardis.mod.sounds.AbstractSoundScheme;
import net.tardis.mod.subsystem.FlightSubsystem;
import net.tardis.mod.subsystem.StabilizerSubsystem;
import net.tardis.mod.subsystem.Subsystem;
import net.tardis.mod.subsystem.SubsystemEntry;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.console.misc.*;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;
import net.tardis.mod.upgrades.Upgrade;
import net.tardis.mod.upgrades.UpgradeEntry;
import org.spongepowered.asm.mixin.Mixin;

import java.util.*;

import static net.tardis.mod.tileentities.ConsoleTile.rand;

@Mixin(ConsoleTile.class)
public class ConsoleMixin extends TileEntity implements IConsoleHelp {

    public int flightTicks = 0;
    private int reachDestinationTick = 0;
    private EmotionHandler emotionHandler;
    private InteriorManager interiorManager;
    private List<PlayerEntity> players = new ArrayList<PlayerEntity>();
    private List<ITickable> tickers = new ArrayList<ITickable>();
    private HashMap<ResourceLocation, INBTSerializable<CompoundNBT>> dataHandlers = new HashMap<ResourceLocation, INBTSerializable<CompoundNBT>>();
    private ArrayList<ControlEntity> controls = new ArrayList<ControlEntity>();
    private ArrayList<ControlRegistry.ControlEntry> controlEntries = new ArrayList<ControlRegistry.ControlEntry>();
    private AbstractExterior exterior;
    private AbstractSoundScheme scheme;
    private BlockPos location = BlockPos.ZERO;
    private BlockPos destination = BlockPos.ZERO;
    private RegistryKey<World> dimension;
    private RegistryKey<World> destinationDimension;
    private Direction facing = Direction.NORTH;
    private float max_artron = 0;
    private float artron = 0;
    private float rechargeMod = 1F;
    private ConsoleRoom consoleRoom = ConsoleRoom.STEAM;
    private List<Subsystem> subsystems = new ArrayList<>();
    private List<Upgrade> upgrades = new ArrayList<>();
    private String customName = "";
    private ExteriorPropertyManager exteriorProps;
    private SpaceTimeCoord returnLocation = SpaceTimeCoord.UNIVERAL_CENTER;
    private FlightEvent currentEvent = null;
    private List<DistressSignal> distressSignal = new ArrayList<DistressSignal>();
    private ItemStack sonic = ItemStack.EMPTY;
    protected TexVariant[] variants = {};
    private int variant = 0;
    private boolean antiGravs = false;
    private boolean intGravs = false;
    private UUID tardisEntityID = null;
    private TardisEntity tardisEntity = null;
    private SparkingLevel sparkLevel = SparkingLevel.NONE;
    private String landingCode = "";
    private int landTime = 0;
    private HashMap<ArtronUse.IArtronType, ArtronUse> artronUses = Maps.newHashMap();
    private LazyOptional<ExteriorTile> exteriorHolder = LazyOptional.empty();
    private boolean dimData = false;
    private UnlockManager unlockManager;
    protected HashMap<Class<?>, ControlOverride> controlOverrides = Maps.newHashMap();
    private boolean hasPoweredDown = false;
    private boolean hasNavCom = false;
    private boolean isBeingTowed = false;
    private BlockPos takeoffLocation = BlockPos.ZERO;
    /**
     * If the console has been force loaded. Internal use only
     */
    private boolean hasForcedChunksToRemove = false;

    /**
     * If this Tardis console should start changing its interior
     */
    private boolean shouldStartChangingInterior = false;
    /**
     * The ConsoleRoom that we will be changing the current to
     */
    private ConsoleRoom nextRoomToChange = ConsoleRoom.STEAM;

    /**
     * What ever you do do not save / sync this (If you use onLoad() the world won't load)
     */
    private int timeUntilControlSpawn = 10;

    /**
     * Last player to interact with a control, used for loyalty
     */
    private PlayerEntity pilot;

    /**
     * Data handlers Read from this
     */
    private Runnable onLoadAction;

    public ConsoleMixin(TileEntityType<?> type) {
        super(type);
        this.emotionHandler = new EmotionHandler(((ConsoleTile) (Object) this));
        this.interiorManager = new InteriorManager(((ConsoleTile) (Object) this));
        this.exteriorProps = new ExteriorPropertyManager(((ConsoleTile) (Object) this));
        this.exterior = ExteriorRegistry.STEAMPUNK.get();
        this.dimension = World.OVERWORLD;
        this.destinationDimension = World.OVERWORLD;
        this.unlockManager = new UnlockManager(((ConsoleTile) (Object) this));
        this.scheme = SoundSchemeRegistry.BASIC.get();
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.HANDBRAKE.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.THROTTLE.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.RANDOM.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.DIMENSION.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.FACING.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.X.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.Y.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.Z.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.INC_MOD.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.LAND_TYPE.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.REFUELER.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.FAST_RETURN.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.TELEPATHIC.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.STABILIZERS.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.SONIC_PORT.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.COMMUNICATOR.get());
        ((ConsoleTile) (Object) this).registerControlEntry(ControlRegistry.DOOR.get());

        for (SubsystemEntry entry : SubsystemRegistry.SUBSYSTEM_REGISTRY.get().getValues()) {
            this.subsystems.add(entry.create(((ConsoleTile) (Object) this)));
        }

        for (UpgradeEntry entry : UpgradeRegistry.UPGRADE_REGISTRY.get().getValues()) {
            this.upgrades.add(entry.create(((ConsoleTile) (Object) this)));
        }

        ((ConsoleTile) (Object) this).registerControlOverrides();
    }


    public void read(BlockState state, CompoundNBT compound) {
        super.read(state, compound);
        //Things registered to save
        for (Map.Entry<ResourceLocation, INBTSerializable<CompoundNBT>> saved : this.dataHandlers.entrySet()) {
            saved.getValue().deserializeNBT(compound.getCompound(saved.getKey().toString()));
        }

        //Subsystems
        ListNBT subsystemList = compound.getList("subsystems", Constants.NBT.TAG_COMPOUND);
        for (INBT base : subsystemList) {
            CompoundNBT nbt = (CompoundNBT) base;
            ResourceLocation key = new ResourceLocation(nbt.getString("name"));
            ((ConsoleTile) (Object) this).getSubsystem(key).ifPresent(sys -> sys.deserializeNBT(nbt));
        }

        if (compound.contains("unlock_manager"))
            this.unlockManager.deserializeNBT(compound.getCompound("unlock_manager"));

        this.location = BlockPos.fromLong(compound.getLong("location"));
        this.destination = BlockPos.fromLong(compound.getLong("destination"));
        this.dimension = WorldHelper.getWorldKeyFromRL(new ResourceLocation(compound.getString("dimension")));
        this.destinationDimension = WorldHelper.getWorldKeyFromRL(new ResourceLocation(compound.getString("dest_dim")));
        this.flightTicks = compound.getInt("flight_ticks");
        this.reachDestinationTick = compound.getInt("max_flight_ticks");
        this.exterior = ExteriorRegistry.getExterior(new ResourceLocation(compound.getString("exterior")));
        this.artron = compound.getFloat("artron");
        if (compound.contains("console_room")) {
            ConsoleRoom room = ConsoleRoom.getRegistry().get(new ResourceLocation(compound.getString("console_room")));
            if (room != null)
                this.consoleRoom = room;
        }
        if (compound.contains("next_console_room")) {
            ConsoleRoom nextRoom = ConsoleRoom.getRegistry().get(new ResourceLocation(compound.getString("next_console_room")));
            if (nextRoom != null)
                this.nextRoomToChange = nextRoom;
        }

        this.customName = compound.getString("custom_name");
        this.returnLocation = SpaceTimeCoord.deserialize(compound.getCompound("return_pos"));
        this.facing = Direction.values()[compound.getInt("facing")];
        this.sonic = ItemStack.read(compound.getCompound("sonic_item"));
        ListNBT distressList = compound.getList("distress_list_initial", Constants.NBT.TAG_COMPOUND);
        this.distressSignal.clear();
        for (INBT dis : distressList) {
            this.distressSignal.add(DistressSignal.deserializeNBT((CompoundNBT) dis));
        }

        this.max_artron = compound.getFloat("max_artron");
        this.rechargeMod = compound.getFloat("recharge_modifier");
        this.variant = compound.getInt("texture_variant");
        this.antiGravs = compound.getBoolean("anti_gravs");
        this.antiGravs = compound.getBoolean("int_gravs");
        this.hasForcedChunksToRemove = compound.getBoolean("has_forced_chunks");
        this.hasNavCom = compound.getBoolean("nav_com");
        this.dimData = compound.getBoolean("dimdata");
        this.shouldStartChangingInterior = compound.getBoolean("start_changing_interior");

        ListNBT artronUsesList = compound.getList("artron_uses", Constants.NBT.TAG_COMPOUND);
        for (INBT base : artronUsesList) {
            CompoundNBT nbt = (CompoundNBT) base;
            ArtronUse use = ArtronUse.deserialiseNBT(nbt);
            ArtronUse.IArtronType type = use.getType();
            if (type != null) {
                this.artronUses.put(type, use);
            }
        }

        if (compound.contains("tardis_entity_id"))
            this.tardisEntityID = compound.getUniqueId("tardis_entity_id");
        this.sparkLevel = SparkingLevel.getFromIndex(compound.getInt("spark_level"));
        this.landingCode = compound.getString("landing_code");
        this.landTime = compound.getInt("landing_time");
        this.takeoffLocation = BlockPos.fromLong(compound.getLong("takeoff_location"));
        if (compound.contains("sound_scheme"))
            this.scheme = SoundSchemeRegistry.SOUND_SCHEME_REGISTRY.get().getValue(new ResourceLocation(compound.getString("sound_scheme")));

        this.onLoadAction = () -> {
            for (Map.Entry<ResourceLocation, INBTSerializable<CompoundNBT>> saved : this.dataHandlers.entrySet()) {
                saved.getValue().deserializeNBT(compound.getCompound(saved.getKey().toString()));
            }
        };
    }


    public CompoundNBT write(CompoundNBT compound) {
        for (Map.Entry<ResourceLocation, INBTSerializable<CompoundNBT>> entry : this.dataHandlers.entrySet()) {
            compound.put(entry.getKey().toString(), entry.getValue().serializeNBT());
        }

        //Subsystems
        ListNBT subsystemList = new ListNBT();
        for (Subsystem s : this.subsystems) {
            CompoundNBT nbt = s.serializeNBT();
            nbt.putString("name", s.getEntry().getRegistryName().toString());
            subsystemList.add(nbt);
        }
        compound.put("subsystems", subsystemList);

        compound.put("unlock_manager", this.unlockManager.serializeNBT());

        compound.putLong("location", this.location.toLong());
        compound.putLong("destination", this.destination.toLong());
        compound.putInt("flight_ticks", this.flightTicks);
        compound.putInt("max_flight_ticks", this.reachDestinationTick);
        compound.putString("exterior", this.exterior.getRegistryName().toString());
        compound.putString("dimension", this.dimension.getLocation().toString());
        compound.putString("dest_dim", this.destinationDimension.getLocation().toString());
        compound.putFloat("artron", this.artron);
        compound.putString("console_room", this.consoleRoom.getRegistryName().toString());
        compound.putString("next_console_room", this.nextRoomToChange.getRegistryName().toString());
        compound.putString("custom_name", this.customName);
        compound.put("return_pos", this.returnLocation.serialize());
        compound.putInt("facing", this.facing.ordinal());
        compound.putLong("takeoff_location", this.takeoffLocation.toLong());

        compound.put("sonic_item", this.sonic.serializeNBT());

        //SOSes
        ListNBT distress = new ListNBT();
        for (DistressSignal dis : this.distressSignal)
            distress.add(dis.serializeNBT());
        compound.put("distress_list_initial", distress);

        compound.putFloat("max_artron", this.max_artron);
        compound.putFloat("recharge_modifier", this.rechargeMod);
        compound.putInt("texture_variant", this.variant);
        compound.putBoolean("anti_gravs", this.antiGravs);
        compound.putBoolean("int_gravs", this.intGravs);
        if (this.tardisEntityID != null)
            compound.putUniqueId("tardis_entity_id", this.tardisEntityID);
        compound.putInt("spark_level", this.sparkLevel.ordinal());
        compound.putString("landing_code", this.landingCode);
        compound.putInt("landing_time", this.landTime);
        compound.putString("sound_scheme", this.scheme.getRegistryName().toString());
        compound.putBoolean("nav_com", this.hasNavCom);
        compound.putBoolean("dimdata", this.dimData);
        compound.putBoolean("has_forced_chunks", this.hasForcedChunksToRemove);
        compound.putBoolean("start_changing_interior", this.shouldStartChangingInterior);
        ListNBT artronUseList = new ListNBT();
        for (Map.Entry<ArtronUse.IArtronType, ArtronUse> entry : this.artronUses.entrySet()) {
            CompoundNBT nbt = entry.getValue().serialiseNBT();
            artronUseList.add(nbt);
        }
        compound.put("artron_uses", artronUseList);
        return super.write(compound);
    }

    @Override
    public boolean isDimOver() {
        return this.dimData;
    }

    @Override
    public void setDimOver(boolean DimOver) {
        this.dimData = DimOver;
        this.markDirty();
    }

  //  @Override
  //  public boolean getIntGrav() {
  //      return this.intGravs;
  //  }
  //
  //  @Override
  //  public void setIntGrav(boolean enabled) {
  //      this.intGravs = enabled;
  //      if (!world.isRemote) {
  //          ((ConsoleTile) (Object) this).getWorld().getPlayers().forEach(player -> {
  //              player.abilities.allowFlying = enabled;
  //              player.sendPlayerAbilities();
  //          });
  //          this.markDirty();
  //      }
  //  }

    public void fly() {
        if(((ConsoleTile) (Object) this).isInFlight()) {

            if(this.isDimOver() && ((ConsoleTile) (Object) this).getDestinationDimension() == MDimensions.TAGREA && ((ConsoleTile) (Object) this).getPercentageJourney() == 0.9 && ((ConsoleTile) (Object) this).getCurrentDimension() != MDimensions.TAGREA ) {
                if (!((ConsoleTile) (Object) this).getUpgrade(FrameStabUpgrade.class).isPresent()) {
                    ((ConsoleTile) (Object) this).crash(new CrashType(100, 0, true));
                    ((ConsoleTile) (Object) this).getInteriorManager().setAlarmOn(false);
                    ((ConsoleTile) (Object) this).getSubSystems().forEach(sub -> {
                        sub.damage(null, 38);
                    });
                    ((ConsoleTile) (Object) this).getSubsystem(FlightSubsystem.class).ifPresent(fly -> {
                        fly.damage(null, 650);
                    });
                    ((ConsoleTile) (Object) this).getInteriorManager().setMonitorOverrides(new MonitorOverride(((ConsoleTile) (Object) this), 600, String.valueOf(new TranslationTextComponent("warning.spatial_rupture").getString())));
                    ((ConsoleTile) (Object) this).onPowerDown(true);
                    ((ConsoleTile) (Object) this).getInteriorManager().setAlarmOn(true);
                }
                else ((ConsoleTile) (Object) this).getUpgrade(FrameStabUpgrade.class).ifPresent(up -> {up.damage(20, Upgrade.DamageType.ITEM,null);});
            }

            ((ConsoleTile) (Object) this).prevFlightTicks = this.flightTicks;
            ++this.flightTicks;

            if(((ConsoleTile) (Object) this).isLanding())
                this.location = ((ConsoleTile) (Object) this).getPositionInFlight().getPos();

            //If crashing, play crash effects
            if(((ConsoleTile) (Object) this).isCrashing())
                ((ConsoleTile) (Object) this).playCrashEffects();

            //Land if reached destination and stabilized
            if(!world.isRemote && this.flightTicks >= this.reachDestinationTick && landTime <= 0){
                if (this.isBeingTowed) {
                    ((ConsoleTile) (Object) this).initLand();
                }
                ((ConsoleTile) (Object) this).getSubsystem(StabilizerSubsystem.class).ifPresent(sys -> {
                    if(sys.isControlActivated()) {
                        //Only call land if we're not being towed.
                        //Prevents land being called twice, which could cause the Tardis' position to get recalculated
                        if (!this.isBeingTowed) {
                            ((ConsoleTile) (Object) this).initLand();
                        }
                    }
                });
            }

            if(!world.isRemote && this.flightTicks > this.landTime && this.landTime > 0) {
                this.flightTicks = this.reachDestinationTick = this.landTime = 0;
                ((ConsoleTile) (Object) this).updateClient();
            }

            //Crash if it can't fly
            if(!world.isRemote && !((ConsoleTile) (Object) this).canFly()) {
                ((ConsoleTile) (Object) this).crash(CrashTypes.DEFAULT);
                return;
            }

            //Artron usage
            if(!world.isRemote) {
                ArtronUse use = ((ConsoleTile) (Object) this).getOrCreateArtronUse(ArtronUse.ArtronType.FLIGHT);
                use.setArtronUsePerTick(((ConsoleTile) (Object) this).calcFuelUse());
                use.setTicksToDrain(1);

                if (this.flightTicks % 20 == 0) {
                    for (Subsystem sub : ((ConsoleTile) (Object) this).getSubSystems()) {
                        sub.onFlightSecond();
                    }
                    for (Upgrade up : ((ConsoleTile) (Object) this).getUpgrades()) {
                        up.onFlightSecond();
                    }
                }

                if(world.getGameTime() % 20 == 0)
                    Network.sendToAllAround(new ConsoleUpdateMessage(DataTypes.FUEL, new Fuel(this.artron, this.max_artron)), world.getDimensionKey(), this.getPos(), 20);

            }

            if (!world.isRemote) {

                //If this has an event and it's time, complete it
                if(!this.isBeingTowed && currentEvent != null && this.currentEvent.getMissedTime() < this.flightTicks) {
                    currentEvent.onComplete(((ConsoleTile) (Object) this));

                    //Search for collisions
                    this.currentEvent = null;

                    //If Not landing
                    if(this.landTime <= 0) {
                        ObjectWrapper<Boolean> collided = new ObjectWrapper<>(false);
                        Iterator<ServerWorld> it = world.getServer().getWorlds().iterator();
                        while(it.hasNext()) {
                            ServerWorld world = it.next();

                            //Stop if found one to collide with
                            if(collided.getValue())
                                break;

                            TardisHelper.getConsoleInWorld(world).ifPresent(tile -> {
                                //if unstabilized and not ourselves
                                ((ConsoleTile) (Object) this).getSubsystem(StabilizerSubsystem.class).ifPresent(sys -> {
                                    if(tile != ((ConsoleTile) (Object) this) && tile.isInFlight() && !sys.isControlActivated()) {
                                        //If not landing and not already colliding
                                        if(tile.getLandTime() == 0 && !(tile.getFlightEvent() instanceof TardisCollideInstigate) && !(tile.getFlightEvent() instanceof TardisCollideRecieve)) {
                                            if(tile.getPositionInFlight().getPos().withinDistance(((ConsoleTile) (Object) this).getPositionInFlight().getPos(), TConfig.SERVER.collisionRange.get())) {
                                                ((ConsoleTile) (Object) this).setFlightEvent(((TardisCollideInstigate)FlightEventRegistry.COLLIDE_INSTIGATE.get().create(((ConsoleTile) (Object) this))).setOtherTARDIS(tile));
                                                collided.setValue(true);
                                            }
                                        }
                                    }
                                });
                            });
                        }
                    }

                    if(((ConsoleTile) (Object) this).canGiveNewEvent() && this.currentEvent == null)
                        ((ConsoleTile) (Object) this).setFlightEvent(FlightEventRegistry.getRandomEvent(rand).create(((ConsoleTile) (Object) this)));

                }

                else if(this.currentEvent == null && ((ConsoleTile) (Object) this).canGiveNewEvent())
                    ((ConsoleTile) (Object) this).setFlightEvent(FlightEventRegistry.getRandomEvent(rand).create(((ConsoleTile) (Object) this)));

            }

            //Shake
            if(!world.isRemote && world.getGameTime() % 3 == 0) {
                if(this.currentEvent != null && !this.currentEvent.getControls().isEmpty())
                    for(PlayerEntity player : world.getPlayers()) {
                        player.getCapability(Capabilities.PLAYER_DATA).ifPresent(cap -> {
                            cap.setShaking(5);
                            cap.update();
                        });
                    }
            }
        }

        ((ConsoleTile) (Object) this).playFlightLoop();

        //Fuck TARDIS abusers
        if(!world.isRemote && this.sparkLevel != SparkingLevel.NONE && world.getGameTime() % 60 == 0) {
            if(((ConsoleTile) (Object) this).getEmotionHandler().getMood() > EmotionHandler.EnumHappyState.DISCONTENT.getTreshold())
                ((ConsoleTile) (Object) this).getEmotionHandler().addMood(-1);
        }


    }
}
