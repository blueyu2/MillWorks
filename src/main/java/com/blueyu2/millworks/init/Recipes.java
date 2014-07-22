package com.blueyu2.millworks.init;

import com.blueyu2.millworks.recipe.RecipesMillStone;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by Blueyu2 on 7/10/2014.
 */
public class Recipes {
    public static void init(){
        //Vanilla Recipes
        GameRegistry.addRecipe(new ItemStack(ModItems.textile),"www",'w',new ItemStack(Blocks.wool,1,OreDictionary.WILDCARD_VALUE));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.millStoneBlock),"sss","sss","www",'s',new ItemStack(Blocks.stone_slab),'w',new ItemStack(Blocks.wooden_slab,1,OreDictionary.WILDCARD_VALUE));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pillarStoneBlock,2),"s","s",'s',new ItemStack(Blocks.stone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pillarSandBlock,2),"s","s",'s',new ItemStack(Blocks.sandstone,1,2));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.shaftBlock, 4),"iwi", 'i', new ItemStack(Items.iron_ingot), 'w', new ItemStack(Blocks.planks, 1, OreDictionary.WILDCARD_VALUE));

        //Millstone Recipes
        RecipesMillStone.getInstance().addRecipe(new ItemStack(Items.sugar, 2, 0), new ItemStack(Items.reeds));
        RecipesMillStone.getInstance().addRecipe(new ItemStack(Items.string, 4, 0), new ItemStack(Blocks.wool, 1, OreDictionary.WILDCARD_VALUE));
        RecipesMillStone.getInstance().addRecipe(new ItemStack(Blocks.cobblestone), new ItemStack(Blocks.stone));
        RecipesMillStone.getInstance().addRecipe(new ItemStack(Blocks.gravel), new ItemStack(Blocks.cobblestone));
        RecipesMillStone.getInstance().addRecipe(new ItemStack(Blocks.sand), new ItemStack(Blocks.gravel));
        RecipesMillStone.getInstance().addRecipe(new ItemStack(Items.blaze_powder, 3, 0), new ItemStack(Items.blaze_rod));
        RecipesMillStone.getInstance().addRecipe(new ItemStack(Items.dye, 4, 15), new ItemStack(Items.bone));
        RecipesMillStone.getInstance().addRecipe(new ItemStack(Items.dye, 1, 15), new ItemStack(Items.fish));
    }
}
