package net.tadditions.mod.tileentity;

import net.minecraft.fluid.FluidState;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.tadditions.mod.blocks.ModBlocks;
import net.tadditions.mod.helper.TAMultiblockPatterns;
import net.tardis.mod.blocks.TBlocks;
import net.tardis.mod.tileentities.IMultiblock;
import net.tardis.mod.tileentities.MultiblockMasterTile;

public class ReplaceZPFCTile extends TileEntity implements ITickableTileEntity {
    public ReplaceZPFCTile(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public ReplaceZPFCTile() {
        super(ModTileEntitys.REPLACE_ZPFC.get());
    }

    @Override
    public void tick() {
        if(world.getRandom().nextBoolean()) {
            world.setBlockState(pos, ModBlocks.zero_point_field_normal.get().getDefaultState());
            MultiblockMasterTile master = ((MultiblockMasterTile) this.getWorld().getTileEntity(this.getPos()));
            for (BlockPos pos : TAMultiblockPatterns.ZPFC.getPositions()) {
                pos = pos.add(this.getPos());
                if (pos.equals(this.getPos()))
                    continue;
                FluidState fluid = this.getWorld().getFluidState(pos);
                this.getWorld().setBlockState(pos, TBlocks.multiblock.get().getDefaultState().with(BlockStateProperties.WATERLOGGED, fluid.getFluidState().isTagged(FluidTags.WATER)));
                TileEntity te = this.getWorld().getTileEntity(pos);
                if (te instanceof IMultiblock) {
                    ((IMultiblock) te).setMasterPos(this.getPos());
                    master.addSlavePos(pos);
                }
            }
        } else {
            world.setBlockState(pos, ModBlocks.zero_point_field_broken.get().getDefaultState());
            MultiblockMasterTile master = ((MultiblockMasterTile) this.getWorld().getTileEntity(this.getPos()));
            for (BlockPos pos : TAMultiblockPatterns.ZPFC.getPositions()) {
                pos = pos.add(this.getPos());
                if (pos.equals(this.getPos()))
                    continue;
                FluidState fluid = this.getWorld().getFluidState(pos);
                this.getWorld().setBlockState(pos, TBlocks.multiblock.get().getDefaultState().with(BlockStateProperties.WATERLOGGED, fluid.getFluidState().isTagged(FluidTags.WATER)));
                TileEntity te = this.getWorld().getTileEntity(pos);
                if (te instanceof IMultiblock) {
                    ((IMultiblock) te).setMasterPos(this.getPos());
                    master.addSlavePos(pos);
                }
            }
        }
    }
}
