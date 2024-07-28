package net.tadditions.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.tadditions.mod.helper.CloakState;
import net.tadditions.mod.helper.IConsoleHelp;
import net.tadditions.mod.helper.IExteriorHelp;
import net.tardis.mod.network.packets.exterior.DoorData;
import net.tardis.mod.network.packets.exterior.ExteriorData;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ExteriorTile.class)
public abstract class ExteriorMixin implements IExteriorHelp {

    @Shadow(remap = false) public abstract void updateClient();

    @Shadow(remap = false) public abstract void updateSpecific(ExteriorData data);

    private CloakState cloakState = CloakState.UNCLOAKED;
    private int cloakAnimTime = 0;

    @Inject(method = "read(Lnet/minecraft/block/BlockState;Lnet/minecraft/nbt/CompoundNBT;)V", at = @At("HEAD"))
    public void read(BlockState state, CompoundNBT compound, CallbackInfo ci) {
        if(compound.contains("cloakState"))
            this.cloakState = CloakState.values()[compound.getInt("cloakState")];
        else cloakState = CloakState.UNCLOAKED;
        this.cloakAnimTime = compound.getInt("cloakAnimTime");
    }

    @Inject(method = "write(Lnet/minecraft/nbt/CompoundNBT;)Lnet/minecraft/nbt/CompoundNBT;", at = @At("HEAD"))
    public void write(CompoundNBT compound, CallbackInfoReturnable<CompoundNBT> cir) {
        compound.putInt("cloakState", this.cloakState.ordinal());
        compound.putInt("cloakAnimTime", this.cloakAnimTime);
    }

    @Inject(method = "tick()V", at = @At("HEAD"))
    public void tick(CallbackInfo ci) {
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
        ((ExteriorTile) (Object) this).markDirty();
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
