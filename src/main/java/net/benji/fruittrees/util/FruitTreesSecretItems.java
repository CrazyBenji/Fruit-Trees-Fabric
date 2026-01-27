package net.benji.fruittrees.util;

import net.benji.fruittrees.item.FruitTreesItems;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.Map;

public class FruitTreesSecretItems {
    public static final Map<Item, String> secretItems = new HashMap<>();

    static {
        secretItems.put(FruitTreesItems.PEAR, "Pearto");
        secretItems.put(FruitTreesItems.PINEAPPLE, "Bavid");
    }
}
