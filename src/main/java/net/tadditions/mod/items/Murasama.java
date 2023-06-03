package net.tadditions.mod.items;

import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.renderer.entity.model.BipedModel.ArmPose;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.BooleanProperty;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.animation.Animation;
import net.minecraftforge.client.model.animation.AnimationItemOverrideList;
import net.tadditions.mod.QolMod;

import javax.annotation.Nullable;
import java.util.List;

public class Murasama extends SwordItem {

    public Murasama(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

        if (Screen.hasShiftDown()) {
            tooltip.add(new TranslationTextComponent("tooltip.tadditions.murasama_shift"));
        } else {
            tooltip.add(new TranslationTextComponent("tooltip.tadditions.murasama"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker) {
        return true;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment == Enchantments.SHARPNESS || enchantment == Enchantments.SWEEPING || super.canApplyAtEnchantingTable(stack, enchantment);
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
