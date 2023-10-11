package net.tadditions.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.stream.Stream;

public class ZPFCUpperBlock extends Block {

    public ZPFCUpperBlock(Properties prop) {
        super(prop);
    }

    private static final VoxelShape SHAPE = Stream.of(
            Block.makeCuboidShape(-14.0, 0.0, 2.0, 14.0, 27.0, 30.0),
            Block.makeCuboidShape(-15.0, 27.0, 1.0, 15.0, 32.0, 31.0)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
    public BlockRenderType getRenderType(BlockState p_149645_1_) {
        return BlockRenderType.INVISIBLE;
    }


    @Override
    public void neighborChanged(BlockState state, World world, BlockPos pos, Block block, BlockPos posfrom, boolean ismoving) {
        if(block.matchesBlock(ModBlocks.zero_point_field_broken.get())){
            world.setBlockState(pos, Blocks.AIR.getDefaultState());
        }

    }
}
