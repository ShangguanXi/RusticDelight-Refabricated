package com.rusticdelight.worldgen.features;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
public class WildCropsFeature {

    public static final RegistryKey<PlacedFeature> WILD_BELL_PEPPERS_PLACED = Feature("wild_bell_peppers_placed");
    public static final RegistryKey<PlacedFeature> WILD_COTTON_PLACED = Feature("wild_cotton_placed");
    private static RegistryKey<PlacedFeature> Feature(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("rusticdelight", name));
    }
    public static void initialize(){
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_JUNGLE), GenerationStep.Feature.VEGETAL_DECORATION, WILD_BELL_PEPPERS_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, WILD_COTTON_PLACED);
    }
}
