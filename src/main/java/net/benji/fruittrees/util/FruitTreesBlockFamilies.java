package net.benji.fruittrees.util;

import net.benji.fruittrees.block.FruitTreesBlocks;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.recipes.RecipeProvider;

public class FruitTreesBlockFamilies {
    public static final BlockFamily MANGO_FAMILY = new BlockFamily.Builder(FruitTreesBlocks.MANGO_PLANKS)
            .slab(FruitTreesBlocks.MANGO_SLAB)
            .stairs(FruitTreesBlocks.MANGO_STAIRS)
            .fence(FruitTreesBlocks.MANGO_FENCE)
            .fenceGate(FruitTreesBlocks.MANGO_FENCE_GATE)
            .door(FruitTreesBlocks.MANGO_DOOR)
            .trapdoor(FruitTreesBlocks.MANGO_TRAPDOOR)
            .button(FruitTreesBlocks.MANGO_BUTTON)
            .pressurePlate(FruitTreesBlocks.MANGO_PRESSURE_PLATE)
            .sign(FruitTreesBlocks.MANGO_SIGN, FruitTreesBlocks.MANGO_WALL_SIGN)
            .recipeGroupPrefix("wooden")
            .recipeUnlockedBy(RecipeProvider.getHasName(FruitTreesBlocks.MANGO_PLANKS))
            .getFamily();
}
