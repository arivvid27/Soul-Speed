package com.soulspeed113.mixin;

import com.soulspeed113.potion.ModPotions;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
// import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContext;
// import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// import java.util.List;

@Mixin(PiglinEntity.class)
public class PiglinBarterMixin {
    @Inject(method = "getBarteredItem", at = @At("RETURN"), cancellable = true)
    private void addSoulSpeedPotions(LootContext lootContext, CallbackInfoReturnable<ItemStack> cir) {
        if (lootContext.getRandom().nextFloat() < 0.05F) {
            ItemStack soulSpeedPotion = new ItemStack(Items.POTION);
            soulSpeedPotion.set(DataComponentTypes.POTION_CONTENTS, 
                new PotionContentsComponent(ModPotions.SOUL_SPEED));
            cir.setReturnValue(soulSpeedPotion);
        }
    }
}