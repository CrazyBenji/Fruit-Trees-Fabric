package net.benji.fruittrees.datagen;

import net.benji.fruittrees.util.FruitTreesTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

import java.util.concurrent.CompletableFuture;

public class FruitTreesBiomeTagProvider extends FabricTagProvider<Biome> {
    public FruitTreesBiomeTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.BIOME, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        this.getOrCreateTagBuilder(FruitTreesTags.Biomes.MANGO_TREE_BIOMES)
                .add(Biomes.PLAINS);

        this.getOrCreateTagBuilder(FruitTreesTags.Biomes.POMEGRANATE_TREE_BIOMES);

        this.getOrCreateTagBuilder(FruitTreesTags.Biomes.PINEAPPLE_TREE_BIOMES)
                .add(Biomes.SPARSE_JUNGLE);

        this.getOrCreateTagBuilder(FruitTreesTags.Biomes.DRAGON_FRUIT_TREE_BIOMES);

        this.getOrCreateTagBuilder(FruitTreesTags.Biomes.PEAR_TREE_BIOMES)
                .add(Biomes.SAVANNA);
    }
}
