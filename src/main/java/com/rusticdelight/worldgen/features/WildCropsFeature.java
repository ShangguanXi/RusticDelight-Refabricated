package com.rusticdelight.worldgen.features;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import static com.rusticdelight.RusticDelight.makeKey;

public class WildCropsFeature {
    public static final RegistryKey<PlacedFeature> WILD_BELL_PEPPERS_PLACED = makeKey(RegistryKeys.PLACED_FEATURE, "wild_bell_peppers_placed");
    public static final RegistryKey<PlacedFeature> WILD_COTTON_PLACED = makeKey(RegistryKeys.PLACED_FEATURE, "wild_cotton_placed");

    public static void initialize() {
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_JUNGLE), GenerationStep.Feature.VEGETAL_DECORATION, WILD_BELL_PEPPERS_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, WILD_COTTON_PLACED);
    }
}
