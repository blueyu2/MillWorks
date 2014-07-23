package com.blueyu2.millworks.client.gui.inventory;

import com.blueyu2.millworks.inventory.ContainerMillStone;
import com.blueyu2.millworks.reference.Names;
import com.blueyu2.millworks.reference.Textures;
import com.blueyu2.millworks.tileentity.TileEntityMillStone;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

/**
 * Created by Blueyu2 on 7/14/2014.
 */
public class GuiMillStone extends GuiContainer {
    private TileEntityMillStone tileEntityMillStone;

    public GuiMillStone(InventoryPlayer inventoryPlayer, TileEntityMillStone tileEntityMillStone) {
        super(new ContainerMillStone(inventoryPlayer, tileEntityMillStone));
        this.tileEntityMillStone = tileEntityMillStone;
        xSize = 176;
        ySize = 166;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y){
        String containerName = StatCollector.translateToLocal(tileEntityMillStone.getInventoryName());
        fontRendererObj.drawString(containerName, xSize / 2 - fontRendererObj.getStringWidth(containerName) / 2, 6, 4210752);
        fontRendererObj.drawString(StatCollector.translateToLocal(Names.Containers.VANILLA_INVENTORY), 8, ySize - 93, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(Textures.GUI_MILLSTONE);
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
        int scaleAdjustment;

        scaleAdjustment = this.tileEntityMillStone.getProcessScaled(24);
        this.drawTexturedModalRect(xStart + 79, yStart + 34, 176, 0, scaleAdjustment + 1, 16);
    }
}
