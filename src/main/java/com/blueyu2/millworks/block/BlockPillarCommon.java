package com.blueyu2.millworks.block;

import com.blueyu2.millworks.creativetab.CreativeTab;
import com.blueyu2.millworks.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

/**
 * Created by Blueyu2 on 7/12/2014.
 */
public class BlockPillarCommon extends BlockRotatedPillar {
    //public int texturesNeeded;
    public IIcon[] iconArray = new IIcon[2];
    public BlockPillarCommon(Material material) {
        super(material);
        this.setCreativeTab(CreativeTab.MillWorksTab);

    }
    public BlockPillarCommon(){
        this(Material.rock);
    }
    public int damageDropped(int meta)
    {
        return 0;
    }
    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        iconArray[0] = iconRegister.registerIcon(String.format("%s_%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName()),0));
        iconArray[1] = iconRegister.registerIcon(String.format("%s_%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName()),1));

        /*if(texturesNeeded == 0){
            blockIcon = iconRegister.registerIcon(getUnwrappedUnlocalizedName(this.getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
            return;
        }
        iconArray=new IIcon[texturesNeeded];
        for(int i=0;i<texturesNeeded;i++){
            iconArray[i] = iconRegister.registerIcon(String.format("%s_%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName()),i));
        }*/
    }
    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
    /*public void getTextures(int number){
        texturesNeeded = number;
    }*/
    @Override
    protected IIcon getSideIcon(int meta) {
        return iconArray[1];
    }
    @Override
    protected IIcon getTopIcon(int meta)
    {
        return iconArray[0];
    }
}
