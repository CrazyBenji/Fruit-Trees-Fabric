package net.benji.fruittrees.world;

import net.benji.fruittrees.FruitTrees;
import net.benji.fruittrees.block.FruitTreesBlocks;
import net.benji.fruittrees.util.FruitTreesWoodTypes;
import net.benji.fruittrees.util.FruitWoods;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class FruitTreesConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> MANGO_KEY = resourceKey("mango");
    public static final ResourceKey<ConfiguredFeature<?, ?>> POMEGRANATE_KEY = resourceKey("pomegranate");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINEAPPLE_KEY = resourceKey("pineapple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DRAGON_FRUIT_KEY = resourceKey("dragon_fruit");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PEAR_KEY = resourceKey("pear");

    public static final ResourceKey<ConfiguredFeature<?, ?>> HONEYDEW_KEY = resourceKey("honeydew");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CANTALOUPE_KEY = resourceKey("cantaloupe");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUEBERRY_KEY = resourceKey("blueberry");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRANBERRY_KEY = resourceKey("cranberry");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HOT_PEPPER_KEY = resourceKey("pear");

    public static void boostrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        register(context, MANGO_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(FruitWoods.MANGO.LOG),
                new StraightTrunkPlacer(4, 2, 0),
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(FruitTreesBlocks.MANGO_LEAVES.defaultBlockState(), 3)
                        .add(FruitTreesBlocks.FLOWERING_MANGO_LEAVES.defaultBlockState(), 1)),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 2))
                .ignoreVines()
                .build()
        );
        register(context, POMEGRANATE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(FruitWoods.POMEGRANATE.LOG),
                new StraightTrunkPlacer(4, 2, 0),
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(FruitTreesBlocks.POMEGRANATE_LEAVES.defaultBlockState(), 3)
                        .add(FruitTreesBlocks.FLOWERING_POMEGRANATE_LEAVES.defaultBlockState(), 1)),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 2))
                .ignoreVines()
                .build()
        );
        register(context, PINEAPPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(FruitWoods.PINEAPPLE.LOG),
                new StraightTrunkPlacer(4, 2, 0),
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(FruitTreesBlocks.PINEAPPLE_LEAVES.defaultBlockState(), 3)
                        .add(FruitTreesBlocks.FLOWERING_PINEAPPLE_LEAVES.defaultBlockState(), 1)),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 2))
                .ignoreVines()
                .build()
        );
        register(context, DRAGON_FRUIT_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(FruitWoods.DRAGON_FRUIT.LOG),
                new StraightTrunkPlacer(4, 2, 0),
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(FruitTreesBlocks.DRAGON_FRUIT_LEAVES.defaultBlockState(), 3)
                        .add(FruitTreesBlocks.FLOWERING_DRAGON_FRUIT_LEAVES.defaultBlockState(), 1)),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 2))
                .ignoreVines()
                .build()
        );
        register(context, PEAR_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(FruitWoods.PEAR.LOG),
                new StraightTrunkPlacer(4, 2, 0),
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(FruitTreesBlocks.PEAR_LEAVES.defaultBlockState(), 3)
                        .add(FruitTreesBlocks.FLOWERING_PEAR_LEAVES.defaultBlockState(), 1)),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 2))
                .ignoreVines()
                .build()
        );
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> resourceKey(String key) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FruitTrees.MOD_ID, key));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
