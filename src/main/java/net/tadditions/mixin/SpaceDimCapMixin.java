package net.tadditions.mixin;


import net.minecraft.util.RegistryKey;
import net.minecraft.world.World;
import net.tadditions.mod.world.MDimensions;
import net.tardis.mod.cap.SpaceDimensionCapability;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SpaceDimensionCapability.class)
public class SpaceDimCapMixin {

    @Shadow private RegistryKey<World> world;


    @Inject(method = "hasAir", at = @At("HEAD"), cancellable = true)
    private void onHasAir(CallbackInfoReturnable<Boolean> callbackInfo) {
        if (this.world == MDimensions.MARS) {
            callbackInfo.setReturnValue(false);
        }
    }
}
