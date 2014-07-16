package com.blueyu2.millworks.recipe;

import com.blueyu2.millworks.item.crafting.RecipeMillStone;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Blueyu2 on 7/15/2014.
 */
public class RecipesMillStone {
    private static RecipesMillStone millStoneRegistry = null;

    private List<RecipeMillStone> millStoneRecipes;

    private RecipesMillStone(){
        millStoneRecipes = new ArrayList<RecipeMillStone>();
    }

    public static RecipesMillStone getInstance(){
        if (millStoneRegistry == null){
            millStoneRegistry = new RecipesMillStone();
        }
        return millStoneRegistry;
    }

    public void addRecipe(ItemStack recipeOutput, ItemStack recipeInputStack)
    {
        addRecipe(new RecipeMillStone(recipeOutput, recipeInputStack));
    }

    public void addRecipe(RecipeMillStone recipeMillStone){
        if (!millStoneRecipes.contains(recipeMillStone)){
            millStoneRecipes.add(recipeMillStone);
        }
    }

    public ItemStack getResult(ItemStack recipeInputStack){
        for (RecipeMillStone recipeMillStone : millStoneRecipes){
            if (recipeInputStack.getItem().getIdFromItem(recipeInputStack.getItem()) == recipeMillStone.getRecipeInput().getItem().getIdFromItem(recipeMillStone.getRecipeInput().getItem())){
                return recipeMillStone.getRecipeOutput();
            }
        }
        return null;
    }

    public RecipeMillStone getRecipe(ItemStack recipeInputStack){
        for (RecipeMillStone recipeMillStone : millStoneRecipes){
            if (recipeInputStack.getItem().getIdFromItem(recipeInputStack.getItem()) == recipeMillStone.getRecipeInput().getItem().getIdFromItem(recipeMillStone.getRecipeInput().getItem())){
                return recipeMillStone;
            }
        }
        return null;
    }

    public List<RecipeMillStone> getRecipes(){
        return millStoneRecipes;
    }
}
