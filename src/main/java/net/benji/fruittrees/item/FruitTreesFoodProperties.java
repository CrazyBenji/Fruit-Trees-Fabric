package net.benji.fruittrees.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;

public class FruitTreesFoodProperties {
    public static final FoodProperties DEFAULT_FRUIT = Foods.APPLE;
    public static final FoodProperties GOLDEN_MANGO = new FoodProperties.Builder()
            .nutrition(4).saturationMod(1.2F)
            .effect(new MobEffectInstance(MobEffects.HEAL, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1.0F)
            .alwaysEat()
            .build();
    public static final FoodProperties GOLDEN_POMEGRANATE = new FoodProperties.Builder()
            .nutrition(4).saturationMod(1.2F)
            .effect(new MobEffectInstance(MobEffects.SATURATION, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1.0F)
            .alwaysEat()
            .build();
    public static final FoodProperties GOLDEN_PINEAPPLE = new FoodProperties.Builder()
            .nutrition(4).saturationMod(1.2F)
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 100, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1.0F)
            .alwaysEat()
            .build();
    public static final FoodProperties GOLDEN_DRAGON_FRUIT = new FoodProperties.Builder()
            .nutrition(4).saturationMod(1.2F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1.0F)
            .alwaysEat()
            .build();
    public static final FoodProperties GOLDEN_PEAR = new FoodProperties.Builder()
            .nutrition(4).saturationMod(1.2F)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1.0F)
            .alwaysEat()
            .build();
    public static final FoodProperties ENCHANTED_GOLDEN_MANGO = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(1.2F)
            .effect(new MobEffectInstance(MobEffects.HEAL, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3), 1.0F)
            .alwaysEat()
            .build();
    public static final FoodProperties ENCHANTED_GOLDEN_POMEGRANATE = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(1.2F)
            .effect(new MobEffectInstance(MobEffects.SATURATION, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3), 1.0F)
            .alwaysEat()
            .build();
    public static final FoodProperties ENCHANTED_GOLDEN_PINEAPPLE = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(1.2F)
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3), 1.0F)
            .alwaysEat()
            .build();
    public static final FoodProperties ENCHANTED_GOLDEN_DRAGON_FRUIT = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(1.2F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3), 1.0F)
            .alwaysEat()
            .build();
    public static final FoodProperties ENCHANTED_GOLDEN_PEAR = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(1.2F)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3), 1.0F)
            .alwaysEat()
            .build();

    public static final FoodProperties DEFAULT_STEM_FRUIT = Foods.MELON_SLICE;
    public static final FoodProperties DEFAULT_GLISTENING_STEM_FRUIT = new FoodProperties.Builder()
            .alwaysEat()
            .nutrition(6)
            .saturationMod(1.2F)
            .build();

    public static final FoodProperties DEFAULT_BERRY = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.1F)
            .fast()
            .build();
    public static final FoodProperties HOT_PEPPER = new FoodProperties.Builder()
            .alwaysEat()
            .nutrition(2)
            .saturationMod(0.1F)
            .fast()
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20 * 5), 1.0F)
            .build();

    public static final FoodProperties DEFAULT_JUICE = new FoodProperties.Builder()
            .nutrition(12)
            .saturationMod(0.5F)
            .build();
    public static final FoodProperties HOT_PEPPER_JUICE = new FoodProperties.Builder()
            .alwaysEat()
            .nutrition(12)
            .saturationMod(0.5F)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20 * 30), 1.0F)
            .build();
}
