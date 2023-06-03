package net.tadditions.mod.tileentity;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.LightType;
import net.tadditions.mod.helper.MTextureVariants;
import net.tardis.mod.texturevariants.TextureVariants;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;


public class ToyotaPoliceBoxExteriorTile extends ExteriorTile {

	public int windowMode = 0;

	public static final AxisAlignedBB RENDER_BOX = new AxisAlignedBB(-2, -2, -2, 2, 5, 2);

	public static final AxisAlignedBB NORTH_BOX = new AxisAlignedBB(0, -1, -0.1, 1, 1, 1);
	public static final AxisAlignedBB EAST_BOX = new AxisAlignedBB(0, -1, 0, 1.1, 1, 1);
	public static final AxisAlignedBB SOUTH_BOX = new AxisAlignedBB(0, -1, 0, 1, 1, 1.1);
	public static final AxisAlignedBB WEST_BOX = new AxisAlignedBB(-0.1, -1, 0, 1, 1, 1);

	public ToyotaPoliceBoxExteriorTile(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}

	public ToyotaPoliceBoxExteriorTile() {
		super(ModTileEntitys.EXTERIOR_TOYOTA_POLICE_BOX.get());
		this.setVariants(MTextureVariants.TOYOTA);
	}

	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return RENDER_BOX.offset(this.getPos());
	}

	@Override
	public AxisAlignedBB getDoorAABB() {
		if(world.getBlockState(getPos()).hasProperty(BlockStateProperties.HORIZONTAL_FACING)) {
			switch(world.getBlockState(getPos()).get(BlockStateProperties.HORIZONTAL_FACING)) {
				case EAST: return EAST_BOX;
				case SOUTH: return SOUTH_BOX;
				case WEST: return WEST_BOX;
				default: return NORTH_BOX;
			}
		}
		return NORTH_BOX;
	}

	@Override
	public float getLightLevel() {
		if (windowMode == 1 && world != null) {
			lightLevel = world.getLightFor(LightType.BLOCK, pos);
			setLightLevel(lightLevel/15);
			return this.lightLevel;
		}
		if(windowMode == 0 && world != null){
			setLightLevel(lightLevel);
		}
		if(windowMode == 2 && world != null){
			lightLevel = ((world.getDayTime() % 24000) / 24000.0f + 0.50f) % 1.0f;
			setLightLevel(lightLevel);
			return this.lightLevel;
		}
		return this.lightLevel;
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		compound.putInt("windowMode", windowMode);
		super.write(compound);
		return compound;
	}


	@Override
	public void read(BlockState state, CompoundNBT compound) {
		windowMode = compound.getInt("windowMode");
		super.read(state, compound);
	}

	public void setWindowMode(int WindowMode){
		this.windowMode = WindowMode;
	}

	public int getWindowMode(){
		return windowMode;
	}

}
