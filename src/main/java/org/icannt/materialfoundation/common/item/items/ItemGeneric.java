package org.icannt.materialfoundation.common.item.items;

import org.icannt.materialfoundation.MaterialFoundation;
import org.icannt.materialfoundation.client.creativetab.TabMaterialFoundation;
import org.icannt.materialfoundation.common.item.metadata.EnumGenericType;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by ICannt on 01/10/17.
 */
public class ItemGeneric extends Item {

    public ItemGeneric() {
        setRegistryName(MaterialFoundation.MOD_ID, "generic");
        setUnlocalizedName(getRegistryName().toString());
        setCreativeTab(TabMaterialFoundation.MATERIAL_FOUNDATION_TAB);
        setHasSubtypes(true);
        setNoRepair();
    }
    
    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + EnumGenericType.values()[stack.getMetadata()].getName();
    }

    public static EnumGenericType getVariant(ItemStack stack) {
        return EnumGenericType.values()[stack.getMetadata()];
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        for (EnumGenericType type : EnumGenericType.values()) {
        	items.add(new ItemStack(this, 1, type.ordinal()));
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void initItemModels() {
    	for (EnumGenericType variant : EnumGenericType.values()) {
    		ModelLoader.setCustomModelResourceLocation(this, variant.ordinal(), new ModelResourceLocation(this.getRegistryName() + "_" + variant.getName(), "inventory"));
    	}
    }
	
}
