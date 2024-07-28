package net.tadditions.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.tadditions.mod.helper.CloakState;
import net.tadditions.mod.helper.IExteriorHelp;
import net.tardis.mod.blocks.exteriors.ExteriorBlock;
import net.tardis.mod.blocks.exteriors.TardisExteriorBottomBlock;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(TardisExteriorBottomBlock.class)
public class TARDISBottomMixin {

    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 1.0F;
    }
}
