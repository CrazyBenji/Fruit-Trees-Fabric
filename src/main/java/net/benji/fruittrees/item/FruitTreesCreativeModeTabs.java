package net.benji.fruittrees.item;

import net.benji.fruittrees.FruitTrees;
import net.benji.fruittrees.block.FruitTreesBlocks;
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
                            output.accept(FruitTreesBlocks.MANGO_LOG);
                            output.accept(FruitTreesBlocks.STRIPPED_MANGO_LOG);
                            output.accept(FruitTreesBlocks.MANGO_WOOD);
                            output.accept(FruitTreesBlocks.STRIPPED_MANGO_WOOD);
                            output.accept(FruitTreesBlocks.MANGO_PLANKS);
                            output.accept(FruitTreesBlocks.MANGO_SLAB);
                            output.accept(FruitTreesBlocks.MANGO_STAIRS);
                            output.accept(FruitTreesBlocks.MANGO_FENCE);
                            output.accept(FruitTreesBlocks.MANGO_FENCE_GATE);
                            output.accept(FruitTreesBlocks.MANGO_DOOR);
                            output.accept(FruitTreesBlocks.MANGO_TRAPDOOR);
                            output.accept(FruitTreesBlocks.MANGO_BUTTON);
                            output.accept(FruitTreesBlocks.MANGO_PRESSURE_PLATE);
                            output.accept(FruitTreesItems.MANGO_SIGN);
                            output.accept(FruitTreesItems.MANGO_HANGING_SIGN);

                            output.accept(FruitTreesItems.POMEGRANATE);
                            output.accept(FruitTreesItems.GOLDEN_POMEGRANATE);
                            output.accept(FruitTreesItems.ENCHANTED_GOLDEN_POMEGRANATE);
                            output.accept(FruitTreesBlocks.POMEGRANATE_LOG);
                            output.accept(FruitTreesBlocks.STRIPPED_POMEGRANATE_LOG);
                            output.accept(FruitTreesBlocks.POMEGRANATE_WOOD);
                            output.accept(FruitTreesBlocks.STRIPPED_POMEGRANATE_WOOD);
                            output.accept(FruitTreesBlocks.POMEGRANATE_PLANKS);
                            output.accept(FruitTreesBlocks.POMEGRANATE_SLAB);
                            output.accept(FruitTreesBlocks.POMEGRANATE_STAIRS);
                            output.accept(FruitTreesBlocks.POMEGRANATE_FENCE);
                            output.accept(FruitTreesBlocks.POMEGRANATE_FENCE_GATE);
                            output.accept(FruitTreesBlocks.POMEGRANATE_DOOR);
                            output.accept(FruitTreesBlocks.POMEGRANATE_TRAPDOOR);
                            output.accept(FruitTreesBlocks.POMEGRANATE_BUTTON);
                            output.accept(FruitTreesBlocks.POMEGRANATE_PRESSURE_PLATE);
                            output.accept(FruitTreesItems.POMEGRANATE_SIGN);
                            output.accept(FruitTreesItems.POMEGRANATE_HANGING_SIGN);

                            output.accept(FruitTreesItems.PINEAPPLE);
                            output.accept(FruitTreesItems.GOLDEN_PINEAPPLE);
                            output.accept(FruitTreesItems.ENCHANTED_GOLDEN_PINEAPPLE);

                            output.accept(FruitTreesItems.DRAGON_FRUIT);
                            output.accept(FruitTreesItems.GOLDEN_DRAGON_FRUIT);
                            output.accept(FruitTreesItems.ENCHANTED_GOLDEN_DRAGON_FRUIT);

                            output.accept(FruitTreesItems.PEAR);
                            output.accept(FruitTreesItems.GOLDEN_PEAR);
                            output.accept(FruitTreesItems.ENCHANTED_GOLDEN_PEAR);
                        })).build()
        );
    }

    public static void registerCreativeModeTabs() {
        FruitTrees.LOGGER.info("Registering Creative Mode Tabs for " + FruitTrees.MOD_NAME);
        bootstrap(BuiltInRegistries.CREATIVE_MODE_TAB);
    }
}
