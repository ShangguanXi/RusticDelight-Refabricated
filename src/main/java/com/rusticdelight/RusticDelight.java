package com.rusticdelight;

import com.rusticdelight.register.BlockRegister;
import com.rusticdelight.register.ItemGroupRegster;
import com.rusticdelight.register.ItemRegister;
import com.rusticdelight.worldgen.features.WildCropsFeature;
import net.fabricmc.api.ModInitializer;

public class RusticDelight implements ModInitializer {

	@Override
	public void onInitialize() {
		ItemGroupRegster.initialize();
		BlockRegister.initialize();
		ItemRegister.initialize();
		WildCropsFeature.initialize();
	}
}