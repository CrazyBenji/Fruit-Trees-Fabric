package net.benji.fruittrees;

import net.benji.fruittrees.block.FruitTreesBlocks;
import net.benji.fruittrees.block.entity.FruitTreesBlockEntities;
import net.benji.fruittrees.util.FruitWood;
import net.benji.fruittrees.util.FruitWoods;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.impl.client.rendering.ColorProviderRegistryImpl;
import net.fabricmc.fabric.mixin.client.rendering.BlockColorsMixin;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.level.block.StemBlock;

@SuppressWarnings("unused")
public class FruitTreesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        this.registerBlockEntityRenderers();
        this.putBlockRenderLayer();

        ColorProviderRegistry.BLOCK.register((blockState, blockAndTintGetter, blockPos, i) -> 0x1ef73a,
                FruitTreesBlocks.HONEYDEW_STEM, FruitTreesBlocks.ATTACHED_HONEYDEW_STEM);
        ColorProviderRegistry.BLOCK.register((blockState, blockAndTintGetter, blockPos, i) -> 0x49c96f,
                FruitTreesBlocks.CANTALOUPE_STEM, FruitTreesBlocks.ATTACHED_CANTALOUPE_STEM);
    }

    private void registerBlockEntityRenderers() {
        BlockEntityRenderers.register(FruitTreesBlockEntities.FRUIT_TREES_SIGN_BLOCK_ENTITY, SignRenderer::new);
        BlockEntityRenderers.register(FruitTreesBlockEntities.FRUIT_TREES_HANGING_SIGN_BLOCK_ENTITY, HangingSignRenderer::new);
    }

    private void putBlockRenderLayer() {
        BlockRenderLayerMap blockRenderLayerMap = BlockRenderLayerMap.INSTANCE;

        this.renderFruitWoodCutouts(FruitWoods.MANGO, blockRenderLayerMap);
        blockRenderLayerMap.putBlock(FruitTreesBlocks.MANGO_LEAVES, RenderType.cutoutMipped());
        blockRenderLayerMap.putBlock(FruitTreesBlocks.FLOWERING_MANGO_LEAVES, RenderType.cutoutMipped());
        blockRenderLayerMap.putBlock(FruitTreesBlocks.MANGO_SAPLING, RenderType.cutout());
        blockRenderLayerMap.putBlock(FruitTreesBlocks.POTTED_MANGO_SAPLING, RenderType.cutout());

        this.renderFruitWoodCutouts(FruitWoods.POMEGRANATE, blockRenderLayerMap);
        blockRenderLayerMap.putBlock(FruitTreesBlocks.POMEGRANATE_LEAVES, RenderType.cutoutMipped());
        blockRenderLayerMap.putBlock(FruitTreesBlocks.FLOWERING_POMEGRANATE_LEAVES, RenderType.cutoutMipped());
        blockRenderLayerMap.putBlock(FruitTreesBlocks.POMEGRANATE_SAPLING, RenderType.cutout());
        blockRenderLayerMap.putBlock(FruitTreesBlocks.POTTED_POMEGRANATE_SAPLING, RenderType.cutout());

        this.renderFruitWoodCutouts(FruitWoods.PINEAPPLE, blockRenderLayerMap);
        blockRenderLayerMap.putBlock(FruitTreesBlocks.PINEAPPLE_LEAVES, RenderType.cutoutMipped());
        blockRenderLayerMap.putBlock(FruitTreesBlocks.FLOWERING_PINEAPPLE_LEAVES, RenderType.cutoutMipped());
        blockRenderLayerMap.putBlock(FruitTreesBlocks.PINEAPPLE_SAPLING, RenderType.cutout());
        blockRenderLayerMap.putBlock(FruitTreesBlocks.POTTED_PINEAPPLE_SAPLING, RenderType.cutout());

        this.renderFruitWoodCutouts(FruitWoods.DRAGON_FRUIT, blockRenderLayerMap);
        blockRenderLayerMap.putBlock(FruitTreesBlocks.DRAGON_FRUIT_LEAVES, RenderType.cutoutMipped());
        blockRenderLayerMap.putBlock(FruitTreesBlocks.FLOWERING_DRAGON_FRUIT_LEAVES, RenderType.cutoutMipped());
        blockRenderLayerMap.putBlock(FruitTreesBlocks.DRAGON_FRUIT_SAPLING, RenderType.cutout());
        blockRenderLayerMap.putBlock(FruitTreesBlocks.POTTED_DRAGON_FRUIT_SAPLING, RenderType.cutout());

        this.renderFruitWoodCutouts(FruitWoods.PEAR, blockRenderLayerMap);
        blockRenderLayerMap.putBlock(FruitTreesBlocks.PEAR_LEAVES, RenderType.cutoutMipped());
        blockRenderLayerMap.putBlock(FruitTreesBlocks.FLOWERING_PEAR_LEAVES, RenderType.cutoutMipped());
        blockRenderLayerMap.putBlock(FruitTreesBlocks.PEAR_SAPLING, RenderType.cutout());
        blockRenderLayerMap.putBlock(FruitTreesBlocks.POTTED_PEAR_SAPLING, RenderType.cutout());

        blockRenderLayerMap.putBlock(FruitTreesBlocks.HONEYDEW_STEM, RenderType.cutout());
        blockRenderLayerMap.putBlock(FruitTreesBlocks.ATTACHED_HONEYDEW_STEM, RenderType.cutout());
        blockRenderLayerMap.putBlock(FruitTreesBlocks.CANTALOUPE_STEM, RenderType.cutout());
        blockRenderLayerMap.putBlock(FruitTreesBlocks.ATTACHED_CANTALOUPE_STEM, RenderType.cutout());

        blockRenderLayerMap.putBlock(FruitTreesBlocks.BLUEBERRY_BUSH, RenderType.cutout());
        blockRenderLayerMap.putBlock(FruitTreesBlocks.CRANBERRY_BUSH, RenderType.cutout());
        blockRenderLayerMap.putBlock(FruitTreesBlocks.HOT_PEPPER_BUSH, RenderType.cutout());
    }

    private void renderFruitWoodCutouts(FruitWood fruitWood, BlockRenderLayerMap blockRenderLayerMap) {
        blockRenderLayerMap.putBlock(fruitWood.DOOR, RenderType.cutout());
        blockRenderLayerMap.putBlock(fruitWood.TRAPDOOR, RenderType.cutout());
    }
}
