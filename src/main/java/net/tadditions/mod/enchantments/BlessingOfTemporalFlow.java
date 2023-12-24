package net.tadditions.mod.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

public class BlessingOfTemporalFlow extends Enchantment {
    protected BlessingOfTemporalFlow(Rarity rarityIn, EnchantmentType typeIn) {
        super(rarityIn, typeIn, EquipmentSlotType.values());
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public ITextComponent getDisplayName(int level) {
        IFormattableTextComponent iformattabletextcomponent = new TranslationTextComponent(this.getName());
        iformattabletextcomponent.mergeStyle(TextFormatting.DARK_PURPLE);

        if (level != 1 || this.getMaxLevel() != 1) {
            iformattabletextcomponent.appendString(" ").appendSibling(new TranslationTextComponent("enchantment.level." + level));
        }

        return iformattabletextcomponent;
    }
}
