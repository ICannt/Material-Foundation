package org.icannt.materialfoundation.client.creativetab;

import org.icannt.materialfoundation.MaterialFoundation;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;


/**
 * Created by ICannt on 24/09/17.
 */
public class TabMaterialFoundation extends CreativeTabs {

    public static final TabMaterialFoundation MATERIAL_FOUNDATION_TAB = new TabMaterialFoundation();

    public TabMaterialFoundation() {
        super(MaterialFoundation.MOD_ID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Blocks.NETHERRACK);
    }
}