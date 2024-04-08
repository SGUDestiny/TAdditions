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
        this.registerControlEntry(ControlRegistry.MONITOR.get());
    }

    public FourteenthConsoleTile(TileEntityType<?> type) {
        super(type);
        this.controlOverrides.put(FacingControl.class, new ControlOverride(new Vector3d(0.22, 0.47, 1.525), EntitySize.flexible(0.2F, 0.2F)));
        this.controlOverrides.put(StabilizerControl.class, new ControlOverride(new Vector3d(-1.27, 0.4, 0.91),EntitySize.flexible(0.25F, 0.15F)));
        this.controlOverrides.put(TelepathicControl.class, new ControlOverride(new Vector3d(1.15, 0.4, -1.1),EntitySize.flexible(0.3F, 0.2F)));
        this.controlOverrides.put(CommunicatorControl.class, new ControlOverride(new Vector3d(1, 0.6, 0.59),EntitySize.flexible(0.3F, 0.2F)));
        this.controlOverrides.put(RefuelerControl.class, new ControlOverride(new Vector3d(0.075, 0.69, 1.17), EntitySize.flexible(0.12F, 0.12F)));
        this.controlOverrides.put(RandomiserControl.class, new ControlOverride(new Vector3d(-1.3275, 0.48, -0.76),EntitySize.flexible(0.3F, 0.1F)));
        this.controlOverrides.put(HandbrakeControl.class, new ControlOverride(new Vector3d(1.175, 0.55, -0.78), EntitySize.flexible(0.17F, 0.2F)));
        this.controlOverrides.put(DoorControl.class, new ControlOverride(new Vector3d(-0.28, 0.64, 1.1),EntitySize.flexible(0.15F, 0.3F)));
        this.controlOverrides.put(IncModControl.class, new ControlOverride(new Vector3d(-0.88, 0.66, 0.921), EntitySize.flexible(0.2F, 0.1F)));
        this.controlOverrides.put(DimensionControl.class, new ControlOverride(new Vector3d(0, 0.52, -1.5),EntitySize.flexible(0.4F, 0.12F)));
        this.controlOverrides.put(LandingTypeControl.class, new ControlOverride(new Vector3d(-1.075, 0.62, -0.625),EntitySize.flexible(0.3F, 0.15F)));
        this.controlOverrides.put(SonicPortControl.class, new ControlOverride(new Vector3d(0, 0.65, -0.935),EntitySize.flexible(0.15F, 0.15F)));
        this.controlOverrides.put(XControl.class, new ControlOverride(new Vector3d(-1.25, 0.635, 0.205),EntitySize.flexible(0.2F, 0.1F)));
        this.controlOverrides.put(YControl.class, new ControlOverride(new Vector3d(-1.108, 0.66, 0.474),EntitySize.flexible(0.2F, 0.1F)));
        this.controlOverrides.put(ZControl.class, new ControlOverride(new Vector3d(-0.935, 0.645, 0.73),EntitySize.flexible(0.2F, 0.1F)));
        this.controlOverrides.put(ThrottleControl.class, new ControlOverride(new Vector3d(1.25, 0.55, -0.6), EntitySize.flexible(0.17F, 0.2F)));
        this.controlOverrides.put(FastReturnControl.class, new ControlOverride(new Vector3d(-1.475, 0.4, 0.57),EntitySize.flexible(0.25F, 0.15F)));
        this.controlOverrides.put(MonitorControl.class, new ControlOverride(new Vector3d(0.475, 0.8, 0.475), EntitySize.flexible(1.2F, 0.7F)));
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {

        return new AxisAlignedBB(this.getPos()).expand(3, 5, 3);
    }
}
