package net.tadditions.mod.client.renderers;

import net.tadditions.mod.client.model.incomplete.AntennaIncompleteModel;
import net.tadditions.mod.client.model.incomplete.ShieldGeneratorIncompleteModel;
import net.tadditions.mod.compat.create.AnimatedSequenceAssemblyItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class IncompleteShieldRenderer extends GeoItemRenderer<AnimatedSequenceAssemblyItem> {
    public IncompleteShieldRenderer() {
        super(new ShieldGeneratorIncompleteModel());
    }

}
