package net.tadditions.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.tadditions.mod.items.ContainmentChamberItem;
import net.tadditions.mod.items.ModItems;
import net.tardis.mod.blocks.TileBlock;

import java.util.stream.Stream;

public class ContainmentChamberBlock extends TileBlock {

    public static final BooleanProperty BROKEN = BooleanProperty.create("broken");

    public ContainmentChamberBlock(Properties prop) {
        super(prop);
        this.setDefaultState(this.getDefaultState().with(BROKEN, false));
    }

    public BlockRenderType getRenderType(BlockState p_149645_1_) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }


    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return super.getStateForPlacement(context).with(BROKEN, false);
    }

    @Override
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        ItemStack stack = new ItemStack(this);
        if(stack.getItem() instanceof ContainmentChamberItem)
        {
            ContainmentChamberItem item = (ContainmentChamberItem) stack.getItem();
            item.setBroken(stack, state.get(BROKEN));
        }
        return stack;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(BROKEN);
    }

}
