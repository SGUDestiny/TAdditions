package net.tadditions.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.concurrent.TickDelayedTask;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.items.ItemStackHandler;
import net.tadditions.mod.helper.CloakState;
import net.tadditions.mod.helper.IConsoleHelp;
import net.tadditions.mod.helper.IExteriorHelp;
import net.tardis.mod.boti.WorldShell;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.client.animation.IExteriorAnimation;
import net.tardis.mod.energy.TardisEnergy;
import net.tardis.mod.entity.TardisEntity;
import net.tardis.mod.enums.EnumDoorState;
import net.tardis.mod.enums.EnumMatterState;
import net.tardis.mod.exterior.AbstractExterior;
import net.tardis.mod.helper.LandingSystem;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.network.packets.exterior.DoorData;
import net.tardis.mod.network.packets.exterior.ExteriorData;
import net.tardis.mod.registries.ExteriorAnimationRegistry;
import net.tardis.mod.registries.ExteriorRegistry;
import net.tardis.mod.sounds.TSounds;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.exteriors.DisguiseExteriorTile;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;
import java.util.List;

@Mixin(ExteriorTile.class)
public abstract class ExteriorMixin extends TileEntity implements IExteriorHelp {

    public ExteriorMixin(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    @Shadow(remap = false) public abstract void updateClient();

    @Shadow(remap = false) private boolean locked;
    @Shadow(remap = false) private EnumDoorState openState;
    @Shadow(remap = false) protected RegistryKey<World> interiorDimension;
    @Shadow(remap = false) private EnumMatterState matterState;
    @Shadow(remap = false) public float lightLevel;
    @Shadow(remap = false) private String customName;
    @Shadow(remap = false) private IExteriorAnimation animation;
    @Shadow(remap = false) private int variantIndex;
    @Shadow(remap = false) private boolean antiGravs;
    @Shadow(remap = false) private boolean hasDemated;
    @Shadow(remap = false) private boolean crashed;
    @Shadow(remap = false) private AbstractExterior exterior;
    @Shadow(remap = false) private int additionalLockLevel;
    @Shadow(remap = false) private boolean isInteriorRegenerating;
    @Shadow(remap = false) private int materializeTime;

    @Shadow(remap = false) public abstract void transferEntities(List<Entity> entityList);

    @Shadow(remap = false) public abstract AxisAlignedBB getDoorAABB();

    @Shadow(remap = false) public abstract void handleMaterializationAnimations();

    @Shadow(remap = false) @Nullable public abstract TardisEntity fall();

    @Shadow(remap = false) public abstract void pushPower();

    @Shadow(remap = false) private int consoleInFlightTicks;

    @Shadow(remap = false) public abstract void deleteExteriorBlocks();

    @Shadow(remap = false) private ItemStackHandler buffer;
    @Shadow(remap = false) private boolean hasSetupCaps;
    @Shadow(remap = false) private TardisEnergy energy;
    @Shadow(remap = false) private WorldShell shell;

    @Shadow(remap = false) public abstract void updateOrBuildBoti();

    @Shadow public abstract void updateSpecific(ExteriorData data);

    private CloakState cloakState = CloakState.UNCLOAKED;
    private int cloakAnimTime = 0;

    /**
     * @author mistersecret312
     * @reason gjtnjgtnjgnjhtgjn jgt
     */
    @Overwrite
    public void read(BlockState state, CompoundNBT compound) {
        this.locked = compound.getBoolean("locked");
        this.openState = EnumDoorState.valueOf(compound.getString("state"));
        if(compound.contains("interior"))
            this.interiorDimension = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(compound.getString("interior")));
        if(compound.contains("matter_state"))
            this.matterState = EnumMatterState.values()[compound.getInt("matter_state")];
        else matterState = EnumMatterState.SOLID;
        if(compound.contains("cloakState"))
            this.cloakState = CloakState.values()[compound.getInt("cloakState")];
        else cloakState = CloakState.UNCLOAKED;
        this.cloakAnimTime = compound.getInt("cloakAnimTime");
        this.lightLevel = compound.getFloat("light_level");
        this.customName = compound.getString("custom_name");
        this.animation = ExteriorAnimationRegistry.EXTERIOR_ANIMATION_REGISTRY.get().getValue(new ResourceLocation(compound.getString("animation")))
                .create(((ExteriorTile) (Object) this));
        this.variantIndex = compound.getInt("variant_index");
        this.antiGravs = compound.getBoolean("anti_grav");
        this.hasDemated = compound.getBoolean("has_demated");
        this.antiGravs = compound.getBoolean("anti_grav");
        this.crashed = compound.getBoolean("crashed");
        if(compound.contains("exterior_type"))
            this.exterior = ExteriorRegistry.getExterior(new ResourceLocation(compound.getString("exterior_type")));
        this.additionalLockLevel = compound.getInt("additional_lock_level");
        this.isInteriorRegenerating = compound.getBoolean("is_regenerating_interior");
        this.materializeTime = compound.getInt("materialize_time");
        super.read(state, compound);
    }

