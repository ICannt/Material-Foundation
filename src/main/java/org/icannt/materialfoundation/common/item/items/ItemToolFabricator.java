package org.icannt.materialfoundation.common.item.items;

import org.icannt.materialfoundation.MaterialFoundation;
import org.icannt.materialfoundation.client.creativetab.TabMaterialFoundation;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by ICannt on 01/10/17.
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
    
    @SideOnly(Side.CLIENT)
    public void initItemModels() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(this.getRegistryName(), "inventory"));
    }
    	
}
