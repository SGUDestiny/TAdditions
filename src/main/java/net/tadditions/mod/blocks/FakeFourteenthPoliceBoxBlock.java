package net.tadditions.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
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
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.helper.MExteriorRegistry;
import net.tadditions.mod.tileentity.FourteenthPoliceBoxDecoTile;
import net.tardis.mod.blocks.template.NotSolidTileBlock;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.items.TItems;
import net.tardis.mod.schematics.ExteriorUnlockSchematic;
import net.tardis.mod.schematics.Schematics;

import java.util.stream.Stream;

public class FakeFourteenthPoliceBoxBlock extends NotSolidTileBlock {

    public FakeFourteenthPoliceBoxBlock(Properties prop) {
        super(prop);
    }

    private static final VoxelShape SHAPE = Stream.of(Block.makeCuboidShape(0, 0, 0, 16, 32, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote) {
            TileEntity te = worldIn.getTileEntity(pos);
            if (te instanceof FourteenthPoliceBoxDecoTile) {
                ItemStack held = player.getHeldItem(handIn);
                FourteenthPoliceBoxDecoTile fourteenth = (FourteenthPoliceBoxDecoTile) te;
                if(held.getItem() == TItems.SONIC.get()) {
                    held.getCapability(Capabilities.SONIC_CAPABILITY).ifPresent(cap -> {
                        ExteriorUnlockSchematic schematic = Schematics.createExteriorSchematicWithTranslation(new ResourceLocation(QolMod.MOD_ID, "exteriors/fourteenth"), MExteriorRegistry.FOURTEENTH_POLICE_BOX.get());
                        cap.getSchematics().add(schematic);
                        fourteenth.setScanned(true);
                        player.sendStatusMessage(new TranslationTextComponent("message.tardis.computer.downloaded"), true);
                    });
                }
            }
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
}
