package net.crazybenji.fruittrees.util;

import net.crazybenji.fruittrees.FruitTrees;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class FruitTreesBlockSetTypes {
    public static final BlockSetType MANGO = registerBlockSetType("mango");
    public static final BlockSetType POMEGRANATE = registerBlockSetType("pomegranate");
    public static final BlockSetType PINEAPPLE = registerBlockSetType("pineapple");
    public static final BlockSetType DRAGON_FRUIT = registerBlockSetType("dragon_fruit");
    public static final BlockSetType PEAR = registerBlockSetType("pear");

    public static BlockSetType registerBlockSetType(String name) {
        return BlockSetTypeBuilder.copyOf(BlockSetType.OAK).register(new ResourceLocation(FruitTrees.MOD_ID, name));
    }
}
