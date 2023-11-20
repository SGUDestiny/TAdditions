package net.tadditions.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ComparatorBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.tardis.mod.blocks.TileBlock;

public class FlightEventDetectorBlock extends TileBlock {

    public static final IntegerProperty POWER = IntegerProperty.create("power", 0, 15);
    public static final BooleanProperty ALT = BooleanProperty.create("alternative");

    public FlightEventDetectorBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.getDefaultState().with(POWER, 0).with(ALT, false));
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(handIn == Hand.MAIN_HAND && !worldIn.isRemote) {
            //Helper.cycleBlockStateProperty(state, INVERTED);
            worldIn.setBlockState(pos, state.with(ALT, !state.get(ALT)));
        }
        return ActionResultType.func_233537_a_(worldIn.isRemote);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return VoxelShapes.create(0, 0, 0, 1, 0.375, 1);
    }

    @Override
    public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return this.getPower(blockState);
    }

    @Override
    public int getStrongPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return this.getPower(blockState);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(POWER, ALT);
    }

    public int getPower(BlockState state) {
        return state.get(POWER);

    }
}
