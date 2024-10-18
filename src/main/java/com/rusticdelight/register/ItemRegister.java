package com.rusticdelight.register;

import com.rusticdelight.items.RusticFoodComponents;
import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import static com.rusticdelight.RusticDelight.makeId;
import static com.rusticdelight.register.ItemGroupRegister.RUSTIC_DELIGHT_GROUP;
import static net.fabricmc.fabric.api.registry.VillagerInteractionRegistries.*;

public class ItemRegister {
    public static final Item COTTON_BOLL = register("cotton_boll", new Item(new Item.Settings()));
    public static final Item BELL_PEPPER_RED = register("bell_pepper_red", new Item(new Item.Settings().food(RusticFoodComponents.BELL_PEPPER)));
    public static final Item BELL_PEPPER_GREEN = register("bell_pepper_green", new Item(new Item.Settings().food(RusticFoodComponents.BELL_PEPPER)));
    public static final Item BELL_PEPPER_YELLOW = register("bell_pepper_yellow", new Item(new Item.Settings().food(RusticFoodComponents.BELL_PEPPER)));
    //seed
    public static final Item COTTON_SEEDS = register("cotton_seeds", new AliasedBlockItem(BlockRegister.COTTON, new Item.Settings()));
    public static final Item BELL_PEPPER_SEEDS = register("bell_pepper_seeds", new AliasedBlockItem(BlockRegister.BELL_PEPPER, new Item.Settings()));
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
        return RUSTIC_DELIGHT_GROUP.register(Registries.ITEM, makeId(path), item);
    }

    public static void initialize() {
        registerCompostableConfig(ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE);

        // villager collectable
        registerCollectable(BELL_PEPPER_GREEN);
        registerCollectable(BELL_PEPPER_YELLOW);
        registerCollectable(BELL_PEPPER_RED);
        /*registerCollectable(COTTON_BOLL); 村民抢棉花不好吧*/
        registerCollectable(BELL_PEPPER_SEEDS);
        registerCollectable(COTTON_SEEDS);

        // villager food
        registerFood(BELL_PEPPER_GREEN, 1);
        registerFood(BELL_PEPPER_YELLOW, 1);
        registerFood(BELL_PEPPER_RED, 1);

        // farmer compostable
        registerCompostable(BELL_PEPPER_SEEDS);
        registerCompostable(COTTON_SEEDS);
    }

    public static void registerCompostableConfig(Object2FloatMap<ItemConvertible> config) {
        // 30% chance
        config.put(COTTON_SEEDS, 0.3f);
        config.put(BELL_PEPPER_SEEDS, 0.3f);
        // 50% chance
        config.put(COTTON_BOLL, 0.5f);
        config.put(POTATO_SLICES, 0.5f);
        // 65% chance
        config.put(BELL_PEPPER_GREEN, 0.65f);
        config.put(BELL_PEPPER_YELLOW, 0.65f);
        config.put(BELL_PEPPER_RED, 0.65f);
        config.put(BlockRegister.WILD_COTTON, 0.65f);
        config.put(BlockRegister.WILD_BELL_PEPPERS, 0.65f);
    }
}
