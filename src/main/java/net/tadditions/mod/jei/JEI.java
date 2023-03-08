package net.tadditions.mod.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.blocks.ModBlocks;
import net.tadditions.mod.recipe.AdvWeldRecipe;
import net.tadditions.mod.screens.AdvQuantiscopeWeldScreen;

import java.util.Objects;

@JeiPlugin
public class JEI implements IModPlugin{

	public static final ResourceLocation NAME = new ResourceLocation(QolMod.MOD_ID, "jei");

	@Override
	public ResourceLocation getPluginUid() {
		return NAME;
	}
	
	@Override
	public void registerGuiHandlers(IGuiHandlerRegistration registry) {
		registry.addRecipeClickArea(AdvQuantiscopeWeldScreen.class, 81, 8, 16, 24, AdvWeldRecipeCategory.NAME);
	}
	
	@Override
	public void registerCategories(IRecipeCategoryRegistration reg) {
		reg.addRecipeCategories(new AdvWeldRecipeCategory(reg.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(ModBlocks.advanced_quantiscope_iron.get()), AdvWeldRecipeCategory.NAME);
    }

	@Override
	public void registerRecipes(IRecipeRegistration reg) {
		ClientWorld world = Objects.requireNonNull(Minecraft.getInstance().world);
		
		
		//Weld
		reg.addRecipes(AdvWeldRecipe.getAllRecipes(world), AdvWeldRecipeCategory.NAME);

	}

}
