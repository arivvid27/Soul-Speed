package com.soulspeed113.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.soulspeed113.effect.ModEffects;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;

@Mixin(Entity.class)
public class EntityMixin {
	@Inject(method = "tick", at = @At("HEAD"))
	private void applySoulSpeedFromPotion(CallbackInfo ci) {
		Entity entity = (Entity)(Object)this;

		if (!(entity instanceof LivingEntity livingEntity)) {
			return;
		}

		// Check if we have the soul speed effect
		var soulSpeedEntry = Registries.STATUS_EFFECT.getEntry(ModEffects.SOUL_SPEED);
		StatusEffectInstance effect = livingEntity.getStatusEffect(soulSpeedEntry);
		
		if (effect == null) {
			return;
		}

		int soulSpeedLevel = effect.getAmplifier() + 1;
		BlockPos pos = entity.getBlockPos();
		BlockState blockState = entity.getWorld().getBlockState(pos);

		if (blockState.isIn(BlockTags.SOUL_SPEED_BLOCKS)) {
			float multiplier = 0.05F * soulSpeedLevel;

			if (entity.isOnGround() && (Math.abs(entity.getVelocity().x) > 0.01 || Math.abs(entity.getVelocity().z) > 0.01)) {
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