package com.rusticdelight.items;


import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class RusticFoodComponents {
    public static final FoodComponent BELL_PEPPER = (new FoodComponent.Builder()).hunger(1).saturationModifier(0.1F).build();
    public static final FoodComponent CALAMARI = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.3F).build();
    public static final FoodComponent COOKED_CALAMARI = (new FoodComponent.Builder()).hunger(5).saturationModifier(0.6F).build();
    public static final FoodComponent ROASTED_BELL_PEPPER = (new FoodComponent.Builder()).hunger(5).saturationModifier(0.8F).build();

    public static final FoodComponent COOKING_OIL = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.3F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 400, 0), 0.5F).build();
    public static final FoodComponent BATTER = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.2F).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.3F).build();
    public static final FoodComponent POTATO_SLICES = (new FoodComponent.Builder()).hunger(1).saturationModifier(0.3F).build();
    public static final FoodComponent BAKED_POTATO_SLICES = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.6F).build();

    public static final FoodComponent CALAMARI_SLICES = (new FoodComponent.Builder()).hunger(1).saturationModifier(0.1F).build();
    public static final FoodComponent COOKED_CALAMARI_SLICES = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.6F).build();
    public static final FoodComponent FRUIT_BEIGNET = (new FoodComponent.Builder()).hunger(6).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 600, 0), 1F).build();
    public static final FoodComponent CALAMARI_ROLL = (new FoodComponent.Builder()).hunger(7).saturationModifier(0.6F).build();
    public static final FoodComponent SPRING_ROLLS = (new FoodComponent.Builder()).hunger(7).saturationModifier(0.6F).build();
    public static final FoodComponent POTATO_SALAD = (new FoodComponent.Builder()).hunger(8).saturationModifier(0.7F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 120, 0), 1F).build();
    public static final FoodComponent STUFFED_BELL_PEPPER = (new FoodComponent.Builder()).hunger(10).saturationModifier(0.7F).build();
    public static final FoodComponent BELL_PEPPER_SOUP = (new FoodComponent.Builder()).hunger(6).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(ModEffects.COMFORT.get(), 3600, 0), 1F).build();
    public static final FoodComponent BELL_PEPPER_PASTA = (new FoodComponent.Builder()).hunger(12).saturationModifier(0.8F).statusEffect(new StatusEffectInstance(ModEffects.NOURISHMENT.get(), 1200, 0), 1F).build();
    public static final FoodComponent FRIED_CALAMARI = (new FoodComponent.Builder()).hunger(12).saturationModifier(0.8F).statusEffect(new StatusEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1F).build();
    public static final FoodComponent FRIED_CHICKEN = (new FoodComponent.Builder()).hunger(12).saturationModifier(0.8F).statusEffect(new StatusEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1F).build();
    public static final FoodComponent FRIED_MUSHROOMS = (new FoodComponent.Builder()).hunger(12).saturationModifier(0.8F).statusEffect(new StatusEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1F).build();
}
