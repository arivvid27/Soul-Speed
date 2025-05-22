package main.java.com.soulspeed113.effect;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;

public class SoulSpeedEffect extends StatusEffect {
    protected SoulSpeedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        BlockPos pos = entity.getBlockPos();
        BlockState blockState = entity.getWorld.getBlockState(pos);

        if (blockState.isIn(BlockTags.SOUL_SPEED_BLOCKS)) {
            // Literally just if I want to add more
        }
    }
}