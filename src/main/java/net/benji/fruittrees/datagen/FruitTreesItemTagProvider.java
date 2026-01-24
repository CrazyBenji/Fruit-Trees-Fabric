package net.benji.fruittrees.datagen;

import net.benji.fruittrees.item.FruitTreesItems;
import net.benji.fruittrees.util.FruitTreesTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class FruitTreesItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public FruitTreesItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        getOrCreateTagBuilder(ConventionalItemTags.FOODS)
                .addTag(FruitTreesTags.Items.FRUITS)
                .addTag(FruitTreesTags.Items.JUICES);

        getOrCreateTagBuilder(FruitTreesTags.Items.FRUITS)
                .addTag(FruitTreesTags.Items.GOLDEN_FRUITS)
                .addTag(FruitTreesTags.Items.ENCHANTED_GOLDEN_FRUITS)
                .add(FruitTreesItems.MANGO)
                .add(FruitTreesItems.POMEGRANATE)
                .add(FruitTreesItems.PINEAPPLE)
                .add(FruitTreesItems.DRAGON_FRUIT)
                .add(FruitTreesItems.PEAR);

        getOrCreateTagBuilder(FruitTreesTags.Items.GOLDEN_FRUITS);

        getOrCreateTagBuilder(FruitTreesTags.Items.ENCHANTED_GOLDEN_FRUITS);

        getOrCreateTagBuilder(FruitTreesTags.Items.JUICES);

        getOrCreateTagBuilder(ItemTags.PIGLIN_LOVED)
                .addTag(FruitTreesTags.Items.GOLDEN_FRUITS)
                .addTag(FruitTreesTags.Items.ENCHANTED_GOLDEN_FRUITS);
    }
}
