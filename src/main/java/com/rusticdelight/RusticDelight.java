package com.rusticdelight;

import com.rusticdelight.register.BlockRegister;
import com.rusticdelight.register.ItemGroupRegister;
import com.rusticdelight.register.ItemRegister;
import com.rusticdelight.register.TradeRegister;
import com.rusticdelight.worldgen.features.WildCropsFeature;
import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class RusticDelight implements ModInitializer {
    public static final String MOD_ID = "rusticdelight";
    public static final Identifier ROOT = new Identifier(MOD_ID, "root");

    /**
     * to skip namespace checking
     */
    public static @NotNull Identifier makeId(String name) {
        return ROOT.withPath(name);
    }

    /**
     * to skip namespace checking
     */
    public static <T> @NotNull RegistryKey<T> makeKey(RegistryKey<? extends Registry<T>> registry, String name) {
        return RegistryKey.of(registry, ROOT.withPath(name));
    }

    @Override
    public void onInitialize() {
        ItemGroupRegister.initialize();
        BlockRegister.initialize();
        ItemRegister.initialize();
        TradeRegister.initialize();
        WildCropsFeature.initialize();
    }
}