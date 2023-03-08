package net.tadditions.mod.jei;

import com.mojang.blaze3d.matrix.MatrixStack;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.blocks.ModBlocks;
import net.tadditions.mod.recipe.AdvWeldRecipe;
import net.tadditions.mod.screens.MConstants;

import java.util.List;

public class AdvWeldRecipeCategory implements IRecipeCategory<AdvWeldRecipe> {

	public static final ResourceLocation NAME = new ResourceLocation(QolMod.MOD_ID, "advquantiscope_weld");
	public static final ResourceLocation TEXTURE = new ResourceLocation(QolMod.MOD_ID, "textures/gui/advweld_iron.png");
	
	private IDrawable background;
	private IDrawable icon;
	private IDrawable arrow;
	
	public AdvWeldRecipeCategory(IGuiHelper gui) {
		background = gui.createDrawable(TEXTURE, 0, 0, 176, 110);
		icon = gui.createDrawableIngredient(new ItemStack(ModBlocks.advanced_quantiscope_iron.get()));
		arrow = gui.drawableBuilder(TEXTURE, 178, 3, 16, 21)
				.buildAnimated(400, IDrawableAnimated.StartDirection.TOP, false);
	}

	@Override
	public ResourceLocation getUid() {
		return NAME;
	}

	@Override
	public Class<AdvWeldRecipe> getRecipeClass() {
		return AdvWeldRecipe.class;
	}

	@Override
	public String getTitle() {
		return MConstants.Translations.ADVQUANTISCOPE_JEI_TITLE.getString();
	}

	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public void setIngredients(AdvWeldRecipe recipe, IIngredients ingredients) {
		
		ingredients.setInputIngredients(recipe.getIngredients());
		ingredients.setOutput(VanillaTypes.ITEM, new ItemStack(recipe.getResult().get().getOutput()));
	}

	@Override
	public void draw(AdvWeldRecipe recipe, MatrixStack matrixStack, double mouseX, double mouseY) {
		IRecipeCategory.super.draw(recipe, matrixStack, mouseX, mouseY);
		arrow.draw(matrixStack, 80, 28);
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, AdvWeldRecipe recipe, IIngredients ingredients) {


		List<Ingredient> ingredientList = recipe.getRequiredIngredients();

		
		JEIHelper.addInputSlot(recipeLayout, 0, 7, 28, JEIHelper.getValidIngredientFromList(0, ingredientList).getMatchingStacks());
		JEIHelper.addInputSlot(recipeLayout, 1, 21, 8, JEIHelper.getValidIngredientFromList(1, ingredientList).getMatchingStacks());
		JEIHelper.addInputSlot(recipeLayout, 2, 41, 8, JEIHelper.getValidIngredientFromList(2, ingredientList).getMatchingStacks());
		JEIHelper.addInputSlot(recipeLayout, 3, 20, 48, JEIHelper.getValidIngredientFromList(3, ingredientList).getMatchingStacks());
		JEIHelper.addInputSlot(recipeLayout, 4, 41, 48, JEIHelper.getValidIngredientFromList(4, ingredientList).getMatchingStacks());
		JEIHelper.addInputSlot(recipeLayout, 5, 55, 28, JEIHelper.getValidIngredientFromList(5, ingredientList).getMatchingStacks());
		JEIHelper.addInputSlot(recipeLayout, 6, 150, 28, JEIHelper.getValidIngredientFromList(6, ingredientList).getMatchingStacks());
		JEIHelper.addInputSlot(recipeLayout, 7, 136, 8, JEIHelper.getValidIngredientFromList(7, ingredientList).getMatchingStacks());
		JEIHelper.addInputSlot(recipeLayout, 8, 115, 8, JEIHelper.getValidIngredientFromList(8, ingredientList).getMatchingStacks());
		JEIHelper.addInputSlot(recipeLayout, 9, 136, 48, JEIHelper.getValidIngredientFromList(9, ingredientList).getMatchingStacks());
		JEIHelper.addInputSlot(recipeLayout, 10, 115, 48, JEIHelper.getValidIngredientFromList(10, ingredientList).getMatchingStacks());
		JEIHelper.addInputSlot(recipeLayout, 11, 102, 28, JEIHelper.getValidIngredientFromList(11, ingredientList).getMatchingStacks());



		recipeLayout.getItemStacks().init(12, false, 79, 74);
		recipeLayout.getItemStacks().set(12, new ItemStack(recipe.getResult().get().getOutput()));
	}
}