    /**
     * @author mistersecret312
     * @reason helpmeplease
     */
    @Overwrite
    public CompoundNBT write(CompoundNBT compound) {
        compound.putBoolean("locked", this.locked);
        compound.putString("state", this.openState.name());
        if(this.interiorDimension != null)
            compound.putString("interior", this.interiorDimension.getLocation().toString());
        compound.putInt("matter_state", this.matterState.ordinal());
        compound.putInt("cloakState", this.cloakState.ordinal());
        compound.putInt("cloakAnimTime", this.cloakAnimTime);
        compound.putFloat("light_level", this.lightLevel);
        compound.putString("custom_name", customName);
        compound.putString("animation", this.animation.getType().getRegistryName().toString());
        compound.putInt("variant_index", this.variantIndex);
        compound.putBoolean("anti_grav", this.antiGravs);
        compound.putBoolean("has_demated", this.hasDemated);
        compound.putBoolean("anti_grav", this.antiGravs);
        compound.putBoolean("crashed", this.crashed);
        if(this.exterior != null)
            compound.putString("exterior_type", this.exterior.getRegistryName().toString());
        compound.putInt("additional_lock_level", this.additionalLockLevel);
        compound.putBoolean("is_regenerating_interior", this.isInteriorRegenerating);
        compound.putInt("materialize_time", this.materializeTime);
        return super.write(compound);
    }

    /**
     * @author mistersecret312
     * @reason pain2.
     */
    @Overwrite
    public void tick() {

        this.transferEntities(world.getEntitiesWithinAABB(Entity.class, this.getDoorAABB().offset(this.getPos())));

        this.handleMaterializationAnimations();

        if(this.getCloakState() == CloakState.CLOAKING || this.getCloakState() == CloakState.UNCLOAKING) {
            this.cloakAnimTime ++;
        }
        if(this.getCloakState() == CloakState.CLOAKING && this.cloakAnimTime == 30){
            this.setCloakState(CloakState.CLOAKED);
        }
        if(this.getCloakState() == CloakState.UNCLOAKING && this.cloakAnimTime == 30){
            this.setCloakState(CloakState.UNCLOAKED);
        }

        if(this.matterState != EnumMatterState.SOLID) {
            this.animation.tick(this.materializeTime);

            if(!world.isRemote) {
                //Teleport what we land on
                for(Entity ent : world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(this.getPos().down()).expand(0, 1, 0))) {
                    ServerWorld serverWorld = world.getServer().getWorld(interiorDimension);
                    if(serverWorld != null) {
                        BlockPos pos = TardisHelper.TARDIS_POS.south(4);
                        WorldHelper.teleportEntities(ent, serverWorld, pos.getX(), pos.getY(), pos.getZ(), ent.rotationYaw, ent.rotationPitch);
                    }
                }
            }
        }

        if(!world.isRemote) {
            //Update console on position
            if(this.matterState == EnumMatterState.SOLID && world.getGameTime() % 90 == 0)
                TardisHelper.getConsole(world.getServer(), interiorDimension).ifPresent(tile -> tile.setCurrentLocation(world.getDimensionKey(), this.getPos().down()));
        }

