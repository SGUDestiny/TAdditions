package net.tadditions.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.PrioritizedGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SEntityVelocityPacket;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.concurrent.TickDelayedTask;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.network.NetworkHooks;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.entity.DoorEntity;
import net.tardis.mod.entity.ai.FollowOutOfTardisGoal;
import net.tardis.mod.enums.EnumDoorState;
import net.tardis.mod.events.LivingEvents;
import net.tardis.mod.helper.Helper;
import net.tardis.mod.helper.LandingSystem;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.misc.IDoorType;
import net.tardis.mod.misc.SpaceTimeCoord;
import net.tardis.mod.registries.TardisStatistics;
import net.tardis.mod.subsystem.ShieldGeneratorSubsystem;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;
import net.tardis.mod.world.dimensions.TDimensions;
import org.spongepowered.asm.mixin.Mixin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static net.tardis.mod.entity.DoorEntity.STATE;
import static net.tardis.mod.entity.DoorEntity.SUCC;

@Mixin(DoorEntity.class)
public class DoorMixin extends Entity{

    public IDoorType doorType = IDoorType.EnumDoorType.STEAM;
    private List<UUID> teleportImmune = new ArrayList<>();
    private boolean isLocked = false;
    private int additionalLockLevel = 0;
    private float health = 10;

    public DoorMixin(EntityType<?> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
    }

    @Override
    protected void registerData() {
        ((DoorEntity) (Object) this).getDataManager().register(STATE, EnumDoorState.CLOSED.ordinal());
        ((DoorEntity) (Object) this).getDataManager().register(SUCC, false);
    }

    @Override
    protected void readAdditional(CompoundNBT compound) {
        ((DoorEntity) (Object) this).getDataManager().set(STATE, compound.getInt("door_state"));
        ((DoorEntity) (Object) this).getDataManager().set(SUCC, compound.getBoolean("succ"));
        this.isLocked = compound.getBoolean("locked");
        this.additionalLockLevel = compound.getInt("additional_lock_level");
    }

