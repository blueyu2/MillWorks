package com.blueyu2.millworks.client.gui;

import com.blueyu2.millworks.handler.ConfigurationHandler;
import com.blueyu2.millworks.reference.Reference;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

import java.util.List;

/**
 * Created by Blueyu2 on 7/9/2014.
 */
public class ModGuiConfig extends GuiConfig {
    public ModGuiConfig(GuiScreen guiScreen) {
        super(guiScreen,
                new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                Reference.MOD_ID,
                false,
                false,
                //Makes the mods config gui name the path to the config file
                /*GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString())*/
                Reference.MOD_NAME + " Configuration");
    }
}
