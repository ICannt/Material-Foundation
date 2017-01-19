package org.icannt.materialfoundation.common.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.icannt.materialfoundation.common.MaterialFoundation;
import org.icannt.materialfoundation.common.creativetab.TabMaterialFoundation;

/**
 * Created by ICannt on 22/12/16.
 */
public class ItemToolFabricator extends Item {

    public ItemToolFabricator() {
        setRegistryName(MaterialFoundation.MOD_ID, "tool_fabricator");
        setUnlocalizedName(getRegistryName().toString());
        setCreativeTab(TabMaterialFoundation.MATERIAL_FOUNDATION_TAB);
        setMaxStackSize(1);
        setNoRepair();
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        return new ItemStack(this);
    }

    @Override
    public boolean isDamageable() {
        return false;
    }
    
}
