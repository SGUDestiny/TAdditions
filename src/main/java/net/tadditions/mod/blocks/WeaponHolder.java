package net.tadditions.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.tadditions.mod.items.ModItems;
import net.tadditions.mod.tileentity.ModTileEntitys;
import net.tadditions.mod.tileentity.WeaponHolderBE;
import net.tardis.mod.blocks.template.NotSolidTileBlock;
import net.tardis.mod.helper.TInventoryHelper;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class WeaponHolder extends NotSolidTileBlock {
    public WeaponHolder(Properties prop) {
        super(prop);
    }

    private static final VoxelShape SHAPEEMP = Stream.of(
            Block.makeCuboidShape(5.5, 6, 4.5, 10.5, 6.5, 11.5),
            Block.makeCuboidShape(4, 3, 3, 12, 6, 13),
            Block.makeCuboidShape(3.5, 3, 2.5, 4.5, 6.5, 3.5),
            Block.makeCuboidShape(3.5, 3, 12.5, 4.5, 6.5, 13.5),
            Block.makeCuboidShape(2.5, 0, 13.5, 3.5, 3.5, 14.5),
            Block.makeCuboidShape(3, 0, 2, 13, 3, 14),
            Block.makeCuboidShape(2.5, 0, 1.5, 3.5, 3.5, 2.5),
            Block.makeCuboidShape(11.5, 3, 2.5, 12.5, 6.5, 3.5),
            Block.makeCuboidShape(12.5, 0, 1.5, 13.5, 3.5, 2.5),
            Block.makeCuboidShape(11.5, 3, 12.5, 12.5, 6.5, 13.5),
            Block.makeCuboidShape(12.5, 0, 13.5, 13.5, 3.5, 14.5)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPEFILL = Stream.of(
            Block.makeCuboidShape(4.5, 6, 5.5, 11.5, 6.5, 10.5),
            Block.makeCuboidShape(3, 3, 4, 13, 6, 12),
            Block.makeCuboidShape(2.5, 3, 11.5, 3.5, 6.5, 12.5),
            Block.makeCuboidShape(12.5, 3, 11.5, 13.5, 6.5, 12.5),
            Block.makeCuboidShape(13.5, 0, 12.5, 14.5, 3.5, 13.5),
            Block.makeCuboidShape(2, 0, 3, 14, 3, 13),
            Block.makeCuboidShape(1.5, 0, 12.5, 2.5, 3.5, 13.5),
            Block.makeCuboidShape(2.5, 3, 3.5, 3.5, 6.5, 4.5),
            Block.makeCuboidShape(1.5, 0, 2.5, 2.5, 3.5, 3.5),
            Block.makeCuboidShape(12.5, 3, 3.5, 13.5, 6.5, 4.5),
            Block.makeCuboidShape(13.5, 0, 2.5, 14.5, 3.5, 3.5)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        if(state.get(BlockStateProperties.HORIZONTAL_FACING) == Direction.EAST || state.get(BlockStateProperties.HORIZONTAL_FACING) == Direction.WEST){
            return SHAPEEMP;
        }
        else return SHAPEFILL;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(handIn == Hand.OFF_HAND)
            return ActionResultType.FAIL;

        WeaponHolderBE tile = (WeaponHolderBE) worldIn.getTileEntity(pos);
        ItemStack stack = player.getHeldItem(handIn);

        if(!tile.getWeapon().isEmpty())
            this.dropCurrentItem(tile, player);
        if (!stack.isEmpty() && stack.getItem() == ModItems.MURASAMA.get()) {
            tile.setWeapon(stack.copy());
            player.setHeldItem(handIn, ItemStack.EMPTY);
            tile.update();
        }
        return ActionResultType.SUCCESS;
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return super.getStateForPlacement(context).with(BlockStateProperties.HORIZONTAL_FACING, context.getPlayer().getHorizontalFacing().getOpposite());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(BlockStateProperties.HORIZONTAL_FACING)));
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(BlockStateProperties.HORIZONTAL_FACING, rot.rotate(state.get(BlockStateProperties.HORIZONTAL_FACING)));
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return type.create();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if(!worldIn.isRemote() && state.getBlock() != newState.getBlock()) {
            WeaponHolderBE holder = (WeaponHolderBE) worldIn.getTileEntity(pos);
            if(!holder.getWeapon().isEmpty())
                InventoryHelper.spawnItemStack(worldIn, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, holder.getWeapon());
        }
        super.onReplaced(state, worldIn, pos, newState, isMoving);
    }

    public boolean dropCurrentItem(WeaponHolderBE tile, PlayerEntity player) {
        if(!tile.getWeapon().isEmpty()) {
            TInventoryHelper.giveStackTo(player, tile.getWeapon());
            tile.setWeapon(ItemStack.EMPTY);
            tile.update();
            return true;
        }
        return false;
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack) {
        super.onBlockPlacedBy(world, pos, state, entity, stack);
        if(world.getTileEntity(pos).getType() == ModTileEntitys.WPH.get()){
            WeaponHolderBE tile = (WeaponHolderBE) world.getTileEntity(pos).getTileEntity();
            tile.setWeapon(ItemStack.EMPTY);
        }
    }

    @Override
    public boolean isToolEffective(BlockState state, ToolType tool) {
        return tool == ToolType.AXE;
    }
}
