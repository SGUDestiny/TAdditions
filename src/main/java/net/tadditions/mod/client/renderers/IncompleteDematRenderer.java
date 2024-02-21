package net.tadditions.mod.client.renderers;

import net.tadditions.mod.client.model.AntennaModel;
import net.tadditions.mod.client.model.incomplete.AntennaIncompleteModel;
import net.tadditions.mod.client.model.incomplete.DematIncompleteModel;
import net.tadditions.mod.compat.create.AnimatedSequenceAssemblyItem;
import net.tadditions.mod.items.SubsysItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class IncompleteDematRenderer extends GeoItemRenderer<AnimatedSequenceAssemblyItem> {
    public IncompleteDematRenderer() {
        super(new DematIncompleteModel());
    }

}
