package net.tadditions.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.tadditions.mod.helper.IMonitorHelp;
import net.tadditions.mod.tileentity.FourteenthConsoleTile;
import net.tardis.mod.client.ClientHelper;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.contexts.gui.EntityContext;
import net.tardis.mod.controls.BaseControl;
import net.tardis.mod.controls.MonitorControl;
import net.tardis.mod.entity.ControlEntity;
import net.tardis.mod.helper.PlayerHelper;
import net.tardis.mod.items.TItems;
import net.tardis.mod.registries.ControlRegistry;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.consoles.CoralConsoleTile;
import net.tardis.mod.tileentities.consoles.GalvanicConsoleTile;
import net.tardis.mod.tileentities.consoles.ToyotaConsoleTile;
import net.tardis.mod.tileentities.consoles.XionConsoleTile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MonitorControl.class)
public abstract class MonitorControlMixin implements IMonitorHelp{

    @Unique
    float rotationAngle;

    @Inject(at = @At("TAIL"), method = "serializeNBT()Lnet/minecraft/nbt/CompoundNBT;", remap = false)
    public void serializeNBT(CallbackInfoReturnable<CompoundNBT> cir){
        cir.getReturnValue().putFloat("rotationAngle", this.rotationAngle);
    }

    @Inject(at = @At("TAIL"), method = "deserializeNBT(Lnet/minecraft/nbt/CompoundNBT;)V", remap = false)
    public void deserializeNBT(CompoundNBT nbt, CallbackInfo ci){
        this.rotationAngle = nbt.getFloat("rotationAngle");
    }

    @Override
    public float getRotAngle(){
        return this.rotationAngle;
    }

    @Override
    public void setRotAngle(float rot){
        this.rotationAngle = rot;
    }
}
