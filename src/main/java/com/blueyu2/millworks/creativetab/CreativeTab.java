package com.blueyu2.millworks.creativetab;

import com.blueyu2.millworks.init.ModBlocks;
import com.blueyu2.millworks.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Blueyu2 on 7/11/2014.
 */
public class CreativeTab {
    public static final CreativeTabs MillWorksTab = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(ModBlocks.millStoneBlock);
        }
    };
}
