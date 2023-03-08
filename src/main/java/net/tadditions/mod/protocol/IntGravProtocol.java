package net.tadditions.mod.protocol;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.tadditions.mod.helper.IConsoleHelp;
import net.tardis.mod.client.ClientHelper;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.misc.GuiContext;
import net.tardis.mod.network.Network;
import net.tardis.mod.network.packets.ConsoleUpdateMessage;
import net.tardis.mod.network.packets.console.AntigravsData;
import net.tardis.mod.network.packets.console.DataTypes;
import net.tardis.mod.protocols.Protocol;
import net.tardis.mod.tileentities.ConsoleTile;

public class IntGravProtocol extends Protocol {

	public static final String TRANS = "message.tardis.int_gravs.";
	public static final TranslationTextComponent TRANS_ON = new TranslationTextComponent("protocol.tardis.intgrav_on");
	public static final TranslationTextComponent TRANS_OFF = new TranslationTextComponent("protocol.tardis.intgrav_off");

	@Override
	public void call(World world, PlayerEntity playerIn, ConsoleTile console) {
	//	if(!world.isRemote) {
	//		((IConsoleHelp) console).setIntGrav(!((IConsoleHelp) console).getIntGrav());
	//		for(PlayerEntity player : world.getEntitiesWithinAABB(PlayerEntity.class, new AxisAlignedBB(console.getPos()).grow(16))) {
	//			player.sendStatusMessage(new TranslationTextComponent(TRANS + ((IConsoleHelp) console).getIntGrav()), true);
	//		}
	//		Network.sendToAllAround(new ConsoleUpdateMessage(DataTypes.ANTIGRAVS, new AntigravsData(console.getAntiGrav())), playerIn.world.getDimensionKey(), playerIn.getPosition(), 64);
	//	}
	//	else ClientHelper.openGUI(TardisConstants.Gui.NONE, new GuiContext());
	}

	//@Override
	//public TranslationTextComponent getDisplayName(ConsoleTile tile) {
	//	return ((IConsoleHelp) tile).getIntGrav() ? TRANS_ON : TRANS_OFF;
	//}

	@Override
	public String getSubmenu() {
		return TardisConstants.Strings.SECURITY_MENU;
	}
}
