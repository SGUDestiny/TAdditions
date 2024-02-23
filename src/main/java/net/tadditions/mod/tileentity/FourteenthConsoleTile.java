package net.tadditions.mod.tileentity;

import net.minecraft.entity.EntitySize;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.tardis.mod.controls.*;
import net.tardis.mod.registries.ControlRegistry;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.console.misc.ControlOverride;

public class FourteenthConsoleTile extends ConsoleTile {

    public FourteenthConsoleTile() {

        this(ModTileEntitys.FOURTEENTH_CONSOLE.get());
        //super(ModTileEntitys.FOURTEENTH_CONSOLE.get());
        this.registerControlEntry(ControlRegistry.MONITOR.get());
    }

    public FourteenthConsoleTile(TileEntityType<?> type) {
        super(type);
        this.controlOverrides.put(FacingControl.class, new ControlOverride(new Vector3d(0.22, 0.47, 1.525), EntitySize.flexible(0.2F, 0.2F)));
        this.controlOverrides.put(StabilizerControl.class, new ControlOverride(new Vector3d(0.275, 0.438, -0.988),EntitySize.flexible(0.1875F, 0.1875F)));
        this.controlOverrides.put(TelepathicControl.class, new ControlOverride(new Vector3d(1.15, 0.4, -1.1),EntitySize.flexible(0.3F, 0.2F)));
        this.controlOverrides.put(CommunicatorControl.class, new ControlOverride(new Vector3d(1, 0.6, 0.59),EntitySize.flexible(0.3F, 0.2F)));
        this.controlOverrides.put(RefuelerControl.class, new ControlOverride(new Vector3d(0.075, 0.69, 1.17), EntitySize.flexible(0.12F, 0.12F)));
        this.controlOverrides.put(RandomiserControl.class, new ControlOverride(new Vector3d(-0.814, 0.531, 0.007),EntitySize.flexible(0.25F, 0.25F)));
        this.controlOverrides.put(HandbrakeControl.class, new ControlOverride(new Vector3d(1.175, 0.55, -0.78), EntitySize.flexible(0.17F, 0.2F)));
        this.controlOverrides.put(DoorControl.class, new ControlOverride(new Vector3d(-0.28, 0.64, 1.1),EntitySize.flexible(0.15F, 0.3F)));
        this.controlOverrides.put(IncModControl.class, new ControlOverride(new Vector3d(1.019, 0.281, 0.33), EntitySize.flexible(0.25F, 0.25F)));
        this.controlOverrides.put(DimensionControl.class, new ControlOverride(new Vector3d(-0.451, 0.562, -0.693),EntitySize.flexible(0.1875F, 0.1875F)));
        this.controlOverrides.put(LandingTypeControl.class, new ControlOverride(new Vector3d(-0.034, 0.594, 0.884),EntitySize.flexible(0.24999999999999994F, 0.25F)));
        this.controlOverrides.put(SonicPortControl.class, new ControlOverride(new Vector3d(0.784, 0.562, -0.001),EntitySize.flexible(0.3125F, 0.3125F)));
        this.controlOverrides.put(XControl.class, new ControlOverride(new Vector3d(1.4, 1, -1),EntitySize.flexible(0.125F, 0.125F)));
        this.controlOverrides.put(YControl.class, new ControlOverride(new Vector3d(-1.181, 0.406, 0.013),EntitySize.flexible(0.125F, 0.125F)));
        this.controlOverrides.put(ZControl.class, new ControlOverride(new Vector3d(-1.182, 0.406, 0.149),EntitySize.flexible(0.125F, 0.125F)));
        this.controlOverrides.put(ThrottleControl.class, new ControlOverride(new Vector3d(1.25, 0.55, -0.6), EntitySize.flexible(0.17F, 0.2F)));
        this.controlOverrides.put(FastReturnControl.class, new ControlOverride(new Vector3d(0.237, 0.281, -1.056),EntitySize.flexible(0.125F, 0.125F)));
        this.controlOverrides.put(MonitorControl.class, new ControlOverride(new Vector3d(-0.165, 1.406, -0.895), EntitySize.flexible(0.5F, 0.5F)));
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {

        return new AxisAlignedBB(this.getPos()).expand(3, 5, 3);
    }
}
