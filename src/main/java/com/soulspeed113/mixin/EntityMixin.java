package com.soulspeed113.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.soulspeed113.effect.ModEffects;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;

@Mixin(Entity.class)
public class EntityMixin {
	@SuppressWarnings("unchecked")
	@Inject(method = "tick", at = @At("HEAD"))
	private void applySoulSpeedFromPotion(CallbackInfo ci) {
		Entity entity = (Entity)(Object)this;

		if (entity instanceof LivingEntity livingEntity) {
			int soulSpeedLevel = 0;
			StatusEffectInstance effect = livingEntity.getStatusEffect((RegistryEntry<StatusEffect>) ModEffects.SOUL_SPEED);
			if (effect != null) {
				soulSpeedLevel = effect.getAmplifier() + 1; // Amplifier is 0-based, so add 1
			}
			
			if (soulSpeedLevel > 0) {
				BlockPos pos = entity.getBlockPos();
				BlockState blockState = entity.getWorld().getBlockState(pos);

				if (blockState.isIn(BlockTags.SOUL_SPEED_BLOCKS)) {
					float multiplier = 0.05F * soulSpeedLevel;

					if (entity.isOnGround() && (entity.getVelocity().x != 0 || entity.getVelocity().z != 0)) {
						entity.setVelocity(
							entity.getVelocity().x * (1.0 + multiplier),
							entity.getVelocity().y,
							entity.getVelocity().z * (1.0 + multiplier)
						);

						// Add soul particles occasionally
						if (entity.getRandom().nextFloat() < 0.2F) {
							entity.getWorld().addParticle(
								net.minecraft.particle.ParticleTypes.SOUL,
								entity.getX(),
								entity.getY() + 0.1,
								entity.getZ(),
								0.0, 0.1, 0.0
							);
						}
					}
				}
			}
		}
	}
}