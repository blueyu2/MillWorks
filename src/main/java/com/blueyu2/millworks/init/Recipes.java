package com.blueyu2.millworks.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by Blueyu2 on 7/10/2014.
 */
public class Recipes {
    public static void init(){
        GameRegistry.addRecipe(new ItemStack(ModItems.textile),"www",'w',new ItemStack(Blocks.wool,1,OreDictionary.WILDCARD_VALUE));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.millStoneBlock),"sss","sss","www",'s',new ItemStack(Blocks.stone_slab),'w',new ItemStack(Blocks.wooden_slab,1,OreDictionary.WILDCARD_VALUE));

    }
}
