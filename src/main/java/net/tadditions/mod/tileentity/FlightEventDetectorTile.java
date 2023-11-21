package net.tadditions.mod.tileentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneLampBlock;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.tadditions.mod.blocks.FlightEventDetectorBlock;
import net.tardis.mod.blocks.VortexDetectorBlock;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.TTiles;

public class FlightEventDetectorTile extends TileEntity implements ITickableTileEntity{

	public FlightEventDetectorTile() {
		this(ModTileEntitys.FLIGHT_EVENT_DETECTOR.get());
	}

	public FlightEventDetectorTile(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}

	@Override
	public void tick() {
		if(!world.isRemote) {
			ConsoleTile tile = TardisHelper.getConsoleInWorld(getWorld()).orElse(null);
			boolean shouldBeOn = this.shouldBeOn();
			if(shouldBeOn){
				if(this.getMode()){
					altMode();
				} else mainMode(tile);
			}
		}
	}
	
	private boolean shouldBeOn() {
		ConsoleTile tile = TardisHelper.getConsoleInWorld(getWorld()).orElse(null);
		if(tile != null) {
			return !tile.getFlightEvent().isComplete();
		}
		return false;
	}

	private void altMode(){
		ConsoleTile tile = TardisHelper.getConsoleInWorld(getWorld()).orElse(null);
		BlockState state = world.getBlockState(getPos());
		int timeleft = tile.getFlightEvent().getMissedTime() - tile.flightTicks;
		int power = timeleft/15;
		if(power>15)
			power = 15;
		world.setBlockState(getPos(), state.with(FlightEventDetectorBlock.POWER, power));
	}

	private void mainMode(ConsoleTile tile){
		BlockState state = world.getBlockState(getPos());
		world.setBlockState(getPos(), state.with(FlightEventDetectorBlock.POWER, tile.getFlightEvent() != null ? 15 : 0));
	}

	private boolean getMode() {
		BlockState state = world.getBlockState(getPos());
		return state.get(FlightEventDetectorBlock.ALT);
	}

}
