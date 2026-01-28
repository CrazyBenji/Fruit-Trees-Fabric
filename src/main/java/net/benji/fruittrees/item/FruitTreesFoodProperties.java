package net.benji.fruittrees.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;

public class FruitTreesFoodProperties {
    public static final FoodProperties DEFAULT_FRUIT = Foods.APPLE;
    public static final FoodProperties DEFAULT_GOLDEN_FRUIT = Foods.GOLDEN_APPLE;
    public static final FoodProperties DEFAULT_ENCHANTED_GOLDEN_FRUIT = Foods.ENCHANTED_GOLDEN_APPLE;

    public static final FoodProperties DEFAULT_STEM_FRUIT = Foods.MELON_SLICE;
    public static final FoodProperties DEFAULT_GLISTENING_STEM_FRUIT = new FoodProperties.Builder()
            .alwaysEat()
            .nutrition(6)
            .saturationMod(1.2F)
            .build();
}
