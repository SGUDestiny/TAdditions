package net.tadditions.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.SoundEvent;
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
import net.tardis.mod.tileentities.monitors.MonitorTile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MonitorControl.class)
public abstract class MonitorControlMixin implements IMonitorHelp{

    float rotationAngle = 0;

    @Inject(at = @At("HEAD"), method = "onRightClicked(Lnet/tardis/mod/tileentities/ConsoleTile;Lnet/minecraft/entity/player/PlayerEntity;)Z", cancellable = true)
    public void onRightClicked(ConsoleTile console, PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {

        if(console instanceof FourteenthConsoleTile && player.isSneaking()) {
            if(player.isSneaking()){
                BlockPos pos = console.getPos();
                Vector3d p = player.getPositionVec().subtract(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5).normalize();

                float hype = (float) Math.sqrt(p.x * p.x + p.z * p.z);
                float rot;
                if (p.z < 0)
                    rot = (float) Math.toDegrees(Math.asin(p.x / hype));
                else rot = -(float) Math.toDegrees(Math.asin(p.x / hype)) - 180;
                rot = (rot + 180);
                if(rot < 0)
                    rot = rot + 360;

                if(rot < 22.5) {
                    rot = 0;
                }
                if(rot >= 22.5 && rot < 67.5)
                    rot = 45;
                if(rot >= 67.5 && rot < 112.5)
                    rot = 90;
                if(rot >= 112.5 && rot < 180)
                    rot = 135;
                if(rot >= 180 && rot < 247.5)
                    rot = -135;
                if(rot >= 247.5 && rot < 292.5)
                    rot = -90;
                if(rot >= 292.5 && rot < 337.5)
                    rot = -45;
                if(rot >= 337.5)
                    rot = 0;

                setRotAngle(rot);
            }
        }
        cir.setReturnValue(true);
    }

    @Inject(at = @At("TAIL"), method = "serializeNBT()Lnet/minecraft/nbt/CompoundNBT;")
    public void serializeNBT(CallbackInfoReturnable<CompoundNBT> cir){
        cir.getReturnValue().putFloat("rotationAngle", rotationAngle);
    }

    @Inject(at = @At("TAIL"), method = "deserializeNBT(Lnet/minecraft/nbt/CompoundNBT;)V")
    public void deserializeNBT(CompoundNBT nbt, CallbackInfo ci){
        this.rotationAngle = nbt.getFloat("rotationAngle");
    }

    @Override
    public void setRotAngle(float rot){
        rotationAngle = rot;
    }

    @Override
    public float getRotAngle(){
        return rotationAngle;
    }

}
