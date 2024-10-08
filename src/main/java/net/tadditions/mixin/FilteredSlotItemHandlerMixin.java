package net.tadditions.mixin;

import net.minecraft.world.item.ItemStack;
import net.tadditions.mod.init.ItemInit;
import net.tardis.mod.menu.slots.FilteredSlotItemHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FilteredSlotItemHandler.class)
public class FilteredSlotItemHandlerMixin
{
    @Inject(at = @At("HEAD"), method = "mayPlace(Lnet/minecraft/world/item/ItemStack;)Z", remap = false, cancellable = true)
    public void placeItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir)
    {
        placeItemCall(stack, cir);
    }

    public void placeItemCall(ItemStack stack, CallbackInfoReturnable<Boolean> cir)
    {
        FilteredSlotItemHandler handler = ((FilteredSlotItemHandler) (Object) this);
        int quantumCount = 0;
        int vortexCount = 0;
        for (int i = 0; i < handler.getItemHandler().getSlots(); i++)
        {
            ItemStack stackCap = handler.getItemHandler().getStackInSlot(i);
            if(stackCap.getItem() == ItemInit.ARTRON_CAPACITOR_QUANTUM.get())
                quantumCount++;
            if(stackCap.getItem() == ItemInit.ARTRON_CAPACITOR_VORTEX.get())
                vortexCount++;
        }
        if(quantumCount > 0 && stack.getItem() == ItemInit.ARTRON_CAPACITOR_VORTEX.get())
            cir.setReturnValue(false);
        if(vortexCount > 0 && stack.getItem() == ItemInit.ARTRON_CAPACITOR_QUANTUM.get())
            cir.setReturnValue(false);
    }
}
