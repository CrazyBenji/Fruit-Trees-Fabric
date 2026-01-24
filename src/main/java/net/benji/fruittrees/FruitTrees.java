package net.benji.fruittrees;

import net.benji.fruittrees.item.FruitTreesCreativeModeTabs;
import net.benji.fruittrees.item.FruitTreesItems;
import net.fabricmc.api.ModInitializer;

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
		FruitTreesCreativeModeTabs.registerCreativeModeTabs();
	}
}