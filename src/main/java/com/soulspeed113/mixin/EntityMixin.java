package com.soulspeed113.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.soulspeed113.effect.ModEffects;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

@Mixin(Entity.class)
public class EntityMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void applySoulSpeedFromPotion(CallbackInfo ci) {
        Entity entity = (Entity)(Object)this;

        if (!(entity instanceof LivingEntity livingEntity)) {
            return;
        }

        var soulSpeedEntry = Registries.STATUS_EFFECT.getEntry(ModEffects.SOUL_SPEED);
        StatusEffectInstance effect = livingEntity.getStatusEffect(soulSpeedEntry);
        
        if (effect == null) {
            return;
        }

        int soulSpeedLevel = effect.getAmplifier() + 1;
        BlockPos belowPos = entity.getBlockPos().down();

        if (entity.getWorld().getBlockState(belowPos).isIn(BlockTags.SOUL_SPEED_BLOCKS)) {
            Vec3d velocity = entity.getVelocity();
            
            if (entity.isOnGround() && (Math.abs(velocity.x) > 0.01 || Math.abs(velocity.z) > 0.01)) {
                float speedMultiplier = 1.0f + soulSpeedLevel * 0.105f;
                
                entity.setVelocity(
                    velocity.x * speedMultiplier,
                    velocity.y,
                    velocity.z * speedMultiplier
                );
                
                if (!entity.getWorld().isClient() && entity.getWorld() instanceof ServerWorld serverWorld) {
                    if (entity.getRandom().nextFloat() < 0.2f) {
                        serverWorld.spawnParticles(
                            ParticleTypes.SOUL,
                            entity.getX() + (entity.getRandom().nextDouble() - 0.5) * 0.8,
                            entity.getY() + 0.1,
                            entity.getZ() + (entity.getRandom().nextDouble() - 0.5) * 0.8,
                            2,
                            0.0, 0.1, 0.0,
                            0.02
                        );
                    }
                }
            }
        }
    }
}