package net.tadditions.mod.client.renderers;

import net.tadditions.mod.client.model.incomplete.AntennaIncompleteModel;
import net.tadditions.mod.client.model.incomplete.FluidLinkIncompleteModel;
import net.tadditions.mod.compat.create.AnimatedSequenceAssemblyItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class IncompleteFluidLinkRenderer extends GeoItemRenderer<AnimatedSequenceAssemblyItem> {
    public IncompleteFluidLinkRenderer() {
        super(new FluidLinkIncompleteModel());
    }

}
