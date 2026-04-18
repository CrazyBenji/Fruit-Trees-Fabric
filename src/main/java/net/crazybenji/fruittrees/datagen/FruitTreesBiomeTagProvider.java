package net.crazybenji.fruittrees.datagen;

import net.crazybenji.fruittrees.util.FruitTreesTags;
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
        this.getOrCreateTagBuilder(FruitTreesTags.Biomes.MANGO_TREE_SUITABLE)
                .add(Biomes.JUNGLE);

        this.getOrCreateTagBuilder(FruitTreesTags.Biomes.POMEGRANATE_TREE_SUITABLE)
                .add(Biomes.DESERT);

        this.getOrCreateTagBuilder(FruitTreesTags.Biomes.PINEAPPLE_TREE_SUITABLE)
                .add(Biomes.SPARSE_JUNGLE);

        this.getOrCreateTagBuilder(FruitTreesTags.Biomes.DRAGON_FRUIT_TREE_SUITABLE)
                .add(Biomes.BADLANDS)
                .add(Biomes.ERODED_BADLANDS);

        this.getOrCreateTagBuilder(FruitTreesTags.Biomes.PEAR_TREE_SUITABLE)
                .add(Biomes.SAVANNA);

        this.getOrCreateTagBuilder(FruitTreesTags.Biomes.HONEYDEW_SUITABLE)
                .add(Biomes.FLOWER_FOREST)
                .add(Biomes.SUNFLOWER_PLAINS);

        this.getOrCreateTagBuilder(FruitTreesTags.Biomes.CANTALOUPE_SUITABLE)
                .add(Biomes.MEADOW)
                .add(Biomes.WINDSWEPT_HILLS);

        this.getOrCreateTagBuilder(FruitTreesTags.Biomes.MIXED_STEM_SUITABLE)
                .add(Biomes.PLAINS);

        this.getOrCreateTagBuilder(FruitTreesTags.Biomes.BLUEBERRY_BUSH_SUITABLE)
                .add(Biomes.FOREST);

        this.getOrCreateTagBuilder(FruitTreesTags.Biomes.CRANBERRY_BUSH_SUITABLE)
                .add(Biomes.BIRCH_FOREST)
                .add(Biomes.OLD_GROWTH_BIRCH_FOREST);

        this.getOrCreateTagBuilder(FruitTreesTags.Biomes.HOT_PEPPER_BUSH_SUITABLE)
                .add(Biomes.NETHER_WASTES);
    }
}
