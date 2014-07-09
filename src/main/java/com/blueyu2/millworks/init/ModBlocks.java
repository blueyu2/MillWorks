package com.blueyu2.millworks.init;

import com.blueyu2.millworks.block.BlockCommon;
import com.blueyu2.millworks.block.BlockMillStone;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Blueyu2 on 7/1/2014.
 */
public class ModBlocks {
    //TODO GameRegistry.ObjectHolder
    public static final BlockCommon millStoneBlock = new BlockMillStone();
    public static void init(){
        GameRegistry.registerBlock(millStoneBlock, BlockMillStone.name);
    }
}
