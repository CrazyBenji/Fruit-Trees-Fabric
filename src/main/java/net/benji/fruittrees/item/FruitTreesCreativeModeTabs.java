package net.benji.fruittrees.item;

import net.benji.fruittrees.FruitTrees;
import net.benji.fruittrees.block.FruitTreesBlocks;
import net.benji.fruittrees.util.FruitWood;
import net.benji.fruittrees.util.FruitWoods;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class FruitTreesCreativeModeTabs {
    public static final ResourceKey<CreativeModeTab> FRUIT_TREES_KEY = createKey("fruittrees_creative_mode_tab");

    @SuppressWarnings("all")
    private static ResourceKey<CreativeModeTab> createKey(String name) {
        return ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(FruitTrees.MOD_ID, name));
    }

    public static void bootstrap(Registry<CreativeModeTab> registry) {
        Registry.register(
                registry,
                FRUIT_TREES_KEY,
                CreativeModeTab.builder(CreativeModeTab.Row.TOP, 7)
                        .title(Component.translatable("creative_mode_tab.fruittrees"))
                        .icon(() -> new ItemStack(FruitTreesItems.MANGO))
                        .displayItems(((itemDisplayParameters, output) -> {
                            output.accept(FruitTreesItems.MANGO);
                            output.accept(FruitTreesItems.GOLDEN_MANGO);
                            output.accept(FruitTreesItems.ENCHANTED_GOLDEN_MANGO);
                            addFruitWoodToTab(output, FruitWoods.MANGO);

                            output.accept(FruitTreesItems.POMEGRANATE);
                            output.accept(FruitTreesItems.GOLDEN_POMEGRANATE);
                            output.accept(FruitTreesItems.ENCHANTED_GOLDEN_POMEGRANATE);
                            addFruitWoodToTab(output, FruitWoods.POMEGRANATE);

                            output.accept(FruitTreesItems.PINEAPPLE);
                            output.accept(FruitTreesItems.GOLDEN_PINEAPPLE);
                            output.accept(FruitTreesItems.ENCHANTED_GOLDEN_PINEAPPLE);
                            addFruitWoodToTab(output, FruitWoods.PINEAPPLE);

                            output.accept(FruitTreesItems.DRAGON_FRUIT);
                            output.accept(FruitTreesItems.GOLDEN_DRAGON_FRUIT);
                            output.accept(FruitTreesItems.ENCHANTED_GOLDEN_DRAGON_FRUIT);
                            addFruitWoodToTab(output, FruitWoods.DRAGON_FRUIT);

                            output.accept(FruitTreesItems.PEAR);
                            output.accept(FruitTreesItems.GOLDEN_PEAR);
                            output.accept(FruitTreesItems.ENCHANTED_GOLDEN_PEAR);
                            addFruitWoodToTab(output, FruitWoods.PEAR);

                            output.accept(FruitTreesItems.HONEYDEW_SEEDS);
                            output.accept(FruitTreesItems.HONEYDEW_SLICE);
                            output.accept(FruitTreesItems.GLISTENING_HONEYDEW_SLICE);
                            output.accept(FruitTreesBlocks.HONEYDEW);

                            output.accept(FruitTreesItems.CANTALOUPE_SEEDS);
                            output.accept(FruitTreesItems.CANTALOUPE_SLICE);
                            output.accept(FruitTreesItems.GLISTENING_CANTALOUPE_SLICE);
                            output.accept(FruitTreesBlocks.CANTALOUPE);
                        })).build()
        );
    }

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
        bootstrap(BuiltInRegistries.CREATIVE_MODE_TAB);
    }
}
