package net.tadditions.mod.client.renderers;

import net.tadditions.mod.client.model.incomplete.AntennaIncompleteModel;
import net.tadditions.mod.client.model.incomplete.GraceIncompleteModel;
import net.tadditions.mod.compat.create.AnimatedSequenceAssemblyItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class IncompleteGraceRenderer extends GeoItemRenderer<AnimatedSequenceAssemblyItem> {
    public IncompleteGraceRenderer() {
        super(new GraceIncompleteModel());
    }

}
