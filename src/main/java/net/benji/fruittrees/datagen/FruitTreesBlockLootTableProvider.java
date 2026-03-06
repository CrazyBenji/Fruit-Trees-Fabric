package net.benji.fruittrees.datagen;

import net.benji.fruittrees.block.FruitTreesBlocks;
import net.benji.fruittrees.block.custom.DynamicBushBlock;
import net.benji.fruittrees.item.FruitTreesItems;
import net.benji.fruittrees.util.FruitWood;
import net.benji.fruittrees.util.FruitWoods;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.IntRange;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.LimitCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class FruitTreesBlockLootTableProvider extends FabricBlockLootTableProvider {
    public FruitTreesBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        this.add(FruitTreesBlocks.FRUIT_LEAVES, this.createFruitLeavesDispatchTable());

        this.generateFruitWoodBlockLootTables(FruitWoods.MANGO);
        this.add(FruitTreesBlocks.MANGO_LEAVES, this.createFruitLeavesDropTable(FruitTreesBlocks.MANGO_SAPLING, FruitTreesItems.MANGO));
        this.add(FruitTreesBlocks.FLOWERING_MANGO_LEAVES, this.createFloweringFruitLeavesDropTable(FruitTreesBlocks.FLOWERING_MANGO_LEAVES, FruitTreesBlocks.MANGO_SAPLING, FruitTreesItems.MANGO));
        this.dropSelf(FruitTreesBlocks.MANGO_SAPLING);
        this.dropPottedContents(FruitTreesBlocks.POTTED_MANGO_SAPLING);

        this.generateFruitWoodBlockLootTables(FruitWoods.POMEGRANATE);
        this.add(FruitTreesBlocks.POMEGRANATE_LEAVES, this.createFruitLeavesDropTable(FruitTreesBlocks.POMEGRANATE_SAPLING, FruitTreesItems.POMEGRANATE));
        this.add(FruitTreesBlocks.FLOWERING_POMEGRANATE_LEAVES, this.createFloweringFruitLeavesDropTable(FruitTreesBlocks.FLOWERING_POMEGRANATE_LEAVES, FruitTreesBlocks.POMEGRANATE_SAPLING, FruitTreesItems.POMEGRANATE));
        this.dropSelf(FruitTreesBlocks.POMEGRANATE_SAPLING);
        this.dropPottedContents(FruitTreesBlocks.POTTED_POMEGRANATE_SAPLING);

        this.generateFruitWoodBlockLootTables(FruitWoods.PINEAPPLE);
        this.add(FruitTreesBlocks.PINEAPPLE_LEAVES, this.createFruitLeavesDropTable(FruitTreesBlocks.PINEAPPLE_SAPLING, FruitTreesItems.PINEAPPLE));
        this.add(FruitTreesBlocks.FLOWERING_PINEAPPLE_LEAVES, this.createFloweringFruitLeavesDropTable(FruitTreesBlocks.FLOWERING_PINEAPPLE_LEAVES, FruitTreesBlocks.PINEAPPLE_SAPLING, FruitTreesItems.PINEAPPLE));
        this.dropSelf(FruitTreesBlocks.PINEAPPLE_SAPLING);
        this.dropPottedContents(FruitTreesBlocks.POTTED_PINEAPPLE_SAPLING);

        this.generateFruitWoodBlockLootTables(FruitWoods.DRAGON_FRUIT);
        this.add(FruitTreesBlocks.DRAGON_FRUIT_LEAVES, this.createFruitLeavesDropTable(FruitTreesBlocks.DRAGON_FRUIT_SAPLING, FruitTreesItems.DRAGON_FRUIT));
        this.add(FruitTreesBlocks.FLOWERING_DRAGON_FRUIT_LEAVES, this.createFloweringFruitLeavesDropTable(FruitTreesBlocks.FLOWERING_DRAGON_FRUIT_LEAVES, FruitTreesBlocks.DRAGON_FRUIT_SAPLING, FruitTreesItems.DRAGON_FRUIT));
        this.dropSelf(FruitTreesBlocks.DRAGON_FRUIT_SAPLING);
        this.dropPottedContents(FruitTreesBlocks.POTTED_DRAGON_FRUIT_SAPLING);

        this.generateFruitWoodBlockLootTables(FruitWoods.PEAR);
        this.add(FruitTreesBlocks.PEAR_LEAVES, this.createFruitLeavesDropTable(FruitTreesBlocks.PEAR_SAPLING, FruitTreesItems.PEAR));
        this.add(FruitTreesBlocks.FLOWERING_PEAR_LEAVES, this.createFloweringFruitLeavesDropTable(FruitTreesBlocks.FLOWERING_PEAR_LEAVES, FruitTreesBlocks.PEAR_SAPLING, FruitTreesItems.PEAR));
        this.dropSelf(FruitTreesBlocks.PEAR_SAPLING);
        this.dropPottedContents(FruitTreesBlocks.POTTED_PEAR_SAPLING);

        this.add(FruitTreesBlocks.HONEYDEW_STEM, createStemDrops(FruitTreesBlocks.HONEYDEW_STEM, FruitTreesItems.HONEYDEW_SEEDS));
        this.add(FruitTreesBlocks.ATTACHED_HONEYDEW_STEM, createAttachedStemDrops(FruitTreesBlocks.ATTACHED_HONEYDEW_STEM, FruitTreesItems.HONEYDEW_SEEDS));
        this.generateStemGrownBlockLootTable(FruitTreesBlocks.HONEYDEW, FruitTreesItems.HONEYDEW_SLICE);

        this.add(FruitTreesBlocks.CANTALOUPE_STEM, createStemDrops(FruitTreesBlocks.CANTALOUPE_STEM, FruitTreesItems.CANTALOUPE_SEEDS));
        this.add(FruitTreesBlocks.ATTACHED_CANTALOUPE_STEM, createAttachedStemDrops(FruitTreesBlocks.ATTACHED_CANTALOUPE_STEM, FruitTreesItems.CANTALOUPE_SEEDS));
        this.generateStemGrownBlockLootTable(FruitTreesBlocks.CANTALOUPE, FruitTreesItems.CANTALOUPE_SLICE);

        this.generateDynamicBushBlockLootTable((DynamicBushBlock) FruitTreesBlocks.BLUEBERRY_BUSH);
        this.generateDynamicBushBlockLootTable((DynamicBushBlock) FruitTreesBlocks.CRANBERRY_BUSH);
        this.generateDynamicBushBlockLootTable((DynamicBushBlock) FruitTreesBlocks.HOT_PEPPER_BUSH);
    }

    public LootTable.Builder createFruitLeavesDispatchTable() {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                .add(LootItem.lootTableItem(FruitTreesBlocks.FRUIT_LEAVES).when(HAS_SHEARS_OR_SILK_TOUCH)))
        .withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(HAS_NO_SHEARS_OR_SILK_TOUCH)
                        .add(
                                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionDecay(
                                        FruitTreesBlocks.FRUIT_LEAVES, LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                ))
                                        .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, NORMAL_LEAVES_STICK_CHANCES))
                        )
        );
    }

    public LootTable.Builder createFruitLeavesDropTable(Block leavesBlock, Block sapling, Item fruit) {
        return this.createLeavesDrops(leavesBlock, sapling, VanillaBlockLoot.NORMAL_LEAVES_SAPLING_CHANCES)
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .when(HAS_NO_SHEARS_OR_SILK_TOUCH)
                                .add(
                                        ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionCondition(leavesBlock, LootItem.lootTableItem(fruit)))
                                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.016F, 0.023F, 0.033F, 0.043F, 0.05F))
                                )
                );
    }
    public LootTable.Builder createFruitLeavesDropTable(Block sapling, Item fruit) {
        return this.createFruitLeavesDropTable(FruitTreesBlocks.FRUIT_LEAVES, sapling, fruit);
    }
    public LootTable.Builder createFloweringFruitLeavesDropTable(Block leavesBlock, Block sapling, Item fruit) {
        return this.createLeavesDrops(leavesBlock, sapling, VanillaBlockLoot.NORMAL_LEAVES_SAPLING_CHANCES)
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .when(HAS_NO_SHEARS_OR_SILK_TOUCH)
                                .add(
                                        ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionCondition(leavesBlock, LootItem.lootTableItem(fruit)))
                                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.032F, 0.046F, 0.066F, 0.086F, 0.1F))
                                )
                );
    }

    public void generateDynamicBushBlockLootTable(DynamicBushBlock bushBlock) {
        this.add(
                bushBlock,
                block -> this.applyExplosionDecay(
                        block,
                        LootTable.lootTable()
                                .withPool(
                                        LootPool.lootPool()
                                                .when(
                                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(bushBlock)
                                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DynamicBushBlock.AGE, 3))
                                                )
                                                .add(LootItem.lootTableItem(bushBlock.getGrownItem()))
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
                                )
                                .withPool(
                                        LootPool.lootPool()
                                                .when(
                                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(bushBlock)
                                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DynamicBushBlock.AGE, 2))
                                                )
                                                .add(LootItem.lootTableItem(bushBlock.getGrownItem()))
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
                                )
                                .withPool(
                                        LootPool.lootPool()
                                                .when(
                                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(bushBlock)
                                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DynamicBushBlock.HAS_SEED, 1))
                                                )
                                                .when(
                                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(bushBlock)
                                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DynamicBushBlock.AGE, 3))
                                                )
                                                .add(LootItem.lootTableItem(bushBlock.getSeed()))
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                )
                )
        );
    }

    public void generateStemGrownBlockLootTable(Block stemBlock, Item sliceItem) {
        this.add(stemBlock, (block) -> createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block, LootItem.lootTableItem(sliceItem)
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
