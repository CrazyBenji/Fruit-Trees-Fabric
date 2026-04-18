package net.crazybenji.fruittrees.util.loot;

import net.crazybenji.fruittrees.block.FruitTreesBlocks;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;

public class FruitTreesTradeOfferModifiers {
    public static void modifyTradeOffers() {
        TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
            factories.add((entity, randomSource) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(FruitTreesBlocks.MANGO_SAPLING, 1),
                    4,
                    5,
                    0.05f
            ));
            factories.add((entity, randomSource) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(FruitTreesBlocks.POMEGRANATE_SAPLING, 1),
                    4,
                    5,
                    0.05f
            ));
            factories.add((entity, randomSource) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(FruitTreesBlocks.PINEAPPLE_SAPLING, 1),
                    4,
                    5,
                    0.05f
            ));
            factories.add((entity, randomSource) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(FruitTreesBlocks.DRAGON_FRUIT_SAPLING, 1),
                    4,
                    5,
                    0.05f
            ));
            factories.add((entity, randomSource) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(FruitTreesBlocks.PEAR_SAPLING, 1),
                    4,
                    5,
                    0.05f
            ));
        });
    }
}
