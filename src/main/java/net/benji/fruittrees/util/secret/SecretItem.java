package net.benji.fruittrees.util.secret;

import net.minecraft.world.item.Item;

public class SecretItem {
    public final Item item;
    public final String name;
    public final String key;

    public SecretItem(Item item, String name, String key) {
        this.item = item;
        this.name = name;
        this.key = key;
    }

    public SecretItem(Item item, String name) {
        this(item, name, name.toLowerCase());
    }
}
