package com.soulspeed113.effect;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;

public class SoulSpeedEffect extends StatusEffect {
    public SoulSpeedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        BlockPos pos = entity.getBlockPos();
        BlockState blockState = entity.getWorld().getBlockState(pos);

        if (blockState.isIn(BlockTags.SOUL_SPEED_BLOCKS)) {
            // Effect logic can be added here if needed
        }
        return true;
    }
}