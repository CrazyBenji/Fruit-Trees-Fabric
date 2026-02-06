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
        this.generateGoldenFruitRecipe(exporter, FruitTreesItems.MANGO, FruitTreesItems.GOLDEN_MANGO);
        this.generateFruitJuiceRecipe(exporter, FruitTreesItems.MANGO, FruitTreesItems.MANGO_JUICE);
        generateFruitWoodRecipes(exporter, FruitWoods.MANGO);

        this.generateGoldenFruitRecipe(exporter, FruitTreesItems.POMEGRANATE, FruitTreesItems.GOLDEN_POMEGRANATE);
        this.generateFruitJuiceRecipe(exporter, FruitTreesItems.POMEGRANATE, FruitTreesItems.POMEGRANATE_JUICE);
        generateFruitWoodRecipes(exporter, FruitWoods.POMEGRANATE);

        this.generateGoldenFruitRecipe(exporter, FruitTreesItems.PINEAPPLE, FruitTreesItems.GOLDEN_PINEAPPLE);
        this.generateFruitJuiceRecipe(exporter, FruitTreesItems.PINEAPPLE, FruitTreesItems.PINEAPPLE_JUICE);
        generateFruitWoodRecipes(exporter, FruitWoods.PINEAPPLE);

        this.generateGoldenFruitRecipe(exporter, FruitTreesItems.DRAGON_FRUIT, FruitTreesItems.GOLDEN_DRAGON_FRUIT);
        this.generateFruitJuiceRecipe(exporter, FruitTreesItems.DRAGON_FRUIT, FruitTreesItems.DRAGON_FRUIT_JUICE);
        generateFruitWoodRecipes(exporter, FruitWoods.DRAGON_FRUIT);

        this.generateGoldenFruitRecipe(exporter, FruitTreesItems.PEAR, FruitTreesItems.GOLDEN_PEAR);
        this.generateFruitJuiceRecipe(exporter, FruitTreesItems.PEAR, FruitTreesItems.PEAR_JUICE);
        generateFruitWoodRecipes(exporter, FruitWoods.PEAR);

        this.generateGlisteningFruitRecipe(exporter, FruitTreesItems.HONEYDEW_SLICE, FruitTreesItems.GLISTENING_HONEYDEW_SLICE);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FruitTreesItems.HONEYDEW_SEEDS)
                .requires(FruitTreesItems.HONEYDEW_SLICE)
                .unlockedBy(getHasName(FruitTreesItems.HONEYDEW_SLICE), has(FruitTreesItems.HONEYDEW_SLICE))
                .save(exporter);
        this.generateFruitJuiceRecipe(exporter, FruitTreesItems.HONEYDEW_SLICE, FruitTreesItems.HONEYDEW_JUICE);
        this.generatePackingRecipe(exporter, RecipeCategory.MISC, FruitTreesItems.HONEYDEW_SLICE, FruitTreesBlocks.HONEYDEW);

        this.generateGlisteningFruitRecipe(exporter, FruitTreesItems.CANTALOUPE_SLICE, FruitTreesItems.GLISTENING_CANTALOUPE_SLICE);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FruitTreesItems.CANTALOUPE_SEEDS)
                .requires(FruitTreesItems.CANTALOUPE_SLICE)
                .unlockedBy(getHasName(FruitTreesItems.CANTALOUPE_SLICE), has(FruitTreesItems.CANTALOUPE_SLICE))
                .save(exporter);
        this.generateFruitJuiceRecipe(exporter, FruitTreesItems.CANTALOUPE_SLICE, FruitTreesItems.CANTALOUPE_JUICE);
        this.generatePackingRecipe(exporter, RecipeCategory.MISC, FruitTreesItems.CANTALOUPE_SLICE, FruitTreesBlocks.CANTALOUPE);

        this.generateFruitJuiceRecipe(exporter, FruitTreesItems.BLUEBERRIES, FruitTreesItems.BLUEBERRY_JUICE);

        this.generateFruitJuiceRecipe(exporter, FruitTreesItems.CRANBERRIES, FruitTreesItems.CRANBERRY_JUICE);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FruitTreesItems.HOT_PEPPER_SEEDS)
                .requires(FruitTreesItems.HOT_PEPPER)
                .unlockedBy(getHasName(FruitTreesItems.HOT_PEPPER), has(FruitTreesItems.HOT_PEPPER))
                .save(exporter);
        this.generateFruitJuiceRecipe(exporter, FruitTreesItems.HOT_PEPPER, FruitTreesItems.HOT_PEPPER_JUICE);
    }

    public void generateFruitJuiceRecipe(Consumer<FinishedRecipe> exporter, ItemLike fruitItem, ItemLike juice) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, juice, 1)
                .requires(fruitItem, 3)
                .requires(Items.GLASS_BOTTLE, 1)
                .unlockedBy(getHasName(fruitItem), has(fruitItem))
                .save(exporter);
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
