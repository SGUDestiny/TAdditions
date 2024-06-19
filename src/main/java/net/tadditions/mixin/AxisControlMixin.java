package net.tadditions.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.tardis.mod.controls.AxisControl;
import net.tardis.mod.tileentities.ConsoleTile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AxisControl.class)
public class AxisControlMixin {


    @Inject(method = "onRightClicked(Lnet/tardis/mod/tileentities/ConsoleTile;Lnet/minecraft/entity/player/PlayerEntity;)Z",
    at = @At(value = "INVOKE", target = "Lnet/tardis/mod/tileentities/ConsoleTile;setDestination(Lnet/minecraft/util/RegistryKey;Lnet/minecraft/util/math/BlockPos;)V", shift = At.Shift.AFTER),
    remap = false)
    public void rightClickInteraction(ConsoleTile console, PlayerEntity player, CallbackInfoReturnable<Boolean> cir)
    {
        //if(console.getEmotionHandler().getConnectedPlayers().containsKey(player.getUniqueID()))
            player.sendStatusMessage(new StringTextComponent(console.getDestinationPosition().toString().toUpperCase()), true);
    }

}
