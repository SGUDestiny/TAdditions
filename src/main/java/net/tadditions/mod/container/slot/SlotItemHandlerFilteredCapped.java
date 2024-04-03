package net.tadditions.mod.container.slot;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;
import java.util.function.Predicate;

public class SlotItemHandlerFilteredCapped extends SlotItemHandler{

	private Predicate<ItemStack> filter;
	private int cap;

	public SlotItemHandlerFilteredCapped(IItemHandler itemHandler, int index, int xPosition, int yPosition, Predicate<ItemStack> filter, int cap) {
		super(itemHandler, index, xPosition, yPosition);
		this.filter = filter;
		this.cap = cap;
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return this.filter.test(stack);
	}


	@Override
	public int getSlotStackLimit() {
		return cap;
	}

	@Override
	public int getItemStackLimit(@Nonnull ItemStack stack) {
		return cap;
	}
}
