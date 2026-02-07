package net.benji.fruittrees.world.tree;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class FruitTreesTreeGrower extends AbstractTreeGrower {
    private final ResourceKey<ConfiguredFeature<?, ?>> RESOURCE_KEY;

    public FruitTreesTreeGrower(ResourceKey<ConfiguredFeature<?, ?>> key) {
        super();
        this.RESOURCE_KEY = key;
    }

    @Override
    protected @Nullable ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomSource, boolean bl) {
        return RESOURCE_KEY;
    }
}
