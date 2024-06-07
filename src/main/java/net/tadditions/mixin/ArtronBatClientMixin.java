package net.tadditions.mixin;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.tadditions.mod.enchantments.TAEnchants;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.items.ArtronItemStackBatteryItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(ArtronItemStackBatteryItem.class)
public abstract class ArtronBatClientMixin {

    @Shadow(remap = false)
    public abstract boolean isCreative();

    @Shadow(remap = false)
    public abstract float getCharge(ItemStack stack);

    @Shadow(remap = false)
    public abstract float getMaxCharge(ItemStack stack);

    @Accessor(remap = false)
    public abstract float getChargeRateMultiplier();

    @Accessor(remap = false)
    public abstract float getDischargeRateMultiplier();

    /**
     * @author me
     * @reason yes
     */
    @Overwrite(remap = false)
    public void createStatisticTooltips(ItemStack stack, World worldIn, List<ITextComponent> tooltip,
                                        ITooltipFlag flagIn) {
        int enchantLevelR = EnchantmentHelper.getEnchantmentLevel(TAEnchants.SUBSPACE_LINK.get(), stack);
        int enchantLevelS = EnchantmentHelper.getEnchantmentLevel(TAEnchants.SUBSPACE_POCKET.get(), stack);

        float r = 0;
        float s = 0;

        if(enchantLevelR > 0){
            r = (float) (enchantLevelR);
        }
        if(enchantLevelS > 0){
            s = (float) (enchantLevelS*1028);
        }
        tooltip.add(new TranslationTextComponent("tooltip.artron_battery.charge").appendSibling(new StringTextComponent(String.valueOf(this.getCharge(stack))).mergeStyle(TextFormatting.LIGHT_PURPLE).appendSibling(TardisConstants.Suffix.ARTRON_UNITS)));
        tooltip.add(new TranslationTextComponent("tooltip.artron_battery.max_charge").appendSibling(new StringTextComponent(String.valueOf(this.getMaxCharge(stack)+s)).mergeStyle(TextFormatting.LIGHT_PURPLE).appendSibling(TardisConstants.Suffix.ARTRON_UNITS)));
        tooltip.add(new TranslationTextComponent("tooltip.artron_battery.discharge_multiplier").appendSibling(new StringTextComponent(String.valueOf(this.getDischargeRateMultiplier()+r)).mergeStyle(TextFormatting.LIGHT_PURPLE)));
        tooltip.add(new TranslationTextComponent("tooltip.artron_battery.charge_multiplier").appendSibling(new StringTextComponent(String.valueOf(this.getChargeRateMultiplier()+r)).mergeStyle(TextFormatting.LIGHT_PURPLE)));
        if (this.isCreative() && this.getCharge(stack) == 0)
            tooltip.add(new TranslationTextComponent("tooltip.artron_battery.creative_setup"));
    }
}
