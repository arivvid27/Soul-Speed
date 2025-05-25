package com.soulspeed113.potion;

import com.soulspeed113.SoulSpeed;
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
            Identifier.of(SoulSpeed.MOD_ID, "soul_speed"),
            new Potion(
                StatusEffectInstance(ModEffects.SOUL_SPEED, 3600, 0)
            )
        );
        
        LONG_SOUL_SPEED = Registry.register(
            Registries.POTION,
            Identifier.of(SoulSpeed.MOD_ID, "long_soul_speed"),
            new Potion(
                StatusEffectInstance(ModEffects.SOUL_SPEED, 9600, 0)
            )
        );

        STRONG_SOUL_SPEED = Registry.register(
            Registries.POTION,
            Identifier.of(SoulSpeed.MOD_ID, "strong_soul_speed"),
            new Potion(
                StatusEffectInstance(ModEffects.SOUL_SPEED, 1800, 1)
            )
        );

        PotionRecipes.registerPotionRecipe();
    }
}