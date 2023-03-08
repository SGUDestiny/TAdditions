package net.tadditions.mod.recipe;

import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTDynamicOps;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;
import net.tadditions.mod.QolMod;
import net.tardis.mod.Tardis;
import net.tardis.mod.misc.CodecJsonDataListener;
import net.tardis.mod.misc.IngredientCodec;
import net.tadditions.mod.tileentity.AdvQuantiscopeTile;

import java.util.*;
import java.util.Map.Entry;
 public class AdvWeldRecipe implements IRecipe<AdvWeldRecipeWrapper>{
    
    private Optional<RecipeResult> output;
    private Optional<Integer> processingTicks;
    private List<Ingredient> ingredients;
    private ResourceLocation id;
    
    private static final Codec<AdvWeldRecipe> CODEC = RecordCodecBuilder.create(instance ->
    instance.group(
            Codec.INT.optionalFieldOf("processing_ticks").forGetter(AdvWeldRecipe::getProcessingTicks),
            IngredientCodec.INGREDIENT_CODEC.listOf().fieldOf("ingredients").forGetter(AdvWeldRecipe::getRequiredIngredients),
            RecipeResult.CODEC.optionalFieldOf("result").forGetter(AdvWeldRecipe::getResult)
            ).apply(instance, AdvWeldRecipe::new)
    );
    
    
    /** Deprecated in favour of using vanilla IRecipe. This is left here as legacy code in case we encouter issues with the vanilla method 
     * <p>Registry for all recipes. 
     * <br> To access the values, call {@link CodecJsonDataListener#getData}*/
    @Deprecated
    public static final CodecJsonDataListener<AdvWeldRecipe> DATA_LOADER = new CodecJsonDataListener<AdvWeldRecipe>(
            "advquantiscope",
            CODEC,
            QolMod.LOGGER);

    public static Collection<AdvWeldRecipe> getAllRecipes(World world){
        return world.getRecipeManager().getRecipesForType(TARecipeSerialisers.ADVWELD_RECIPE_TYPE);
    }
    
    /**
     * Custom Recipe format for the {@linkplain net.tadditions.mod.tileentity.AdvQuantiscopeTile}
     * <br> Allows for new items to be created from a list of ingredients, or "repair" a damaged input item to form a full durability version of the input
     * @param ingredients - Items required for this recipe
     * @param result - the optional result. This is optional because in repair recipes, there is technially no new "result". The output is just the input item but at full durability
     * @impleNote Each recipe must be unique
     */
    public AdvWeldRecipe(List<Ingredient> ingredients, Optional<RecipeResult> result) {
        this.ingredients = ingredients;
        this.output = result;
        this.processingTicks = Optional.of(400);
    }
    
    public AdvWeldRecipe(Optional<Integer> processingTicks, List<Ingredient> ingredients, Optional<RecipeResult> result) {
        this(ingredients, result);
        this.processingTicks = processingTicks;
    }
    
    /** Our codec, a sort of wrapper object that allows MC to have a "template" so it can efficiently serialise/deserialise other file types into this WeldRecipe object type*/
    public static Codec<AdvWeldRecipe> getCodec(){
        return CODEC;
    }

    /** Wrapper Object for the "result":{"item":"modid:item"} structure in the recipe json.
     * <br> This is required because since we use Codecs to de/serialise recipes, we can't have nested codecs, hence this is needed*/
    public static class RecipeResult{
        
        public static final Codec<RecipeResult> CODEC = RecordCodecBuilder.create(instance -> 
            instance.group(
                Registry.ITEM.fieldOf("item").forGetter(RecipeResult::getOutput)
            ).apply(instance, RecipeResult::new)
        );
        
        private Item output;
        
        public RecipeResult(Item output) {
            this.output = output;
        }
        
        public Item getOutput() {
            return this.output;
        }
        
        public void setOutput(Item input) {
            this.output = input;
        }
        
    }
    
    /** Gets the output of the recipe. 
     * <br> This is optional because when the input item is being "repaired", there is technically no "result" item because the result is actually the input item but with full durability
     * <br> Hence we don't really need a "result".
     * <br> For purposes of satisfying serialisation/deserialisation this is made an optional field*/
    public Optional<RecipeResult> getResult() {
        if (output.isPresent()) {
            return this.output;
        }
        else {
            return this.output;
        }
    }

    public Optional<Integer> getProcessingTicks(){
    	return this.processingTicks;
    }
    
    /** Get the raw required input ingredients for the recipe
     * <br> For display purposes/JEI use {@link #getIngredients()}*/
    public List<Ingredient> getRequiredIngredients() {
        return this.ingredients;
    }

    /** Tests if the recipe matches that of the one in the Quantiscope*/
    @Override
    public boolean matches(AdvWeldRecipeWrapper inv, World worldIn) {
        /** Items to check this recipe against */
        List<Item> inputItems = new ArrayList<>();
        List<ItemStack> inputStacks = new ArrayList<>();
        HashSet<Item> uniqueItems = new HashSet<>();
        Map<ResourceLocation, Integer> stackCounts = new HashMap<>();
        for (int i = 0; i < 12; i ++) {
        	ItemStack stack = inv.getStackInSlot(i);
        	if (!stack.isEmpty()) {
        		inputItems.add(stack.getItem());
        		inputStacks.add(stack);
        	}
        }
        
        uniqueItems.addAll(inputItems);
        uniqueItems.forEach(entry -> {
            int count = Collections.frequency(inputItems, entry);
            stackCounts.put(entry.getRegistryName(), count);
        });




    	//If there isn't anything in the input slots, don't do anything
    	if (inputItems.isEmpty()) {
    		return false;
    	}
    	
    	int inputsInIngredients = 0;
    	int ingredientsInInputStacks = 0;
    	boolean ingredientMatchesInputSize = false;
    	boolean ingredientsContainInputStacks = false;
    	boolean inputsContainIngredients = false;
    	Map<ResourceLocation, Integer> validStackCounts = new HashMap<>();
    	Map<ResourceLocation, Integer> validIngredientCounts = new HashMap<>();
    	
    	//If we have some number of item stacks as ingredients
    	if (inputStacks.size() == this.ingredients.size()) {
    	    //Check if every ingredient matches each input itemstack
    		for (ItemStack stack : inputStacks) {
    	    	for (Ingredient ing : this.ingredients) {
        	        if (ing.test(stack)) {
        	        	ResourceLocation itemID = stack.getItem().getRegistryName();
        	        	int count = validStackCounts.getOrDefault(itemID, 0) + 1;
        	        	validStackCounts.put(itemID, count);
        	        	break;
        	        }
        	    }
        	}
    		
    		for (Ingredient ing : this.ingredients) {
        	    for (ItemStack stack : inputStacks) {
        			if (ing.test(stack)) {
        	        	ResourceLocation itemID = stack.getItem().getRegistryName();
        	        	int count = validIngredientCounts.getOrDefault(itemID, 0) + 1;
        	        	validIngredientCounts.put(itemID, count);
        				break;
        			}
        		}
        	}
    		
    	}
    	
    	//Make sure every ingredient item has the same count as that of the count of items that have been tested as being as valid ingredients
    	for (Entry<ResourceLocation, Integer> entry : validIngredientCounts.entrySet()) {
			if (stackCounts.get(entry.getKey()) == entry.getValue()) {
				ingredientsInInputStacks++;
			}
		}
    	
    	//Make sure every input item has the same count as that of the count of items that have been tested as being as valid ingredients
    	for (Entry<ResourceLocation, Integer> entry : validStackCounts.entrySet()) {
			if (stackCounts.get(entry.getKey()) == entry.getValue()) {
				inputsInIngredients++;
			}
		}
    	
    	if (ingredientsInInputStacks == inputsInIngredients) {
    		ingredientMatchesInputSize = true;
    	}
    	
    	if (inputsInIngredients == uniqueItems.size()) {
    		inputsContainIngredients = true;
    	}
    	
    	if (ingredientsInInputStacks == uniqueItems.size()) {
    		ingredientsContainInputStacks = true;
    	}
    	
    	boolean matching = ingredientMatchesInputSize && ingredientsContainInputStacks && inputsContainIngredients;
    	
        return matching;
    }

    /** The result of the recipe if this was being used in the Crafting Table
     * <br> Since this can only be used in a Quantiscope, this method is redundant and only here because it's part of the required methods of IRecipe*/
    @Override
    public ItemStack getCraftingResult(AdvWeldRecipeWrapper inv) {
        if (output.isPresent()) {
            return new ItemStack(this.output.get().getOutput());
        }
        else {
            return new ItemStack(this.output.get().getOutput());
        }
    }

    @Override
    public boolean canFit(int width, int height) {
        return false;
    }

    /** Vanilla's way of getting the recipe's result with Itemstack sensitive context
     * <br> We do not need to use this*/
    @Override
    public ItemStack getRecipeOutput() {
        return new ItemStack(this.output.get().getOutput());
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    /** Sets the id for this recipe. ALWAYS call this when making a new instance of this, as the registry name is null by default*/
    public AdvWeldRecipe setRegistryId(ResourceLocation id) {
        this.id = id;
        return this;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return TARecipeSerialisers.ADVQUANTISCOPE_SERIALISER.get();
    }

    @Override
    public IRecipeType<?> getType() {
        return TARecipeSerialisers.ADVWELD_RECIPE_TYPE;
    }
    
    @Override
    public boolean isDynamic() {
        return false; //If false, allows recipe unlocking to be available (though this doesn't actually work)
    }

    @Override
    public String getGroup() {
        return " "; //Must have a value, otherwise vanilla will complain about a null recipe category type
    }
    
    /** Gets the ingredients in the WeldRecipe. <br> Use this for JEI display purposes*/
    @Override
	public NonNullList<Ingredient> getIngredients() {
    	NonNullList<Ingredient> nonnulllist = NonNullList.create();
    	nonnulllist.addAll(this.ingredients);
		return nonnulllist;
	}


	/** The recipe serialiser implementation. 
     * <br> Making this allows vanilla to automatically add our recipe types onto its recipe packet entry and reload listener 
     * <p> A potential issue with this is if we have have many mods togethor that add loads of recipes, the packet could be too large
     * <br> Forge does have a workaround for this in the latest builds by splitting large vanilla packets
     * */
    public static class AdvWeldRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>>
    implements IRecipeSerializer<AdvWeldRecipe>{

        @Override
        public AdvWeldRecipe read(ResourceLocation recipeId, JsonObject json) {
            AdvWeldRecipe recipe = CODEC.parse(JsonOps.INSTANCE, json).resultOrPartial(QolMod.LOGGER::error).get();
            recipe.setRegistryId(recipeId); //We have to explicitly set the registry name to avoid a NPE
            return recipe;
        }

        @Override
        public AdvWeldRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
            AdvWeldRecipe recipe = CODEC.parse(NBTDynamicOps.INSTANCE, buffer.readCompoundTag()).resultOrPartial(QolMod.LOGGER::error).get();
            recipe.setRegistryId(recipeId); //We have to explicitly set the registry name to avoid a NPE
            return recipe;
        }

        @Override
        public void write(PacketBuffer buffer, AdvWeldRecipe recipe) {
            buffer.writeCompoundTag((CompoundNBT) CODEC.encodeStart(NBTDynamicOps.INSTANCE, recipe).resultOrPartial(QolMod.LOGGER::error).orElse(new CompoundNBT()));
        }
    }
    
    /**
     * DEPRECATED - Use {@link AdvWeldRecipe#matches(AdvWeldRecipeWrapper, World)}
     * @param repair - Item in the repair slot, or {@link ItemStack#EMPTY} if not a repair recipe
     * @param recipe - Items to check this recipe against
     * @return - If it matches this recipe
     */
    @Deprecated
    public boolean matches(ItemStack repair, ItemStack... recipe) {
        return true;
    }

    /** Unused, if used, can be done in a sync packet or in nbt.*/
    @Deprecated
    public CompoundNBT serialize() {
        CompoundNBT tag = new CompoundNBT();
        CODEC.encodeStart(NBTDynamicOps.INSTANCE, this).resultOrPartial(QolMod.LOGGER::error).ifPresent(data -> {
           tag.put("advweld_recipe", data);
        });
        return tag;
    }

    /** Unused, if used, can be done in a sync packet or in nbt.*/
    @Deprecated
    public static AdvWeldRecipe deserialize(CompoundNBT tag) {
        AdvWeldRecipe recipe = CODEC.parse(new Dynamic<>(NBTDynamicOps.INSTANCE)).resultOrPartial(QolMod.LOGGER::error).get();
        return recipe;
    }
}