        boolean fall = LandingSystem.shouldTARDISFall(world, pos.down(2));

        if(!world.isRemote && fall && !this.antiGravs && !(((ExteriorTile) (Object) this) instanceof DisguiseExteriorTile))
            this.fall();

        this.pushPower();

        //Crashed particle effects
        if(world.isRemote) {

            double x = this.getPos().getX() + (world.rand.nextFloat() - 0.5), y = this.getPos().getY() + 1, z = this.getPos().getZ() + (world.rand.nextFloat() - 0.5);
            if (this.crashed) {
                if(world.getGameTime() % 20 == 0) {
                    world.addParticle(ParticleTypes.LARGE_SMOKE, x, y, z, 0, 0.1, 0);
                    world.addParticle(ParticleTypes.SMOKE, x, y, z, 0, 0, 0);
                }
                if(world.getGameTime() % 40 == 0)
                    world.addParticle(ParticleTypes.LAVA, x, y, z, 0, 0, 0);
            }
        }

        if (this.isInteriorRegenerating) {
            if (world.isRemote()) {
                double x = this.getPos().getX() + (world.rand.nextFloat() - 0.5), y = this.getPos().getY() + 1, z = this.getPos().getZ() + (world.rand.nextFloat() - 0.5);
                if(world.getGameTime() % 20 == 0) {
                    world.addParticle(ParticleTypes.LARGE_SMOKE, x, y, z, 0, 0.1, 0);
                }
            }
            if (!world.isRemote()) {
                if (world.getGameTime() % 200 == 0) {
                    world.playSound(null, pos, TSounds.STEAM_HISS.get(), SoundCategory.BLOCKS, 0.1F, 1F);
                }
            }
        }

        if(!world.isRemote) {
            //Logic to remove duplicate exteriors
            if(this.interiorDimension == null)
                ++this.consoleInFlightTicks;
            else {
                TardisHelper.getConsole(world.getServer(), interiorDimension).ifPresent(tile -> {
                    if(tile.isInFlight() && tile.getLandTime() <= 0 && this.matterState == EnumMatterState.SOLID)
                        ++this.consoleInFlightTicks;
                });
            }

            if(this.consoleInFlightTicks > 40) {
                this.deleteExteriorBlocks();
            }

            if(!this.hasSetupCaps && !this.world.isRemote) {
                world.getServer().enqueue(new TickDelayedTask(0, () -> {
                    world.getServer().getWorld(interiorDimension).getCapability(Capabilities.TARDIS_DATA).ifPresent(data -> {
                        this.buffer = data.getItemBuffer();
                        this.energy = data.getEnergyCap();
                    });
                }));
                this.hasSetupCaps = true;
            }
        }

        //Fetch initial world shell if null. If shell is built, update the world shell every 5 seconds
        if(!world.isRemote()){
            if (this.shell == null || world.getGameTime() % 100 == 0) {
                this.updateOrBuildBoti();
            }
        }

        //Tick the world shell on the client
        if(this.shell != null)
            this.shell.tick(world.isRemote);

    }

    @Inject(at = @At(value = "HEAD"), method = "copyConsoleData(Lnet/tardis/mod/tileentities/ConsoleTile;)V", remap = false)
    public void copyConsoleData(ConsoleTile console, CallbackInfo ci){
        this.setCloakState(((IConsoleHelp) console).getCloakState() ? CloakState.CLOAKED : CloakState.UNCLOAKED);
    }

    @Override
    public CloakState getCloakState() {
        return cloakState;
    }

    @Override
    public void setCloakState(CloakState cloakedState) {
        this.cloakState = cloakedState;
        this.markDirty();
        this.updateClient();
        this.cloakAnimTime = 0;
    }

    @Override
    public int getCloakAnimTime() {
        return cloakAnimTime;
    }

    @Inject(method = "toggleLocked()V", at = @At("TAIL"), remap = false)
    public void toggleLocked(CallbackInfo ci){
        this.updateSpecific(DoorData.create((ExteriorTile) (Object)this));
    }

}
