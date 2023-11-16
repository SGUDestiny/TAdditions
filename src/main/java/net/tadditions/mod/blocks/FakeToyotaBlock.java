package net.tadditions.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.tardis.mod.blocks.template.NotSolidTileBlock;

import java.util.stream.Stream;

public class FakeToyotaBlock extends NotSolidTileBlock {
    public FakeToyotaBlock(Properties prop) {
        super(prop);
    }

    private static final VoxelShape SHAPE = Stream.of(Block.makeCuboidShape(0, 0, 0, 16, 32, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }


}
