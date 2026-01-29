package net.benji.fruittrees;

import net.benji.fruittrees.block.FruitTreesBlocks;
import net.benji.fruittrees.block.entity.FruitTreesBlockEntities;
import net.benji.fruittrees.util.FruitWood;
import net.benji.fruittrees.util.FruitWoods;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;

@SuppressWarnings("unused")
public class FruitTreesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        this.registerBlockEntityRenderers();
        this.putBlockRenderLayer();
    }

    private void registerBlockEntityRenderers() {
        BlockEntityRenderers.register(FruitTreesBlockEntities.FRUIT_TREES_SIGN_BLOCK_ENTITY, SignRenderer::new);
        BlockEntityRenderers.register(FruitTreesBlockEntities.FRUIT_TREES_HANGING_SIGN_BLOCK_ENTITY, HangingSignRenderer::new);
    }

    private void putBlockRenderLayer() {
        this.renderFruitWoodCutouts(FruitWoods.MANGO);
        BlockRenderLayerMap.INSTANCE.putBlock(FruitTreesBlocks.MANGO_LEAVES, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FruitTreesBlocks.FLOWERING_MANGO_LEAVES, RenderType.translucent());
        //BlockRenderLayerMap.INSTANCE.putBlock(FruitTreesBlocks.MANGO_SAPLING, RenderType.cutout());
        //BlockRenderLayerMap.INSTANCE.putBlock(FruitTreesBlocks.POTTED_MANGO_SAPLING, RenderType.cutout());

        this.renderFruitWoodCutouts(FruitWoods.POMEGRANATE);
        BlockRenderLayerMap.INSTANCE.putBlock(FruitTreesBlocks.POMEGRANATE_LEAVES, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FruitTreesBlocks.FLOWERING_POMEGRANATE_LEAVES, RenderType.translucent());
        //BlockRenderLayerMap.INSTANCE.putBlock(FruitTreesBlocks.POMEGRANATE_SAPLING, RenderType.cutout());
        //BlockRenderLayerMap.INSTANCE.putBlock(FruitTreesBlocks.POTTED_POMEGRANATE_SAPLING, RenderType.cutout());

        this.renderFruitWoodCutouts(FruitWoods.PINEAPPLE);
        BlockRenderLayerMap.INSTANCE.putBlock(FruitTreesBlocks.PINEAPPLE_LEAVES, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FruitTreesBlocks.FLOWERING_PINEAPPLE_LEAVES, RenderType.translucent());
        //BlockRenderLayerMap.INSTANCE.putBlock(FruitTreesBlocks.PINEAPPLE_SAPLING, RenderType.cutout());
        //BlockRenderLayerMap.INSTANCE.putBlock(FruitTreesBlocks.POTTED_PINEAPPLE_SAPLING, RenderType.cutout());

        this.renderFruitWoodCutouts(FruitWoods.DRAGON_FRUIT);
        BlockRenderLayerMap.INSTANCE.putBlock(FruitTreesBlocks.DRAGON_FRUIT_LEAVES, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FruitTreesBlocks.FLOWERING_DRAGON_FRUIT_LEAVES, RenderType.translucent());
        //BlockRenderLayerMap.INSTANCE.putBlock(FruitTreesBlocks.DRAGON_FRUIT_SAPLING, RenderType.cutout());
        //BlockRenderLayerMap.INSTANCE.putBlock(FruitTreesBlocks.POTTED_DRAGON_FRUIT_SAPLING, RenderType.cutout());

        this.renderFruitWoodCutouts(FruitWoods.PEAR);
        BlockRenderLayerMap.INSTANCE.putBlock(FruitTreesBlocks.PEAR_LEAVES, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FruitTreesBlocks.FLOWERING_PEAR_LEAVES, RenderType.translucent());
        //BlockRenderLayerMap.INSTANCE.putBlock(FruitTreesBlocks.PEAR_SAPLING, RenderType.cutout());
        //BlockRenderLayerMap.INSTANCE.putBlock(FruitTreesBlocks.POTTED_PEAR_SAPLING, RenderType.cutout());

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
