package com.blueyu2.millworks.inventory;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Blueyu2 on 7/15/2014.
 */
public class SlotOutput extends Slot {

    public SlotOutput(IInventory inventory, int slotIndex, int x, int y) {
        super(inventory, slotIndex, x, y);
    }

    @Override
    public void onPickupFromSlot(EntityPlayer entityPlayer, ItemStack itemStack){
        super.onPickupFromSlot(entityPlayer, itemStack);
        FMLCommonHandler.instance().firePlayerCraftingEvent(entityPlayer, itemStack, inventory);
    }

    @Override
    public boolean isItemValid(ItemStack itemStack){
        return false;
    }
}
