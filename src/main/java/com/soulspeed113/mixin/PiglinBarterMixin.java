package com.soulspeed113.mixin;

import com.soulspeed113.potion.ModPotions;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Random;

@Mixin(PiglinEntity.class)
public class PiglinBarterMixin {
    @Inject(method = "getBarterResponseItems", at = @At("RETURN"), cancellable = true) 
    private void addSoulSpeedPotions(CallbackInfoReturnable<List<ItemStack>> cir) {
        List<ItemStack> originalLoot = cir.getReturnValue();
        Random random = new Random();

        if (random.nextFloat() < 0.05F) {
            originalLoot.clear();

            ItemStack soulSpeedPotion = PotionUtil.setPotion(new ItemStack(Items.POTION), ModPotions.SOUL_SPEED);
            originalLoot.add(soulSpeedPotion);

        }
    }
}