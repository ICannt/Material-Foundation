package org.icannt.materialfoundation.common.block.itemblock;

import org.icannt.materialfoundation.common.block.ItemBlockVariantBase;
import org.icannt.materialfoundation.common.block.variant.EnumCompositeWallPlasterType;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

/**
 * Created by ICannt on 14/02/17.
 */
public class ItemBlockCompositeWallPlaster extends ItemBlockVariantBase {

    public ItemBlockCompositeWallPlaster(Block block) {
        super(block);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + EnumCompositeWallPlasterType.values()[stack.getMetadata()].getName();
    }
    
    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumCompositeWallPlasterType.values()[stack.getMetadata()].getRarity();
    }
}
