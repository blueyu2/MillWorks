package com.blueyu2.millworks.init;

import com.blueyu2.millworks.block.*;
import com.blueyu2.millworks.reference.Names;
import com.blueyu2.millworks.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Blueyu2 on 7/1/2014.
 */
@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {
    public static final BlockCommon millStoneBlock = new BlockMillStone();
    public static final BlockPillarCommon pillarStoneBlock = new BlockPillarStone();
    public static final BlockPillarCommon pillarSandBlock = new BlockPillarSand();
    public static void init(){
        GameRegistry.registerBlock(millStoneBlock, Names.Blocks.MILLSTONE);
        GameRegistry.registerBlock(pillarStoneBlock, Names.Blocks.PILLARSTONE);
        GameRegistry.registerBlock(pillarSandBlock, Names.Blocks.PILLARSAND);
    }
}
