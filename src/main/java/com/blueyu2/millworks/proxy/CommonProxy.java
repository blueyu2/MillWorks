package com.blueyu2.millworks.proxy;

import com.blueyu2.millworks.reference.Names;
import com.blueyu2.millworks.tileentity.TileEntityMillStone;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Blueyu2 on 6/30/2014.
 */
public abstract class CommonProxy implements IProxy {
    public void registerTileEntities(){
        GameRegistry.registerTileEntity(TileEntityMillStone.class, "tile." + Names.Blocks.MILLSTONE);
    }
}
