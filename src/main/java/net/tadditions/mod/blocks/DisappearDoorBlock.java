package net.tadditions.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.concurrent.TickDelayedTask;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.*;

public class DisappearDoorBlock extends Block {

    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");
    public static final BooleanProperty VANISHED = BooleanProperty.create("vanish");
    public static final BooleanProperty LOCKED = BooleanProperty.create("locked");

    private static final VoxelShape REAPPEARING_BB = VoxelShapes.create(new AxisAlignedBB(0.375F, 0.375F, 0.375F, 0.625F, 0.625F, 0.625F));

    public DisappearDoorBlock(Properties properties) {
        super(properties);
        this.setDefaultState(stateContainer.getBaseState().with(ACTIVE, false).with(VANISHED, false).with(LOCKED, true));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(ACTIVE, VANISHED, LOCKED);
    }

    @Override
    @Deprecated
    public VoxelShape getCollisionShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        return state.get(VANISHED) ? VoxelShapes.empty() : super.getCollisionShape(state, world, pos, context);
    }

    @Override
    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        return state.get(VANISHED) ? REAPPEARING_BB : super.getShape(state, world, pos, context);
    }

    @Override
    @Deprecated
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        return ActionResultType.PASS;
    }

    @Override
    @Deprecated
    public void neighborChanged(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (world.isRemote) {
            return;
        }

        if (!isVanished(state) && !state.get(ACTIVE) && world.isBlockPowered(pos) && !areBlocksLocked(world, pos)) {
            changeToActiveBlock(world, pos);
        }
    }

    public void changeToActiveBlock(World world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        if (state.getBlock() instanceof DisappearDoorBlock && !isVanished(state) && !state.get(ACTIVE)) {
            world.setBlockState(pos, state.with(ACTIVE, true));
            world.getPendingBlockTicks().scheduleTick(pos, state.getBlock(), 2 + world.rand.nextInt(5));
        }
    }
    public void changeToUnlockedBlock(World world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        if (state.getBlock() instanceof DisappearDoorBlock && !isVanished(state) && !state.get(ACTIVE)) {
            world.setBlockState(pos, state.with(LOCKED, false));
            for(Direction e : Direction.values()){
                if(world.getBlockState(pos.offset(e)).getBlock() == ModBlocks.ancient_door.get()){
                    world.setBlockState(pos.offset(e), state.with(LOCKED, false));
                }
            }
            world.getPendingBlockTicks().scheduleTick(pos, state.getBlock(), 2 + world.rand.nextInt(5));
        }
    }

    private static boolean areBlocksLocked(IBlockReader world, BlockPos start) {
        int limit = 512;
        Deque<BlockPos> queue = new ArrayDeque<>();
        Set<BlockPos> checked = new HashSet<>();
        queue.offer(start);

        for (int iter = 0; !queue.isEmpty() && iter < limit; iter++) {
            BlockPos cur = queue.pop();
            BlockState state = world.getBlockState(cur);
            if (state.getBlock() == ModBlocks.ancient_keyholder.get() && state.get(DisappearDoorKeyBlock.LOCKED)) {
                return true;
            }
            if(state.getBlock() == ModBlocks.ancient_door.get() && state.get(DisappearDoorBlock.LOCKED)){
                return true;
            }

            checked.add(cur);

            if (state.getBlock() instanceof DisappearDoorBlock) {
                for (Direction facing : Direction.values()) {
                    BlockPos neighbor = cur.offset(facing);
                    if (!checked.contains(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return false;
    }

    @Override
    public void tick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.isRemote) {
            return;
        }

        if (isVanished(state)) {
            if (state.get(ACTIVE)) {
                world.setBlockState(pos, state.with(VANISHED, false).with(ACTIVE, false));
            } else {
                world.setBlockState(pos, state.with(ACTIVE, true));
                world.getPendingBlockTicks().scheduleTick(pos, this, 2);
            }
        } else {
            if (state.get(ACTIVE)) {
                if (state.hasProperty(VANISHED)) {
                    world.setBlockState(pos, state.with(ACTIVE, false).with(VANISHED, true));
                    world.getPendingBlockTicks().scheduleTick(pos, this, 60);
                } else {
                    world.removeBlock(pos, false);
                }

                world.playSound(null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 0.3F, 0.5F);

                for (Direction e : Direction.values()) {
                    changeToActiveBlock(world, pos.offset(e));
                }
            }
        }
    }

    private boolean isVanished(BlockState state) {
        return state.hasProperty(VANISHED) && state.get(VANISHED);
    }

}
