package com.rusticdelight.client;

import com.rusticdelight.register.BlockRegister;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class RusticDelightClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(
                RenderLayer.getCutout(),
                BlockRegister.WILD_BELL_PEPPER,
                BlockRegister.WILD_COTTON,
                BlockRegister.COTTON,
                BlockRegister.BELL_PEPPER
        );
    }
}
