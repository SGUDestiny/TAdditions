package net.tadditions.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.tadditions.mod.helper.IConsoleHelp;
import net.tardis.mod.controls.DimensionControl;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.network.Network;
import net.tardis.mod.network.packets.ConsoleUpdateMessage;
import net.tardis.mod.network.packets.console.DataTypes;
import net.tardis.mod.network.packets.console.DimensionData;
import net.tardis.mod.tileentities.ConsoleTile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(DimensionControl.class)
public abstract class DimConMixin {

    @Shadow(remap = false) private static final String MESSAGE = "message.tardis.control.dimchange";
    @Shadow(remap = false) private int index = 0;

    /**
     * @author mistersecret312
     * @reason Dimension Unlocking
     */
    @Overwrite(remap = false)
    private boolean doDimChangeAction(ConsoleTile console, PlayerEntity player) {
        if(!console.getWorld().isRemote() && console.getLandTime() <= 0) {
            if(!((IConsoleHelp) console).getAvailable().isEmpty()) {
                this.modIndex(player.isSneaking() ? -1 : 1);
                console.setDestination(((IConsoleHelp) console).getAvailable().get(index), console.getDestinationPosition());
                player.sendStatusMessage(new TranslationTextComponent(MESSAGE).appendSibling(new StringTextComponent(WorldHelper.formatDimName(((IConsoleHelp) console).getAvailable().get(index))).mergeStyle(TextFormatting.LIGHT_PURPLE)), true);
                ((DimensionControl) (Object) this).startAnimation();

                ConsoleTile tile = ((DimensionControl) (Object) this).getConsole();
                if(tile != null)
                    Network.sendToTrackingTE(new ConsoleUpdateMessage(DataTypes.DIMENSION_LIST, new DimensionData(((IConsoleHelp) tile).getAvailable().size(), this.index)), tile);
            }
            else index = 0;
            return true;
        }
        return false;
    }

    /**
     * @author mistersecret312
     * @reason Dimension Unlocking(scrolling through availables)
     */
    @Overwrite(remap = false)
    private void modIndex(int i) {
        if(this.index + i >= ((IConsoleHelp) ((DimensionControl) (Object) this).getConsole()).getAvailable().size()) {
            this.index = 0;
            return;
        }
        if(this.index + i < 0) {
            this.index = ((IConsoleHelp) ((DimensionControl) (Object) this).getConsole()).getAvailable().size() - 1;
            return;
        }
        this.index += i;
    }
}
