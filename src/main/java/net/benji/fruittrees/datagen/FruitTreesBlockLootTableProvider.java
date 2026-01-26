package net.benji.fruittrees.datagen;

import net.benji.fruittrees.block.FruitTreesBlocks;
import net.benji.fruittrees.item.FruitTreesItems;
import net.benji.fruittrees.util.FruitTreesBlockFamilies;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.data.BlockFamily;

public class FruitTreesBlockLootTableProvider extends FabricBlockLootTableProvider {
    public FruitTreesBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        this.dropSelf(FruitTreesBlocks.MANGO_LOG);
        this.dropSelf(FruitTreesBlocks.STRIPPED_MANGO_LOG);
        this.dropSelf(FruitTreesBlocks.MANGO_WOOD);
        this.dropSelf(FruitTreesBlocks.STRIPPED_MANGO_WOOD);
        this.generateFruitWoodBlockFamilyDrops(FruitTreesBlockFamilies.MANGO_FAMILY);
        this.dropOther(FruitTreesBlocks.MANGO_SIGN, FruitTreesItems.MANGO_SIGN);
        this.dropOther(FruitTreesBlocks.MANGO_WALL_SIGN, FruitTreesItems.MANGO_SIGN);
        this.dropOther(FruitTreesBlocks.MANGO_HANGING_SIGN, FruitTreesItems.MANGO_HANGING_SIGN);
        this.dropOther(FruitTreesBlocks.MANGO_WALL_HANGING_SIGN, FruitTreesItems.MANGO_HANGING_SIGN);


    }

    public void generateFruitWoodBlockFamilyDrops(BlockFamily blockFamily) {
        this.dropSelf(blockFamily.getBaseBlock());
        this.add(blockFamily.get(BlockFamily.Variant.SLAB), this.createSlabItemTable(blockFamily.get(BlockFamily.Variant.SLAB)));
        this.dropSelf(blockFamily.get(BlockFamily.Variant.STAIRS));
        this.dropSelf(blockFamily.get(BlockFamily.Variant.FENCE));
        this.dropSelf(blockFamily.get(BlockFamily.Variant.FENCE_GATE));
        this.add(blockFamily.get(BlockFamily.Variant.DOOR), createDoorTable(blockFamily.get(BlockFamily.Variant.DOOR)));
        this.dropSelf(blockFamily.get(BlockFamily.Variant.TRAPDOOR));
        this.dropSelf(blockFamily.get(BlockFamily.Variant.BUTTON));
        this.dropSelf(blockFamily.get(BlockFamily.Variant.PRESSURE_PLATE));
    }
}
