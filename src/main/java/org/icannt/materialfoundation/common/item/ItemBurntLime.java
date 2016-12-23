package org.icannt.materialfoundation.common.item;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import org.icannt.materialfoundation.common.MaterialFoundation;
import org.icannt.materialfoundation.common.block.state.EnumMetalType;
import org.icannt.materialfoundation.common.creativetab.TabMaterialFoundation;

/**
 * Created by ICannt on 22/12/16.
 */
public class ItemBurntLime extends Item {

    public ItemBurntLime() {
        setRegistryName(MaterialFoundation.MOD_ID, "burnt_lime");
        setUnlocalizedName(getRegistryName().toString());
        setCreativeTab(TabMaterialFoundation.MATERIAL_FOUNDATION_TAB);
        setMaxStackSize(64);
    }
    
}
