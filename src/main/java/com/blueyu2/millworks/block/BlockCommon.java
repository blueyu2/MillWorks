package com.blueyu2.millworks.block;

import com.blueyu2.millworks.creativetab.CreativeTab;
import com.blueyu2.millworks.reference.Reference;
import com.blueyu2.millworks.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

/**
 * Created by Blueyu2 on 7/1/2014.
 */
public class BlockCommon extends Block {
    public int texturesNeeded;
    public IIcon[] iconArray;
    public BlockCommon(Material material) {
        super(material);
        this.setCreativeTab(CreativeTab.MillWorksTab);
    }
    public BlockCommon(){
        this(Material.rock);
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
        if(texturesNeeded == 0){
            blockIcon = iconRegister.registerIcon(getUnwrappedUnlocalizedName(this.getUnlocalizedName()));
            return;
        }
        iconArray=new IIcon[texturesNeeded];
        for(int i=0;i<texturesNeeded;i++){
            iconArray[i] = iconRegister.registerIcon(String.format("%s_%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName()),i));
        }
    }
    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
    public void getTextures(int number){
        texturesNeeded = number;
    }
}
