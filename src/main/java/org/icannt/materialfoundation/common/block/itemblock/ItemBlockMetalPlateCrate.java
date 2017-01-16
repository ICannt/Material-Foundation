package org.icannt.materialfoundation.common.block.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import org.icannt.materialfoundation.common.block.ItemBlockVariantBase;
import org.icannt.materialfoundation.common.block.variant.EnumMetalPlateCrateType;

/**
 * Created by ICannt on 14/01/17.
 */
public class ItemBlockMetalPlateCrate extends ItemBlockVariantBase {

    public ItemBlockMetalPlateCrate(Block block) {
        super(block);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + EnumMetalPlateCrateType.values()[stack.getMetadata()].getName();
    }
    
    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumMetalPlateCrateType.values()[stack.getMetadata()].getRarity();
    }
}
