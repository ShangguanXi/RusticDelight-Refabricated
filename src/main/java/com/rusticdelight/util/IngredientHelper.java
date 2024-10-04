package com.rusticdelight.util;

import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;

import java.util.Arrays;
import java.util.stream.Stream;

public class IngredientHelper {
    public static Ingredient addAll(Ingredient original, ItemConvertible... items) {
        return Ingredient.ofStacks(Stream.concat(Arrays.stream(original.getMatchingStacks()), Arrays.stream(items).map(ItemStack::new)));
    }
}
