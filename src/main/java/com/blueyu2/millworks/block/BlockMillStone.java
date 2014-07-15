package com.blueyu2.millworks.block;

import com.blueyu2.millworks.MillWorks;
import com.blueyu2.millworks.reference.GuiIds;
import com.blueyu2.millworks.reference.Names;
import com.blueyu2.millworks.tileentity.TileEntityCommon;
import com.blueyu2.millworks.tileentity.TileEntityMillStone;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Created by Blueyu2 on 7/1/2014.
 */
public class BlockMillStone extends BlockCommon implements ITileEntityProvider {

    public BlockMillStone() {
        super();
        this.setBlockName(Names.Blocks.MILLSTONE);
        this.setHardness(1.5F);
        this.setStepSound(soundTypeStone);
        this.getTextures(3);
    }
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta){
        if (side == 0){return iconArray[2];}
        else if (side == 1){return iconArray[0];}
        else{return iconArray[1];}
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata){
        return new TileEntityMillStone();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if (player.isSneaking())
        {
            return true;
        }
        else
        {
            if (!world.isRemote && world.getTileEntity(x, y, z) instanceof TileEntityMillStone)
            {
                player.openGui(MillWorks.instance, GuiIds.MILLSTONE, world, x, y, z);
            }
        }
        return true;
    }

    //Gets custom name for block
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack)
    {
        if(itemStack.hasDisplayName())
        {
            ((TileEntityCommon) world.getTileEntity(x, y, z)).setCustomName(itemStack.getDisplayName());
        }
    }
}
