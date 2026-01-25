package net.benji.fruittrees.util;

import net.benji.fruittrees.FruitTrees;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class FruitTreesWoodTypes {
    public static final WoodType MANGO = registerWoodType(FruitTreesBlockSetTypes.MANGO, "mango");
    public static final WoodType POMEGRANATE = registerWoodType(FruitTreesBlockSetTypes.POMEGRANATE, "pomegranate");
    public static final WoodType PINEAPPLE = registerWoodType(FruitTreesBlockSetTypes.PINEAPPLE, "pineapple");
    public static final WoodType DRAGON_FRUIT = registerWoodType(FruitTreesBlockSetTypes.DRAGON_FRUIT, "dragon_fruit");
    public static final WoodType PEAR = registerWoodType(FruitTreesBlockSetTypes.PEAR, "pear");

    public static WoodType registerWoodType(BlockSetType blockSetType, String name) {
        return WoodTypeBuilder.copyOf(WoodType.OAK).register(new ResourceLocation(FruitTrees.MOD_ID, name), blockSetType);
    }
}
