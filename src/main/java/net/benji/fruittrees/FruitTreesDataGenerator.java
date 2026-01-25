package net.benji.fruittrees;

import net.benji.fruittrees.datagen.FruitTreesBlockTagProvider;
import net.benji.fruittrees.datagen.FruitTreesItemTagProvider;
import net.benji.fruittrees.datagen.FruitTreesModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.Util;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class FruitTreesDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		CompletableFuture<HolderLookup.Provider> completableFuture = CompletableFuture.supplyAsync(VanillaRegistries::createLookup, Util.backgroundExecutor());

		pack.addProvider(FruitTreesModelProvider::new);
		FabricTagProvider.BlockTagProvider blockTagsProvider = pack.addProvider(FruitTreesBlockTagProvider::new);
		pack.addProvider((FabricDataGenerator.Pack.Factory<FruitTreesItemTagProvider>) packOutput -> new FruitTreesItemTagProvider(packOutput, completableFuture, blockTagsProvider));
	}
}
