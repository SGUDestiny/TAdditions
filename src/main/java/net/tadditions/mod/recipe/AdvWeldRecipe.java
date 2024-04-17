package net.tadditions.mod.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;
import net.tadditions.mod.blocks.ModBlocks;

import javax.annotation.Nullable;
import java.util.*;

public class AdvWeldRecipe implements IRecipe<AdvWeldRecipeWrapper>{

    private final ResourceLocation id;
    private final ItemStack output;
    private final Optional<Integer> processingTicks;
    private final NonNullList<Ingredient> recipeItems;

    public AdvWeldRecipe(ResourceLocation id, ItemStack output,
                                    NonNullList<Ingredient> recipeItems, Optional<Integer> length) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
        this.processingTicks = length;
    }

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
        if (inputStacks.size() == this.recipeItems.size()) {
            //Check if every ingredient matches each input itemstack
            for (ItemStack stack : inputStacks) {
                for (Ingredient ing : this.recipeItems) {
                    if (ing.test(stack)) {
                        ResourceLocation itemID = stack.getItem().getRegistryName();
                        int count = validStackCounts.getOrDefault(itemID, 0) + 1;
                        validStackCounts.put(itemID, count);
                        break;
                    }
                }
            }

            for (Ingredient ing : this.recipeItems) {
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
        for (Map.Entry<ResourceLocation, Integer> entry : validIngredientCounts.entrySet()) {
            if (stackCounts.get(entry.getKey()) == entry.getValue()) {
                ingredientsInInputStacks++;
            }
        }

        //Make sure every input item has the same count as that of the count of items that have been tested as being as valid ingredients
        for (Map.Entry<ResourceLocation, Integer> entry : validStackCounts.entrySet()) {
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


    public static Collection<AdvWeldRecipe> getAllRecipes(World world) {
        return world.getRecipeManager().getRecipesForType(TARecipeSerialisers.ADVWELD_RECIPE_TYPE);
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public ItemStack getCraftingResult(AdvWeldRecipeWrapper inv) {
        return output;
    }

    public int getProcessingTicks(){
        return processingTicks.orElse(400);
    }

    @Override
    public boolean canFit(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return output.copy();
    }

    public ItemStack getIcon() {
        return new ItemStack(ModBlocks.advanced_quantiscope_iron.get());
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return TARecipeSerialisers.ADVQUANTISCOPE_SERIALISER.get();
    }

    @Override
    public IRecipeType<?> getType() {
        return TARecipeSerialisers.ADVWELD_RECIPE_TYPE;
    }

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>>
            implements IRecipeSerializer<AdvWeldRecipe> {

        @Override
        public AdvWeldRecipe read(ResourceLocation recipeId, JsonObject json) {
            ItemStack output = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json, "result"));
            int processing_time = JSONUtils.getInt(json, "processing_time", 400);

            JsonArray ingredients = JSONUtils.getJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(11, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.deserialize(ingredients.get(i)));
            }

            return new AdvWeldRecipe(recipeId, output,
                    inputs, Optional.of(processing_time));
        }

        @Nullable
        @Override
        public AdvWeldRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(11, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.read(buffer));
            }
            int time = buffer.readInt();

            ItemStack output = buffer.readItemStack();
            return new AdvWeldRecipe(recipeId, output,
                    inputs, Optional.of(time));
        }

        @Override
        public void write(PacketBuffer buffer, AdvWeldRecipe recipe) {
            buffer.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buffer);
            }
            buffer.writeInt(recipe.getProcessingTicks());
            buffer.writeItemStack(recipe.getRecipeOutput(), false);
        }
    }
}
