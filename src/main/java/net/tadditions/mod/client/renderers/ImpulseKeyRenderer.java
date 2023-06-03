package net.tadditions.mod.client.renderers;

import net.tadditions.mod.client.model.ImpulseKeyModel;
import net.tadditions.mod.items.CoreKeyItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class ImpulseKeyRenderer extends GeoItemRenderer<CoreKeyItem> {
    public ImpulseKeyRenderer() {
        super(new ImpulseKeyModel());
    }

}
