package com.blueyu2.millworks.init;

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
        GameRegistry.addRecipe(new ItemStack(ModItems.textile),"www",'w',new ItemStack(Blocks.wool,1,OreDictionary.WILDCARD_VALUE));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.millStoneBlock),"sss","sss","www",'s',new ItemStack(Blocks.stone_slab),'w',new ItemStack(Blocks.wooden_slab,1,OreDictionary.WILDCARD_VALUE));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pillarStoneBlock,2),"s","s",'s',new ItemStack(Blocks.stone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pillarSandBlock,2),"s","s",'s',new ItemStack(Blocks.sandstone,1,2));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.shaftBlock, 4),"iwi", 'i', new ItemStack(Items.iron_ingot), 'w', new ItemStack(Blocks.planks, 1, OreDictionary.WILDCARD_VALUE));
    }
}
