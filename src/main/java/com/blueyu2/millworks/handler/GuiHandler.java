package com.blueyu2.millworks.handler;

import com.blueyu2.millworks.client.gui.inventory.GuiMillStone;
import com.blueyu2.millworks.inventory.ContainerMillStone;
import com.blueyu2.millworks.reference.GuiIds;
import com.blueyu2.millworks.tileentity.TileEntityMillStone;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by Blueyu2 on 7/14/2014.
 */
public class GuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == GuiIds.MILLSTONE){
            TileEntityMillStone tileEntityMillStone = (TileEntityMillStone) world.getTileEntity(x, y, z);
            return new ContainerMillStone(player.inventory, tileEntityMillStone);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == GuiIds.MILLSTONE){
            TileEntityMillStone tileEntityMillStone = (TileEntityMillStone) world.getTileEntity(x, y, z);
            return new GuiMillStone(player.inventory, tileEntityMillStone);
        }
        return null;
    }
}
