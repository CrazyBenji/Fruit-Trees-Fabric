package net.crazybenji.fruittrees.datagen;

import net.crazybenji.fruittrees.FruitTrees;
import net.crazybenji.fruittrees.block.FruitTreesBlocks;
import net.crazybenji.fruittrees.item.FruitTreesItems;
import net.crazybenji.fruittrees.util.FruitWood;
import net.crazybenji.fruittrees.util.FruitWoods;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class FruitTreesModelProvider extends FabricModelProvider {
    public FruitTreesModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerator) {
        generateFruitWoodBlockModels(blockModelGenerator, FruitWoods.MANGO);
        blockModelGenerator.createTrivialBlock(FruitTreesBlocks.MANGO_LEAVES, TexturedModel.CUBE);
        blockModelGenerator.createTrivialBlock(FruitTreesBlocks.FLOWERING_MANGO_LEAVES, TexturedModel.CUBE);
        blockModelGenerator.createPlant(FruitTreesBlocks.MANGO_SAPLING, FruitTreesBlocks.POTTED_MANGO_SAPLING, BlockModelGenerators.TintState.NOT_TINTED);

        generateFruitWoodBlockModels(blockModelGenerator, FruitWoods.POMEGRANATE);
        blockModelGenerator.copyModel(FruitTreesBlocks.MANGO_LEAVES, FruitTreesBlocks.POMEGRANATE_LEAVES);
        blockModelGenerator.createTrivialBlock(FruitTreesBlocks.FLOWERING_POMEGRANATE_LEAVES, TexturedModel.CUBE);
        blockModelGenerator.createPlant(FruitTreesBlocks.POMEGRANATE_SAPLING, FruitTreesBlocks.POTTED_POMEGRANATE_SAPLING, BlockModelGenerators.TintState.NOT_TINTED);

        generateFruitWoodBlockModels(blockModelGenerator, FruitWoods.PINEAPPLE);
        blockModelGenerator.copyModel(FruitTreesBlocks.MANGO_LEAVES, FruitTreesBlocks.PINEAPPLE_LEAVES);
        blockModelGenerator.createTrivialBlock(FruitTreesBlocks.FLOWERING_PINEAPPLE_LEAVES, TexturedModel.CUBE);
        blockModelGenerator.createPlant(FruitTreesBlocks.PINEAPPLE_SAPLING, FruitTreesBlocks.POTTED_PINEAPPLE_SAPLING, BlockModelGenerators.TintState.NOT_TINTED);

        generateFruitWoodBlockModels(blockModelGenerator, FruitWoods.DRAGON_FRUIT);
        blockModelGenerator.copyModel(FruitTreesBlocks.MANGO_LEAVES, FruitTreesBlocks.DRAGON_FRUIT_LEAVES);
        blockModelGenerator.createTrivialBlock(FruitTreesBlocks.FLOWERING_DRAGON_FRUIT_LEAVES, TexturedModel.CUBE);
        blockModelGenerator.createPlant(FruitTreesBlocks.DRAGON_FRUIT_SAPLING, FruitTreesBlocks.POTTED_DRAGON_FRUIT_SAPLING, BlockModelGenerators.TintState.NOT_TINTED);

        generateFruitWoodBlockModels(blockModelGenerator, FruitWoods.PEAR);
        blockModelGenerator.copyModel(FruitTreesBlocks.MANGO_LEAVES, FruitTreesBlocks.PEAR_LEAVES);
        blockModelGenerator.createTrivialBlock(FruitTreesBlocks.FLOWERING_PEAR_LEAVES, TexturedModel.CUBE);
        blockModelGenerator.createPlant(FruitTreesBlocks.PEAR_SAPLING, FruitTreesBlocks.POTTED_PEAR_SAPLING, BlockModelGenerators.TintState.NOT_TINTED);

        blockModelGenerator.createTrivialBlock(FruitTreesBlocks.HONEYDEW, TexturedModel.COLUMN);
        blockModelGenerator.createStems(FruitTreesBlocks.HONEYDEW_STEM, FruitTreesBlocks.ATTACHED_HONEYDEW_STEM);

        blockModelGenerator.createTrivialBlock(FruitTreesBlocks.CANTALOUPE, TexturedModel.COLUMN);
        blockModelGenerator.createStems(FruitTreesBlocks.CANTALOUPE_STEM, FruitTreesBlocks.ATTACHED_CANTALOUPE_STEM);

        this.generateDynamicBushBlockModel(blockModelGenerator, FruitTreesBlocks.BLUEBERRY_BUSH);
        this.generateDynamicBushBlockModel(blockModelGenerator, FruitTreesBlocks.CRANBERRY_BUSH);
        this.generateDynamicBushBlockModel(blockModelGenerator, FruitTreesBlocks.HOT_PEPPER_BUSH);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(FruitTreesItems.MANGO, ModelTemplates.FLAT_ITEM);
        generateEnchantedAndRegularGoldenFruitItemModels(itemModelGenerator, FruitTreesItems.GOLDEN_MANGO);
        itemModelGenerator.generateFlatItem(FruitTreesItems.MANGO_JUICE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(FruitTreesItems.POMEGRANATE, ModelTemplates.FLAT_ITEM);
        generateEnchantedAndRegularGoldenFruitItemModels(itemModelGenerator, FruitTreesItems.GOLDEN_POMEGRANATE);
        itemModelGenerator.generateFlatItem(FruitTreesItems.POMEGRANATE_JUICE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(FruitTreesItems.PINEAPPLE, ModelTemplates.FLAT_ITEM);
        generateEnchantedAndRegularGoldenFruitItemModels(itemModelGenerator, FruitTreesItems.GOLDEN_PINEAPPLE);
        itemModelGenerator.generateFlatItem(FruitTreesItems.PINEAPPLE_JUICE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(FruitTreesItems.DRAGON_FRUIT, ModelTemplates.FLAT_ITEM);
        generateEnchantedAndRegularGoldenFruitItemModels(itemModelGenerator, FruitTreesItems.GOLDEN_DRAGON_FRUIT);
        itemModelGenerator.generateFlatItem(FruitTreesItems.DRAGON_FRUIT_JUICE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(FruitTreesItems.PEAR, ModelTemplates.FLAT_ITEM);
        generateEnchantedAndRegularGoldenFruitItemModels(itemModelGenerator, FruitTreesItems.GOLDEN_PEAR);
        itemModelGenerator.generateFlatItem(FruitTreesItems.PEAR_JUICE, ModelTemplates.FLAT_ITEM);

        // itemModelGenerator.generateFlatItem(FruitTreesItems.HONEYDEW_SEEDS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FruitTreesItems.HONEYDEW_SLICE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FruitTreesItems.GLISTENING_HONEYDEW_SLICE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FruitTreesItems.HONEYDEW_JUICE, ModelTemplates.FLAT_ITEM);

        // itemModelGenerator.generateFlatItem(FruitTreesItems.CANTALOUPE_SEEDS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FruitTreesItems.CANTALOUPE_SLICE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FruitTreesItems.GLISTENING_CANTALOUPE_SLICE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FruitTreesItems.CANTALOUPE_JUICE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(FruitTreesItems.BLUEBERRIES, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FruitTreesItems.BLUEBERRY_JUICE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(FruitTreesItems.CRANBERRIES, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FruitTreesItems.CRANBERRY_JUICE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(FruitTreesItems.HOT_PEPPER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FruitTreesItems.HOT_PEPPER_SEEDS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FruitTreesItems.HOT_PEPPER_JUICE, ModelTemplates.FLAT_ITEM);

        generateSecretItemModel(itemModelGenerator, "pearto");
        generateSecretItemModel(itemModelGenerator, "bavid");
        generateSecretItemModel(itemModelGenerator, "golden_bavid");
        generateSecretItemModel(itemModelGenerator, "mustard");
    }

    public void generateDynamicBushBlockModel(BlockModelGenerators blockModelGenerator, Block bushBlock) {
        blockModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(bushBlock)
                .with(PropertyDispatch.property(BlockStateProperties.AGE_3)
                        .generate((integer) -> Variant.variant().with(VariantProperties.MODEL,
                                blockModelGenerator.createSuffixedVariant(bushBlock, "_stage" + integer,
                                        ModelTemplates.CROSS, TextureMapping::cross)))));
    }

    public void generateFruitWoodBlockModels(BlockModelGenerators blockModelGenerator, FruitWood fruitWood) {
        blockModelGenerator.woodProvider(fruitWood.LOG).logWithHorizontal(fruitWood.LOG).wood(fruitWood.WOOD);
        blockModelGenerator.woodProvider(fruitWood.STRIPPED_LOG).logWithHorizontal(fruitWood.STRIPPED_LOG).wood(fruitWood.STRIPPED_WOOD);
        blockModelGenerator.family(fruitWood.PLANKS).generateFor(fruitWood.FAMILY);
        blockModelGenerator.createHangingSign(fruitWood.PLANKS, fruitWood.HANGING_SIGN, fruitWood.WALL_HANGING_SIGN);
    }

    public void generateEnchantedAndRegularGoldenFruitItemModels(ItemModelGenerators itemModelGenerator, Item fruitItem) {
        itemModelGenerator.generateFlatItem(fruitItem, ModelTemplates.FLAT_ITEM);
        ResourceLocation resourceLocation = BuiltInRegistries.ITEM.getKey(fruitItem).withPrefix("item/enchanted_");
        ModelTemplates.FLAT_ITEM.create(resourceLocation, TextureMapping.layer0(fruitItem), itemModelGenerator.output);
    }

    public void generateSecretItemModel(ItemModelGenerators itemModelGenerator, String name) {
        ResourceLocation resourceLocation = new ResourceLocation(FruitTrees.MOD_ID, name).withPrefix("item/");
        ModelTemplates.FLAT_ITEM.create(resourceLocation, TextureMapping.layer0(resourceLocation), itemModelGenerator.output);
    }
}
