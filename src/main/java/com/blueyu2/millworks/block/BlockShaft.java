package com.blueyu2.millworks.block;

import com.blueyu2.millworks.reference.Names;
import com.blueyu2.millworks.utility.IMechanicalMW;
import com.blueyu2.millworks.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Blueyu2 on 7/12/2014.
 */
public class BlockShaft extends BlockPillarCommonMW implements IMechanicalMW {
    //only 0, 4, 8 are valid
    ForgeDirection[][] testy = {{ForgeDirection.UP, ForgeDirection.DOWN}, null, null, null, {ForgeDirection.EAST, ForgeDirection.WEST}, null, null, null, {ForgeDirection.NORTH, ForgeDirection.SOUTH}};
    int meta;
    ForgeDirection inputSide;
    int energy;
    boolean reverse;

    int xCoord;
    int yCoord;
    int zCoord;

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

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);
        this.meta = world.getBlockMetadata(x, y, z);
        this.xCoord = x;
        this.yCoord = y;
        this.zCoord = z;
        String coords = "X:" + xCoord + " Y:" + yCoord + " Z:" + zCoord;
        LogHelper.info(coords);

    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
        if(this.inputSide != null){
            Block blockTo = world.getBlock(x + inputSide.getOpposite().offsetX, y + inputSide.getOpposite().offsetY, z + inputSide.getOpposite().offsetZ);
            if(blockTo != null && blockTo instanceof IMechanicalMW){
                IMechanicalMW handler = (IMechanicalMW)blockTo;
                boolean results = handler.mechanicalReceive(inputSide, this.energy, this.reverse);
                String coords = "X:" + x + " Y:" + y + " Z:" + z + " = ";
                LogHelper.info(coords + "Block " + results);
                //TODO Keep?
                this.inputSide = null;
                this.energy = 0;
                this.reverse = false;
                world.notifyBlockChange(x, y, z, world.getBlock(x, y, z));
/*                return;
            }
            TileEntity tileTo = world.getTileEntity(x + inputSide.getOpposite().offsetX, y + inputSide.getOpposite().offsetY, z + inputSide.getOpposite().offsetZ);
            if(tileTo != null && tileTo instanceof IMechanicalMW){
                IMechanicalMW handler = (IMechanicalMW)tileTo;
                boolean results = handler.mechanicalReceive(inputSide, this.energy, this.reverse);
                String coords = "X:" + x + " Y:" + y + " Z:" + z + " = ";
                LogHelper.info(coords + "Tile " + results);
                //TODO Keep?
                this.inputSide = null;
                this.energy = 0;
                this.reverse = false;
                world.notifyBlockChange(x, y, z, world.getBlock(x, y, z));*/
            }
        }
    }

    @Override
    public boolean mechanicalReceive(ForgeDirection from, int energy, boolean reverse) {
        //Check if side is available
        if(testy[meta][0] == from || testy[meta][1] == from){
            this.inputSide = from;
            this.energy = energy;
            this.reverse = reverse;
            return true;
        }
        return false;
    }
}
