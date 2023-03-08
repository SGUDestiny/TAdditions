package net.tadditions.mod.recipe;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import net.tadditions.mod.tileentity.AdvQuantiscopeTile;

public class AdvWeldRecipeWrapper extends RecipeWrapper{

	public AdvWeldRecipeWrapper(AdvQuantiscopeTile inv) {
		super(inv);
	}
	
	@Override
	public int getSizeInventory() {
		return inv.getSlots();
	}

	@Override
	public boolean isEmpty() {
		for(int i = 0; i < inv.getSlots(); ++i) {
			if(!inv.getStackInSlot(i).isEmpty())
				return false;
		}
		return true;
	}
	
	@Override
	public ItemStack removeStackFromSlot(int index) {
		ItemStack stack = inv.getStackInSlot(index);
		inv.setStackInSlot(index, ItemStack.EMPTY);
		this.markDirty();
		return stack;
	}
	
	@Override
	public void clear() {
		for(int i = 0; i < inv.getSlots(); ++i) {
			inv.setStackInSlot(i, ItemStack.EMPTY);
		}
		this.markDirty();
	}
	
	@Override
	public ItemStack decrStackSize(int index, int count) {
		this.markDirty();
		return inv.getStackInSlot(index).split(count);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		inv.setStackInSlot(index, stack);
		this.markDirty();
	}

	@Override
	public boolean isUsableByPlayer(PlayerEntity player) {
		return true;
	}

}
