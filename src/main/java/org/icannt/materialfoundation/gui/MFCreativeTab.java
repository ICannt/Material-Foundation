package org.icannt.materialfoundation.gui;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import org.icannt.materialfoundation.block.ItemBlockMetalPlateChecker;
//import org.icannt.materialfoundation.block.MFBlocks;
import org.icannt.materialfoundation.item.MFItems;
import org.icannt.materialfoundation.lib.Constants;

/**
 * Created by PrinceCat on 29/08/2014.
 * Recoded and refactored by trab
 */

public class MFCreativeTab {

    public static final CreativeTabs mfCreativeTab = new CreativeTabs(Constants.MODID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            //return Item.getItemFromBlock(MFBlocks.blockMetalPlateChecker);
        	return MFItems.mfBlockFabricator;
        }
    };
}
