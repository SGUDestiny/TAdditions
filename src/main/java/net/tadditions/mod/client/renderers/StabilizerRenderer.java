package net.tadditions.mod.client.renderers;

import net.tadditions.mod.client.model.NavComModel;
import net.tadditions.mod.client.model.StabilizerModel;
import net.tadditions.mod.items.SubsysItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class StabilizerRenderer extends GeoItemRenderer<SubsysItem> {
    public StabilizerRenderer() {
            super(new StabilizerModel());
    }

}
