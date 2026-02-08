package net.benji.fruittrees.util;

import net.benji.fruittrees.FruitTrees;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class FruitTreesTags {
    public static class Items {
        public static final TagKey<Item> FRUITS = createTag("fruits");
        public static final TagKey<Item> GOLDEN_FRUITS = createTag("golden_fruits");
        public static final TagKey<Item> ENCHANTED_GOLDEN_FRUITS = createTag("enchanted_golden_fruits");
        public static final TagKey<Item> JUICES = createTag("juices");

        public static TagKey<Item> createTag(String key) {
            return TagKey.create(Registries.ITEM, new ResourceLocation(FruitTrees.MOD_ID, key));
        }
    }

    public static class Blocks {
        public static final TagKey<Block> HOT_PEPPER_BUSH_SUITABLE = createTag("suitable/hot_pepper_bush");

        public static TagKey<Block> createTag(String key) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(FruitTrees.MOD_ID, key));
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> MANGO_TREE_BIOMES = createTag("mango_tree_biomes");
        public static final TagKey<Biome> POMEGRANATE_TREE_BIOMES = createTag("pomegranate_tree_biomes");
        public static final TagKey<Biome> PINEAPPLE_TREE_BIOMES = createTag("pineapple_tree_biomes");
        public static final TagKey<Biome> DRAGON_FRUIT_TREE_BIOMES = createTag("dragon_fruit_tree_biomes");
        public static final TagKey<Biome> PEAR_TREE_BIOMES = createTag("pear_tree_biomes");

        public static TagKey<Biome> createTag(String key) {
            return TagKey.create(Registries.BIOME, new ResourceLocation(FruitTrees.MOD_ID, key));
        }
    }
}
