package com.blueyu2.millworks;

import com.blueyu2.millworks.configuration.ConfigurationHandler;
import com.blueyu2.millworks.init.ModBlocks;
import com.blueyu2.millworks.proxy.IProxy;
import com.blueyu2.millworks.reference.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Blueyu2 on 6/30/2014.
 */

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class MillWorks {
    @Mod.Instance(Reference.MOD_ID)
    public static MillWorks instance;
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
    //Network Handling, Mod Configuration, Add items and blocks
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        ModBlocks.init();
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
    //Register GUIS, TileEntities, Recipies
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }
}
