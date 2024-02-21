package net.tadditions.mod.client.renderers;

import net.tadditions.mod.client.model.incomplete.AntennaIncompleteModel;
import net.tadditions.mod.client.model.incomplete.ChameleonIncompleteModel;
import net.tadditions.mod.compat.create.AnimatedSequenceAssemblyItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class IncompleteChameleonRenderer extends GeoItemRenderer<AnimatedSequenceAssemblyItem> {
    public IncompleteChameleonRenderer() {
        super(new ChameleonIncompleteModel());
    }

}
