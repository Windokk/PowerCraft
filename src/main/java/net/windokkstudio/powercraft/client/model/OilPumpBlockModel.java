package net.windokkstudio.powercraft.client.model;

import net.minecraft.resources.ResourceLocation;
import net.windokkstudio.powercraft.PowerCraft;
import net.windokkstudio.powercraft.blocks.entity.OilPumpBlockEntity;
import net.windokkstudio.powercraft.init.PowercraftBlocks;
import software.bernie.geckolib.model.GeoModel;

public class OilPumpBlockModel extends GeoModel<OilPumpBlockEntity> {
    @Override
    public ResourceLocation getModelResource(OilPumpBlockEntity animatable) {
        return new ResourceLocation(PowerCraft.MODID, "geo/oil_pump.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OilPumpBlockEntity animatable) {
        return new ResourceLocation(PowerCraft.MODID, "textures/block/oil_pump.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OilPumpBlockEntity animatable) {
        return new ResourceLocation(PowerCraft.MODID, "animations/pumping.animation.json");
    }
}
