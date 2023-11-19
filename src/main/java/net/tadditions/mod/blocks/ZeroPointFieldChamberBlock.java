package net.tadditions.mod.blocks;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.tardis.mod.blocks.MultiblockBlock;

public class ZeroPointFieldChamberBlock extends MultiblockBlock {

    public ZeroPointFieldChamberBlock(Properties prop) {
        super(prop);
    }

    public BlockRenderType getRenderType(BlockState p_149645_1_) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if(!world.isRemote() && !player.isCreative()) {
            if (state.getBlock().getDefaultState() == ModBlocks.zero_point_field_normal.get().getDefaultState()) {
                world.setBlockState(pos, ModBlocks.zero_point_field_broken.get().getDefaultState());
            }
            if (state.getBlock().getDefaultState() == ModBlocks.zero_point_field_broken.get().getDefaultState()) {
                super.onBlockHarvested(world, pos, state, player);
            }
        }
    }

}
