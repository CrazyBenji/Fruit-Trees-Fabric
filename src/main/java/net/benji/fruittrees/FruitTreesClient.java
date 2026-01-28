package net.benji.fruittrees;

import net.benji.fruittrees.block.FruitTreesBlocks;
import net.benji.fruittrees.block.entity.FruitTreesBlockEntities;
import net.benji.fruittrees.util.FruitTreesTags;
import net.benji.fruittrees.util.FruitWood;
import net.benji.fruittrees.util.FruitWoods;
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

        this.renderFruitWoodCutouts(FruitWoods.MANGO);
        this.renderFruitWoodCutouts(FruitWoods.POMEGRANATE);
        this.renderFruitWoodCutouts(FruitWoods.PINEAPPLE);
        this.renderFruitWoodCutouts(FruitWoods.DRAGON_FRUIT);

        BlockRenderLayerMap.INSTANCE.putBlock(FruitTreesBlocks.HONEYDEW_STEM, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FruitTreesBlocks.ATTACHED_HONEYDEW_STEM, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FruitTreesBlocks.CANTALOUPE_STEM, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FruitTreesBlocks.ATTACHED_CANTALOUPE_STEM, RenderType.cutout());
    }

    private void renderFruitWoodCutouts(FruitWood fruitWood) {
        BlockRenderLayerMap.INSTANCE.putBlock(fruitWood.DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(fruitWood.TRAPDOOR, RenderType.cutout());
    }
}
