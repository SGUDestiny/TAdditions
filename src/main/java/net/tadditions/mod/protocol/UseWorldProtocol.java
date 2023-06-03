package net.tadditions.mod.protocol;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.NBTTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.tadditions.mod.helper.IConsoleHelp;
import net.tardis.mod.client.ClientHelper;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.misc.GuiContext;
import net.tardis.mod.network.Network;
import net.tardis.mod.network.packets.ConsoleUpdateMessage;
import net.tardis.mod.network.packets.console.DataType;
import net.tardis.mod.network.packets.console.DataTypes;
import net.tardis.mod.protocols.Protocol;
import net.tardis.mod.tileentities.ConsoleTile;

public class UseWorldProtocol extends Protocol {

	@Override
	public void call(World world, PlayerEntity playerIn, ConsoleTile console) {
		if(!world.isRemote) {
			BlockState state = console.getBlockState();
			this.shiftMode(console);
			for(PlayerEntity player : world.getEntitiesWithinAABB(PlayerEntity.class, new AxisAlignedBB(console.getPos()).grow(16))) {
				player.sendStatusMessage(new TranslationTextComponent("message.tardis.window_mode." + ((IConsoleHelp) console).getWindowMode()), true);

				world.notifyBlockUpdate(console.getPos(), state, console.getBlockState(), 1);
            }
		}
		else ClientHelper.openGUI(TardisConstants.Gui.NONE, new GuiContext());
	}

	@Override
	public TranslationTextComponent getDisplayName(ConsoleTile tile) {
		return new TranslationTextComponent("protocol.tardis.window_mode." + ((IConsoleHelp) tile).getWindowMode());
	}

	@Override
	public String getSubmenu() {
		return TardisConstants.Strings.EXTERIOR_PROPERTIES;
	}

	public void shiftMode(ConsoleTile tile){
		if(((IConsoleHelp) tile).getWindowMode() < 2){
			int winmode = ((IConsoleHelp) tile).getWindowMode();
			((IConsoleHelp) tile).setWindowMode(++winmode);
		} else ((IConsoleHelp) tile).setWindowMode(0);
	}
}
