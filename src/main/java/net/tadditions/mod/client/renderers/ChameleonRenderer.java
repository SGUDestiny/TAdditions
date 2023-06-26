package net.tadditions.mod.client.renderers;

import net.tadditions.mod.client.model.ChameleonModel;
import net.tadditions.mod.client.model.NavComModel;
import net.tadditions.mod.items.SubsysItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class ChameleonRenderer extends GeoItemRenderer<SubsysItem> {
    public ChameleonRenderer() {
        super(new ChameleonModel());
    }

}
