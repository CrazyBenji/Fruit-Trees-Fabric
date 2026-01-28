package net.benji.fruittrees.datagen;

import net.benji.fruittrees.block.FruitTreesBlocks;
import net.benji.fruittrees.item.FruitTreesItems;
import net.benji.fruittrees.util.FruitWood;
import net.benji.fruittrees.util.FruitWoods;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.IntRange;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.LimitCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class FruitTreesBlockLootTableProvider extends FabricBlockLootTableProvider {
    public FruitTreesBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        this.generateFruitWoodBlockLootTables(FruitWoods.MANGO);
        this.generateFruitWoodBlockLootTables(FruitWoods.POMEGRANATE);
        this.generateFruitWoodBlockLootTables(FruitWoods.PINEAPPLE);
        this.generateFruitWoodBlockLootTables(FruitWoods.DRAGON_FRUIT);
        this.generateFruitWoodBlockLootTables(FruitWoods.PEAR);

        this.add(FruitTreesBlocks.HONEYDEW_STEM, createAttachedStemDrops(FruitTreesBlocks.HONEYDEW_STEM, FruitTreesItems.HONEYDEW_SEEDS));
        this.add(FruitTreesBlocks.ATTACHED_HONEYDEW_STEM, createAttachedStemDrops(FruitTreesBlocks.ATTACHED_HONEYDEW_STEM, FruitTreesItems.HONEYDEW_SEEDS));
        this.add(FruitTreesBlocks.HONEYDEW, (block) -> createSilkTouchDispatchTable(block,
                        this.applyExplosionDecay(block, LootItem.lootTableItem(FruitTreesItems.HONEYDEW_SLICE)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 7.0F)))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
                        .apply(LimitCount.limitCount(IntRange.upperBound(9))))));

        this.add(FruitTreesBlocks.CANTALOUPE_STEM, createAttachedStemDrops(FruitTreesBlocks.CANTALOUPE_STEM, FruitTreesItems.CANTALOUPE_SEEDS));
        this.add(FruitTreesBlocks.ATTACHED_CANTALOUPE_STEM, createAttachedStemDrops(FruitTreesBlocks.ATTACHED_CANTALOUPE_STEM, FruitTreesItems.CANTALOUPE_SEEDS));
        this.add(FruitTreesBlocks.CANTALOUPE, (block) -> createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block, LootItem.lootTableItem(FruitTreesItems.CANTALOUPE_SLICE)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 7.0F)))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
                        .apply(LimitCount.limitCount(IntRange.upperBound(9))))));

    }

    public void generateFruitWoodBlockLootTables(FruitWood fruitWood) {
        this.dropSelf(fruitWood.LOG);
        this.dropSelf(fruitWood.STRIPPED_LOG);
        this.dropSelf(fruitWood.WOOD);
        this.dropSelf(fruitWood.STRIPPED_WOOD);
        this.dropSelf(fruitWood.PLANKS);
        this.add(fruitWood.SLAB, this.createSlabItemTable(fruitWood.SLAB));
        this.dropSelf(fruitWood.STAIRS);
        this.dropSelf(fruitWood.FENCE);
        this.dropSelf(fruitWood.FENCE_GATE);
        this.add(fruitWood.DOOR, this.createDoorTable(fruitWood.DOOR));
        this.dropSelf(fruitWood.TRAPDOOR);
        this.dropSelf(fruitWood.BUTTON);
        this.dropSelf(fruitWood.PRESSURE_PLATE);
        this.dropOther(fruitWood.SIGN, fruitWood.SIGN_ITEM);
        this.dropOther(fruitWood.WALL_SIGN, fruitWood.SIGN_ITEM);
        this.dropOther(fruitWood.HANGING_SIGN, fruitWood.HANGING_SIGN_ITEM);
        this.dropOther(fruitWood.WALL_HANGING_SIGN, fruitWood.HANGING_SIGN_ITEM);
    }
}
