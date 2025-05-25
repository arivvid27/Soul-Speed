package com.soulspeed113.potion;

import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.entry.RegistryEntry;

public class PotionRecipes {
    public static void registerPotionRecipe() {
        // Regular potion - Soul Sand + Awkward Potion = Soul Speed Potion
        BrewingRecipeRegistry.registerPotionRecipe(
            (RegistryEntry) Potions.AWKWARD,
            Items.SOUL_SAND,
            (RegistryEntry) ModPotions.SOUL_SPEED
        );

        // Long potion - Soul Speed + Redstone = Long Soul Speed
        BrewingRecipeRegistry.registerPotionRecipe(
            (RegistryEntry) ModPotions.SOUL_SPEED,
            Items.REDSTONE,
            (RegistryEntry) ModPotions.LONG_SOUL_SPEED
        );

        // Strong potion - Soul Speed + Glowstone = Strong Soul Speed
        BrewingRecipeRegistry.registerPotionRecipe(
            (RegistryEntry) ModPotions.SOUL_SPEED,
            Items.GLOWSTONE_DUST,
            (RegistryEntry) ModPotions.STRONG_SOUL_SPEED
        );
    }
}