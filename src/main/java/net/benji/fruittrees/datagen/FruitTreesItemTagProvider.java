package net.benji.fruittrees.datagen;

import net.benji.fruittrees.item.FruitTreesItems;
import net.benji.fruittrees.util.FruitTreesTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class FruitTreesItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public FruitTreesItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture, BlockTagProvider blockTagsProvider) {
        super(output, completableFuture, blockTagsProvider);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.getOrCreateTagBuilder(ConventionalItemTags.FOODS)
                .addTag(FruitTreesTags.Items.FRUITS)
                .addTag(FruitTreesTags.Items.JUICES);

        this.getOrCreateTagBuilder(FruitTreesTags.Items.FRUITS)
                .addTag(FruitTreesTags.Items.GOLDEN_FRUITS)
                .addTag(FruitTreesTags.Items.ENCHANTED_GOLDEN_FRUITS)
                .add(FruitTreesItems.MANGO)
                .add(FruitTreesItems.POMEGRANATE)
                .add(FruitTreesItems.PINEAPPLE)
                .add(FruitTreesItems.DRAGON_FRUIT)
                .add(FruitTreesItems.PEAR);

        this.getOrCreateTagBuilder(FruitTreesTags.Items.GOLDEN_FRUITS);

        this.getOrCreateTagBuilder(FruitTreesTags.Items.ENCHANTED_GOLDEN_FRUITS);

        this.getOrCreateTagBuilder(FruitTreesTags.Items.JUICES);

        this.copy(FruitTreesTags.Blocks.MANGO_LOGS, FruitTreesTags.Items.MANGO_LOGS);
        this.copy(FruitTreesTags.Blocks.POMEGRANATE_LOGS, FruitTreesTags.Items.POMEGRANATE_LOGS);
        this.copy(FruitTreesTags.Blocks.PINEAPPLE_LOGS, FruitTreesTags.Items.PINEAPPLE_LOGS);
        this.copy(FruitTreesTags.Blocks.DRAGON_FRUIT_LOGS, FruitTreesTags.Items.DRAGON_FRUIT_LOGS);
        this.copy(FruitTreesTags.Blocks.PEAR_LOGS, FruitTreesTags.Items.PEAR_LOGS);

        this.getOrCreateTagBuilder(ItemTags.PIGLIN_LOVED)
                .addTag(FruitTreesTags.Items.GOLDEN_FRUITS)
                .addTag(FruitTreesTags.Items.ENCHANTED_GOLDEN_FRUITS);

        this.copy(BlockTags.LOGS, ItemTags.LOGS);
        this.copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
        this.copy(BlockTags.PLANKS, ItemTags.PLANKS);
        this.copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        this.copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
        this.copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        this.copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);
        this.copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
        this.copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);
        this.copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
        this.copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
        this.copy(BlockTags.SIGNS, ItemTags.SIGNS);
        this.copy(BlockTags.CEILING_HANGING_SIGNS, ItemTags.HANGING_SIGNS);
    }
}
