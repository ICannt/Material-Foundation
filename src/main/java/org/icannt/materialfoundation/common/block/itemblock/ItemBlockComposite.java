package org.icannt.materialfoundation.common.block.itemblock;

import org.icannt.materialfoundation.common.block.ItemBlockVariantBase;
import org.icannt.materialfoundation.common.block.variant.EnumCompositeType;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

/**
 * Created by ICannt on 23/12/16.
 */
public class ItemBlockComposite extends ItemBlockVariantBase {

    public ItemBlockComposite(Block block) {
        super(block);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + EnumCompositeType.values()[stack.getMetadata()].getName();
    }
    
    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumCompositeType.values()[stack.getMetadata()].getRarity();
    }
}
