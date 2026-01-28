package net.benji.fruittrees.datagen;

import net.benji.fruittrees.block.FruitTreesBlocks;
import net.benji.fruittrees.item.FruitTreesItems;
import net.benji.fruittrees.util.FruitTreesTags;
import net.benji.fruittrees.util.FruitWood;
import net.benji.fruittrees.util.FruitWoods;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.*;

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
