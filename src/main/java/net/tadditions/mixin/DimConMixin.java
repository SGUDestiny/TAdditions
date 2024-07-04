package net.tadditions.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.tadditions.mod.helper.IConsoleHelp;
import net.tardis.mod.controls.BaseControl;
import net.tardis.mod.controls.DimensionControl;
import net.tardis.mod.entity.ControlEntity;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.network.Network;
import net.tardis.mod.network.packets.ConsoleUpdateMessage;
import net.tardis.mod.network.packets.console.DataTypes;
import net.tardis.mod.network.packets.console.DimensionData;
import net.tardis.mod.registries.ControlRegistry;
import net.tardis.mod.sounds.TSounds;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.consoles.*;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(DimensionControl.class)
public abstract class DimConMixin extends BaseControl {

    private static final String MESSAGE = "message.tardis.control.dimchange";
    private int index = 0;

    public DimConMixin(ControlRegistry.ControlEntry entry, ConsoleTile console, ControlEntity entity) {
        super(entry, console, entity);
    }

    @Override
    public Vector3d getPos() {
        if(this.getConsole() instanceof NemoConsoleTile)
            return new Vector3d(0, 12 / 16.0, 8 / 16.0);

        if(this.getConsole() instanceof GalvanicConsoleTile)
            return new Vector3d(0.004546756986454792, 0.5499999970197678, 0.43130290108982927);


        if(getConsole() instanceof CoralConsoleTile){
            return new Vector3d(-0.1918160605288799, 0.28125, 0.85162353648727);
        }

        if(this.getConsole() instanceof HartnellConsoleTile)
            return new Vector3d(0.605, 0.469, -0.516);

        if(this.getConsole() instanceof ToyotaConsoleTile)
            return new Vector3d(-0.557, 0.438, -0.313);

        if(this.getConsole() instanceof XionConsoleTile)
            return new Vector3d(-0.4978632379852379, 0.5, 0.30190849470534653);

        if(this.getConsole() instanceof NeutronConsoleTile)
            return new Vector3d(0.04, 0.40625, 0.8683701375027411);

        if(this.getConsole() instanceof KeltConsoleTile)
            return new Vector3d(-0.9009227420613739, 0.28125, -0.5234101003733683);

        return new Vector3d(-0.1 / 16.0, 7 / 16.0, 12 / 16.0);
    }

    private boolean doDimChangeAction(ConsoleTile console, PlayerEntity player) {
        if(!console.getWorld().isRemote() && console.getLandTime() <= 0) {
            if(!((IConsoleHelp) console).getAvailable().isEmpty()) {
                this.modIndex(player.isSneaking() ? -1 : 1);
                console.setDestination(((IConsoleHelp) console).getAvailable().get(index), console.getDestinationPosition());
                player.sendStatusMessage(new TranslationTextComponent(MESSAGE).appendSibling(new StringTextComponent(WorldHelper.formatDimName(((IConsoleHelp) console).getAvailable().get(index))).mergeStyle(TextFormatting.LIGHT_PURPLE)), true);
                this.startAnimation();

                ConsoleTile tile = this.getConsole();
                if(tile != null)
                    Network.sendToTrackingTE(new ConsoleUpdateMessage(DataTypes.DIMENSION_LIST, new DimensionData(((IConsoleHelp) tile).getAvailable().size(), this.index)), tile);
            }
            else index = 0;
            return true;
        }
        return false;
    }

    private void modIndex(int i) {
        if(this.index + i >= ((IConsoleHelp) this.getConsole()).getAvailable().size()) {
            this.index = 0;
            return;
        }
        if(this.index + i < 0) {
            this.index = ((IConsoleHelp) this.getConsole()).getAvailable().size() - 1;
            return;
        }
        this.index += i;
    }

    @Override
    public SoundEvent getFailSound(ConsoleTile console) {
        return TSounds.SONIC_FAIL.get();
    }

    @Override
    public SoundEvent getSuccessSound(ConsoleTile console) {
        return TSounds.DIMENSION.get();
    }

    @Override
    public void deserializeNBT(CompoundNBT tag) {}

    @Override
    public CompoundNBT serializeNBT() {
        return new CompoundNBT();
    }
}
