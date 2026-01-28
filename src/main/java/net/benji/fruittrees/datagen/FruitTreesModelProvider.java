package net.benji.fruittrees.datagen;

import net.benji.fruittrees.FruitTrees;
import net.benji.fruittrees.block.FruitTreesBlocks;
import net.benji.fruittrees.item.FruitTreesItems;
import net.benji.fruittrees.util.FruitWood;
import net.benji.fruittrees.util.FruitWoods;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class FruitTreesModelProvider extends FabricModelProvider {
    public FruitTreesModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerator) {
        generateFruitWoodBlockModels(blockModelGenerator, FruitWoods.MANGO);
        generateFruitWoodBlockModels(blockModelGenerator, FruitWoods.POMEGRANATE);
        generateFruitWoodBlockModels(blockModelGenerator, FruitWoods.PINEAPPLE);
        generateFruitWoodBlockModels(blockModelGenerator, FruitWoods.DRAGON_FRUIT);
        generateFruitWoodBlockModels(blockModelGenerator, FruitWoods.PEAR);

        blockModelGenerator.createTrivialBlock(FruitTreesBlocks.HONEYDEW, TexturedModel.COLUMN);
        blockModelGenerator.createStems(FruitTreesBlocks.HONEYDEW_STEM, FruitTreesBlocks.ATTACHED_HONEYDEW_STEM);

        blockModelGenerator.createTrivialBlock(FruitTreesBlocks.CANTALOUPE, TexturedModel.COLUMN);
        blockModelGenerator.createStems(FruitTreesBlocks.CANTALOUPE_STEM, FruitTreesBlocks.ATTACHED_CANTALOUPE_STEM);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(FruitTreesItems.MANGO, ModelTemplates.FLAT_ITEM);
        generateEnchantedAndRegularGoldenFruit(itemModelGenerator, FruitTreesItems.GOLDEN_MANGO);

        itemModelGenerator.generateFlatItem(FruitTreesItems.POMEGRANATE, ModelTemplates.FLAT_ITEM);
        generateEnchantedAndRegularGoldenFruit(itemModelGenerator, FruitTreesItems.GOLDEN_POMEGRANATE);

        itemModelGenerator.generateFlatItem(FruitTreesItems.PINEAPPLE, ModelTemplates.FLAT_ITEM);
        generateEnchantedAndRegularGoldenFruit(itemModelGenerator, FruitTreesItems.GOLDEN_PINEAPPLE);

        itemModelGenerator.generateFlatItem(FruitTreesItems.DRAGON_FRUIT, ModelTemplates.FLAT_ITEM);
        generateEnchantedAndRegularGoldenFruit(itemModelGenerator, FruitTreesItems.GOLDEN_DRAGON_FRUIT);

        itemModelGenerator.generateFlatItem(FruitTreesItems.PEAR, ModelTemplates.FLAT_ITEM);
        generateEnchantedAndRegularGoldenFruit(itemModelGenerator, FruitTreesItems.GOLDEN_PEAR);

        itemModelGenerator.generateFlatItem(FruitTreesItems.HONEYDEW_SLICE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FruitTreesItems.GLISTENING_HONEYDEW_SLICE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(FruitTreesItems.CANTALOUPE_SLICE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FruitTreesItems.GLISTENING_CANTALOUPE_SLICE, ModelTemplates.FLAT_ITEM);

        generateSecret(itemModelGenerator, "pearto");
        generateSecret(itemModelGenerator, "bavid");
    }

    public void generateFruitWoodBlockModels(BlockModelGenerators blockModelGenerator, FruitWood fruitWood) {
        blockModelGenerator.woodProvider(fruitWood.LOG).logWithHorizontal(fruitWood.LOG).wood(fruitWood.WOOD);
        blockModelGenerator.woodProvider(fruitWood.STRIPPED_LOG).logWithHorizontal(fruitWood.STRIPPED_LOG).wood(fruitWood.STRIPPED_WOOD);
        blockModelGenerator.family(fruitWood.PLANKS).generateFor(fruitWood.FAMILY);
        blockModelGenerator.createHangingSign(fruitWood.PLANKS, fruitWood.HANGING_SIGN, fruitWood.WALL_HANGING_SIGN);
    }

    public void generateEnchantedAndRegularGoldenFruit(ItemModelGenerators itemModelGenerator, Item fruitItem) {
        itemModelGenerator.generateFlatItem(fruitItem, ModelTemplates.FLAT_ITEM);
        ResourceLocation resourceLocation = BuiltInRegistries.ITEM.getKey(fruitItem).withPrefix("item/enchanted_");
        ModelTemplates.FLAT_ITEM.create(resourceLocation, TextureMapping.layer0(fruitItem), itemModelGenerator.output);
    }

    public void generateSecret(ItemModelGenerators itemModelGenerator, String name) {
        ResourceLocation resourceLocation = new ResourceLocation(FruitTrees.MOD_ID, name).withPrefix("item/");
        ModelTemplates.FLAT_ITEM.create(resourceLocation, TextureMapping.layer0(resourceLocation), itemModelGenerator.output);
    }
}
