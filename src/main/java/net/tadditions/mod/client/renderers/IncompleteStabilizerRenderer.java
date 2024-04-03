package net.tadditions.mod.client.renderers;

import net.tadditions.mod.client.model.incomplete.AntennaIncompleteModel;
import net.tadditions.mod.client.model.incomplete.StabilizerIncompleteModel;
import net.tadditions.mod.compat.create.AnimatedSequenceAssemblyItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class IncompleteStabilizerRenderer extends GeoItemRenderer<AnimatedSequenceAssemblyItem> {
    public IncompleteStabilizerRenderer() {
        super(new StabilizerIncompleteModel());
    }

}
