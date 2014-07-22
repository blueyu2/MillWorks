package com.blueyu2.millworks.tileentity;

import com.blueyu2.millworks.utility.IMechanicalMW;
import com.blueyu2.millworks.utility.LogHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Blueyu2 on 7/21/2014.
 */
public class TileEntityTESTY extends TileEntityCommonMW implements IMechanicalMW {
    private ForgeDirection[] direction = {ForgeDirection.NORTH, ForgeDirection.SOUTH, ForgeDirection.EAST, ForgeDirection.WEST, ForgeDirection.UP, ForgeDirection.DOWN};
    private TileEntity[] side = new TileEntity[6];

    @Override
    public void updateEntity(){
        for(int i = 0; i<6; i++){
            side[i] = worldObj.getTileEntity(xCoord + direction[i].offsetX, yCoord + direction[i].offsetY, zCoord + direction[i].offsetZ);
            if(side[i] != null && side[i] instanceof IMechanicalMW){
                IMechanicalMW handler = (IMechanicalMW)side[i];
                boolean results = handler.mechanicalReceive(direction[i].getOpposite(), 15, false);
                String coords = "X:" + xCoord + " Y:" + yCoord + " Z:" + zCoord + " = ";
                LogHelper.info(coords + results);
            }
        }
    }

    @Override
    public boolean mechanicalReceive(ForgeDirection from, int energy, boolean reverse) {
        return false;
    }
}
