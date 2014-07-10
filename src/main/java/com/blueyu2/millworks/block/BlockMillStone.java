package com.blueyu2.millworks.block;

import com.blueyu2.millworks.reference.Names;
import net.minecraft.block.material.Material;

/**
 * Created by Blueyu2 on 7/1/2014.
 */
public class BlockMillStone extends BlockCommon {

    public BlockMillStone() {
        super();
        this.setBlockName(Names.Blocks.MILLSTONE);
        this.setHardness(1.5F);
        this.setStepSound(soundTypeStone);
    }

}
