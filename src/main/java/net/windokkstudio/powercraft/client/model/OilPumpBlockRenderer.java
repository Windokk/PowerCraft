package net.windokkstudio.powercraft.client.model;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.windokkstudio.powercraft.blocks.entity.OilPumpBlockEntity;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class OilPumpBlockRenderer extends GeoBlockRenderer<OilPumpBlockEntity> {
    public OilPumpBlockRenderer(BlockEntityRendererProvider.Context context) {
        super(new OilPumpBlockModel());
    }
}
