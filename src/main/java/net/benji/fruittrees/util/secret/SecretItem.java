package net.benji.fruittrees.util.secret;

import net.minecraft.world.item.Item;

public record SecretItem(Item item, String name, String key) {

    public SecretItem(Item item, String name) {
        this(item, name, name.toLowerCase());
    }
}
