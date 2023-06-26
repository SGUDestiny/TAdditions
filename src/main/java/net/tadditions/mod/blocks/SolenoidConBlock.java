package net.tadditions.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.tadditions.mod.items.ModItems;
import net.tadditions.mod.network.MNetwork;
import net.tadditions.mod.network.packets.QuanSpawnMessage;

import java.util.stream.Stream;

public class SolenoidConBlock extends Block {

    public SolenoidConBlock(Properties properties) {
        super(properties);
    }

    private static final VoxelShape SHAPE = Stream.of(
            Block.makeCuboidShape(1, 0, 1, 15, 14, 15)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        Block block = state.getBlock();
        if(!worldIn.isRemote()) {
            if (block == ModBlocks.filled_electromagnetic_solenoid_container.get()) {
                worldIn.setBlockState(pos, ModBlocks.electromagnetic_solenoid_container.get().getDefaultState());
                MNetwork.sendToServer(new QuanSpawnMessage(ModItems.QUANTUM_EXOTIC_MATTER.get()));
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.PASS;
    }
}
