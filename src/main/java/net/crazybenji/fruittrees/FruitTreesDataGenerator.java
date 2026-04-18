package net.crazybenji.fruittrees;

import net.crazybenji.fruittrees.datagen.*;
import net.crazybenji.fruittrees.world.FruitTreesConfiguredFeatures;
import net.crazybenji.fruittrees.world.FruitTreesPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.Util;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.registries.VanillaRegistries;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public class FruitTreesDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		CompletableFuture<HolderLookup.Provider> completableFuture = CompletableFuture.supplyAsync(VanillaRegistries::createLookup, Util.backgroundExecutor());

		pack.addProvider(FruitTreesModelProvider::new);
		FabricTagProvider.BlockTagProvider blockTagsProvider = pack.addProvider(FruitTreesBlockTagProvider::new);
		pack.addProvider((FabricDataGenerator.Pack.Factory<FruitTreesItemTagProvider>) packOutput -> new FruitTreesItemTagProvider(packOutput, completableFuture, blockTagsProvider));
		pack.addProvider(FruitTreesBiomeTagProvider::new);
		pack.addProvider(FruitTreesRecipeProvider::new);
		pack.addProvider(FruitTreesBlockLootTableProvider::new);
		pack.addProvider(FruitTreesLanguageProvider::new);
		pack.addProvider(FruitTreesDynamicRegistryProvider::new);
		pack.addProvider(FruitTreesAdvancementProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registrySetBuilder) {
		registrySetBuilder.add(Registries.CONFIGURED_FEATURE, FruitTreesConfiguredFeatures::boostrap);
		registrySetBuilder.add(Registries.PLACED_FEATURE, FruitTreesPlacedFeatures::bootstrap);
	}
}
