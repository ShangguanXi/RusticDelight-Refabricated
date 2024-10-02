package com.rusticdelight.register;

import com.rusticdelight.items.RusticFoodComponents;
import net.minecraft.block.Block;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import java.util.ArrayList;
import java.util.List;

public class ItemRegister {
    public static final List<Item> registeredItems = new ArrayList<>();
    public static final Item COTTON_BOLL = register("cotton_boll", new Item(new Item.Settings()));
    public static final Item BELL_PEPPER_RED = register("bell_pepper_red", new Item(new Item.Settings().food(RusticFoodComponents.BELL_PEPPER)));
    public static final Item BELL_PEPPER_GREEN = register("bell_pepper_green", new Item(new Item.Settings().food(RusticFoodComponents.BELL_PEPPER)));
    public static final Item BELL_PEPPER_YELLOW = register("bell_pepper_yellow", new Item(new Item.Settings().food(RusticFoodComponents.BELL_PEPPER)));
    //seed
    public static final Item COTTON_SEEDS = register("cotton_seeds",new AliasedBlockItem(BlockRegister.COTTON,new Item.Settings()));
    public static final Item BELL_PEPPER_SEEDS = register("bell_pepper_seeds",new AliasedBlockItem(BlockRegister.BELL_PEPPER,new Item.Settings()));
    //food
    public static final Item CALAMARI = register("calamari", new Item(new Item.Settings().food(RusticFoodComponents.CALAMARI)));
    public static final Item COOKED_CALAMARI = register("cooked_calamari", new Item(new Item.Settings().food(RusticFoodComponents.COOKED_CALAMARI)));
    public static final Item ROASTED_BELL_PEPPER_GREEN = register("roasted_bell_pepper_green", new Item(new Item.Settings().food(RusticFoodComponents.ROASTED_BELL_PEPPER)));
    public static final Item ROASTED_BELL_PEPPER_YELLOW = register("roasted_bell_pepper_yellow", new Item(new Item.Settings().food(RusticFoodComponents.ROASTED_BELL_PEPPER)));
    public static final Item ROASTED_BELL_PEPPER_RED = register("roasted_bell_pepper_red", new Item(new Item.Settings().food(RusticFoodComponents.ROASTED_BELL_PEPPER)));
    public static final Item COOKING_OIL = register("cooking_oil", new DrinkableItem(new Item.Settings().food(RusticFoodComponents.COOKING_OIL).recipeRemainder(Items.GLASS_BOTTLE).maxCount(16)));
    public static final Item BATTER = register("batter", new DrinkableItem(new Item.Settings().food(RusticFoodComponents.BATTER).recipeRemainder(Items.BOWL).maxCount(16)));

    public static final Item POTATO_SLICES = register("potato_slices", new Item(new Item.Settings().food(RusticFoodComponents.POTATO_SLICES)));
    public static final Item BAKED_POTATO_SLICES = register("baked_potato_slices", new Item(new Item.Settings().food(RusticFoodComponents.BAKED_POTATO_SLICES)));
    public static final Item CALAMARI_SLICES = register("calamari_slice", new Item(new Item.Settings().food(RusticFoodComponents.CALAMARI_SLICES)));
    public static final Item COOKED_CALAMARI_SLICES = register("cooked_calamari_slice", new Item(new Item.Settings().food(RusticFoodComponents.COOKED_CALAMARI_SLICES)));
    public static final Item FRUIT_BEIGNET = register("fruit_beignet", new Item(new Item.Settings().food(RusticFoodComponents.FRUIT_BEIGNET)));

    public static final Item CALAMARI_ROLL = register("calamari_roll", new Item(new Item.Settings().food(RusticFoodComponents.CALAMARI_ROLL)));
    public static final Item POTATO_SALAD = register("potato_salad", new Item(new Item.Settings().food(RusticFoodComponents.POTATO_SALAD).recipeRemainder(Items.BOWL).maxCount(16)));
    public static final Item SPRING_ROLLS = register("spring_rolls", new Item(new Item.Settings().food(RusticFoodComponents.SPRING_ROLLS)));
    public static final Item STUFFED_BELL_PEPPER_GREEN = register("stuffed_bell_pepper_green", new Item(new Item.Settings().food(RusticFoodComponents.STUFFED_BELL_PEPPER)));
    public static final Item STUFFED_BELL_PEPPER_YELLOW = register("stuffed_bell_pepper_yellow", new Item(new Item.Settings().food(RusticFoodComponents.STUFFED_BELL_PEPPER)));
    public static final Item STUFFED_BELL_PEPPER_RED = register("stuffed_bell_pepper_red", new Item(new Item.Settings().food(RusticFoodComponents.STUFFED_BELL_PEPPER)));
    public static final Item BELL_PEPPER_SOUP = register("bell_pepper_soup", new Item(new Item.Settings().food(RusticFoodComponents.BELL_PEPPER_SOUP).recipeRemainder(Items.BOWL).maxCount(16)));
    public static final Item BELL_PEPPER_PASTA = register("bell_pepper_pasta", new Item(new Item.Settings().food(RusticFoodComponents.BELL_PEPPER_PASTA).recipeRemainder(Items.BOWL).maxCount(16)));
    public static final Item FRIED_CALAMARI = register("fried_calamari", new Item(new Item.Settings().food(RusticFoodComponents.FRIED_CALAMARI).recipeRemainder(Items.BOWL).maxCount(16)));
    public static final Item FRIED_CHICKEN = register("fried_chicken", new Item(new Item.Settings().food(RusticFoodComponents.FRIED_CHICKEN).recipeRemainder(Items.BOWL).maxCount(16)));
    public static final Item FRIED_MUSHROOMS = register("fried_mushrooms", new Item(new Item.Settings().food(RusticFoodComponents.FRIED_MUSHROOMS).recipeRemainder(Items.BOWL).maxCount(16)));


    public static <T extends Item> T register(String path, T item) {
        registeredItems.add(item);
        return Registry.register(Registries.ITEM, new Identifier("rusticdelight", path), item);
    }

    public static void initialize() {
    }

}