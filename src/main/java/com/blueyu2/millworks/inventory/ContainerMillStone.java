package com.blueyu2.millworks.inventory;

import com.blueyu2.millworks.tileentity.TileEntityMillStone;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Blueyu2 on 7/14/2014.
 */
public class ContainerMillStone extends Container {
    private final int PLAYER_INVENTORY_ROWS = 3;
    private final int PLAYER_INVENTORY_COLUMNS = 9;

    public ContainerMillStone(InventoryPlayer inventoryPlayer, TileEntityMillStone tileEntityMillStone){
        this.addSlotToContainer(new Slot(tileEntityMillStone, TileEntityMillStone.INPUT_INDEX, 56, 35));

        //Adds the player's inventory slots to the container
        for (int inventoryRowIndex = 0; inventoryRowIndex < PLAYER_INVENTORY_ROWS; inventoryRowIndex++){
            for (int inventoryColumnIndex = 0; inventoryColumnIndex < PLAYER_INVENTORY_COLUMNS; inventoryColumnIndex++){
                this.addSlotToContainer(new Slot(inventoryPlayer, inventoryColumnIndex + inventoryRowIndex * 9 + 9, 8 + inventoryColumnIndex * 18, 84 + inventoryRowIndex * 18));
            }
        }

        //Adds the player's action bar slots to the container
        for (int actionBarSlotIndex = 0; actionBarSlotIndex < PLAYER_INVENTORY_COLUMNS; actionBarSlotIndex++){
            this.addSlotToContainer(new Slot(inventoryPlayer, actionBarSlotIndex, 8 + actionBarSlotIndex * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex){
        ItemStack itemStack = null;
        Slot slot = (Slot) inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack()){
            ItemStack slotItemStack = slot.getStack();
            itemStack = slotItemStack.copy();

            if (slotIndex < TileEntityMillStone.INVENTORY_SIZE){
                if (!this.mergeItemStack(slotItemStack, TileEntityMillStone.INVENTORY_SIZE, inventorySlots.size(), false)){
                    return null;
                }
            }
            else if (!this.mergeItemStack(slotItemStack, TileEntityMillStone.INPUT_INDEX, TileEntityMillStone.OUTPUT_INDEX, false)){
                return null;
            }

            if (slotItemStack.stackSize == 0){
                slot.putStack(null);
            }
            else{
                slot.onSlotChanged();
            }
        }
        return itemStack;
    }
}
