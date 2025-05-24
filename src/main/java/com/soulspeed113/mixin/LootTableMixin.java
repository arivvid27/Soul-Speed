package come.soulspeed113.mixin;

import com.soulspeed113.potion.ModPotions;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.function.SetPotionLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.potion.PotionUtil;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(LootTable.class)
public class LootTableMixin {
    private static final Identifier BASTION_TREASURE = new Identifier("minecraft:chests/bastion_treasure");
    private static final Identifier END_CITY_TREASURE = new Identifier("minecraft:chests/ruined_portal");
    private static final Identifier SHIPWRECK_TREASURE = new Identifier("minecraft:chests/nether_bridge");

    @Inject(method = "generateLoot", at = @At("RETURN"))
    private void addSoulSpeedPotionToLoot(LootContext context, CallbackInfoReturnable<List<ItemStack>> cir) {
        Identifier tableId = context.getTable().getId();
        List<ItemStack> loot = cir.getReturnValue();

        if (BASTION_TREASURE.equals(tableId) || RUINED_PORTAL.equals(tableId) || NETHER_BRIDGE.equals(tableId)) {
            if (context.getRandom().nextFloat() < 0.15F) {
                float potionTypeRoll = context.getRandom().nextFloat();
                ItemStack potionStack;
                if (potionTypeRoll < 0.6F) {
                    potionStack = PotionUtil.setPotion(new ItemStack(Items.POTION), ModPotions.SOUL_SPEED);
                } else if (potionTypeRoll < 0.9F) {
                    potionStack = PotionUtil.setPotion(new ItemStack(Items.POTION), ModPotions.LONG_SOUL_SPEED);
                } else {
                    potionStack = PotionUtil.setPotion(new ItemStack(Items.POTION), ModPotions.STRONG_SOUL_SPEED);
                }

                loot.add(potionStack);
            }
        }
    }
}

