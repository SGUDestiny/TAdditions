package net.tadditions.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.tadditions.mod.enchantments.TAEnchants;
import net.tardis.mod.containers.slot.EngineSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(EngineSlot.class)
public class EngineSlotMixin {

    @Unique
    public boolean tAdditions$canTakeStack(PlayerEntity player){
        return !((EngineSlot) (Object) this).getStack().isEnchanted() || (EnchantmentHelper.getEnchantmentLevel(TAEnchants.CURSE_OF_WINDS.get(), ((EngineSlot) (Object) this).getStack()) <= 0) || (((EngineSlot) (Object) this).getStack().getDamage() >= ((EngineSlot) (Object) this).getStack().getMaxDamage() * 0.75);
    }

}
