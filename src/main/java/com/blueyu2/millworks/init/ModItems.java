package com.blueyu2.millworks.init;

import com.blueyu2.millworks.item.ItemCommon;
import com.blueyu2.millworks.item.ItemTextile;
import com.blueyu2.millworks.reference.Names;
import com.blueyu2.millworks.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Blueyu2 on 7/10/2014.
 */
@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
    public static final ItemCommon textile = new ItemTextile();
    public static void init(){
        GameRegistry.registerItem(textile, Names.Items.TEXTILE);
    }
}
