package org.icannt.materialfoundation.common.item;

import net.minecraft.item.Item;
import org.icannt.materialfoundation.common.MaterialFoundation;
import org.icannt.materialfoundation.common.creativetab.TabMaterialFoundation;

/**
 * Created by ICannt on 22/12/16.
 */
public class ItemMineralLimeBurnt extends Item {

    public ItemMineralLimeBurnt() {
        setRegistryName(MaterialFoundation.MOD_ID, "mineral_lime_burnt");
        setUnlocalizedName(getRegistryName().toString());
        setCreativeTab(TabMaterialFoundation.MATERIAL_FOUNDATION_TAB);
        setMaxStackSize(64);
    }
    
}
