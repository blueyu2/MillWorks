package com.blueyu2.millworks.block;

import com.blueyu2.millworks.creativetab.CreativeTab;
import com.blueyu2.millworks.reference.Reference;
import com.blueyu2.millworks.tileentity.TileEntityCommonMW;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Blueyu2 on 7/1/2014.
 */
public class BlockCommonMW extends Block {
    public int texturesNeeded;
    public IIcon[] iconArray;

    public BlockCommonMW(Material material){
        super(material);
        this.setCreativeTab(CreativeTab.MillWorksTab);
    }

    public BlockCommonMW(){
        this(Material.rock);
    }

    @Override
    public String getUnlocalizedName(){
        return String.format("tile.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
        if(texturesNeeded == 0){
            blockIcon = iconRegister.registerIcon(getUnwrappedUnlocalizedName(this.getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
            return;
        }
        iconArray=new IIcon[texturesNeeded];
        for(int i=0;i<texturesNeeded;i++){
            iconArray[i] = iconRegister.registerIcon(String.format("%s_%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName()),i));
        }
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName){
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    public void getTextures(int number){
        texturesNeeded = number;
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta){
        dropInventory(world, x, y, z);
        super.breakBlock(world, x, y, z, block, meta);
    }

    //Gets custom name for block
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack){
        if (world.getTileEntity(x, y, z) instanceof TileEntityCommonMW){
            if(itemStack.hasDisplayName()){
                ((TileEntityCommonMW) world.getTileEntity(x, y, z)).setCustomName(itemStack.getDisplayName());
            }
        }
    }

    public void dropInventory(World world, int x, int y, int z){
        TileEntity tileEntity = world.getTileEntity(x, y, z);

        if (!(tileEntity instanceof IInventory)){
            return;
        }

        IInventory inventory = (IInventory) tileEntity;

        for (int i=0; i<inventory.getSizeInventory(); i++){
            ItemStack itemStack = inventory.getStackInSlot(i);

            if (itemStack != null && itemStack.stackSize > 0){
                Random random = new Random();

                float dX = random.nextFloat() * 0.8F + 0.1F;
                float dY = random.nextFloat() * 0.8F + 0.1F;
                float dZ = random.nextFloat() * 0.8F + 0.1F;

                EntityItem entityItem = new EntityItem(world, x + dX, y + dY, z + dZ, itemStack.copy());

                if (itemStack.hasTagCompound()){
                    entityItem.getEntityItem().setTagCompound((NBTTagCompound) itemStack.getTagCompound().copy());
                }

                float factor = 0.05F;
                entityItem.motionX = random.nextGaussian() * factor;
                entityItem.motionY = random.nextGaussian() * factor + 0.2F;
                entityItem.motionZ = random.nextGaussian() * factor;
                world.spawnEntityInWorld(entityItem);
                itemStack.stackSize = 0;
            }
        }
    }
}
