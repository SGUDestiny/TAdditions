package net.tadditions.mod.client.renderers;

import net.tadditions.mod.client.model.DematModel;
import net.tadditions.mod.client.model.ThermocouplingsModel;
import net.tadditions.mod.items.SubsysItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class ThermocouplingRenderer extends GeoItemRenderer<SubsysItem> {
    public ThermocouplingRenderer() {
        super(new ThermocouplingsModel());
    }

}
