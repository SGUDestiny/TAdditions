package net.tadditions.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.Constants;
import net.tadditions.mod.items.ModItems;
import net.tadditions.mod.network.MNetwork;
import net.tadditions.mod.network.packets.QuanSpawnMessage;
import net.tardis.mod.blocks.MultiblockBlock;
import net.tardis.mod.blocks.TileBlock;

import java.util.Random;
import java.util.stream.Stream;

public class ZeroPointFieldChamberBlock extends TileBlock {

    public ZeroPointFieldChamberBlock(Properties prop) {
        super(prop);
    }

    private static final VoxelShape SHAPE = Stream.of(
            Block.makeCuboidShape(-15.0, 0, 1.0, 15.0, 5.0, 31.0),
            Block.makeCuboidShape(-14.0, 5.0, 2.0, 14.0, 48.0, 30.0),
            Block.makeCuboidShape(-15.0, 75.0, 1.0, 15.0, 80.0, 31.0)
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
        if(!world.isRemote() && !player.isCreative()) {
            if (state.getBlock() == ModBlocks.zero_point_field_normal.get()) {
                world.setBlockState(pos, ModBlocks.zero_point_field_broken.get().getDefaultState());
            }
            if (state.getBlock() == ModBlocks.zero_point_field_broken.get()) {
                super.onBlockHarvested(world, pos, state, player);
            }
        }
    }


    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if(world.getBlockState(pos.up()).getBlock().matchesBlock(Blocks.AIR.getBlock()) && world.getBlockState(pos.up(2)).getBlock().matchesBlock(Blocks.AIR.getBlock()) && world.getBlockState(pos.up(3)).getBlock().matchesBlock(Blocks.AIR.getBlock())) {
            world.setBlockState(pos.up(), ModBlocks.zpfcupper.get().getDefaultState());
        }
    }
}
