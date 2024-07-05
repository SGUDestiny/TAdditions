package net.tadditions.mixin;

import net.tadditions.mod.tileentity.FourteenthConsoleTile;
import net.tardis.mod.controls.CommunicatorControl;
import net.tardis.mod.tileentities.ConsoleTile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CommunicatorControl.class)
public abstract class CommunicatorControlMixin{

    @Inject(method = "usePhoneSounds(Lnet/tardis/mod/tileentities/ConsoleTile;)Z", at = @At(value = "RETURN"), cancellable = true, remap = false)
    public void usePhoneSounds(ConsoleTile tile, CallbackInfoReturnable<Boolean> cir) {
        if(tile instanceof FourteenthConsoleTile)
            cir.setReturnValue(true);
    }
}
