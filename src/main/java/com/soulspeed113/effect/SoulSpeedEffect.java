package com.soulspeed113.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class SoulSpeedEffect extends StatusEffect {
    public SoulSpeedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient()) {
            return true;
        }

        BlockPos belowPos = entity.getBlockPos().down();
        
        // Check if standing on soul speed blocks
        if (entity.getWorld().getBlockState(belowPos).isIn(BlockTags.SOUL_SPEED_BLOCKS)) {
            Vec3d velocity = entity.getVelocity();
            
            if (Math.abs(velocity.x) > 0.01 || Math.abs(velocity.z) > 0.01) {
                float speedMultiplier = 1.0f + (amplifier + 1) * 0.105f;
                
                entity.setVelocity(
                    velocity.x * speedMultiplier,
                    velocity.y,
                    velocity.z * speedMultiplier
                );
                
                if (entity.getWorld() instanceof ServerWorld serverWorld) {
                    if (entity.getRandom().nextFloat() < 0.3f) {
                        serverWorld.spawnParticles(
                            ParticleTypes.SOUL,
                            entity.getX() + (entity.getRandom().nextDouble() - 0.5) * 0.5,
                            entity.getY() + 0.1,
                            entity.getZ() + (entity.getRandom().nextDouble() - 0.5) * 0.5,
                            1,
                            0.0, 0.1, 0.0,
                            0.05
                        );
                    }
                }
                
            }
        }
        
        return true;
    }
}