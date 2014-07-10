package com.blueyu2.millworks.block;

import com.blueyu2.millworks.reference.Reference;
import com.blueyu2.millworks.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Blueyu2 on 7/1/2014.
 */
public class BlockCommon extends Block {
    public BlockCommon(Material material) {
        super(material);
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
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }
    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
