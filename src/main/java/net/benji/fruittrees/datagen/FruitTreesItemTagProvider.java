package net.benji.fruittrees.datagen;

import net.benji.fruittrees.item.FruitTreesItems;
import net.benji.fruittrees.util.FruitTreesTags;
import net.benji.fruittrees.util.FruitWoods;
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
                .add(FruitTreesItems.PEAR)
                .add(FruitTreesItems.HONEYDEW_SLICE)
                .add(FruitTreesItems.CANTALOUPE_SLICE)
                .add(FruitTreesItems.BLUEBERRIES)
                .add(FruitTreesItems.CRANBERRIES)
                .add(FruitTreesItems.HOT_PEPPER);

        this.getOrCreateTagBuilder(FruitTreesTags.Items.GOLDEN_FRUITS)
                .addTag(FruitTreesTags.Items.ENCHANTED_GOLDEN_FRUITS)
                .add(FruitTreesItems.GOLDEN_MANGO)
                .add(FruitTreesItems.GOLDEN_POMEGRANATE)
                .add(FruitTreesItems.GOLDEN_PINEAPPLE)
                .add(FruitTreesItems.GOLDEN_DRAGON_FRUIT)
                .add(FruitTreesItems.GOLDEN_PEAR)
                .add(FruitTreesItems.GLISTENING_HONEYDEW_SLICE)
                .add(FruitTreesItems.GLISTENING_CANTALOUPE_SLICE);

        this.getOrCreateTagBuilder(FruitTreesTags.Items.ENCHANTED_GOLDEN_FRUITS)
                .add(FruitTreesItems.ENCHANTED_GOLDEN_MANGO)
                .add(FruitTreesItems.ENCHANTED_GOLDEN_POMEGRANATE)
                .add(FruitTreesItems.ENCHANTED_GOLDEN_PINEAPPLE)
                .add(FruitTreesItems.ENCHANTED_GOLDEN_DRAGON_FRUIT)
                .add(FruitTreesItems.ENCHANTED_GOLDEN_PEAR);

        this.getOrCreateTagBuilder(FruitTreesTags.Items.JUICES)
                .add(FruitTreesItems.MANGO_JUICE)
                .add(FruitTreesItems.POMEGRANATE_JUICE)
                .add(FruitTreesItems.PINEAPPLE_JUICE)
                .add(FruitTreesItems.DRAGON_FRUIT_JUICE)
                .add(FruitTreesItems.PEAR_JUICE)
                .add(FruitTreesItems.HONEYDEW_JUICE)
                .add(FruitTreesItems.CANTALOUPE_JUICE)
                .add(FruitTreesItems.BLUEBERRY_JUICE)
                .add(FruitTreesItems.CRANBERRY_JUICE)
                .add(FruitTreesItems.HOT_PEPPER_JUICE);

        this.copy(FruitWoods.MANGO.LOGS_BLOCK, FruitWoods.MANGO.LOGS_ITEM);
        this.copy(FruitWoods.POMEGRANATE.LOGS_BLOCK, FruitWoods.POMEGRANATE.LOGS_ITEM);
        this.copy(FruitWoods.PINEAPPLE.LOGS_BLOCK, FruitWoods.PINEAPPLE.LOGS_ITEM);
        this.copy(FruitWoods.DRAGON_FRUIT.LOGS_BLOCK, FruitWoods.DRAGON_FRUIT.LOGS_ITEM);
        this.copy(FruitWoods.PEAR.LOGS_BLOCK, FruitWoods.PEAR.LOGS_ITEM);

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

        this.copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
        this.copy(BlockTags.LEAVES, ItemTags.LEAVES);
    }
}
