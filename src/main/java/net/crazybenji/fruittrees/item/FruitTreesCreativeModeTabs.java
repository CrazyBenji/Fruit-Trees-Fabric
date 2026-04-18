package net.crazybenji.fruittrees.item;

import net.crazybenji.fruittrees.FruitTrees;
import net.crazybenji.fruittrees.block.FruitTreesBlocks;
import net.crazybenji.fruittrees.util.FruitWood;
import net.crazybenji.fruittrees.util.FruitWoods;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

@SuppressWarnings("all")
public class FruitTreesCreativeModeTabs {
    public static final ResourceKey<CreativeModeTab> FRUIT_TREES_KEY = createKey("fruittrees_creative_mode_tab");

    private static ResourceKey<CreativeModeTab> createKey(String name) {
        return ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(FruitTrees.MOD_ID, name));
    }

    public static final CreativeModeTab FRUIT_TREES_CREATIVE_MODE_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            FRUIT_TREES_KEY,
            CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                    .title(Component.translatable("creative_mode_tab.fruittrees"))
                    .icon(() -> new ItemStack(FruitTreesItems.MANGO))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(FruitTreesItems.MANGO);
                        output.accept(FruitTreesItems.GOLDEN_MANGO);
                        output.accept(FruitTreesItems.ENCHANTED_GOLDEN_MANGO);
                        output.accept(FruitTreesItems.MANGO_JUICE);
                        addFruitWoodToTab(output, FruitWoods.MANGO);
                        output.accept(FruitTreesBlocks.MANGO_LEAVES);
                        output.accept(FruitTreesBlocks.FLOWERING_MANGO_LEAVES);
                        output.accept(FruitTreesBlocks.MANGO_SAPLING);

                        output.accept(FruitTreesItems.POMEGRANATE);
                        output.accept(FruitTreesItems.GOLDEN_POMEGRANATE);
                        output.accept(FruitTreesItems.ENCHANTED_GOLDEN_POMEGRANATE);
                        output.accept(FruitTreesItems.POMEGRANATE_JUICE);
                        addFruitWoodToTab(output, FruitWoods.POMEGRANATE);
                        output.accept(FruitTreesBlocks.POMEGRANATE_LEAVES);
                        output.accept(FruitTreesBlocks.FLOWERING_POMEGRANATE_LEAVES);
                        output.accept(FruitTreesBlocks.POMEGRANATE_SAPLING);

                        output.accept(FruitTreesItems.PINEAPPLE);
                        output.accept(FruitTreesItems.GOLDEN_PINEAPPLE);
                        output.accept(FruitTreesItems.ENCHANTED_GOLDEN_PINEAPPLE);
                        output.accept(FruitTreesItems.PINEAPPLE_JUICE);
                        addFruitWoodToTab(output, FruitWoods.PINEAPPLE);
                        output.accept(FruitTreesBlocks.PINEAPPLE_LEAVES);
                        output.accept(FruitTreesBlocks.FLOWERING_PINEAPPLE_LEAVES);
                        output.accept(FruitTreesBlocks.PINEAPPLE_SAPLING);

                        output.accept(FruitTreesItems.DRAGON_FRUIT);
                        output.accept(FruitTreesItems.GOLDEN_DRAGON_FRUIT);
                        output.accept(FruitTreesItems.ENCHANTED_GOLDEN_DRAGON_FRUIT);
                        output.accept(FruitTreesItems.DRAGON_FRUIT_JUICE);
                        addFruitWoodToTab(output, FruitWoods.DRAGON_FRUIT);
                        output.accept(FruitTreesBlocks.DRAGON_FRUIT_LEAVES);
                        output.accept(FruitTreesBlocks.FLOWERING_DRAGON_FRUIT_LEAVES);
                        output.accept(FruitTreesBlocks.DRAGON_FRUIT_SAPLING);

                        output.accept(FruitTreesItems.PEAR);
                        output.accept(FruitTreesItems.GOLDEN_PEAR);
                        output.accept(FruitTreesItems.ENCHANTED_GOLDEN_PEAR);
                        output.accept(FruitTreesItems.PEAR_JUICE);
                        addFruitWoodToTab(output, FruitWoods.PEAR);
                        output.accept(FruitTreesBlocks.PEAR_LEAVES);
                        output.accept(FruitTreesBlocks.FLOWERING_PEAR_LEAVES);
                        output.accept(FruitTreesBlocks.PEAR_SAPLING);

                        output.accept(FruitTreesItems.HONEYDEW_SEEDS);
                        output.accept(FruitTreesItems.HONEYDEW_SLICE);
                        output.accept(FruitTreesItems.GLISTENING_HONEYDEW_SLICE);
                        output.accept(FruitTreesItems.HONEYDEW_JUICE);
                        output.accept(FruitTreesBlocks.HONEYDEW);

                        output.accept(FruitTreesItems.CANTALOUPE_SEEDS);
                        output.accept(FruitTreesItems.CANTALOUPE_SLICE);
                        output.accept(FruitTreesItems.GLISTENING_CANTALOUPE_SLICE);
                        output.accept(FruitTreesItems.CANTALOUPE_JUICE);
                        output.accept(FruitTreesBlocks.CANTALOUPE);

                        output.accept(FruitTreesItems.BLUEBERRIES);
                        output.accept(FruitTreesItems.BLUEBERRY_JUICE);

                        output.accept(FruitTreesItems.CRANBERRIES);
                        output.accept(FruitTreesItems.CRANBERRY_JUICE);

                        output.accept(FruitTreesItems.HOT_PEPPER);
                        output.accept(FruitTreesItems.HOT_PEPPER_SEEDS);
                        output.accept(FruitTreesItems.HOT_PEPPER_JUICE);
                    }).build()
    );

    public static void addFruitWoodToTab(CreativeModeTab.Output output, FruitWood fruitWood) {
        output.accept(fruitWood.LOG);
        output.accept(fruitWood.STRIPPED_LOG);
        output.accept(fruitWood.WOOD);
        output.accept(fruitWood.STRIPPED_WOOD);
        output.accept(fruitWood.PLANKS);
        output.accept(fruitWood.SLAB);
        output.accept(fruitWood.STAIRS);
        output.accept(fruitWood.FENCE);
        output.accept(fruitWood.FENCE_GATE);
        output.accept(fruitWood.DOOR);
        output.accept(fruitWood.TRAPDOOR);
        output.accept(fruitWood.BUTTON);
        output.accept(fruitWood.PRESSURE_PLATE);
        output.accept(fruitWood.SIGN_ITEM);
        output.accept(fruitWood.HANGING_SIGN_ITEM);
    }

    public static void registerCreativeModeTabs() {
        FruitTrees.LOGGER.info("Registering Creative Mode Tabs for " + FruitTrees.MOD_NAME);
    }
}
