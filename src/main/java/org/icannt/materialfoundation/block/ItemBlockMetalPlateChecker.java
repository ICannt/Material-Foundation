package org.icannt.materialfoundation.block;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import org.icannt.materialfoundation.lib.Constants;
import org.icannt.materialfoundation.lib.DB;
import org.icannt.materialfoundation.lib.MFMaterial;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by PrinceCat on 29/08/2014.
 * Recoded and refactored by trab
 */

public class ItemBlockMetalPlateChecker extends ItemBlock
{
	
    public ItemBlockMetalPlateChecker(Block block)
    {
        super(block);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    /*
    @Override
    public String getItemStackDisplayName(ItemStack item)
    {
        return StatCollector.translateToLocal(getUnlocalizedName(item));
    }
    */

    @Override
    public String getUnlocalizedName(ItemStack item)
    {
        return "tile."+ Constants.MODID + BlockMetalPlateChecker.namePath + BlockMetalPlateChecker.meta[item.getItemDamage()].toLowerCase() + ".name";
    }
    
    @Override
    public int getMetadata(int i)
    {
        return i;
    }

    /*
    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack item)
    {
        return EnumRarity.valueOf(MFMaterial.MFRarity[MFMaterial.MetalRarity[item.getItemDamage()]].toLowerCase());
    }
	*/

}
