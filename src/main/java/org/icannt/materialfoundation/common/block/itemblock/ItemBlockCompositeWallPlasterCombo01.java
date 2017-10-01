package org.icannt.materialfoundation.common.block.itemblock;

import org.icannt.materialfoundation.common.block.ItemBlockVariantBase;
import org.icannt.materialfoundation.common.block.variant.EnumCompositeWallPlasterCombo01Type;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

/**
 * Created by ICannt on 14/02/17.
 */
public class ItemBlockCompositeWallPlasterCombo01 extends ItemBlockVariantBase {

    public ItemBlockCompositeWallPlasterCombo01(Block block) {
        super(block);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + EnumCompositeWallPlasterCombo01Type.values()[stack.getMetadata()].getName();
    }
    
    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumCompositeWallPlasterCombo01Type.values()[stack.getMetadata()].getRarity();
    }
}
