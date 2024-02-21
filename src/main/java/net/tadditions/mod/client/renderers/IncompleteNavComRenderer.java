package net.tadditions.mod.client.renderers;

import net.tadditions.mod.client.model.incomplete.AntennaIncompleteModel;
import net.tadditions.mod.client.model.incomplete.NavComIncompleteModel;
import net.tadditions.mod.compat.create.AnimatedSequenceAssemblyItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class IncompleteNavComRenderer extends GeoItemRenderer<AnimatedSequenceAssemblyItem> {
    public IncompleteNavComRenderer() {
        super(new NavComIncompleteModel());
    }

}
