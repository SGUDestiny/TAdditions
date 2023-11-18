package net.tadditions.mixin;


import net.minecraft.util.RegistryKey;
import net.minecraft.world.World;
import net.tadditions.mod.world.MDimensions;
import net.tardis.mod.cap.SpaceDimensionCapability;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.world.dimensions.TDimensions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(SpaceDimensionCapability.class)
public class SpaceDimCapMixin {

    @Shadow private RegistryKey<World> world;

    @Overwrite
    public boolean hasAir() {
        if (this.world == TDimensions.SPACE_DIM || this.world == TDimensions.MOON_DIM || this.world == MDimensions.MARS)
            return false;
        return true;
    }
}
