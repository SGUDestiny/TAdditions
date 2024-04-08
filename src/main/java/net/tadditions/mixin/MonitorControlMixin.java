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
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MonitorControl.class)
public abstract class MonitorControlMixin extends BaseControl implements IMonitorHelp{

    float rotationAngle;

    public MonitorControlMixin(ControlRegistry.ControlEntry entry, ConsoleTile console, ControlEntity entity) {
        super(entry, console, entity);
    }

    /**
     * @author Zolton21
     * @reason Monitor rotation for custom console
     */
    @Overwrite(remap = false)
    public boolean onRightClicked(ConsoleTile console, PlayerEntity player) {

        if(console.getWorld().isRemote && !player.isSneaking()) {

            if(PlayerHelper.InEitherHand(player, stack -> stack.getItem() == TItems.MONITOR_REMOTE.get())) {
                ClientHelper.openGUI(TardisConstants.Gui.MONITOR_REMOTE, new EntityContext(this.getEntity()));
                return true;
            }

            if(console instanceof GalvanicConsoleTile) {
                ClientHelper.openGUI(TardisConstants.Gui.MONITOR_MAIN_GALVANIC, null);
                return true;
            }
            if (console instanceof XionConsoleTile) {
                ClientHelper.openGUI(TardisConstants.Gui.MONITOR_MAIN_XION, null);
                return true;
            }
            if (console instanceof ToyotaConsoleTile) {
                ClientHelper.openGUI(TardisConstants.Gui.MONITOR_MAIN_TOYOTA, null);
                return true;
            }
            if (console instanceof CoralConsoleTile) {
                ClientHelper.openGUI(TardisConstants.Gui.MONITOR_MAIN_CORAL, null);
                return true;
            }
            else {
                ClientHelper.openGUI(TardisConstants.Gui.MONITOR_MAIN_EYE, null);
                return true;
            }
        }

        if(console instanceof FourteenthConsoleTile && player.isSneaking()) {
            if(player.isSneaking()){
                BlockPos pos = this.getConsole().getPos();
                Vector3d p = player.getPositionVec().subtract(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5).normalize();

                float hype = (float) Math.sqrt(p.x * p.x + p.z * p.z);
                float rot;
                if (p.z < 0)
                    rot = (float) Math.toDegrees(Math.asin(p.x / hype));
                else rot = -(float) Math.toDegrees(Math.asin(p.x / hype)) - 180;
                rot = (rot + 180);
                if(rot < 0)
                    rot = rot + 360;

                if(rot < 30)
                    rot = 0;
                if(rot >= 30 && rot < 90)
                    rot = 60;
                if(rot >= 90 && rot < 180)
                    rot = 120;
                if(rot >= 180 && rot < 270)
                    rot = -120;
                if(rot >= 270 && rot < 330)
                    rot = -60;
                if(rot >= 330)
                    rot = 0;
                setRotAngle(rot);
            }
        }
        return true;
    }

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
