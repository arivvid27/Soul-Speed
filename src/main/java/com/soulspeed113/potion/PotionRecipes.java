package main.java.com.soulspeed113.potion;

import net.minecraft.item.Item;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;

public class PotionRecipes {
    public static void registerPotionRecipe() {
        // reg potion
        BrewingRecipeRegistry.registerPotionRecipe(
            Potions.AWKWARD,
            Items.SOUL_SAND,
            ModPotions.SOUL_SPEED
        );

        // long potion
        BrewingRecipeRegistry.registerPotionRecipe(
            ModPotions.SOUL_SPEED,
            Items.REDSTONE,
            ModPotions.SOUL_SPEED_LONG
        );

        // strong potion
        BrewingRecipeRegistry.registerPotionRecipe(
            ModPotions.SOUL_SPEED,
            Items.GLOWSTONE_DUST,
            ModPotions.STRONG_SOUL_SPEED
        );
    }
}