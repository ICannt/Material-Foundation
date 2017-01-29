package org.icannt.materialfoundation.common.block.itemblock;

import org.icannt.materialfoundation.common.block.ItemBlockVariantBase;
import org.icannt.materialfoundation.common.block.variant.EnumMetalMultiExtraType;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

/**
 * Created by ICannt on 29/01/17.
 */
public class ItemBlockMetalMultiExtra extends ItemBlockVariantBase {

    public ItemBlockMetalMultiExtra(Block block) {
        super(block);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + EnumMetalMultiExtraType.values()[stack.getMetadata()].getName();
    }
    
    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumMetalMultiExtraType.values()[stack.getMetadata()].getRarity();
    }
}
