package net.tadditions.mixin;

import com.google.common.collect.Lists;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.tadditions.mod.enchantments.TAEnchants;
import net.tadditions.mod.items.ModItemGroups;
import net.tadditions.mod.items.ModItems;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.helper.TextHelper;
import net.tardis.mod.items.ArtronCapacitorItem;
import net.tardis.mod.items.misc.TooltipProviderItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.ArrayList;
import java.util.List;

@Mixin(ArtronCapacitorItem.class)
public class ArtronCapMixin extends Item {

    @Shadow(remap = false)
    private float storage;

    @Shadow(remap = false)
    private float rechargeModifier;

    @Shadow(remap = false) @Final
    protected final IFormattableTextComponent descriptionTooltip = TextHelper.createDescriptionItemTooltip(new TranslationTextComponent("tooltip.artron_capacitor.info"));
    @Shadow(remap = false) @Final
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

        float r = 0;
        float s = 0;

        if(enchantLevelR > 0){
            r = (float) (enchantLevelR);
        }
        if(enchantLevelS > 0){
            s = (float) (enchantLevelS*128);
        }
        if (Screen.hasShiftDown()) {
            tooltip.clear();
            tooltip.add(0, this.getDisplayName(stack));
            tooltip.add(new TranslationTextComponent("tooltip.artron_capacitor.max_charge").appendSibling(new StringTextComponent(String.valueOf(this.storage + s)).mergeStyle(TextFormatting.LIGHT_PURPLE).appendSibling(TardisConstants.Suffix.ARTRON_UNITS)));
            tooltip.add(new TranslationTextComponent("tooltip.artron_capacitor.recharge_multiplier").appendSibling(new StringTextComponent(String.valueOf(this.rechargeModifier + r)).mergeStyle(TextFormatting.LIGHT_PURPLE)));
        }
        if (Screen.hasControlDown()) {
            tooltip.clear();
            tooltip.add(0, this.getDisplayName(stack));
            tooltip.add(descriptionTooltip);
            tooltip.add(descriptionTooltipTwo);
        }
    }
}
