package com.blueyu2.millworks.block;

import com.blueyu2.millworks.reference.Names;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;

/**
 * Created by Blueyu2 on 7/1/2014.
 */
public class BlockMillStone extends BlockCommon {

    public BlockMillStone() {
        super();
        this.setBlockName(Names.Blocks.MILLSTONE);
        this.setHardness(1.5F);
        this.setStepSound(soundTypeStone);
        this.getTextures(3);
    }
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta){
        if (side == 0){return iconArray[2];}
        else if (side == 1){return iconArray[0];}
        else{return iconArray[1];}
    }
}
