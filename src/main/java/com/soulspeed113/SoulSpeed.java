package com.soulspeed113;

import com.soulspeed113.effect.ModEffects;
import com.soulspeed113.item.ModItems;
import com.soulspeed113.potion.ModPotions;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SoulSpeed implements ModInitializer {
	public static final String MOD_ID = "soulspeed113";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Soul Speed Potion Mod");

		// CUstom stuff
		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModItems.registerItems();

		LOGGER.info("Initialization of SoulSpeed complete");
	}
}