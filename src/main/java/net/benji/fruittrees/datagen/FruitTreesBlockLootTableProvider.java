package net.benji.fruittrees.datagen;

import net.benji.fruittrees.util.FruitWood;
import net.benji.fruittrees.util.FruitWoods;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

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
