package net.tadditions.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.tileentity.AdvQuantiscopeTile;
import net.tardis.mod.blocks.template.NotSolidTileBlock;
import net.tardis.mod.helper.TInventoryHelper;
import net.tardis.mod.properties.Prop;

public class AdvQuantiscopeBlock extends NotSolidTileBlock {

    public AdvQuantiscopeBlock() {
        super(Prop.Blocks.BASIC_TECH.get());
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        TileEntity te = worldIn.getTileEntity(pos);
        if (!worldIn.isRemote && te instanceof AdvQuantiscopeTile) {
            NetworkHooks.openGui((ServerPlayerEntity) player, new INamedContainerProvider() {

                @Override
                public Container createMenu(int id, PlayerInventory inv, PlayerEntity arg2) {
                    return ((AdvQuantiscopeTile) te).createContainer(id, inv);
                }

                @Override
                public ITextComponent getDisplayName() {
                    return new TranslationTextComponent("container." + QolMod.MOD_ID + ".advquantiscope");
                }
            }, pos);
        }
        return ActionResultType.SUCCESS;
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return super.getStateForPlacement(context).with(BlockStateProperties.HORIZONTAL_FACING, context.getPlayer().getHorizontalFacing().getOpposite());
    }

    @Override
    protected void fillStateContainer(Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
    }

    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        AdvQuantiscopeTile tileEntity = (AdvQuantiscopeTile) worldIn.getTileEntity(pos);
        if (tileEntity != null && state.getBlock() != newState.getBlock()) {
            TInventoryHelper.dropInventoryItems(worldIn, pos, (AdvQuantiscopeTile) tileEntity);
            worldIn.removeTileEntity(pos);
        }
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
