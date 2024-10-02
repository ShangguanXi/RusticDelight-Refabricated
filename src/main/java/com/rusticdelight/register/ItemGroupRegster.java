package com.rusticdelight.register;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;

public class ItemGroupRegster {
    public static final ItemGroup RUSTIC_DELIGHT_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(BlockRegister.WILD_COTTON))
            .displayName(Text.translatable("itemGroup.rusticdelight"))
            .entries((context, entries) -> {
                for (Block block : BlockRegister.registeredBlocks) {
                    entries.add(new ItemStack(block));
                }
                for (Item item : ItemRegister.registeredItems) {
                    if ((item != ItemRegister.COTTON_SEEDS && item != ItemRegister.BELL_PEPPER_SEEDS)){
                        entries.add(new ItemStack(item));
                    }
                }
            })
            .build();
    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, new Identifier("rusticdelight", "rustic_delight_group"), RUSTIC_DELIGHT_GROUP);
    }
}
