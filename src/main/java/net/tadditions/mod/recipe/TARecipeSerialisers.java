package net.tadditions.mod.recipe;

import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tadditions.mod.QolMod;

public class TARecipeSerialisers {
	
		public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALISERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, QolMod.MOD_ID);
	
	public static final RegistryObject<IRecipeSerializer<?>> ADVQUANTISCOPE_SERIALISER = RECIPE_SERIALISERS.register("advquantiscope", AdvWeldRecipe.Serializer::new);
	public static final ResourceLocation ADVWELD_RECIPE_TYPE_LOC = new ResourceLocation(QolMod.MOD_ID, "advquantiscope");
	public static final IRecipeType<AdvWeldRecipe> ADVWELD_RECIPE_TYPE = IRecipeType.register(ADVWELD_RECIPE_TYPE_LOC.toString());

}
