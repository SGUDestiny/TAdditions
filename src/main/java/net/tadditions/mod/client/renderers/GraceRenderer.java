package net.tadditions.mod.client.renderers;

import net.tadditions.mod.client.model.GraceModel;
import net.tadditions.mod.client.model.NavComModel;
import net.tadditions.mod.items.SubsysItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class GraceRenderer extends GeoItemRenderer<SubsysItem> {
    public GraceRenderer() {
        super(new GraceModel());
    }

}
