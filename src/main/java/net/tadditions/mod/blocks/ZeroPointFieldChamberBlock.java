package net.tadditions.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.tadditions.mod.items.ModItems;
import net.tadditions.mod.network.MNetwork;
import net.tadditions.mod.network.packets.QuanSpawnMessage;
import net.tardis.mod.blocks.TileBlock;

import java.util.stream.Stream;

public class ZeroPointFieldChamberBlock extends TileBlock {

    public ZeroPointFieldChamberBlock(Properties prop) {
        super(prop);
    }

    private VoxelShape SHAPE = Stream.of(
            Block.makeCuboidShape(-0.9375,0,0.0625,0.9375,0.3125,1.9375),
            Block.makeCuboidShape(-0.875,0.3125,0.125,0.875,4.6875,1.875),
            Block.makeCuboidShape(-0.9375, 4.6875, 0.0625, 0.9375, 5, 1.9375)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
    public BlockRenderType getRenderType(BlockState p_149645_1_) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public void onPlayerDestroy(IWorld world, BlockPos pos, BlockState state) {
        if(!world.isRemote()) {
            if (state.getBlock() == ModBlocks.zero_point_field_normal.get()) {
                world.setBlockState(pos, ModBlocks.zero_point_field_broken.get().getDefaultState(), 3);
                MNetwork.sendToServer(new QuanSpawnMessage(ModItems.QUANTUM_EXOTIC_MATTER.get()));
            }
            if (state.getBlock() == ModBlocks.zero_point_field_broken.get()) {
                super.onPlayerDestroy(world, pos, state);
            }
        }
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if(!world.isRemote()) {
            if (state.getBlock() == ModBlocks.zero_point_field_normal.get()) {
                world.setBlockState(pos, ModBlocks.zero_point_field_broken.get().getDefaultState());
            }
            if (state.getBlock() == ModBlocks.zero_point_field_broken.get()) {
                super.onBlockHarvested(world, pos, state, player);
            }
        }
    }


}
