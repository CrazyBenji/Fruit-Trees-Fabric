package net.benji.fruittrees.datagen;

import net.benji.fruittrees.block.FruitTreesBlocks;
import net.benji.fruittrees.item.FruitTreesItems;
import net.benji.fruittrees.util.FruitTreesBlockFamilies;
import net.benji.fruittrees.util.FruitTreesTags;
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
        woodFromLogs(exporter, FruitTreesBlocks.MANGO_WOOD, FruitTreesBlocks.MANGO_LOG);
        woodFromLogs(exporter, FruitTreesBlocks.STRIPPED_MANGO_WOOD, FruitTreesBlocks.STRIPPED_MANGO_LOG);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, FruitTreesBlocks.MANGO_PLANKS, 4)
                .requires(FruitTreesTags.Items.MANGO_LOGS)
                .unlockedBy(getHasName(FruitTreesBlocks.MANGO_LOG), has(FruitTreesTags.Items.MANGO_LOGS))
                .save(exporter);
        generateRecipes(exporter, FruitTreesBlockFamilies.MANGO_FAMILY);
        hangingSign(exporter, FruitTreesItems.MANGO_HANGING_SIGN, FruitTreesBlocks.MANGO_PLANKS);
    }
}
