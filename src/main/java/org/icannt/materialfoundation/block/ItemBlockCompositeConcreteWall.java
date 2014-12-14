package org.icannt.materialfoundation.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import org.icannt.materialfoundation.lib.Constants;
import org.icannt.materialfoundation.lib.DB;

/**
 * Created by PrinceCat on 29/08/2014.
 * Recoded and refactored by trab
 */

public class ItemBlockCompositeConcreteWall extends ItemBlock
{
	
    public ItemBlockCompositeConcreteWall(Block block)
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
        return "tile."+ Constants.MODID + BlockCompositeConcreteWall.namePath + BlockCompositeConcreteWall.meta[item.getItemDamage()].toLowerCase() + ".name";
    }
    
    @Override
    public int getMetadata(int i)
    {
        return i;
    }
    
}
