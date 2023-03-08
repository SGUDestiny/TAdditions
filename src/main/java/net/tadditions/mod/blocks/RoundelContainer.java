package net.tadditions.mod.blocks;

import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.concurrent.TickDelayedTask;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.server.ServerWorld;
import net.tadditions.mod.tileentity.RoundelContainerTileEntity;
import net.tardis.mod.ars.IARS;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.cap.ILightCap;
import net.tardis.mod.properties.TardisBlockProperties;

import javax.annotation.Nullable;
import java.util.Random;

public class RoundelContainer extends ContainerBlock implements IARS {

    public RoundelContainer(Block.Properties properties) {
        super(properties);
        this.setDefaultState(this.getDefaultState().with(TardisBlockProperties.LIGHT, 15));
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        return state.get(TardisBlockProperties.LIGHT);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(TardisBlockProperties.LIGHT);
    }

    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!worldIn.isRemote) {
            worldIn.getServer().enqueue(new TickDelayedTask(1, () -> {
                IChunk chunk = worldIn.getChunk(pos);
                if (chunk instanceof Chunk) {
                    ILightCap cap = ((Chunk) chunk).getCapability(Capabilities.LIGHT).orElse(null);
                    if (cap != null) {
                        cap.addLightPos(pos);
                    }
                }
            }));
        }
    }

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (worldIn.isRemote) {
            return ActionResultType.SUCCESS;
        } else {
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof RoundelContainerTileEntity) {
                player.openContainer((RoundelContainerTileEntity)tileentity);
                player.addStat(Stats.OPEN_BARREL);
            }

            return ActionResultType.CONSUME;
        }
    }

    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.matchesBlock(newState.getBlock())) {
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof IInventory) {
                InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory)tileentity);
                worldIn.updateComparatorOutputLevel(pos, this);
            }

            super.onReplaced(state, worldIn, pos, newState, isMoving);
        }
    }

    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        if (tileentity instanceof RoundelContainerTileEntity) {
            ((RoundelContainerTileEntity)tileentity).barrelTick();
        }

    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if (stack.hasDisplayName()) {
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof RoundelContainerTileEntity) {
                ((RoundelContainerTileEntity)tileentity).setCustomName(stack.getDisplayName());
            }
        }

    }

    @Nullable
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new RoundelContainerTileEntity();
    }
}
