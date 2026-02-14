package net.benji.fruittrees.world;

import net.benji.fruittrees.FruitTrees;
import net.benji.fruittrees.block.FruitTreesBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class FruitTreesPlacedFeatures {
    public static final ResourceKey<PlacedFeature> MANGO_PLACED_KEY = resourceKey("mango_placed");
    public static final ResourceKey<PlacedFeature> POMEGRANATE_PLACED_KEY = resourceKey("pomegranate_placed");
    public static final ResourceKey<PlacedFeature> PINEAPPLE_PLACED_KEY = resourceKey("pineapple_placed");
    public static final ResourceKey<PlacedFeature> DRAGON_FRUIT_PLACED_KEY = resourceKey("dragon_fruit_placed");
    public static final ResourceKey<PlacedFeature> PEAR_PLACED_KEY = resourceKey("pear_placed");

    public static final ResourceKey<PlacedFeature> HONEYDEW_PLACED_KEY = resourceKey("honeydew_placed");
    public static final ResourceKey<PlacedFeature> CANTALOUPE_PLACED_KEY = resourceKey("cantaloupe_placed");
    public static final ResourceKey<PlacedFeature> MIXED_STEM_PLACED_KEY = resourceKey("mixed_stem_placed");

    public static final ResourceKey<PlacedFeature> BLUEBERRY_PLACED_KEY = resourceKey("blueberry_placed");
    public static final ResourceKey<PlacedFeature> CRANBERRY_PLACED_KEY = resourceKey("cranberry_placed");
    public static final ResourceKey<PlacedFeature> HOT_PEPPER_PLACED_KEY = resourceKey("hot_pepper_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, MANGO_PLACED_KEY, configuredFeatures.getOrThrow(FruitTreesConfiguredFeatures.MANGO_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(6, 1F, 1), FruitTreesBlocks.MANGO_SAPLING
                )
        );
        register(context, POMEGRANATE_PLACED_KEY, configuredFeatures.getOrThrow(FruitTreesConfiguredFeatures.POMEGRANATE_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(0, 0.02F, 1)
                )
        );
        register(context, PINEAPPLE_PLACED_KEY, configuredFeatures.getOrThrow(FruitTreesConfiguredFeatures.PINEAPPLE_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(0, 0.2F, 1), FruitTreesBlocks.PINEAPPLE_SAPLING
                )
        );
        register(context, DRAGON_FRUIT_PLACED_KEY, configuredFeatures.getOrThrow(FruitTreesConfiguredFeatures.DRAGON_FRUIT_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(0, 0.02F, 1)
                )
        );
        register(context, PEAR_PLACED_KEY, configuredFeatures.getOrThrow(FruitTreesConfiguredFeatures.PEAR_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(0, 0.1F, 1), FruitTreesBlocks.PEAR_SAPLING
                )
        );

        register(context, HONEYDEW_PLACED_KEY, configuredFeatures.getOrThrow(FruitTreesConfiguredFeatures.HONEYDEW_KEY),
                RarityFilter.onAverageOnceEvery(75), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()
        );
        register(context, CANTALOUPE_PLACED_KEY, configuredFeatures.getOrThrow(FruitTreesConfiguredFeatures.CANTALOUPE_KEY),
                RarityFilter.onAverageOnceEvery(75), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()
        );
        register(context, MIXED_STEM_PLACED_KEY, configuredFeatures.getOrThrow(FruitTreesConfiguredFeatures.MIXED_STEM_KEY),
                RarityFilter.onAverageOnceEvery(75), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

        register(context, BLUEBERRY_PLACED_KEY, configuredFeatures.getOrThrow(FruitTreesConfiguredFeatures.BLUEBERRY_KEY),
                RarityFilter.onAverageOnceEvery(48), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()
        );
        register(context, CRANBERRY_PLACED_KEY, configuredFeatures.getOrThrow(FruitTreesConfiguredFeatures.CRANBERRY_KEY),
                RarityFilter.onAverageOnceEvery(64), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()
        );
        register(context, HOT_PEPPER_PLACED_KEY, configuredFeatures.getOrThrow(FruitTreesConfiguredFeatures.HOT_PEPPER_KEY),
                RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome()
        );
    }


    public static ResourceKey<PlacedFeature> resourceKey(String key) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(FruitTrees.MOD_ID, key));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                                                                          Holder<ConfiguredFeature<?, ?>> configuration,
                                                                                          PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}