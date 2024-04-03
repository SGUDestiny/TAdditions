package net.tadditions.mixin;

import net.minecraft.block.AbstractGlassBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.tardis.mod.blocks.exteriors.TardisExteriorBottomBlock;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(TardisExteriorBottomBlock.class)
public class TARDISBottomMixin {

    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 1.0F;
    }
}
