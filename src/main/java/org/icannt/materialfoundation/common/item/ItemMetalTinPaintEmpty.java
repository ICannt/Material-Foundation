package org.icannt.materialfoundation.common.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.icannt.materialfoundation.common.MaterialFoundation;
import org.icannt.materialfoundation.common.creativetab.TabMaterialFoundation;

/**
 * Created by ICannt on 18/01/17.
 */
public class ItemMetalTinPaintEmpty extends Item {

    public ItemMetalTinPaintEmpty() {
        setRegistryName(MaterialFoundation.MOD_ID, "metal_tin_paint_empty");
        setUnlocalizedName(getRegistryName().toString());
        setCreativeTab(TabMaterialFoundation.MATERIAL_FOUNDATION_TAB);
        setMaxStackSize(16);
        setNoRepair();
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return false;
    }

    @Override
    public boolean isDamageable() {
        return false;
    }
    
}
