package net.tadditions.mixin;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.tadditions.mod.enchantments.TAEnchants;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.helper.TextHelper;
import net.tardis.mod.items.ArtronCapacitorItem;
import net.tardis.mod.items.misc.TooltipProviderItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

@Mixin(ArtronCapacitorItem.class)
public class ArtronCapMixin extends Item {

    @Shadow
    private float storage;

    @Shadow
    private float rechargeModifier;

    @Shadow @Final
    protected final IFormattableTextComponent descriptionTooltip = TextHelper.createDescriptionItemTooltip(new TranslationTextComponent("tooltip.artron_capacitor.info"));
    @Shadow @Final
    protected final IFormattableTextComponent descriptionTooltipTwo = TextHelper.createExtraLineItemTooltip(new TranslationTextComponent("tooltip.artron_capacitor.howto"));


    public ArtronCapMixin(Properties properties) {
        super(properties);
    }

    /**
     * @author me
     * @reason yes
     */
    @Overwrite(remap = false)
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(TardisConstants.Translations.TOOLTIP_HOLD_SHIFT);
        tooltip.add(TardisConstants.Translations.TOOLTIP_CONTROL);

        int enchantLevelR = EnchantmentHelper.getEnchantmentLevel(TAEnchants.SUBSPACE_LINK.get(), stack);
        int enchantLevelS = EnchantmentHelper.getEnchantmentLevel(TAEnchants.SUBSPACE_POCKET.get(), stack);

        float r = 1;
        float s = 1;

        if(enchantLevelR > 0){
            r = (float) (enchantLevelR*1.25);
        }
        if(enchantLevelS > 0){
            s = (float) (enchantLevelS*1.25);
        }
        if (Screen.hasShiftDown()) {
            tooltip.clear();
            tooltip.add(0, this.getDisplayName(stack));
            tooltip.add(new TranslationTextComponent("tooltip.artron_capacitor.max_charge").appendSibling(new StringTextComponent(String.valueOf(this.storage * s)).mergeStyle(TextFormatting.LIGHT_PURPLE).appendSibling(TardisConstants.Suffix.ARTRON_UNITS)));
            tooltip.add(new TranslationTextComponent("tooltip.artron_capacitor.recharge_multiplier").appendSibling(new StringTextComponent(String.valueOf(this.rechargeModifier * r)).mergeStyle(TextFormatting.LIGHT_PURPLE)));
        }
        if (Screen.hasControlDown()) {
            tooltip.clear();
            tooltip.add(0, this.getDisplayName(stack));
            tooltip.add(descriptionTooltip);
            tooltip.add(descriptionTooltipTwo);
        }
    }
}
