package net.tadditions.mod.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

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

    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return 100;
    }

    @Override
    protected boolean canApplyTogether(Enchantment ench) {
        return !ench.equals(TAEnchants.BLESSING_OF_FLOW.get());
    }

    @Override
    public boolean canApply(ItemStack stack) {
        return super.canApply(stack) && EnchantmentHelper.getEnchantmentLevel(TAEnchants.BLESSING_OF_FLOW.get(), stack)==0;
    }
}
