package net.tadditions.mod.client.renderers;

import net.tadditions.mod.client.model.AntennaModel;
import net.tadditions.mod.items.SubsysItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class AntennaRenderer extends GeoItemRenderer<SubsysItem> {
    public AntennaRenderer() {
        super(new AntennaModel());
    }

}
