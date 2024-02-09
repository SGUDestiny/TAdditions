package net.tadditions.mod.tileentity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;
import net.tardis.mod.registries.ControlRegistry;
import net.tardis.mod.tileentities.ConsoleTile;

public class FourteenthConsoleTile extends ConsoleTile {

    public FourteenthConsoleTile() {

        super(ModTileEntitys.FOURTEENTH_CONSOLE.get());
        this.registerControlEntry(ControlRegistry.MONITOR.get());
    }

    public FourteenthConsoleTile(TileEntityType<?> type) {
        super(type);
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {

        return new AxisAlignedBB(this.getPos()).expand(2, 4, 2);
    }
}
