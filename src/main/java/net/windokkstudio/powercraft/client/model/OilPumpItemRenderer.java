package net.windokkstudio.powercraft.client.model;

import net.windokkstudio.powercraft.items.OilPumpItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class OilPumpItemRenderer extends GeoItemRenderer<OilPumpItem> {
    public OilPumpItemRenderer() {
        super(new OilPumpItemModel());
    }
}
