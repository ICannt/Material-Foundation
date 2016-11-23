package org.icannt.materialfoundation.block;

import org.icannt.materialfoundation.lib.Constants;
import org.icannt.materialfoundation.lib.DB;
import org.icannt.materialfoundation.lib.MFMaterial;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

/**
 * Created by PrinceCat on 29/08/2014.
 * Recoded and refactored by trab
 */

public class ItemBlockMetalPlateScaleScale extends ItemBlock
{
	
    public ItemBlockMetalPlateScaleScale(Block block)
    {
        super(block);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    public String getItemStackDisplayName(ItemStack item)
    {
        return StatCollector.translateToLocal(getUnlocalizedName(item));
    }

    @Override
    public String getUnlocalizedName(ItemStack item)
    {
    	return "tile."+ Constants.MODID + BlockMetalPlateScaleScale.namePath + BlockMetalPlateScaleScale.meta[item.getItemDamage()].toLowerCase() + ".name";
    }
    
    @Override
    public int getMetadata(int i)
    {
        return i;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack item)
    {
        return EnumRarity.valueOf(MFMaterial.MFRarity[MFMaterial.MetalRarity[item.getItemDamage()]].toLowerCase());
    }
    
}
