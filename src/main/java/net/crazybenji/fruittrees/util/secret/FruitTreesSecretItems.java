package net.crazybenji.fruittrees.util.secret;

import net.crazybenji.fruittrees.item.FruitTreesItems;

import java.util.ArrayList;
import java.util.List;

public class FruitTreesSecretItems {
    public static final List<SecretItem> SECRET_ITEMS = new ArrayList<>();

    static {
        SECRET_ITEMS.add(new SecretItem(FruitTreesItems.PEAR, "Pearto"));
        SECRET_ITEMS.add(new SecretItem(FruitTreesItems.PINEAPPLE, "Bavid"));
        SECRET_ITEMS.add(new SecretItem(FruitTreesItems.GOLDEN_PINEAPPLE, "Bavid", "golden_bavid"));
        SECRET_ITEMS.add(new SecretItem(FruitTreesItems.ENCHANTED_GOLDEN_PINEAPPLE, "Bavid", "golden_bavid"));
        SECRET_ITEMS.add(new SecretItem(FruitTreesItems.MANGO, "Mustard"));
    }
}
