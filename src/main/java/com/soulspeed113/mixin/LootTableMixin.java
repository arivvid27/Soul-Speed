package com.soulspeed113.mixin;

import com.soulspeed113.potion.ModPotions;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContext;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(LootTable.class)
public class LootTableMixin {
    private static final Identifier BASTION_TREASURE = Identifier.of("minecraft", "chests/bastion_treasure");
    private static final Identifier RUINED_PORTAL = Identifier.of("minecraft", "chests/ruined_portal");
    private static final Identifier NETHER_BRIDGE = Identifier.of("minecraft", "chests/nether_bridge");

    @Inject(method = "generateLoot", at = @At("RETURN"))
    private void addSoulSpeedPotionToLoot(LootContext context, CallbackInfoReturnable<List<ItemStack>> cir) {
        List<ItemStack> loot = cir.getReturnValue();

        if (context.getRandom().nextFloat() < 0.15F) {
            float potionTypeRoll = context.getRandom().nextFloat();
            ItemStack potionStack = new ItemStack(Items.POTION);
            
            if (potionTypeRoll < 0.6F) {
                potionStack.set(DataComponentTypes.POTION_CONTENTS, 
                    new PotionContentsComponent(ModPotions.SOUL_SPEED));
            } else if (potionTypeRoll < 0.9F) {
                potionStack.set(DataComponentTypes.POTION_CONTENTS, 
                    new PotionContentsComponent(ModPotions.LONG_SOUL_SPEED));
            } else {
                potionStack.set(DataComponentTypes.POTION_CONTENTS, 
                    new PotionContentsComponent(ModPotions.STRONG_SOUL_SPEED));
            }
            
            loot.add(potionStack);
        }
    }
}