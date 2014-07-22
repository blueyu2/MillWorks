package com.blueyu2.millworks.block;

import com.blueyu2.millworks.reference.Names;

/**
 * Created by Blueyu2 on 7/12/2014.
 */
public class BlockPillarStone extends BlockPillarCommonMW {
    public BlockPillarStone() {
        super();
        this.setBlockName(Names.Blocks.PILLARSTONE);
        this.setHardness(1.5F);
        this.setStepSound(soundTypeStone);
    }
}
