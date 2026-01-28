package net.benji.fruittrees.datagen;

import net.benji.fruittrees.item.FruitTreesItems;
import net.benji.fruittrees.util.FruitWood;
import net.benji.fruittrees.util.FruitWoods;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class FruitTreesLanguageProvider extends FabricLanguageProvider {
    public FruitTreesLanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(FruitTreesItems.MANGO, "Mango");
        translationBuilder.add(FruitTreesItems.GOLDEN_MANGO, "Golden Mango");
        translationBuilder.add(FruitTreesItems.ENCHANTED_GOLDEN_MANGO, "Enchanted Golden Mango");
        this.generateFruitWoodTranslations(translationBuilder, FruitWoods.MANGO, "Mango");

        translationBuilder.add(FruitTreesItems.POMEGRANATE, "Pomegranate");
        translationBuilder.add(FruitTreesItems.GOLDEN_POMEGRANATE, "Golden Pomegranate");
        translationBuilder.add(FruitTreesItems.ENCHANTED_GOLDEN_POMEGRANATE, "Enchanted Golden Pomegranate");
        this.generateFruitWoodTranslations(translationBuilder, FruitWoods.POMEGRANATE, "Pomegranate");

        translationBuilder.add(FruitTreesItems.PINEAPPLE, "Pineapple");
        translationBuilder.add(FruitTreesItems.GOLDEN_PINEAPPLE, "Golden Pineapple");
        translationBuilder.add(FruitTreesItems.ENCHANTED_GOLDEN_PINEAPPLE, "Enchanted Golden Pineapple");
        this.generateFruitWoodTranslations(translationBuilder, FruitWoods.PINEAPPLE, "Pineapple");

        translationBuilder.add(FruitTreesItems.DRAGON_FRUIT, "Dragon Fruit");
        translationBuilder.add(FruitTreesItems.GOLDEN_DRAGON_FRUIT, "Golden Dragon Fruit");
        translationBuilder.add(FruitTreesItems.ENCHANTED_GOLDEN_DRAGON_FRUIT, "Enchanted Golden Dragon Fruit");

        translationBuilder.add(FruitTreesItems.PEAR, "Pear");
        translationBuilder.add(FruitTreesItems.GOLDEN_PEAR, "Golden Pear");
        translationBuilder.add(FruitTreesItems.ENCHANTED_GOLDEN_PEAR, "Enchanted Golden Pear");

        translationBuilder.add("creative_mode_tab.fruittrees", "Fruit Trees");
    }

    public void generateFruitWoodTranslations(TranslationBuilder translationBuilder, FruitWood fruitWood, String fruitName) {
        translationBuilder.add(fruitWood.LOG, fruitName + " Log");
        translationBuilder.add(fruitWood.STRIPPED_LOG, "Stripped " + fruitName + " Log");
        translationBuilder.add(fruitWood.WOOD, fruitName + " Wood");
        translationBuilder.add(fruitWood.STRIPPED_WOOD, "Stripped " + fruitName + " Wood");
        translationBuilder.add(fruitWood.PLANKS, fruitName + " Planks");
        translationBuilder.add(fruitWood.SLAB, fruitName + " Slab");
        translationBuilder.add(fruitWood.STAIRS, fruitName + " Stairs");
        translationBuilder.add(fruitWood.FENCE, fruitName + " Fence");
        translationBuilder.add(fruitWood.FENCE_GATE, fruitName + " Fence Gate");
        translationBuilder.add(fruitWood.DOOR, fruitName + " Door");
        translationBuilder.add(fruitWood.TRAPDOOR, fruitName + " Trapdoor");
        translationBuilder.add(fruitWood.BUTTON, fruitName + " Button");
        translationBuilder.add(fruitWood.PRESSURE_PLATE, fruitName + " Pressure Plate");
        translationBuilder.add(fruitWood.SIGN, fruitName + " Sign");
        translationBuilder.add(fruitWood.HANGING_SIGN, fruitName + " Hanging Sign");
    }
}
