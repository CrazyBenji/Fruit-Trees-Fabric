package net.benji.fruittrees;

import net.benji.fruittrees.block.FruitTreesBlocks;
import net.benji.fruittrees.block.entity.FruitTreesBlockEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;

public class FruitTreesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRenderers.register(FruitTreesBlockEntities.FRUIT_TREES_SIGN_BLOCK_ENTITY, SignRenderer::new);
        BlockEntityRenderers.register(FruitTreesBlockEntities.FRUIT_TREES_HANGING_SIGN_BLOCK_ENTITY, HangingSignRenderer::new);

        this.renderCutout();
    }

    private void renderCutout() {
        BlockRenderLayerMap.INSTANCE.putBlock(FruitTreesBlocks.MANGO_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FruitTreesBlocks.MANGO_TRAPDOOR, RenderType.cutout());
    }
}
