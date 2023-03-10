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

    private static final VoxelShape SHAPE = Stream.of(Block.makeCuboidShape(1.95, 0.275, 1.975, 13.95, 25.525, 14.125)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
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
