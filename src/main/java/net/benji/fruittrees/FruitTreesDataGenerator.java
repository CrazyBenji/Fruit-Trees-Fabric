package net.benji.fruittrees;

import net.benji.fruittrees.datagen.FruitTreesItemTagProvider;
import net.benji.fruittrees.datagen.FruitTreesModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class FruitTreesDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(FruitTreesModelProvider::new);
		pack.addProvider(FruitTreesItemTagProvider::new);
	}
}
