package net.crazybenji.fruittrees.world.gen;

import net.crazybenji.fruittrees.util.FruitTreesTags;
import net.crazybenji.fruittrees.world.FruitTreesPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.levelgen.GenerationStep;

public class FruitTreesStemBlockGeneration {
    public static void generateStemBlocks() {
        BiomeModifications.addFeature(BiomeSelectors.tag(FruitTreesTags.Biomes.HONEYDEW_SUITABLE),
                GenerationStep.Decoration.VEGETAL_DECORATION, FruitTreesPlacedFeatures.HONEYDEW_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(FruitTreesTags.Biomes.CANTALOUPE_SUITABLE),
                GenerationStep.Decoration.VEGETAL_DECORATION, FruitTreesPlacedFeatures.CANTALOUPE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(FruitTreesTags.Biomes.MIXED_STEM_SUITABLE),
                GenerationStep.Decoration.VEGETAL_DECORATION, FruitTreesPlacedFeatures.MIXED_STEM_PLACED_KEY);
    }
}
