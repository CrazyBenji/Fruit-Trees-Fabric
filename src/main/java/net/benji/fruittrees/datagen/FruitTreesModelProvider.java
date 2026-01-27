package net.benji.fruittrees.datagen;

import net.benji.fruittrees.FruitTrees;
import net.benji.fruittrees.block.FruitTreesBlocks;
import net.benji.fruittrees.item.FruitTreesItems;
import net.benji.fruittrees.util.FruitTreesBlockFamilies;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class FruitTreesModelProvider extends FabricModelProvider {
    public FruitTreesModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerator) {
        blockModelGenerator.woodProvider(FruitTreesBlocks.MANGO_LOG).logWithHorizontal(FruitTreesBlocks.MANGO_LOG).wood(FruitTreesBlocks.MANGO_WOOD);
        blockModelGenerator.woodProvider(FruitTreesBlocks.STRIPPED_MANGO_LOG).logWithHorizontal(FruitTreesBlocks.STRIPPED_MANGO_LOG).wood(FruitTreesBlocks.STRIPPED_MANGO_WOOD);

        blockModelGenerator.family(FruitTreesBlocks.MANGO_PLANKS).generateFor(FruitTreesBlockFamilies.MANGO_FAMILY);
        blockModelGenerator.createHangingSign(FruitTreesBlocks.MANGO_PLANKS, FruitTreesBlocks.MANGO_HANGING_SIGN, FruitTreesBlocks.MANGO_WALL_HANGING_SIGN);

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(FruitTreesItems.MANGO, ModelTemplates.FLAT_ITEM);
        registerEnchantedAndRegularGoldenFruit(itemModelGenerator, FruitTreesItems.GOLDEN_MANGO);

        itemModelGenerator.generateFlatItem(FruitTreesItems.POMEGRANATE, ModelTemplates.FLAT_ITEM);
        registerEnchantedAndRegularGoldenFruit(itemModelGenerator, FruitTreesItems.GOLDEN_POMEGRANATE);

        itemModelGenerator.generateFlatItem(FruitTreesItems.PINEAPPLE, ModelTemplates.FLAT_ITEM);
        registerEnchantedAndRegularGoldenFruit(itemModelGenerator, FruitTreesItems.GOLDEN_PINEAPPLE);

        itemModelGenerator.generateFlatItem(FruitTreesItems.DRAGON_FRUIT, ModelTemplates.FLAT_ITEM);
        registerEnchantedAndRegularGoldenFruit(itemModelGenerator, FruitTreesItems.GOLDEN_DRAGON_FRUIT);

        itemModelGenerator.generateFlatItem(FruitTreesItems.PEAR, ModelTemplates.FLAT_ITEM);
        registerEnchantedAndRegularGoldenFruit(itemModelGenerator, FruitTreesItems.GOLDEN_PEAR);

        registerSecret(itemModelGenerator, "pearto");
        registerSecret(itemModelGenerator, "bavid");
    }

    public void registerEnchantedAndRegularGoldenFruit(ItemModelGenerators itemModelGenerator, Item fruitItem) {
        itemModelGenerator.generateFlatItem(fruitItem, ModelTemplates.FLAT_ITEM);
        ResourceLocation resourceLocation = BuiltInRegistries.ITEM.getKey(fruitItem).withPrefix("item/enchanted_");
        ModelTemplates.FLAT_ITEM.create(resourceLocation, TextureMapping.layer0(fruitItem), itemModelGenerator.output);
    }

    public void registerSecret(ItemModelGenerators itemModelGenerator, String name) {
        ResourceLocation resourceLocation = new ResourceLocation(FruitTrees.MOD_ID, name).withPrefix("item/");
        ModelTemplates.FLAT_ITEM.create(resourceLocation, TextureMapping.layer0(resourceLocation), itemModelGenerator.output);
    }
}
