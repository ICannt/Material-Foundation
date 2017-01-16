package org.icannt.materialfoundation.common.block.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import org.icannt.materialfoundation.common.block.ItemBlockVariantBase;
import org.icannt.materialfoundation.common.block.variant.EnumMetalGrillType;

/**
 * Created by ICannt on 20/12/16.
 */
public class ItemBlockMetalGrill extends ItemBlockVariantBase {

    public ItemBlockMetalGrill(Block block) {
        super(block);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + EnumMetalGrillType.values()[stack.getMetadata()].getName();
    }
    
    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumMetalGrillType.values()[stack.getMetadata()].getRarity();
    }
}
