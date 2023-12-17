package net.tadditions.mod.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.tardis.mod.items.ArtronCapacitorItem;

public class SubspaceLinkEnchant extends Enchantment {
    protected SubspaceLinkEnchant(Rarity rarityIn, EnchantmentType type, EquipmentSlotType[] slots) {
        super(rarityIn, type, slots);
    }

    @Override
    public boolean canApply(ItemStack stack) {
        return type.canEnchantItem(stack.getItem());
    }

    @Override
    public boolean isTreasureEnchantment() {
        return true;
    }

    @Override
    public boolean canVillagerTrade() {
        return true;
    }

    @Override
    public boolean canGenerateInLoot() {
        return true;
    }

    @Override
    public int getMaxLevel() {
        return 10;
    }


}
