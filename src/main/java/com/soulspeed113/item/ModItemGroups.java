package com.soulspeed113.item;

import com.soulspeed113.SoulSpeed;
import com.soulspeed113.potion.ModPotions;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup SOUL_SPEED_GROUP = Registry.register(
        Registries.ITEM_GROUP,
        Identifier.of(SoulSpeed.MOD_ID, "soul_speed"),
        FabricItemGroup.builder()
            .displayName(Text.translatable("itemgroup.soulspeed113.soul_speed"))
            .icon(() -> {
                ItemStack stack = new ItemStack(Items.POTION);
                stack.set(DataComponentTypes.POTION_CONTENTS,
                new PotionContentsComponent(ModPotions.SOUL_SPEED));
            return stack;
        })
        .entries((displayContext, entries) -> {
            // POTIONS
            ItemStack soulSpeedPotion = new ItemStack(Items.POTION);
            soulSpeedPotion.set(DataComponentTypes.POTION_CONTENTS,
                new PotionContentsComponent(ModPotions.SOUL_SPEED));
            entries.add(soulSpeedPotion);

            ItemStack longSoulSpeedPotion = new ItemStack(Items.POTION);
            longSoulSpeedPotion.set(DataComponentTypes.POTION_CONTENTS,
                new PotionContentsComponent(ModPotions.LONG_SOUL_SPEED));
            entries.add(longSoulSpeedPotion);

            ItemStack strongSoulSpeedPotion = new ItemStack(Items.POTION);
            strongSoulSpeedPotion.set(DataComponentTypes.POTION_CONTENTS,
                new PotionContentsComponent(ModPotions.STRONG_SOUL_SPEED));
            entries.add(strongSoulSpeedPotion);

            // LINGERING
            ItemStack lingeringSoulSpeed = new ItemStack(Items.LINGERING_POTION);
            lingeringSoulSpeed.set(DataComponentTypes.POTION_CONTENTS,
                new PotionContentsComponent(ModPotions.SOUL_SPEED));
            entries.add(lingeringSoulSpeed);

            ItemStack lingeringLongSoulSpeed = new ItemStack(Items.LINGERING_POTION);
            lingeringLongSoulSpeed.set(DataComponentTypes.POTION_CONTENTS,
                new PotionContentsComponent(ModPotions.LONG_SOUL_SPEED));
            entries.add(lingeringLongSoulSpeed);

            ItemStack lingeringStrongSoulSpeed = new ItemStack(Items.LINGERING_POTION);
            lingeringStrongSoulSpeed.set(DataComponentTypes.POTION_CONTENTS,
                new PotionContentsComponent(ModPotions.STRONG_SOUL_SPEED));
            entries.add(lingeringStrongSoulSpeed);

            // ARROWS
            ItemStack arrowSoulSpeed = new ItemStack(Items.TIPPED_ARROW);
            arrowSoulSpeed.set(DataComponentTypes.POTION_CONTENTS,
                new PotionContentsComponent(ModPotions.SOUL_SPEED));
            entries.add(arrowSoulSpeed);

            ItemStack arrowLongSoulSpeed = new ItemStack(Items.TIPPED_ARROW);
            arrowLongSoulSpeed.set(DataComponentTypes.POTION_CONTENTS,
                new PotionContentsComponent(ModPotions.LONG_SOUL_SPEED));
            entries.add(arrowLongSoulSpeed);

            ItemStack arrowStrongSoulSpeed = new ItemStack(Items.TIPPED_ARROW);
            arrowStrongSoulSpeed.set(DataComponentTypes.POTION_CONTENTS,
                new PotionContentsComponent(ModPotions.STRONG_SOUL_SPEED));
            entries.add(arrowStrongSoulSpeed);
        })
        .build()
    );
}