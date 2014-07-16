package com.blueyu2.millworks.item.crafting;

import net.minecraft.item.ItemStack;

/**
 * Created by Blueyu2 on 7/15/2014.
 */
public class RecipeMillStone {
    private ItemStack recipeOutput;
    private ItemStack inputStack;

    public RecipeMillStone(ItemStack recipeOutput, ItemStack inputStack){
        this.recipeOutput = recipeOutput.copy();
        this.inputStack = inputStack.copy();
    }

    public ItemStack getRecipeInput(){
        return this.inputStack;
    }

    public ItemStack getRecipeOutput(){
        return this.recipeOutput;
    }


}
