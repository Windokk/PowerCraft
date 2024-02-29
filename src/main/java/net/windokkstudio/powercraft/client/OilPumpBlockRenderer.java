package net.windokkstudio.powercraft.client;

import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.windokkstudio.powercraft.blocks.entity.OilPumpBlockEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class OilPumpBlockRenderer extends GeoBlockRenderer<OilPumpBlockEntity> {
    public OilPumpBlockRenderer(BlockEntityRendererProvider.Context context) {
        super(new OilPumpBlockModel());
    }
}
