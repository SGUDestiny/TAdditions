package net.tadditions.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.tadditions.mod.enchantments.TAEnchants;
import net.tardis.mod.items.ArtronItemStackBatteryItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ArtronItemStackBatteryItem.class)
public abstract class ArtronBatMixin extends Item {

    @Shadow(remap = false) @Final
    private static final String CHARGE = "artron";

    public ArtronBatMixin(Properties properties) {
        super(properties);
    }

    @Shadow(remap = false)
    public abstract float getChargeRate(float amount);

    @Shadow(remap = false)
    public abstract float getMaxCharge(ItemStack stack);

    @Shadow(remap = false)
    public abstract void writeCharge(ItemStack stack, float charge);

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

    @Shadow(remap = false)
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
}
