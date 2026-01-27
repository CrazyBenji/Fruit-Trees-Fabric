package net.benji.fruittrees;

import net.benji.fruittrees.block.FruitTreesBlocks;
import net.benji.fruittrees.block.entity.FruitTreesBlockEntities;
import net.benji.fruittrees.item.FruitTreesCreativeModeTabs;
import net.benji.fruittrees.item.FruitTreesItems;
import net.benji.fruittrees.util.FruitTreesTags;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FruitTrees implements ModInitializer {
	public static final String MOD_ID = "fruittrees";
	public static final String MOD_NAME = "Fruit Trees";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing " + MOD_NAME);

		FruitTreesItems.registerItems();
		FruitTreesBlocks.registerBlocks();
		FruitTreesCreativeModeTabs.registerCreativeModeTabs();
		FruitTreesBlockEntities.registerBlockEntities();

		registerStrippables();
		registerFlammables();
	}

	public static void registerStrippables() {
		StrippableBlockRegistry.register(FruitTreesBlocks.MANGO_LOG, FruitTreesBlocks.STRIPPED_MANGO_LOG);
		StrippableBlockRegistry.register(FruitTreesBlocks.MANGO_WOOD, FruitTreesBlocks.STRIPPED_MANGO_WOOD);
	}

	public static void registerFlammables() {
		FlammableBlockRegistry flammableRegistry = FlammableBlockRegistry.getDefaultInstance();

		flammableRegistry.add(FruitTreesTags.Blocks.MANGO_LOGS, 5, 5);
		flammableRegistry.add(FruitTreesTags.Blocks.POMEGRANATE_LOGS, 5, 5);
		flammableRegistry.add(FruitTreesTags.Blocks.PINEAPPLE_LOGS, 5, 5);
		flammableRegistry.add(FruitTreesTags.Blocks.DRAGON_FRUIT_LOGS, 5, 5);
		flammableRegistry.add(FruitTreesTags.Blocks.PEAR_LOGS, 5, 5);

		flammableRegistry.add(FruitTreesBlocks.MANGO_PLANKS, 20, 5);
		flammableRegistry.add(FruitTreesBlocks.MANGO_SLAB, 20, 5);
		flammableRegistry.add(FruitTreesBlocks.MANGO_STAIRS, 20, 5);
		flammableRegistry.add(FruitTreesBlocks.MANGO_FENCE, 20, 5);
		flammableRegistry.add(FruitTreesBlocks.MANGO_FENCE_GATE, 20, 5);
	}
}