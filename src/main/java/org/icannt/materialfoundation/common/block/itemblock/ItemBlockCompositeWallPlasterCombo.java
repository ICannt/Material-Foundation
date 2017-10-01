package org.icannt.materialfoundation.common.block.itemblock;

import org.icannt.materialfoundation.common.block.ItemBlockVariantBase;
import org.icannt.materialfoundation.common.block.variant.EnumCompositeWallPlasterComboType;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

/**
 * Created by ICannt on 26/02/17.
 */
public class ItemBlockCompositeWallPlasterCombo extends ItemBlockVariantBase {

    public ItemBlockCompositeWallPlasterCombo(Block block) {
        super(block);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + EnumCompositeWallPlasterComboType.values()[stack.getMetadata()].getName();
    }
    
    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumCompositeWallPlasterComboType.values()[stack.getMetadata()].getRarity();
    }
}
