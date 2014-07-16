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
        //this.getTextures(2);
    }
/*    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta){
        if(meta == 0) {
            return side == 0 || side == 1 ? iconArray[0] : iconArray[1];
        }
        else if(meta == 1){
            return side == 2 || side == 3 ? iconArray[0] : iconArray[1];
        }
        else if (meta == 2){
            return side == 4 || side == 5 ? iconArray[0] : iconArray[1];
        }
        return iconArray[0];
    }*/
/*    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta){
        return side == 0 || side == 1 ? 0 : side == 2 || side == 3 ? 1 : side == 4 || side == 5 ? 2 : 0;
    }*/
}
