package net.tadditions.mod.blocks;

import it.unimi.dsi.fastutil.booleans.BooleanArrayList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.concurrent.TickDelayedTask;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.tadditions.mod.items.ModItems;
import net.tadditions.mod.network.MNetwork;
import net.tadditions.mod.network.packets.QuanSpawnMessage;

import java.util.Random;
import java.util.stream.Stream;

public class DisappearDoorKeyBlock extends Block {

    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");
    public static final BooleanProperty VANISHED = BooleanProperty.create("vanish");
    public static final BooleanProperty LOCKED = BooleanProperty.create("locked");

    private static final VoxelShape REAPPEARING_BB = VoxelShapes.create(new AxisAlignedBB(0.375F, 0.375F, 0.375F, 0.625F, 0.625F, 0.625F));

    public DisappearDoorKeyBlock(Properties properties) {
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
        if (state.get(VANISHED) || state.get(ACTIVE)) return ActionResultType.FAIL;

        if (state.get(LOCKED)) {
            ItemStack stack = player.getHeldItem(handIn);
            if (!stack.isEmpty() && stack.getItem() == ModItems.IMPULSE_KEY.get()) {
                if (!world.isRemote) {
                    stack.shrink(1);
                    world.playSound(null, pos, SoundEvents.BLOCK_DISPENSER_DISPENSE, SoundCategory.BLOCKS, 1.0F, 0.3F);
                    world.setBlockState(pos, state.with(LOCKED, false));
                    for(Direction e : Direction.values()){
                        checkAndUnlockBlock(world, pos.offset(e));
                    }
                }
                return ActionResultType.SUCCESS;
            }
        } else {
            changeToActiveBlock(world, pos, state);
            return ActionResultType.SUCCESS;
        }
        return super.onBlockActivated(state, world, pos, player, handIn, hit);
    }

    @Override
    @Deprecated
    public void neighborChanged(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
    }

    private static void changeToActiveBlock(World world, BlockPos pos, BlockState originState) {
        if (originState.getBlock() instanceof DisappearDoorKeyBlock) {
            world.setBlockState(pos, originState.with(ACTIVE, true));
        }
        world.getPendingBlockTicks().scheduleTick(pos, originState.getBlock(), 2 + world.rand.nextInt(5));
    }

    @Override
    @Deprecated
    public void tick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(VANISHED)) {
            if (state.get(ACTIVE)) {
                world.setBlockState(pos, state.with(VANISHED, false).with(ACTIVE, false));
            } else {
                changeToActiveBlock(world, pos, state);
            }
        } else {
            if (state.get(ACTIVE)) {
                world.setBlockState(pos, state.with(VANISHED, true).with(ACTIVE, false));
                world.getPendingBlockTicks().scheduleTick(pos, this, 60);

                world.playSound(null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 0.3F, 0.5F);


                // activate all adjacent inactive doors
                for (Direction e : Direction.values()) {
                    checkAndActivateBlock(world, pos.offset(e));
                }
            }
        }
    }

    public static void checkAndActivateBlock(World world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);

        if (state.getBlock() instanceof DisappearDoorBlock && !state.get(VANISHED) && !state.get(ACTIVE) && !state.get(LOCKED)) {
            DisappearDoorBlock block = (DisappearDoorBlock)state.getBlock();
            block.changeToActiveBlock(world, pos);
        }
    }
    public static void checkAndUnlockBlock(World world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);

        if (state.getBlock() instanceof DisappearDoorBlock && !state.get(VANISHED) && !state.get(ACTIVE) && state.get(LOCKED)) {
            DisappearDoorBlock block = (DisappearDoorBlock)state.getBlock();
            block.changeToUnlockedBlock(world, pos);
        }
    }
}
