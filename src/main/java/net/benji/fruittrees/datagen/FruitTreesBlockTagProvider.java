package net.benji.fruittrees.datagen;

import net.benji.fruittrees.block.FruitTreesBlocks;
import net.benji.fruittrees.util.FruitWood;
import net.benji.fruittrees.util.FruitWoods;
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
        generateFruitWoodTags(FruitWoods.MANGO);
        generateFruitWoodTags(FruitWoods.POMEGRANATE);
        generateFruitWoodTags(FruitWoods.PINEAPPLE);
        generateFruitWoodTags(FruitWoods.DRAGON_FRUIT);
    }

    public void generateFruitWoodTags(FruitWood fruitWood) {
        this.getOrCreateTagBuilder(fruitWood.LOGS_BLOCK)
                .add(fruitWood.LOG)
                .add(fruitWood.STRIPPED_LOG)
                .add(fruitWood.WOOD)
                .add(fruitWood.STRIPPED_WOOD);
        this.getOrCreateTagBuilder(BlockTags.LOGS)
                .addTag(fruitWood.LOGS_BLOCK);
        this.getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .addTag(fruitWood.LOGS_BLOCK);
        this.getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(fruitWood.PLANKS);
        this.getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(fruitWood.SLAB);
        this.getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(fruitWood.STAIRS);
        this.getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(fruitWood.FENCE);
        this.getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(fruitWood.FENCE_GATE);
        this.getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(fruitWood.DOOR);
        this.getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(fruitWood.TRAPDOOR);
        this.getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(fruitWood.BUTTON);
        this.getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(fruitWood.PRESSURE_PLATE);
        this.getOrCreateTagBuilder(BlockTags.SIGNS)
                .add(fruitWood.SIGN);
        this.getOrCreateTagBuilder(BlockTags.WALL_SIGNS)
                .add(fruitWood.WALL_SIGN);
        this.getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS)
                .add(fruitWood.HANGING_SIGN);
        this.getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS)
                .add(fruitWood.WALL_HANGING_SIGN);
    }
}
