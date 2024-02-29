package net.windokkstudio.powercraft.client.model;

import net.minecraft.resources.ResourceLocation;
import net.windokkstudio.powercraft.PowerCraft;
import net.windokkstudio.powercraft.items.OilPumpItem;
import software.bernie.geckolib.model.GeoModel;

public class OilPumpItemModel extends GeoModel<OilPumpItem> {
    @Override
    public ResourceLocation getModelResource(OilPumpItem oilPumpItem) {
        return new ResourceLocation(PowerCraft.MODID, "geo/oil_pump.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OilPumpItem oilPumpItem) {
        return new ResourceLocation(PowerCraft.MODID, "textures/block/oil_pump.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OilPumpItem oilPumpItem) {
        return new ResourceLocation(PowerCraft.MODID, "animations/pumping.animation.json");
    }
}
