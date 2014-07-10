package com.blueyu2.millworks.init;

import com.blueyu2.millworks.item.ItemCommon;
import com.blueyu2.millworks.item.ItemTextile;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Blueyu2 on 7/10/2014.
 */
public class ModItems {
    public static final ItemCommon textile = new ItemTextile();
    public static void init(){
        GameRegistry.registerItem(textile, "textile");
    }
}
