package net.benji.fruittrees.datagen;

import net.benji.fruittrees.block.FruitTreesBlocks;
import net.benji.fruittrees.util.FruitTreesTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class FruitTreesBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public FruitTreesBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        this.getOrCreateTagBuilder(FruitTreesTags.Blocks.MANGO_LOGS)
                .add(FruitTreesBlocks.MANGO_LOG)
                .add(FruitTreesBlocks.STRIPPED_MANGO_LOG)
                .add(FruitTreesBlocks.MANGO_WOOD)
                .add(FruitTreesBlocks.STRIPPED_MANGO_WOOD);

        this.getOrCreateTagBuilder(FruitTreesTags.Blocks.POMEGRANATE_LOGS);

        this.getOrCreateTagBuilder(FruitTreesTags.Blocks.PINEAPPLE_LOGS);

        this.getOrCreateTagBuilder(FruitTreesTags.Blocks.DRAGON_FRUIT_LOGS);

        this.getOrCreateTagBuilder(FruitTreesTags.Blocks.PEAR_LOGS);

        this.getOrCreateTagBuilder(BlockTags.LOGS)
                .addTag(FruitTreesTags.Blocks.MANGO_LOGS)
                .addTag(FruitTreesTags.Blocks.POMEGRANATE_LOGS)
                .addTag(FruitTreesTags.Blocks.PINEAPPLE_LOGS)
                .addTag(FruitTreesTags.Blocks.DRAGON_FRUIT_LOGS)
                .addTag(FruitTreesTags.Blocks.PEAR_LOGS);

        this.getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(FruitTreesBlocks.MANGO_PLANKS);

        this.getOrCreateTagBuilder(BlockTags.WOODEN_SLABS);

        this.getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS);

        this.getOrCreateTagBuilder(BlockTags.WOODEN_FENCES);

        this.getOrCreateTagBuilder(BlockTags.FENCE_GATES);

        this.getOrCreateTagBuilder(BlockTags.WOODEN_DOORS);

        this.getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS);

        this.getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS);

        this.getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES);
    }
}
