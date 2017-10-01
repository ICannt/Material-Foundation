package org.icannt.materialfoundation.client.block.itemblocks;

import org.icannt.materialfoundation.client.block.ItemBlockVariantBase;
import org.icannt.materialfoundation.common.block.metadata.EnumMetalOne;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

/**
 * Created by ICannt on 24/09/17.
 */
public class ItemBlockMetalOne extends ItemBlockVariantBase {

    public ItemBlockMetalOne(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + EnumMetalOne.values()[stack.getMetadata()].getName();
    }
    
    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumMetalOne.values()[stack.getMetadata()].getRarity();
    }
}