    @Override
    protected void writeAdditional(CompoundNBT compound) {
        compound.putInt("door_state", ((DoorEntity) (Object) this).getDataManager().get(STATE));
        compound.putBoolean("locked", ((DoorEntity) (Object) this).isLocked());
        compound.putBoolean("succ", ((DoorEntity) (Object) this).getDataManager().get(SUCC));
        compound.putInt("additional_lock_level", this.additionalLockLevel);
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void tick() {
        super.tick();

        //If console is null, none of this should happen
        ConsoleTile console = ((DoorEntity) (Object) this).getConsole();
        if (console == null)
            return;

        if (!world.isRemote) {
            //Teleport entities

            if (((DoorEntity) (Object) this).getOpenState() != EnumDoorState.CLOSED && this.ticksExisted> 5) {
                List<Entity> entities = world.getEntitiesWithinAABB(Entity.class, ((DoorEntity) (Object) this).getDoorBB().offset(this.getPositionVec()));
                List<UUID> list = new ArrayList<UUID>();
                this.teleportEntity(entities);
                for (Entity e : entities) {
                    if (this.teleportImmune.contains(e.getUniqueID()))
                        list.add(e.getUniqueID());
                }
                this.teleportImmune = list;
            }

            //Suck if in a space dim
            if (world.getGameTime() % 100 == 0)
                ((DoorEntity) (Object) this).handleSucking();

            //Interdimensional Fluids
            if (world.getGameTime() % 20 == 0) {
                ServerWorld otherW = world.getServer().getWorld(console.getCurrentDimension());
                ShieldGeneratorSubsystem shield = console.getSubsystem(ShieldGeneratorSubsystem.class).orElse(null);
                if (((DoorEntity) (Object) this).getOpenState() != EnumDoorState.CLOSED && shield != null && !shield.isActivated()) {
                    BlockPos bottomBlock = console.getCurrentLocation().offset(console.getTrueExteriorFacingDirection());
                    BlockPos topBlock = console.getCurrentLocation().offset(console.getTrueExteriorFacingDirection());
                    FluidState topFluid = otherW.getFluidState(topBlock);
                    FluidState bottomFluid = otherW.getFluidState(bottomBlock);
                    WorldHelper.setFluidStateIfNot(topFluid, world, this.getPosition().up());
                    WorldHelper.setFluidStateIfNot(Fluids.EMPTY.getDefaultState(), otherW, topBlock);
                    WorldHelper.setFluidStateIfNot(bottomFluid, world, this.getPosition());
                    WorldHelper.setFluidStateIfNot(Fluids.EMPTY.getDefaultState(), otherW, bottomBlock);

                } else {
                    WorldHelper.setFluidStateIfNot(Fluids.EMPTY.getDefaultState(), world, this.getPosition());
                    WorldHelper.setFluidStateIfNot(Fluids.EMPTY.getDefaultState(), world, this.getPosition().up());
                }
            }

        }
        this.doorType = console.getExteriorType().getDoorType();

        if ((console.isInFlight() || this.getDataManager().get(SUCC)) && ((DoorEntity) (Object) this).getOpenState() != EnumDoorState.CLOSED) {
            ((DoorEntity) (Object) this).suckIntoVoid();
        }

    }

    private void teleportEntity(List<Entity> entity) {
        ConsoleTile console = ((DoorEntity) (Object) this).getConsole();
        if (console == null)
            return;

        world.getServer().enqueue(new TickDelayedTask(1, () -> {

            for (Entity e : entity) {
                if (!(e instanceof DoorEntity)) {

                    if (console.isInFlight()) {

                        if (e instanceof PlayerEntity) {
                            if (console.getEmotionHandler().getLoyalty(e.getUniqueID())> 50) {
                                ((DoorEntity) (Object) this).setOpenState(EnumDoorState.CLOSED);
                                continue;
                            } else if (console.getEmotionHandler().getLoyalty(e.getUniqueID())> 25) {
                                console.initLand();
                                ((PlayerEntity) e).abilities.isFlying = false;
                                if(!((PlayerEntity) e).isCreative()) {
                                    ((PlayerEntity) e).abilities.allowFlying = false;
                                }
                                ((PlayerEntity) e).sendPlayerAbilities();
                            }
                        }

                        BlockPos diff = console.getDestinationPosition().subtract(console.getCurrentLocation());
                        double scale = console.getPercentageJourney();
                        RegistryKey<World> type = scale> 0.5 ? console.getDestinationDimension() : console.getCurrentDimension();
                        ChunkPos cPos = new ChunkPos(console.getCurrentLocation());
                        ServerWorld sWorld = world.getServer().getWorld(type);

                        WorldHelper.forceChunkIfNotLoaded(sWorld, cPos, console.getCurrentLocation());
                        BlockPos targetPos = LandingSystem.getTopBlock(sWorld, console.getCurrentLocation().add(new BlockPos(diff.getX() * scale, diff.getY() * scale, diff.getZ() * scale)));
                        SpaceTimeCoord target = new SpaceTimeCoord(type, targetPos);
                        WorldHelper.unForceChunkIfLoaded(sWorld, cPos, console.getCurrentLocation());

                        if (e instanceof LivingEntity)
                            MinecraftForge.EVENT_BUS.post(new LivingEvents.TardisLeaveEvent((LivingEntity) e, ((DoorEntity) (Object) this), world.getServer().getWorld(type)));

                        //The big Succ
                        e.getCapability(Capabilities.PLAYER_DATA).ifPresent(cap -> {
                            cap.setDestination(target);
                            WorldHelper.teleportEntities(e, world.getServer().getWorld(TDimensions.VORTEX_DIM), 0, 128, 0, e.rotationYaw, e.rotationPitch);
                            if (e instanceof PlayerEntity)
                                Helper.addTardisStatistic((PlayerEntity)e, TardisStatistics.VORTEX_TRAVEL_COUNT);
                        });

                        //Suckout non- players too
                        if (!e.getCapability(Capabilities.PLAYER_DATA).isPresent()) {
                            WorldHelper.teleportEntities(e, world.getServer().getWorld(WorldHelper.getWorldKeyFromRL(target.getDimRL())), target.getPos().getX() + 0.5, target.getPos().getY() + 1, target.getPos().getZ() + 0.5, e.rotationYaw, e.rotationPitch);
                        }

                        return;
                    }

                    if (this.teleportImmune.contains(e.getUniqueID()))
                        continue;

                    ExteriorTile ext = console.getExteriorType().getExteriorTile(console);
                    if (ext != null)
                        ext.addTeleportedEntity(e.getUniqueID());

                    Vector3d oldMotion = e.getMotion();

                    ServerWorld destWorld = world.getServer().getWorld(console.getCurrentDimension());

                    Direction dir = console.getTrueExteriorFacingDirection();

                    float diff = WorldHelper.getFixedRotation(e.rotationYaw) - WorldHelper.getFixedRotation(this.rotationYaw);//(e.rotationYaw % 360.0F) - this.rotationYaw % 360.0F;

                    float realFacing = WorldHelper.getAngleFromFacing(dir.getOpposite()) + diff;

                    BlockPos pos = console.getCurrentLocation().offset(dir);
                    e.rotationYaw = WorldHelper.getAngleFromFacing(dir.getOpposite());

                    if (e instanceof LivingEntity)
                        MinecraftForge.EVENT_BUS.post(new LivingEvents.TardisLeaveEvent((LivingEntity) e, ((DoorEntity) (Object) this), world.getServer().getWorld(console.getCurrentDimension())));

                    WorldHelper.teleportEntities(e, destWorld, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, realFacing, e.rotationPitch);

                    //Follow out of TARDIS
                    if (e instanceof PlayerEntity) {
                        for (MonsterEntity ent : world.getEntitiesWithinAABB(MonsterEntity.class, new AxisAlignedBB(this.getPosition()).grow(20))) {
                            if (ent.getAttackTarget() == e) {
                                for (PrioritizedGoal goal : ent.goalSelector.goals) {
                                    if (goal.getGoal() instanceof FollowOutOfTardisGoal) {
                                        ((FollowOutOfTardisGoal) goal.getGoal()).setTarget(this.getPosition());
                                    }
                                }
                            }
                        }
                    }

                    if (e instanceof PlayerEntity && console.getEntity() != null) {
                        e.startRiding(console.getEntity());
                    }
                    if(e instanceof PlayerEntity){
                        ((PlayerEntity) e).abilities.isFlying = false;
                        if(!((PlayerEntity) e).isCreative()) {
                            ((PlayerEntity) e).abilities.allowFlying = false;
                        }
                        ((PlayerEntity) e).sendPlayerAbilities();
                    }

                    Vector3d setMot = oldMotion.rotateYaw(-(float) Math.toRadians(realFacing));

                    world.getServer().enqueue(new TickDelayedTask(2, () -> {
                        Entity ent = destWorld.getEntityByUuid(e.getUniqueID());
                        if (ent != null)
                            ent.setMotion(setMot);
                        if (ent instanceof ServerPlayerEntity) {
                            ((ServerPlayerEntity) ent).connection.sendPacket(new SEntityVelocityPacket(ent));
                        }
                    }));

                }
            }

        }));
    }

}
