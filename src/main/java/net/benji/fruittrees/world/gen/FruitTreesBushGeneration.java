package net.benji.fruittrees.world.gen;

import net.benji.fruittrees.util.FruitTreesTags;
import net.benji.fruittrees.world.FruitTreesPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.levelgen.GenerationStep;

public class FruitTreesBushGeneration {
    public static void generateBushes() {
        BiomeModifications.addFeature(BiomeSelectors.tag(FruitTreesTags.Biomes.BLUEBERRY_BUSH_SUITABLE),
                GenerationStep.Decoration.VEGETAL_DECORATION, FruitTreesPlacedFeatures.BLUEBERRY_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(FruitTreesTags.Biomes.CRANBERRY_BUSH_SUITABLE),
                GenerationStep.Decoration.VEGETAL_DECORATION, FruitTreesPlacedFeatures.CRANBERRY_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(FruitTreesTags.Biomes.HOT_PEPPER_BUSH_SUITABLE),
                GenerationStep.Decoration.UNDERGROUND_DECORATION, FruitTreesPlacedFeatures.HOT_PEPPER_PLACED_KEY);
    }
}
