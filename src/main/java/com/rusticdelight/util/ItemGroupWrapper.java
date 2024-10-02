package com.rusticdelight.util;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class ItemGroupWrapper implements ItemGroup.EntryCollector {
    protected final ObjectArrayList<ItemConvertible> items = new ObjectArrayList<>();
    protected final Supplier<ItemConvertible> icon;
    protected final Text title;
    public final ItemGroup instance;

    public ItemGroupWrapper(Identifier identifier, String title, Supplier<ItemConvertible> icon) {
        this.icon = icon;
        this.title = Text.translatable(title);
        this.instance = Registry.register(
                Registries.ITEM_GROUP,
                identifier,
                FabricItemGroup.builder()
                        .displayName(this.title)
                        .icon(this::getIcon)
                        .entries(this)
                        .build()
        );
    }

    public <T extends ItemConvertible> T register(Registry<? super T> registry, Identifier identifier, T item) {
        this.items.add(item);
        return Registry.register(registry, identifier, item);
    }

    public void add(ItemConvertible item) {
        this.items.add(item);
    }

    public ItemStack getIcon() {
        return new ItemStack(this.icon.get());
    }

    @Override
    public void accept(ItemGroup.DisplayContext displayContext, ItemGroup.Entries entries) {
        this.items.forEach(entries::add);
    }
}