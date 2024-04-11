package net.tadditions.mixin;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.vector.Vector3d;
import net.tadditions.mod.tileentity.FourteenthConsoleTile;
import net.tardis.mod.controls.BaseControl;
import net.tardis.mod.controls.CommunicatorControl;
import net.tardis.mod.entity.ControlEntity;
import net.tardis.mod.registries.ControlRegistry;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.consoles.CoralConsoleTile;
import net.tardis.mod.tileentities.consoles.ToyotaConsoleTile;
import net.tardis.mod.tileentities.consoles.XionConsoleTile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CommunicatorControl.class)
public abstract class CommunicatorControlMixin extends BaseControl{


    public CommunicatorControlMixin(ControlRegistry.ControlEntry entry, ConsoleTile console, ControlEntity entity) {
        super(entry, console, entity);
    }

    @Shadow(remap = false) public abstract Vector3d getPos();
    @Shadow(remap = false) public abstract SoundEvent getFailSound(ConsoleTile console);
    @Shadow(remap = false) public abstract SoundEvent getSuccessSound(ConsoleTile console);
    @Shadow(remap = false) public abstract CompoundNBT serializeNBT();
    @Shadow(remap = false) public abstract void deserializeNBT(CompoundNBT nbt);

    public boolean usePhoneSounds(ConsoleTile tile) {
        return this.getConsole() instanceof CoralConsoleTile || this.getConsole() instanceof XionConsoleTile || this.getConsole() instanceof ToyotaConsoleTile || this.getConsole() instanceof FourteenthConsoleTile;
    }
}
