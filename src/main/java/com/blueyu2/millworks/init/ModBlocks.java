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
    public static final BlockCommonMW millStoneBlock = new BlockMillStone();
    public static final BlockPillarCommonMW pillarStoneBlock = new BlockPillarStone();
    public static final BlockPillarCommonMW pillarSandBlock = new BlockPillarSand();
    public static final BlockPillarCommonMW shaftBlock = new BlockShaft();
    public static final BlockCommonMW testBlock = new BlockTESTGenerator();

    public static void init(){
        GameRegistry.registerBlock(millStoneBlock, Names.Blocks.MILLSTONE);
        GameRegistry.registerBlock(pillarStoneBlock, Names.Blocks.PILLARSTONE);
        GameRegistry.registerBlock(pillarSandBlock, Names.Blocks.PILLARSAND);
        GameRegistry.registerBlock(shaftBlock, Names.Blocks.SHAFT);
        GameRegistry.registerBlock(testBlock, Names.Blocks.TESTY);
    }
}
