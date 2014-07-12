package com.blueyu2.millworks.block;

import com.blueyu2.millworks.reference.Names;

/**
 * Created by Blueyu2 on 7/12/2014.
 */
public class BlockPillarSand extends BlockPillarCommon {
    public BlockPillarSand() {
        super();
        this.setBlockName(Names.Blocks.PILLARSAND);
        this.setHardness(1.5F);
        this.setStepSound(soundTypeStone);
    }
}
