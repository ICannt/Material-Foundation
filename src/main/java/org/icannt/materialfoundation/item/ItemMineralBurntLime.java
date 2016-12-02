package org.icannt.materialfoundation.item;

import org.icannt.materialfoundation.gui.MFCreativeTab;
import org.icannt.materialfoundation.lib.Constants;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

public class ItemMineralBurntLime extends Item
{
	private String type = "mineral";
	private String name = "Burnt_Lime";
	
	public ItemMineralBurntLime()
	{
		this.setUnlocalizedName(Constants.MODID + "." + type + "." + name.toLowerCase());
		this.setCreativeTab(MFCreativeTab.mfCreativeTab);
		this.setMaxStackSize(64);
		//this.setMaxDamage(10 - 1);
		//this.setNoRepair();
	}
	
/*	
	@Override 
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack)
	{		
		return false;     
    }
	
	@Override
    public Item setContainerItem(Item item)
    {
        return this;
    }

	@Override
	public boolean hasContainerItem(ItemStack itemStack)
	{
		return true;
	}
	
	@Override
    public boolean isDamageable()
    {
        return false;
    }
	
	@Override
	public ItemStack getContainerItem(ItemStack itemStack)
	{
		//itemStack.setItemDamage(itemStack.getItemDamage() + 1);
		return itemStack;
	}
*/	
}
