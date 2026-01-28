package net.benji.fruittrees.datagen;

import net.benji.fruittrees.block.FruitTreesBlocks;
import net.benji.fruittrees.item.FruitTreesItems;
import net.benji.fruittrees.util.FruitWood;
import net.benji.fruittrees.util.FruitWoods;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class FruitTreesRecipeProvider extends FabricRecipeProvider {
    public FruitTreesRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        generateFruitWoodRecipes(exporter, FruitWoods.MANGO);
        generateFruitWoodRecipes(exporter, FruitWoods.POMEGRANATE);
        generateFruitWoodRecipes(exporter, FruitWoods.PINEAPPLE);
        generateFruitWoodRecipes(exporter, FruitWoods.DRAGON_FRUIT);
        generateFruitWoodRecipes(exporter, FruitWoods.PEAR);

        this.generateGoldenFruitRecipe(exporter, FruitTreesItems.MANGO, FruitTreesItems.GOLDEN_MANGO);
        this.generateGoldenFruitRecipe(exporter, FruitTreesItems.POMEGRANATE, FruitTreesItems.GOLDEN_POMEGRANATE);
        this.generateGoldenFruitRecipe(exporter, FruitTreesItems.PINEAPPLE, FruitTreesItems.GOLDEN_PINEAPPLE);
        this.generateGoldenFruitRecipe(exporter, FruitTreesItems.DRAGON_FRUIT, FruitTreesItems.GOLDEN_DRAGON_FRUIT);
        this.generateGoldenFruitRecipe(exporter, FruitTreesItems.PEAR, FruitTreesItems.GOLDEN_PEAR);
        this.generateGlisteningFruitRecipe(exporter, FruitTreesItems.HONEYDEW_SLICE, FruitTreesItems.GLISTENING_HONEYDEW_SLICE);
        this.generateGlisteningFruitRecipe(exporter, FruitTreesItems.CANTALOUPE_SLICE, FruitTreesItems.GLISTENING_CANTALOUPE_SLICE);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FruitTreesItems.HONEYDEW_SEEDS)
                .requires(FruitTreesItems.HONEYDEW_SLICE)
                .unlockedBy(getHasName(FruitTreesItems.HONEYDEW_SLICE), has(FruitTreesItems.HONEYDEW_SLICE))
                .save(exporter);
        this.generatePackingRecipe(exporter, RecipeCategory.MISC, FruitTreesItems.HONEYDEW_SLICE, FruitTreesBlocks.HONEYDEW);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FruitTreesItems.CANTALOUPE_SEEDS)
                .requires(FruitTreesItems.CANTALOUPE_SLICE)
                .unlockedBy(getHasName(FruitTreesItems.CANTALOUPE_SLICE), has(FruitTreesItems.CANTALOUPE_SLICE))
                .save(exporter);
        this.generatePackingRecipe(exporter, RecipeCategory.MISC, FruitTreesItems.CANTALOUPE_SLICE, FruitTreesBlocks.CANTALOUPE);
    }

    public void generatePackingRecipe(Consumer<FinishedRecipe> exporter, RecipeCategory category, ItemLike input, ItemLike result) {
        ShapedRecipeBuilder.shaped(category, result, 1)
                .pattern("iii")
                .pattern("iii")
                .pattern("iii")
                .define('i', input)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter, result.asItem() + "_from_packing");
    }

    public void generateGoldenFruitRecipe(Consumer<FinishedRecipe> exporter, ItemLike fruit, ItemLike result) {
        this.generateSurroundedFruitRecipe(exporter, fruit, Items.GOLD_INGOT, result);
    }
    public void generateGlisteningFruitRecipe(Consumer<FinishedRecipe> exporter, ItemLike fruit, ItemLike result) {
        this.generateSurroundedFruitRecipe(exporter, fruit, Items.GOLD_NUGGET, result);
    }

    public void generateSurroundedFruitRecipe(Consumer<FinishedRecipe> exporter, ItemLike fruit, ItemLike surrounding, ItemLike result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, result, 1)
                .pattern("ggg")
                .pattern("gfg")
                .pattern("ggg")
                .define('g', surrounding)
                .define('f', fruit)
                .unlockedBy(getHasName(fruit), has(fruit))
                .save(exporter);
    }

    public void generateFruitWoodRecipes(Consumer<FinishedRecipe> exporter, FruitWood fruitWood) {
        woodFromLogs(exporter, fruitWood.WOOD, fruitWood.LOG);
        woodFromLogs(exporter, fruitWood.STRIPPED_WOOD, fruitWood.STRIPPED_LOG);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, fruitWood.PLANKS, 4)
                .requires(fruitWood.LOGS_ITEM)
                .unlockedBy(getHasName(fruitWood.LOG), has(fruitWood.LOGS_ITEM))
                .save(exporter);
        generateRecipes(exporter, fruitWood.FAMILY);
        hangingSign(exporter, fruitWood.HANGING_SIGN, fruitWood.PLANKS);
    }
}
