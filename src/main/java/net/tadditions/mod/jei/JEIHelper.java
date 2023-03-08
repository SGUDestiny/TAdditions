package net.tadditions.mod.jei;

import com.google.common.collect.Lists;
import mezz.jei.api.gui.IRecipeLayout;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

import java.util.List;

public class JEIHelper {

	public static void addInputSlot(IRecipeLayout layout, int id, int x, int y, ItemStack[] stacks) {
		layout.getItemStacks().init(id, true, x, y);
		layout.getItemStacks().set(id, Lists.newArrayList(stacks));
	}
	
	public static Ingredient getValidIngredientFromList(int index, List<Ingredient> ingredients) {
	    return index < ingredients.size() ? ingredients.get(index) : Ingredient.EMPTY;
	}

}
