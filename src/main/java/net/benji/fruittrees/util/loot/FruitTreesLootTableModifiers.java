package net.benji.fruittrees.util.loot;

import net.benji.fruittrees.item.FruitTreesItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;

import java.util.ArrayList;
import java.util.List;

public class FruitTreesLootTableModifiers {
    public static void modifyChestLootTables() {
        List<ResourceLocation> lootPoolsWeight1 = new ArrayList<>();
        lootPoolsWeight1.add(BuiltInLootTables.ABANDONED_MINESHAFT);
        lootPoolsWeight1.add(BuiltInLootTables.RUINED_PORTAL);
        lootPoolsWeight1.add(BuiltInLootTables.ANCIENT_CITY);


        List<ResourceLocation> lootPoolsWeight2 = new ArrayList<>();
        lootPoolsWeight2.add(BuiltInLootTables.SIMPLE_DUNGEON);
        lootPoolsWeight2.add(BuiltInLootTables.BASTION_TREASURE);
        lootPoolsWeight2.add(BuiltInLootTables.WOODLAND_MANSION);
        lootPoolsWeight2.add(BuiltInLootTables.DESERT_PYRAMID);

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            LootPool.Builder poolBuilderWeight1 = LootPool.lootPool()
                    .add(LootItem.lootTableItem(FruitTreesItems.ENCHANTED_GOLDEN_MANGO))
                    .add(LootItem.lootTableItem(FruitTreesItems.ENCHANTED_GOLDEN_POMEGRANATE))
                    .add(LootItem.lootTableItem(FruitTreesItems.ENCHANTED_GOLDEN_PINEAPPLE))
                    .add(LootItem.lootTableItem(FruitTreesItems.ENCHANTED_GOLDEN_DRAGON_FRUIT))
                    .add(LootItem.lootTableItem(FruitTreesItems.ENCHANTED_GOLDEN_PEAR));
            LootPool.Builder poolBuilderWeight2 = LootPool.lootPool()
                    .add(LootItem.lootTableItem(FruitTreesItems.ENCHANTED_GOLDEN_MANGO).setWeight(2))
                    .add(LootItem.lootTableItem(FruitTreesItems.ENCHANTED_GOLDEN_POMEGRANATE).setWeight(2))
                    .add(LootItem.lootTableItem(FruitTreesItems.ENCHANTED_GOLDEN_PINEAPPLE).setWeight(2))
                    .add(LootItem.lootTableItem(FruitTreesItems.ENCHANTED_GOLDEN_DRAGON_FRUIT).setWeight(2))
                    .add(LootItem.lootTableItem(FruitTreesItems.ENCHANTED_GOLDEN_PEAR).setWeight(2));
            if (lootPoolsWeight1.contains(id)) {
                tableBuilder.withPool(poolBuilderWeight1);
            }
            if (lootPoolsWeight2.contains(id)) {
                tableBuilder.withPool(poolBuilderWeight2);
            }
        });
    }
}
