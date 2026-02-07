package net.benji.fruittrees.world;

import net.benji.fruittrees.FruitTrees;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

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

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> resourceKey(String key) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FruitTrees.MOD_ID, key));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
