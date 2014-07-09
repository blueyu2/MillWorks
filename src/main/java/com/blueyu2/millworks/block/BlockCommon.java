package com.blueyu2.millworks.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by Blueyu2 on 7/1/2014.
 */
public class BlockCommon extends Block {
    public BlockCommon(Material material) {
        super(material);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName){
        return unlocalizedName.substring(unlocalizedName.indexOf(".")+1);
    }

    public void TESTY(){
        System.out.println("TESTY: " + getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
}
