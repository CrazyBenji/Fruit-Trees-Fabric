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

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, new ResourceLocation(FruitTrees.MOD_ID, name));
        }
    }

    public static class Blocks {

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(FruitTrees.MOD_ID, name));
        }
    }
}
