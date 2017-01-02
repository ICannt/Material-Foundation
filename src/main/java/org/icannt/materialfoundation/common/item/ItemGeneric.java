package org.icannt.materialfoundation.common.item;

import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.text.WordUtils;
import org.icannt.materialfoundation.common.MaterialFoundation;
import org.icannt.materialfoundation.common.block.variant.EnumCompositeType;
import org.icannt.materialfoundation.common.creativetab.TabMaterialFoundation;
import org.icannt.materialfoundation.common.init.ModItems;
import org.icannt.materialfoundation.common.item.variant.EnumGenericType;
import org.icannt.materialfoundation.common.item.variant.EnumPaintType;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ICannt on 01/01/17.
 */
public class ItemGeneric extends Item {

    public ItemGeneric() {
        setRegistryName(MaterialFoundation.MOD_ID, "generic");
        setUnlocalizedName(getRegistryName().toString());
        setCreativeTab(TabMaterialFoundation.MATERIAL_FOUNDATION_TAB);
        setHasSubtypes(true);
    }
    
    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + EnumGenericType.values()[stack.getMetadata()].getName();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
        for (EnumGenericType type : EnumGenericType.values()) {
        	subItems.add(new ItemStack(this, 1, type.ordinal()));
        }
    }
    
    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }
    

    public static EnumGenericType getVariant(ItemStack stack) {
        return EnumGenericType.values()[stack.getMetadata()];
    }
    
}
