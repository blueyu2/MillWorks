package com.blueyu2.millworks.block;

import com.blueyu2.millworks.reference.Names;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Created by Blueyu2 on 7/12/2014.
 */
public class BlockShaft extends BlockPillarCommonMW {
    public BlockShaft() {
        super(Material.wood);
        this.setBlockName(Names.Blocks.SHAFT);
        this.setHardness(1.5F);
        this.setStepSound(soundTypeWood);
    }
    public boolean renderAsNormalBlock(){return false;}

    public boolean isOpaqueCube(){return false;}

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        this.setBlockBoundsBasedOnState(world, x, y, z);
        return super.getCollisionBoundingBoxFromPool(world, x, y, z);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);
        if (meta == 0){
            this.setBlockBounds(0.375F, 0.0F, 0.375F, 0.625F, 1.0F, 0.625F);
        }
        else if (meta == 8){
            this.setBlockBounds(0.375F, 0.375F, 0.0F, 0.625F, 0.625F, 1.0F);
        }
        else if (meta == 4){
            this.setBlockBounds(0.0F, 0.375F, 0.375F, 1.0F, 0.625F, 0.625F);
        }
    }
    public void setBlockBoundsForItemRender(){
        this.setBlockBounds(0.375F, 0.0F, 0.375F, 0.625F, 1.0F, 0.625F);
    }
}
