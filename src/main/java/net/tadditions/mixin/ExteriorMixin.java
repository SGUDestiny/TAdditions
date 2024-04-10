package net.tadditions.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.tadditions.mod.helper.CloakState;
import net.tadditions.mod.helper.IConsoleHelp;
import net.tadditions.mod.helper.IExteriorHelp;
import net.tardis.mod.client.animation.IExteriorAnimation;
import net.tardis.mod.enums.EnumDoorState;
import net.tardis.mod.enums.EnumMatterState;
import net.tardis.mod.exterior.AbstractExterior;
import net.tardis.mod.registries.ExteriorAnimationRegistry;
import net.tardis.mod.registries.ExteriorRegistry;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ExteriorTile.class)
public abstract class ExteriorMixin extends TileEntity implements IExteriorHelp {

    public ExteriorMixin(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    @Shadow public abstract void updateClient();

    @Shadow private boolean locked;
    @Shadow private EnumDoorState openState;
    @Shadow protected RegistryKey<World> interiorDimension;
    @Shadow private EnumMatterState matterState;
    @Shadow public float lightLevel;
    @Shadow private String customName;
    @Shadow private IExteriorAnimation animation;
    @Shadow private int variantIndex;
    @Shadow private boolean antiGravs;
    @Shadow private boolean hasDemated;
    @Shadow private boolean crashed;
    @Shadow private AbstractExterior exterior;
    @Shadow private int additionalLockLevel;
    @Shadow private boolean isInteriorRegenerating;
    @Shadow private int materializeTime;
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

    @Inject(at = @At(value = "HEAD"), method = "tick()V")
    public void tick(CallbackInfo ci){
        if(this.getCloakState() == CloakState.CLOAKING || this.getCloakState() == CloakState.UNCLOAKING) {
            this.cloakAnimTime ++;
        }
        if(this.getCloakState() == CloakState.CLOAKING && this.cloakAnimTime == 30){
            this.setCloakState(CloakState.CLOAKED);
        }
        if(this.getCloakState() == CloakState.UNCLOAKING && this.cloakAnimTime == 30){
            this.setCloakState(CloakState.UNCLOAKED);
        }
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


}
