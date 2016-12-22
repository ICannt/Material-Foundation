package org.icannt.materialfoundation.common.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import org.icannt.materialfoundation.common.MaterialFoundation;
import org.icannt.materialfoundation.common.registry.BlockRegistry;

/**
 * Created by Liam on 21/12/16.
 */
public class TabMaterialFoundation extends CreativeTabs {

    public static final TabMaterialFoundation MATERIAL_FOUNDATION_TAB = new TabMaterialFoundation();

    public TabMaterialFoundation() {
        super(MaterialFoundation.MOD_ID);
    }

    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(BlockRegistry.METAL_CHECKER);
    }
}