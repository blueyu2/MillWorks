package com.blueyu2.millworks.block;

import com.blueyu2.millworks.reference.Names;
import com.blueyu2.millworks.tileentity.TileEntityTESTY;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Blueyu2 on 7/21/2014.
 */
public class BlockTESTGenerator extends BlockCommonMW implements ITileEntityProvider {
    public BlockTESTGenerator() {
        super();
        this.setBlockName(Names.Blocks.TESTY);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata){
        return new TileEntityTESTY();
    }
}
