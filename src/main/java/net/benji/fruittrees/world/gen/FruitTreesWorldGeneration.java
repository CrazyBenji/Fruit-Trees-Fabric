package net.benji.fruittrees.world.gen;

public class FruitTreesWorldGeneration {
    public static void generateWorldGen() {
        FruitTreesTreeGeneration.generateTrees();
        FruitTreesStemBlockGeneration.generateStemBlocks();
        FruitTreesBushGeneration.generateBushes();
    }
}
