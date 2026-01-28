package net.benji.fruittrees.item;

import net.benji.fruittrees.FruitTrees;
import net.benji.fruittrees.block.FruitTreesBlocks;
import net.benji.fruittrees.item.custom.EnchantedItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Rarity;

import java.util.function.Function;

public class FruitTreesItems {
    // Mango Items
    public static final Item MANGO = registerItem("mango",
            Item::new,
            new Item.Properties().food(FruitTreesFoodProperties.DEFAULT_FRUIT));
    public static final Item GOLDEN_MANGO = registerItem("golden_mango",
            Item::new,
            new Item.Properties().rarity(Rarity.RARE).food(FruitTreesFoodProperties.DEFAULT_GOLDEN_FRUIT));
    public static final Item ENCHANTED_GOLDEN_MANGO = registerItem("enchanted_golden_mango",
            EnchantedItem::new,
            new Item.Properties().rarity(Rarity.EPIC).food(FruitTreesFoodProperties.DEFAULT_ENCHANTED_GOLDEN_FRUIT));

    // Pomegranate Items
    public static final Item POMEGRANATE = registerItem("pomegranate",
            Item::new,
            new Item.Properties().food(FruitTreesFoodProperties.DEFAULT_FRUIT));
    public static final Item GOLDEN_POMEGRANATE = registerItem("golden_pomegranate",
            Item::new,
            new Item.Properties().rarity(Rarity.RARE).food(FruitTreesFoodProperties.DEFAULT_GOLDEN_FRUIT));
    public static final Item ENCHANTED_GOLDEN_POMEGRANATE = registerItem("enchanted_golden_pomegranate",
            EnchantedItem::new,
            new Item.Properties().rarity(Rarity.EPIC).food(FruitTreesFoodProperties.DEFAULT_ENCHANTED_GOLDEN_FRUIT));

    // Pineapple Items
    public static final Item PINEAPPLE = registerItem("pineapple",
            Item::new,
            new Item.Properties().food(FruitTreesFoodProperties.DEFAULT_FRUIT));
    public static final Item GOLDEN_PINEAPPLE = registerItem("golden_pineapple",
            Item::new,
            new Item.Properties().rarity(Rarity.RARE).food(FruitTreesFoodProperties.DEFAULT_GOLDEN_FRUIT));
    public static final Item ENCHANTED_GOLDEN_PINEAPPLE = registerItem("enchanted_golden_pineapple",
            EnchantedItem::new,
            new Item.Properties().rarity(Rarity.EPIC).food(FruitTreesFoodProperties.DEFAULT_ENCHANTED_GOLDEN_FRUIT));

    // Dragon Fruit Items
    public static final Item DRAGON_FRUIT = registerItem("dragon_fruit",
            Item::new,
            new Item.Properties().food(FruitTreesFoodProperties.DEFAULT_FRUIT));
    public static final Item GOLDEN_DRAGON_FRUIT = registerItem("golden_dragon_fruit",
            Item::new,
            new Item.Properties().rarity(Rarity.RARE).food(FruitTreesFoodProperties.DEFAULT_GOLDEN_FRUIT));
    public static final Item ENCHANTED_GOLDEN_DRAGON_FRUIT = registerItem("enchanted_golden_dragon_fruit",
            EnchantedItem::new,
            new Item.Properties().rarity(Rarity.EPIC).food(FruitTreesFoodProperties.DEFAULT_ENCHANTED_GOLDEN_FRUIT));

    // Pear Items
    public static final Item PEAR = registerItem("pear",
            Item::new,
            new Item.Properties().food(FruitTreesFoodProperties.DEFAULT_FRUIT));
    public static final Item GOLDEN_PEAR = registerItem("golden_pear",
            Item::new,
            new Item.Properties().rarity(Rarity.RARE).food(FruitTreesFoodProperties.DEFAULT_GOLDEN_FRUIT));
    public static final Item ENCHANTED_GOLDEN_PEAR = registerItem("enchanted_golden_pear",
            EnchantedItem::new,
            new Item.Properties().rarity(Rarity.EPIC).food(FruitTreesFoodProperties.DEFAULT_ENCHANTED_GOLDEN_FRUIT));

    // Honeydew Items
    public static final Item HONEYDEW_SEEDS = registerItem(
            "honeydew_seeds",
            properties -> new ItemNameBlockItem(FruitTreesBlocks.HONEYDEW_STEM, properties),
            new Item.Properties()
    );

    // Cantaloupe Items
    public static final Item CANTALOUPE_SEEDS = registerItem(
            "cantaloupe_seeds",
            properties -> new ItemNameBlockItem(FruitTreesBlocks.CANTALOUPE_STEM, properties),
            new Item.Properties()
    );

    public static Item registerItem(String name, Function<Item.Properties, Item> itemFactory, Item.Properties properties) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(FruitTrees.MOD_ID, name), itemFactory.apply(properties));
    }

    public static void registerItems() {
        FruitTrees.LOGGER.info("Registering Items for " + FruitTrees.MOD_NAME);
    }
}
