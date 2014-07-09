package com.blueyu2.millworks.block;

import net.minecraft.block.material.Material;

/**
 * Created by Blueyu2 on 7/1/2014.
 */
public class BlockMillStone extends BlockCommon {
    public static final String name = "millStone";

    public BlockMillStone() {
        super(Material.rock);
        this.setBlockName(this.name);
        this.setHardness(1.5F);
        this.setStepSound(soundTypeStone);
        this.TESTY();
    }


}
