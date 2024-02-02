package net.tadditions.mixin;



import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.tadditions.mod.enchantments.TAEnchants;
import net.tardis.mod.containers.slot.EngineSlot;
import org.spongepowered.asm.mixin.Mixin;


import java.util.function.Predicate;

@Mixin(EngineSlot.class)

public class EngineSlotMixin extends SlotItemHandler {

    Direction panel;
    Predicate<ItemStack> filter;

    public EngineSlotMixin(Direction panel, IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        this(stack -> true, panel, itemHandler, index, xPosition, yPosition);
    }
    public EngineSlotMixin(Predicate<ItemStack> filter, Direction panel, IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
        this.panel = panel;
        this.filter = filter;
    }

    @Override
    public boolean canTakeStack(PlayerEntity player){
        if(getStack().isEnchanted() && (EnchantmentHelper.getEnchantmentLevel(TAEnchants.CURSE_OF_WINDS.get(), this.getStack())>0) && (this.getStack().getDamage() < this.getStack().getMaxDamage() * 0.75)){
            return false;
        }
        return true;
    }

}
