package com.blueyu2.millworks.tileentity;

import com.blueyu2.millworks.reference.Names;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Blueyu2 on 7/12/2014.
 */
public class TileEntityCommonMW extends TileEntity
{
    protected String customName;

    public TileEntityCommonMW()
    {
        customName = "";
    }

    public String getCustomName()
    {
        return customName;
    }

    public void setCustomName(String customName)
    {
        this.customName = customName;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);

        if (nbtTagCompound.hasKey(Names.NBT.CUSTOM_NAME))
        {
            this.customName = nbtTagCompound.getString(Names.NBT.CUSTOM_NAME);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeToNBT(nbtTagCompound);

        if (this.hasCustomName())
        {
            nbtTagCompound.setString(Names.NBT.CUSTOM_NAME, customName);
        }
    }

    public boolean hasCustomName()
    {
        return customName != null && customName.length() > 0;
    }
}
