package net.tadditions.mixin;

import net.tardis.mod.tileentities.console.misc.EmotionHandler;
import net.tardis.mod.traits.TardisTrait;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(EmotionHandler.class)
public interface EmotionHandlerMixin {

    @Accessor(value = "traits", remap = false)
    void setTraits(TardisTrait[] traits);
}
