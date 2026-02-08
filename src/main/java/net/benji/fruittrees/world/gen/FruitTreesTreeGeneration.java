package net.benji.fruittrees.world.gen;

import net.benji.fruittrees.util.FruitTreesTags;
import net.benji.fruittrees.world.FruitTreesPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.levelgen.GenerationStep;

public class FruitTreesTreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.tag(FruitTreesTags.Biomes.MANGO_TREE_BIOMES),
                GenerationStep.Decoration.VEGETAL_DECORATION, FruitTreesPlacedFeatures.MANGO_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(FruitTreesTags.Biomes.POMEGRANATE_TREE_BIOMES),
                GenerationStep.Decoration.VEGETAL_DECORATION, FruitTreesPlacedFeatures.POMEGRANATE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(FruitTreesTags.Biomes.PINEAPPLE_TREE_BIOMES),
                GenerationStep.Decoration.VEGETAL_DECORATION, FruitTreesPlacedFeatures.PINEAPPLE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(FruitTreesTags.Biomes.DRAGON_FRUIT_TREE_BIOMES),
                GenerationStep.Decoration.VEGETAL_DECORATION, FruitTreesPlacedFeatures.DRAGON_FRUIT_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(FruitTreesTags.Biomes.PEAR_TREE_BIOMES),
                GenerationStep.Decoration.VEGETAL_DECORATION, FruitTreesPlacedFeatures.PEAR_PLACED_KEY);
    }
}
