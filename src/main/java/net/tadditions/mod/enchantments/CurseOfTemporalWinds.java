package net.tadditions.mod.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class CurseOfTemporalWinds extends Enchantment {
    protected CurseOfTemporalWinds(Rarity rarityIn, EnchantmentType typeIn) {
        super(rarityIn, typeIn, EquipmentSlotType.values());
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean isCurse() {
        return true;
    }
}
