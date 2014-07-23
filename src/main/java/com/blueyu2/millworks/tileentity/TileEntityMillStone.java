package com.blueyu2.millworks.tileentity;

import com.blueyu2.millworks.block.BlockMillStone;
import com.blueyu2.millworks.item.crafting.RecipeMillStone;
import com.blueyu2.millworks.recipe.RecipesMillStone;
import com.blueyu2.millworks.reference.Names;
import com.blueyu2.millworks.utility.IMechanicalMW;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Blueyu2 on 7/12/2014.
 */
public class TileEntityMillStone extends TileEntityCommonMW implements ISidedInventory, IMechanicalMW {
    public static final int INVENTORY_SIZE = 2;
    public static final int INPUT_INDEX = 0;
    public static final int OUTPUT_INDEX = 1;

    public int processTime;
    //Used if millstone is processing something
    public boolean STATE = false;
    //Used to cool down sound playing to prevent spam
    public int cool;
    //Used to check if machine is powered or not
    public boolean powered;

    private ItemStack[] inventory;
    public TileEntityMillStone(){
        inventory = new ItemStack[INVENTORY_SIZE];
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound){
        super.readFromNBT(nbtTagCompound);

        NBTTagList tagList = nbtTagCompound.getTagList("Items", 10);
        inventory = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < tagList.tagCount(); i++)
        {
            NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
            byte slotIndex = tagCompound.getByte("Slot");
            if (slotIndex >= 0 && slotIndex < inventory.length)
            {
                inventory[slotIndex] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }
        processTime = nbtTagCompound.getInteger("processTime");
    }

    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slotIndex) {
        return inventory[slotIndex];
    }

    @Override
    public ItemStack decrStackSize(int slotIndex, int decrementAmount) {
        ItemStack itemStack = getStackInSlot(slotIndex);
        if (itemStack != null)
        {
            if (itemStack.stackSize <= decrementAmount)
            {
                setInventorySlotContents(slotIndex,null);
            }
            else
            {
                itemStack = itemStack.splitStack(decrementAmount);
                if (itemStack.stackSize == 0)
                {
                    setInventorySlotContents(slotIndex,null);
                }
            }
        }
        return itemStack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slotIndex) {
        ItemStack itemStack = getStackInSlot(slotIndex);
        if (itemStack != null)
        {
            setInventorySlotContents(slotIndex,null);
        }
        return itemStack;
    }

    @Override
    public void setInventorySlotContents(int slotIndex, ItemStack itemStack) {
        inventory[slotIndex] = itemStack;
        if (itemStack != null && itemStack.stackSize > getInventoryStackLimit())
        {
            itemStack.stackSize = getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName() {
        return this.hasCustomName() ? this.getCustomName() : Names.Containers.MILLSTONE;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return this.hasCustomName();
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return true;
    }

    @Override
    public void openInventory() {
        // lolno
    }

    @Override
    public void closeInventory() {
        // lolno
    }
    //TODO
    @Override
    public boolean isItemValidForSlot(int slotIndex, ItemStack itemStack) {
        return true;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeToNBT(nbtTagCompound);

        NBTTagList tagList = new NBTTagList();
        for (int currentIndex = 0; currentIndex < inventory.length; currentIndex++)
        {
            if (inventory[currentIndex] != null)
            {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) currentIndex);
                inventory[currentIndex].writeToNBT(tagCompound);
                tagList.appendTag(tagCompound);
            }
        }
        nbtTagCompound.setTag("Items", tagList);
        nbtTagCompound.setInteger("processTime", processTime);
    }

    @Override
    public void updateEntity()
    {
        boolean sendUpdate = false;
        if (!this.worldObj.isRemote)
        {
            if(this.powered){
                if (this.canProcess()){
                    this.processTime++;
                    if(this.processTime == 200){
                        this.processTime = 0;
                        this.processItem();
                        sendUpdate = true;
                    }
                }
                else{
                    this.processTime = 0;
                }
                this.STATE = true;
            }
            else{
                this.STATE = false;
                this.processTime = 0;
            }
        }

        if (sendUpdate){
            markDirty();
        }

        if (STATE){
            Block block = worldObj.getBlock(xCoord, yCoord, zCoord);
            if(block instanceof BlockMillStone) {
                if(cool==0) {
                    ((BlockMillStone) block).playOperation(worldObj, xCoord, yCoord, zCoord);
                }
            }
            cool++;
            if(cool > 30){
                cool = 0;
            }
        }
        else{cool=0;}
        this.powered = false;
    }

    private boolean canProcess()
    {
        if (inventory[INPUT_INDEX] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemStack = RecipesMillStone.getInstance().getResult(inventory[INPUT_INDEX]);
            if (itemStack == null){
                return  false;
            }

            if (inventory[OUTPUT_INDEX] == null){
                return  true;
            }
            else{
                boolean outputEquals = this.inventory[OUTPUT_INDEX].isItemEqual(itemStack);
                int mergedOutputStackSize = this.inventory[OUTPUT_INDEX].stackSize + itemStack.stackSize;

                if(outputEquals){
                    return mergedOutputStackSize <= getInventoryStackLimit() && mergedOutputStackSize <= itemStack.getMaxStackSize();
                }
            }
        }
        return false;
    }

    public void processItem(){
        if(this.canProcess()){
            RecipeMillStone recipe = RecipesMillStone.getInstance().getRecipe(inventory[INPUT_INDEX]);

            if (this.inventory[OUTPUT_INDEX] == null){
                this.inventory[OUTPUT_INDEX] = recipe.getRecipeOutput().copy();
            }
            else if (this.inventory[OUTPUT_INDEX].isItemEqual(recipe.getRecipeOutput())){
                inventory[OUTPUT_INDEX].stackSize += recipe.getRecipeOutput().stackSize;
            }
            decrStackSize(INPUT_INDEX, recipe.getRecipeInput().stackSize);
        }
    }

    @SideOnly(Side.CLIENT)
    public int getProcessScaled(int scale){
        return this.processTime * scale / 200;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        return side == ForgeDirection.DOWN.ordinal() ? new int[]{OUTPUT_INDEX} : new int[]{INPUT_INDEX};
    }

    @Override
    public boolean canInsertItem(int slotIndex, ItemStack itemStack, int side) {
        return isItemValidForSlot(slotIndex, itemStack);
    }

    @Override
    public boolean canExtractItem(int slotIndex, ItemStack itemStack, int side) {
        return slotIndex == OUTPUT_INDEX;
    }

    @Override
    public boolean mechanicalReceive(ForgeDirection from, int energy, boolean reverse) {
        if(from == ForgeDirection.UP){
            if(energy >= 15){
                powered = true;
            }
            return true;
        }
    return false;
    }
}
