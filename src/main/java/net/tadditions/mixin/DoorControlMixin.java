package net.tadditions.mixin;

import com.llamalad7.mixinextras.injector.ModifyReceiver;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.tardis.mod.controls.DoorControl;
import net.tardis.mod.entity.DoorEntity;
import net.tardis.mod.tileentities.ConsoleTile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DoorControl.class)
public abstract class DoorControlMixin
{
    @Inject(method = "onRightClicked(Lnet/tardis/mod/tileentities/ConsoleTile;Lnet/minecraft/entity/player/PlayerEntity;)Z", at = @At(value = "INVOKE", target = "Lnet/tardis/mod/entity/DoorEntity;setOpenState(Lnet/tardis/mod/enums/EnumDoorState;)V", ordinal = 0, shift = At.Shift.AFTER), remap = false)
    public void onRMB(ConsoleTile console, PlayerEntity player, CallbackInfoReturnable<Boolean> cir)
    {
        if(!console.getWorld().isRemote()) {
            for (DoorEntity ent : console.getWorld().getEntitiesWithinAABB(DoorEntity.class, new AxisAlignedBB(console.getPos()).grow(25))) {
                ent.updateExteriorDoorData();
            }
        }
    }
}
