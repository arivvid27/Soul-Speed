package com.soulspeed113.effect;

import com.soulspeed113.SoulSpeed;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static StatusEffect SOUL_SPEED;

    public static void registerEffects() {
        SOUL_SPEED = Registry.register(
            Registries.STATUS_EFFECT,
            Identifier.of(SoulSpeed.MOD_ID, "soul_speed"),
            new SoulSpeedEffect(StatusEffectCategory.BENEFICIAL, 0x7433FF)
        );
    }
}
