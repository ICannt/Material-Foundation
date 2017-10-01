package org.icannt.materialfoundation.client.block.itemblocks;

import org.icannt.materialfoundation.client.block.ItemBlockVariantBase;
import org.icannt.materialfoundation.common.block.metadata.EnumMetalPainted;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

/**
 * Created by ICannt on 24/09/17.
 */
public class ItemBlockMetalPainted extends ItemBlockVariantBase {

    public ItemBlockMetalPainted(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + EnumMetalPainted.values()[stack.getMetadata()].getName();
    }
    
    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumMetalPainted.values()[stack.getMetadata()].getRarity();
    }
}
