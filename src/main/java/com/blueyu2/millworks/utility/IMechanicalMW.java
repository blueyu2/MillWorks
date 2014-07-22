package com.blueyu2.millworks.utility;

import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Blueyu2 on 7/21/2014.
 */
public interface IMechanicalMW {
    boolean mechanicalReceive(ForgeDirection from, int energy, boolean reverse);
}
