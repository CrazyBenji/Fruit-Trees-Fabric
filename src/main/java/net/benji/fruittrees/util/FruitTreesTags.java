package net.benji.fruittrees.util;

import net.benji.fruittrees.FruitTrees;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class FruitTreesTags {
    public static class Items {
        public static final TagKey<Item> FRUITS = createTag("fruits");
        public static final TagKey<Item> GOLDEN_FRUITS = createTag("golden_fruits");
        public static final TagKey<Item> ENCHANTED_GOLDEN_FRUITS = createTag("enchanted_golden_fruits");
        public static final TagKey<Item> JUICES = createTag("juices");

        public static final TagKey<Item> MANGO_LOGS = createTag("mango_logs");
        public static final TagKey<Item> POMEGRANATE_LOGS = createTag("pomegranate_logs");
        public static final TagKey<Item> PINEAPPLE_LOGS = createTag("pineapple_logs");
        public static final TagKey<Item> DRAGON_FRUIT_LOGS = createTag("dragon_fruit_logs");
        public static final TagKey<Item> PEAR_LOGS = createTag("pear_logs");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, new ResourceLocation(FruitTrees.MOD_ID, name));
        }
    }

    public static class Blocks {
        public static final TagKey<Block> MANGO_LOGS = createTag("mango_logs");
        public static final TagKey<Block> POMEGRANATE_LOGS = createTag("pomegranate_logs");
        public static final TagKey<Block> PINEAPPLE_LOGS = createTag("pineapple_logs");
        public static final TagKey<Block> DRAGON_FRUIT_LOGS = createTag("dragon_fruit_logs");
        public static final TagKey<Block> PEAR_LOGS = createTag("pear_logs");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(FruitTrees.MOD_ID, name));
        }
    }
}
