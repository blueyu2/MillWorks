package com.blueyu2.millworks.reference;

import com.blueyu2.millworks.utility.ResourceLocationHelper;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Blueyu2 on 7/14/2014.
 */
public class Textures {
    public static final String RESOURCE_PREFIX = Reference.MOD_ID.toLowerCase() + ":";

    public static final String MODEL_TEXTURE_LOCATION = "textures/models/";
    public static final String GUI_SHEET_LOCATION = "textures/gui/";

    public static final ResourceLocation GUI_MILLSTONE = ResourceLocationHelper.getResourceLocation(GUI_SHEET_LOCATION + "millstone.png");
}
