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
    
    @SideOnly(Side.CLIENT)
    public void initItemModels() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(this.getRegistryName(), "inventory"));
    }
    
}
