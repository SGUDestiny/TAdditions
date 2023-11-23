package net.tadditions.mod.client.renderers;

import net.tadditions.mod.client.model.AntennaModel;
import net.tadditions.mod.client.model.ArcaneGuideBookModel;
import net.tadditions.mod.items.ArcaneGuidebookItem;
import net.tadditions.mod.items.SubsysItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class ArcaneGuideBookRenderer extends GeoItemRenderer<ArcaneGuidebookItem> {
    public ArcaneGuideBookRenderer() {
        super(new ArcaneGuideBookModel());
    }

}
