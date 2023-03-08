package net.tadditions.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
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
import net.tadditions.mod.screens.MClientHelper;
import net.tadditions.mod.screens.MConstants;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.misc.GuiContext;
import net.tardis.mod.properties.Prop;
import net.tardis.mod.tileentities.ConsoleTile;

import java.util.stream.Stream;

public class FoodMaker extends HorizontalBlock {

    public static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
    public FoodMaker() {
        super(Prop.Blocks.BASIC_TECH.get());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(1.95, 24.175, 2, 5, 25.175, 14.125),
            Block.makeCuboidShape(1.95, 0.275, 1.975, 13.95, 25.5, 14.125),
            Block.makeCuboidShape(14, 2, 6, 14.25, 9, 10),
            Block.makeCuboidShape(1.75, 2, 6, 2, 9, 10),
            Block.makeCuboidShape(14, 11, 4, 14.25, 14.25, 12)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(1.9, 24.175, 1.98, 14, 25.175, 5),
            Block.makeCuboidShape(1.9, 0.275, 1.98, 14, 25.5245, 13.98),
            Block.makeCuboidShape(6, 2, 14, 10, 9, 14.28),
            Block.makeCuboidShape(6, 2, 1.78125, 10, 9, 2),
            Block.makeCuboidShape(4, 11, 14, 12, 14.25, 14.28)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(11, 24.175, 1.94, 14, 25.175, 14),
            Block.makeCuboidShape(2, 0.275, 1.94, 14, 25.5245, 14),
            Block.makeCuboidShape(1.75, 2, 6, 2, 9, 10),
            Block.makeCuboidShape(14, 2, 6, 14.25, 9, 10),
            Block.makeCuboidShape(1.75, 11, 4, 2, 14.25, 12)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(1.96875, 24.175, 11.03, 14, 25.175, 14),
            Block.makeCuboidShape(1.94376, 0.275, 2, 14.09375, 25.525, 14),
            Block.makeCuboidShape(5.96875, 2, 1.78, 9.96875, 9, 2),
            Block.makeCuboidShape(5.96875, 2, 14.03, 9.96875, 9, 14.3),
            Block.makeCuboidShape(3.96875, 11, 1.78, 11.96875, 14.25, 2)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(HORIZONTAL_FACING)){
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            case SOUTH:
                return SHAPE_S;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

        if (!WorldHelper.isDimensionBlocked(worldIn)) {
            if (worldIn.isRemote)
                MClientHelper.openGUI(MConstants.Gui.FOODMAKER, new GuiContext());
        } else if (!worldIn.isRemote()) {
            player.sendStatusMessage(TardisConstants.Translations.NO_USE_OUTSIDE_TARDIS, true);
        }



        return ActionResultType.SUCCESS;
    }


}
