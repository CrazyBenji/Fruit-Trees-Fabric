package net.benji.fruittrees.datagen;

import net.benji.fruittrees.block.FruitTreesBlocks;
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
        translationBuilder.add(FruitTreesItems.MANGO_JUICE, "Mango Juice");
        this.generateFruitWoodTranslations(translationBuilder, FruitWoods.MANGO, "Mango");
        translationBuilder.add(FruitTreesBlocks.MANGO_LEAVES, "Mango Leaves");
        translationBuilder.add(FruitTreesBlocks.FLOWERING_MANGO_LEAVES, "Flowering Mango Leaves");

        translationBuilder.add(FruitTreesItems.POMEGRANATE, "Pomegranate");
        translationBuilder.add(FruitTreesItems.GOLDEN_POMEGRANATE, "Golden Pomegranate");
        translationBuilder.add(FruitTreesItems.ENCHANTED_GOLDEN_POMEGRANATE, "Enchanted Golden Pomegranate");
        translationBuilder.add(FruitTreesItems.POMEGRANATE_JUICE, "Pomegranate Juice");
        this.generateFruitWoodTranslations(translationBuilder, FruitWoods.POMEGRANATE, "Pomegranate");
        translationBuilder.add(FruitTreesBlocks.POMEGRANATE_LEAVES, "Pomegranate Leaves");
        translationBuilder.add(FruitTreesBlocks.FLOWERING_POMEGRANATE_LEAVES, "Flowering Pomegranate Leaves");

        translationBuilder.add(FruitTreesItems.PINEAPPLE, "Pineapple");
        translationBuilder.add(FruitTreesItems.GOLDEN_PINEAPPLE, "Golden Pineapple");
        translationBuilder.add(FruitTreesItems.ENCHANTED_GOLDEN_PINEAPPLE, "Enchanted Golden Pineapple");
        translationBuilder.add(FruitTreesItems.PINEAPPLE_JUICE, "Pineapple Juice");
        this.generateFruitWoodTranslations(translationBuilder, FruitWoods.PINEAPPLE, "Pineapple");
        translationBuilder.add(FruitTreesBlocks.PINEAPPLE_LEAVES, "Pineapple Leaves");
        translationBuilder.add(FruitTreesBlocks.FLOWERING_PINEAPPLE_LEAVES, "Flowering Pineapple Leaves");

        translationBuilder.add(FruitTreesItems.DRAGON_FRUIT, "Dragon Fruit");
        translationBuilder.add(FruitTreesItems.GOLDEN_DRAGON_FRUIT, "Golden Dragon Fruit");
        translationBuilder.add(FruitTreesItems.ENCHANTED_GOLDEN_DRAGON_FRUIT, "Enchanted Golden Dragon Fruit");
        translationBuilder.add(FruitTreesItems.DRAGON_FRUIT_JUICE, "Dragon Fruit Juice");
        this.generateFruitWoodTranslations(translationBuilder, FruitWoods.DRAGON_FRUIT, "Dragon Fruit");
        translationBuilder.add(FruitTreesBlocks.DRAGON_FRUIT_LEAVES, "Dragon Fruit Leaves");
        translationBuilder.add(FruitTreesBlocks.FLOWERING_DRAGON_FRUIT_LEAVES, "Flowering Dragon Fruit Leaves");

        translationBuilder.add(FruitTreesItems.PEAR, "Pear");
        translationBuilder.add(FruitTreesItems.GOLDEN_PEAR, "Golden Pear");
        translationBuilder.add(FruitTreesItems.ENCHANTED_GOLDEN_PEAR, "Enchanted Golden Pear");
        translationBuilder.add(FruitTreesItems.PEAR_JUICE, "Pear Juice");
        this.generateFruitWoodTranslations(translationBuilder, FruitWoods.PEAR, "Pear");
        translationBuilder.add(FruitTreesBlocks.PEAR_LEAVES, "Pear Leaves");
        translationBuilder.add(FruitTreesBlocks.FLOWERING_PEAR_LEAVES, "Flowering Pear Leaves");

        translationBuilder.add(FruitTreesItems.HONEYDEW_SEEDS, "Honeydew Seeds");
        translationBuilder.add(FruitTreesItems.HONEYDEW_SLICE, "Honeydew Slice");
        translationBuilder.add(FruitTreesItems.GLISTENING_HONEYDEW_SLICE, "Glistening Honeydew Slice");
        translationBuilder.add(FruitTreesItems.HONEYDEW_JUICE, "Honeydew Juice");
        translationBuilder.add(FruitTreesBlocks.HONEYDEW, "Honeydew");
        translationBuilder.add(FruitTreesBlocks.HONEYDEW_STEM, "Honeydew Stem");
        translationBuilder.add(FruitTreesBlocks.ATTACHED_HONEYDEW_STEM, "Attached Honeydew Stem");

        translationBuilder.add(FruitTreesItems.CANTALOUPE_SEEDS, "Cantaloupe Seeds");
        translationBuilder.add(FruitTreesItems.CANTALOUPE_SLICE, "Cantaloupe Slice");
        translationBuilder.add(FruitTreesItems.GLISTENING_CANTALOUPE_SLICE, "Glistening Cantaloupe Slice");
        translationBuilder.add(FruitTreesItems.CANTALOUPE_JUICE, "Cantaloupe Juice");
        translationBuilder.add(FruitTreesBlocks.CANTALOUPE, "Cantaloupe");
        translationBuilder.add(FruitTreesBlocks.CANTALOUPE_STEM, "Cantaloupe Stem");
        translationBuilder.add(FruitTreesBlocks.ATTACHED_CANTALOUPE_STEM, "Attached Cantaloupe Stem");

        translationBuilder.add(FruitTreesItems.BLUEBERRIES, "Blueberries");
        translationBuilder.add(FruitTreesItems.BLUEBERRY_JUICE, "Blueberry Juice");

        translationBuilder.add(FruitTreesItems.CRANBERRIES, "Cranberries");
        translationBuilder.add(FruitTreesItems.CRANBERRY_JUICE, "Cranberry Juice");

        translationBuilder.add(FruitTreesItems.HOT_PEPPER, "Hot Pepper");
        translationBuilder.add(FruitTreesItems.HOT_PEPPER_SEEDS, "Hot Pepper Seeds");
        translationBuilder.add(FruitTreesItems.HOT_PEPPER_JUICE, "Hot Pepper Juice");

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
