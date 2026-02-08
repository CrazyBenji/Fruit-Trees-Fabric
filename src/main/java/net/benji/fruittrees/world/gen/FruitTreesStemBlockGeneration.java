package net.benji.fruittrees.world.gen;

import net.benji.fruittrees.util.FruitTreesTags;
import net.benji.fruittrees.world.FruitTreesPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.levelgen.GenerationStep;

public class FruitTreesStemBlockGeneration {
    public static void generateStemBlocks() {
        BiomeModifications.addFeature(BiomeSelectors.tag(FruitTreesTags.Biomes.HONEYDEW_SUITABLE),
                GenerationStep.Decoration.VEGETAL_DECORATION, FruitTreesPlacedFeatures.HONEYDEW_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(FruitTreesTags.Biomes.CANTALOUPE_SUITABLE),
                GenerationStep.Decoration.VEGETAL_DECORATION, FruitTreesPlacedFeatures.CANTALOUPE_PLACED_KEY);
    }
}
