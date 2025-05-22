package com.soulspeed113;

import com.soulspeed113.SoulSpeed.effect.ModEffects;
import com.soulspeed113.SoulSpeed.item.ModItems;
import com.soulspeed113.SoulSpeed.potion.ModPotions;
import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SoulSpeed implements ModInitializer {
	public static final String MOD_ID = "soul_speed_potion";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Initializing SoulSpeed");

		// CUstom Content
		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModItems.registerItems();

		LOGGER.info("Initialized SoulSpeed Successfully");
	}
}