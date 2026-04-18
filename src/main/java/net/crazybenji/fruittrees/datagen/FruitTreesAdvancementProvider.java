package net.crazybenji.fruittrees.datagen;

import net.crazybenji.fruittrees.FruitTrees;
import net.crazybenji.fruittrees.item.FruitTreesItems;
import net.crazybenji.fruittrees.util.FruitTreesTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

public class FruitTreesAdvancementProvider extends FabricAdvancementProvider {
    public FruitTreesAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    public Advancement getAdvancement(String namespace, String id) {
        return Advancement.Builder.advancement().build(new ResourceLocation(namespace, id));
    }

    public Advancement getAdvancement(String id) {
        return getAdvancement("minecraft", id);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement getFruit = Advancement.Builder.advancement()
                .parent(getAdvancement("husbandry/balanced_diet"))
                .display(FruitTreesItems.MANGO,
                        Component.translatable("advancements.husbandry.get_fruit.title"),
                        Component.translatable("advancements.husbandry.get_fruit.description"),
                        null,
                        FrameType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("got_fruit", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(FruitTreesTags.Items.FRUITS).build()
                ))
                .save(consumer, FruitTrees.MOD_ID + ":husbandry/get_fruit");
    }
}
