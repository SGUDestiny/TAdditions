package net.tadditions.mod.client.renderers;

import net.tadditions.mod.client.model.DematModel;
import net.tadditions.mod.client.model.MurasamaModel;
import net.tadditions.mod.items.SubsysItem;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class MurasamaRenderer extends GeoItemRenderer<SubsysItem> {
    public MurasamaRenderer() {
        super(new MurasamaModel());
    }

}
