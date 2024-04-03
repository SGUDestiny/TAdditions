package net.tadditions.mod.protocol;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;
import net.tadditions.mod.helper.CloakState;
import net.tadditions.mod.helper.IConsoleHelp;
import net.tadditions.mod.helper.IExteriorHelp;
import net.tardis.mod.client.ClientHelper;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.misc.GuiContext;
import net.tardis.mod.network.Network;
import net.tardis.mod.network.packets.ConsoleUpdateMessage;
import net.tardis.mod.network.packets.console.AntigravsData;
import net.tardis.mod.network.packets.console.DataTypes;
import net.tardis.mod.protocols.Protocol;
import net.tardis.mod.tileentities.ConsoleTile;

public class CloakingProtocol extends Protocol {

    public static final String TRANS = "message.tardis.cloak.";
    public static final TranslationTextComponent TRANS_ON = new TranslationTextComponent("protocol.tardis.cloak_on");
    public static final TranslationTextComponent TRANS_OFF = new TranslationTextComponent("protocol.tardis.cloak_off");

    @Override
    public void call(World world, PlayerEntity playerIn, ConsoleTile console) {
        if (!world.isRemote) {
            ((IConsoleHelp) console).setCloakState(!((IConsoleHelp) console).getCloakState());
            console.getOrFindExteriorTile().ifPresent(ex -> ((IExteriorHelp) ex).setCloakState(((IConsoleHelp) console).getCloakState() ? CloakState.CLOAKING : CloakState.UNCLOAKING));
            for (PlayerEntity player : world.getEntitiesWithinAABB(PlayerEntity.class, new AxisAlignedBB(console.getPos()).grow(16))) {
                player.sendStatusMessage(new TranslationTextComponent(TRANS + ((IConsoleHelp) console).getCloakState()), true);
            }
        } else ClientHelper.openGUI(TardisConstants.Gui.NONE, new GuiContext());
    }

    @Override
    public TranslationTextComponent getDisplayName(ConsoleTile tile) {
        return ((IConsoleHelp) tile).getCloakState() ? TRANS_ON : TRANS_OFF;
    }

    @Override
    public String getSubmenu() {
        return TardisConstants.Strings.SECURITY_MENU;
    }
}
