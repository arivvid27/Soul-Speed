package main.java.com.soulspeed113.potion;

import com.soulspeed113.SoulSpeedPotionMod;
import com.soulspeed113.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static Potion SOUL_SPEED;
    public static Potion LONG_SOUL_SPEED;
    public static Potion STRONG_SOUL_SPEED;

    public static void registerPotions() {
        SOUL_SPEED = Registry.register(
            Registries.POTION,
            new Identifier(SoulSpeedPotionMod.MOD_ID, "soul_speed"),
            new Potion(
                new StatusEffectInstance(ModEffects.SOUL_SPEED, 3600, 0)
            )
        );
        SOUL_SPEED_LONG = Registry.register(
            Registries.POTION,
            new Identifier(SoulSpeedPotionMod.MOD_ID, "long_soul_speed"),
            new Potion(
                new StatusEffectInstance(ModEffects.SOUL_SPEED, 9600, 0)
            )
        );
        STRONG_SOUL_SPEED = Registry.register(
            Registries.POTION,
            new Identifier(SoulSpeedPotionMod.MOD_ID, "strong_soul_speed"),
            new Potion(
                new StatusEffectInstance(ModEffects.SOUL_SPEED, 1800, 1)
            )
        );
    
        registerBrewingRecipes();
    }

    private static void registerBrewingRecipes() {
        // TODO: Add recipes
        PotionRecipes.registerPotionRecipe();
    }
}