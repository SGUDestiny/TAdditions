package net.tadditions.mod.tileentity;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;
import net.tadditions.mod.helper.MTextureVariants;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;


public class ToyotaPoliceBoxDecoTile extends TileEntity {

	public boolean scanned;
	public static final AxisAlignedBB RENDER_BOX = new AxisAlignedBB(-2, -2, -2, 2, 5, 2);

	public ToyotaPoliceBoxDecoTile(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}

	public ToyotaPoliceBoxDecoTile() {
		super(ModTileEntitys.DECORATIVE_TOYOTA_POLICE_BOX.get());
	}

	@Override
	public CompoundNBT write(CompoundNBT nbt) {
		nbt.putBoolean("scanned", scanned);
		return super.write(nbt);
	}

	@Override
	public void read(BlockState state, CompoundNBT nbt) {
		this.scanned = nbt.getBoolean("scanned");
		super.read(state, nbt);
	}

	public boolean isScanned(){
		return this.scanned;
	}

	public void setScanned(boolean scanned) {
		this.scanned = scanned;
	}

	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return RENDER_BOX.offset(this.getPos());
	}

}
