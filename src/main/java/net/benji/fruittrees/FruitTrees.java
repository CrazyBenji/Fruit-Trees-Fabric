package net.benji.fruittrees;

import net.benji.fruittrees.block.FruitTreesBlocks;
import net.benji.fruittrees.block.entity.FruitTreesBlockEntities;
import net.benji.fruittrees.item.FruitTreesCreativeModeTabs;
import net.benji.fruittrees.item.FruitTreesItems;
import net.benji.fruittrees.util.FruitWoods;
import net.benji.fruittrees.util.FruitWood;
import net.benji.fruittrees.util.loot.FruitTreesLootTableModifiers;
import net.benji.fruittrees.world.gen.FruitTreesWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
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
		FruitTreesWorldGeneration.generateWorldGen();

		FruitTreesLootTableModifiers.modifyChestLootTables();

		this.addFruitWoodRegistries(FruitWoods.MANGO);
		this.addFruitWoodRegistries(FruitWoods.POMEGRANATE);
		this.addFruitWoodRegistries(FruitWoods.PINEAPPLE);
		this.addFruitWoodRegistries(FruitWoods.DRAGON_FRUIT);
		this.addFruitWoodRegistries(FruitWoods.PEAR);

		this.registerFlammables();
	}

	public void registerFlammables() {
		FlammableBlockRegistry flammableBlockRegistry = FlammableBlockRegistry.getDefaultInstance();

		flammableBlockRegistry.add(FruitTreesBlocks.MANGO_LEAVES, 30, 60);
		flammableBlockRegistry.add(FruitTreesBlocks.FLOWERING_MANGO_LEAVES, 30, 60);
		flammableBlockRegistry.add(FruitTreesBlocks.POMEGRANATE_LEAVES, 30, 60);
		flammableBlockRegistry.add(FruitTreesBlocks.FLOWERING_POMEGRANATE_LEAVES, 30, 60);
		flammableBlockRegistry.add(FruitTreesBlocks.PINEAPPLE_LEAVES, 30, 60);
		flammableBlockRegistry.add(FruitTreesBlocks.FLOWERING_PINEAPPLE_LEAVES, 30, 60);
		flammableBlockRegistry.add(FruitTreesBlocks.DRAGON_FRUIT_LEAVES, 30, 60);
		flammableBlockRegistry.add(FruitTreesBlocks.FLOWERING_DRAGON_FRUIT_LEAVES, 30, 60);
		flammableBlockRegistry.add(FruitTreesBlocks.PEAR_LEAVES, 30, 60);
		flammableBlockRegistry.add(FruitTreesBlocks.FLOWERING_PEAR_LEAVES, 30, 60);
	}

	public void addFruitWoodRegistries(FruitWood fruitWood) {
		StrippableBlockRegistry.register(fruitWood.LOG, fruitWood.STRIPPED_LOG);
		StrippableBlockRegistry.register(fruitWood.WOOD, fruitWood.STRIPPED_WOOD);

		FlammableBlockRegistry flammableBlockRegistry = FlammableBlockRegistry.getDefaultInstance();
		flammableBlockRegistry.add(fruitWood.LOGS_BLOCK, 5, 5);
		flammableBlockRegistry.add(fruitWood.PLANKS, 20, 5);
		flammableBlockRegistry.add(fruitWood.SLAB, 20, 5);
		flammableBlockRegistry.add(fruitWood.STAIRS, 20, 5);
		flammableBlockRegistry.add(fruitWood.FENCE, 20, 5);
		flammableBlockRegistry.add(fruitWood.FENCE_GATE, 20, 5);
	}

}