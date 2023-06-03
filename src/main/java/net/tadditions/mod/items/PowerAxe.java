package net.tadditions.mod.items;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class PowerAxe extends SwordItem {

    public PowerAxe(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

        if(!Screen.hasShiftDown()) {
            tooltip.add(new TranslationTextComponent("tooltip.tadditions.poweraxe_shift"));
        } else {
            tooltip.add(new TranslationTextComponent("tooltip.tadditions.poweraxe.line1"));
            tooltip.add(new TranslationTextComponent("tooltip.tadditions.poweraxe.line2"));
            tooltip.add(new TranslationTextComponent("tooltip.tadditions.poweraxe.line3"));
            tooltip.add(new TranslationTextComponent("tooltip.tadditions.poweraxe.line4"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, net.minecraft.enchantment.Enchantment enchantment)
    {
        return true;
    }

    @Override
    public boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker)
    {
        return true;
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target.isActiveItemStackBlocking()) {
            float damage = this.getAttackDamage() - 1.0f; // Adjust the sword's attack damage as needed

            if (attacker.swingingHand == Hand.OFF_HAND) {
                damage /= 2.0f; // Shields are more effective against off-hand attacks
            }

            if (target instanceof PlayerEntity && !attacker.isSpectator()) {
                PlayerEntity player = (PlayerEntity) attacker;

                if (player.getCooledAttackStrength(0.5F) >= 0.9F) {
                    player.resetCooldown();
                    ((PlayerEntity) target).disableShield(false); // This disables the shield
                }
            }

            return target.attackEntityFrom(DamageSource.causePlayerDamage((PlayerEntity) attacker), damage);
        } else
            return super.hitEntity(stack, target, attacker);
    }

}
