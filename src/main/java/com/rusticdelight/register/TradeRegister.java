package com.rusticdelight.register;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;

public class TradeRegister {

    public static TradeOffers.Factory sellForOneEmeraldTrade(ItemConvertible item, int count, int maxTrades, int xp) {
        return new TradeOffers.BuyForOneEmeraldFactory(item, count, maxTrades, xp);
    }

    public static TradeOffers.Factory buyTrade(ItemConvertible secondItem, int secondCount, int price, Item item, int sellCount, int maxTrades, int xp) {
        return new TradeOffers.ProcessItemFactory(secondItem, secondCount, price, item, sellCount, maxTrades, xp);
    }

    public static TradeOffers.Factory sellForEmeraldTrade(ItemConvertible item, int maxTrades, int xp) {
        return new TradeOffers.SellItemFactory(new ItemStack(item), 1, 1, maxTrades, xp, 0.05F);
    }

    public static void initialize() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, (trades) -> {
            trades.add(sellForOneEmeraldTrade(ItemRegister.BELL_PEPPER_RED, 24, 2, 16));
            trades.add(sellForOneEmeraldTrade(ItemRegister.COTTON_BOLL, 24, 2, 16));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 1, (trades) -> {
            trades.add(buyTrade(ItemRegister.CALAMARI, 6, 1, ItemRegister.COOKED_CALAMARI, 6, 1, 16));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 2, (trades) -> {
            trades.add(sellForOneEmeraldTrade(ItemRegister.CALAMARI, 15, 1, 16));
        });
        TradeOfferHelper.registerWanderingTraderOffers(1, (trades) -> {
            trades.add(sellForEmeraldTrade(ItemRegister.COTTON_SEEDS, 2, 16));
            trades.add(sellForEmeraldTrade(ItemRegister.BELL_PEPPER_SEEDS, 2, 16));
        });
    }
}
