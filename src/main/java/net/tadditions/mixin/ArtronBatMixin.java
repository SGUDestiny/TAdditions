package net.tadditions.mixin;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.tadditions.mod.enchantments.TAEnchants;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.helper.TextHelper;
import net.tardis.mod.items.ArtronCapacitorItem;
import net.tardis.mod.items.ArtronItemStackBatteryItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(ArtronItemStackBatteryItem.class)
public abstract class ArtronBatMixin extends Item {

    @Shadow @Final
    private static final String CHARGE = "artron";

    @Shadow @Final
    protected final IFormattableTextComponent descriptionTooltip = TextHelper.createDescriptionItemTooltip(new TranslationTextComponent("tooltip.artron_capacitor.info"));


    public ArtronBatMixin(Properties properties) {
        super(properties);
    }

    @Shadow
    public abstract float getChargeRate(float amount);

    @Shadow
    public abstract float getMaxCharge(ItemStack stack);

    @Shadow
    public abstract void writeCharge(ItemStack stack, float charge);

    @Shadow
    public abstract boolean isCreative();

    @Accessor
    public abstract float getChargeRateMultiplier();

    @Accessor
    public abstract float getDischargeRateMultiplier();

    /**
     * @author me
     * @reason yes
     */
    @Overwrite(remap = false)
    public float charge(ItemStack stack, float amount, boolean simulate) {
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
        amount = this.getChargeRate(amount)+r;
        float charge = stack.getOrCreateTag().getFloat(CHARGE);
        float maxCharge = this.getMaxCharge(stack)+s;
        //If adding more will go over the max charge, return however much is needed to reach max.
        if (charge + amount >= maxCharge) {
            float chargeToAdd = maxCharge - charge;
            if (!simulate)
                this.writeCharge(stack, charge + chargeToAdd); //We need to write to nbt everytime we want to save data
            return chargeToAdd;
        } else {
            if (!simulate)
                this.writeCharge(stack, charge + amount);
            return amount;
        }
    }

    @Shadow
    public abstract float getDischargeRate(float charge);


    /**
     * @author me
     * @reason no
     */
    @Overwrite(remap = false)
    public float discharge(ItemStack stack, float amount, boolean simulate) {
        int enchantLevelR = EnchantmentHelper.getEnchantmentLevel(TAEnchants.SUBSPACE_LINK.get(), stack);

        float r = 0;

        if(enchantLevelR > 0){
            r = (float) (enchantLevelR);
        }
        float current = stack.getOrCreateTag().getFloat(CHARGE);
        float takenAmount = this.getDischargeRate(amount)+r;
        float updatedCharge = current - takenAmount;
        if (takenAmount <= current && updatedCharge > 0) {
            if (!simulate)
                writeCharge(stack, updatedCharge);
            return takenAmount;
        }
        if (!simulate)
            writeCharge(stack, 0);
        return current;
    }

    @Shadow
    public abstract float getCharge(ItemStack stack);



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
