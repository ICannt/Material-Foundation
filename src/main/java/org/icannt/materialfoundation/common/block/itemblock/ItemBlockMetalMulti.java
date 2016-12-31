package org.icannt.materialfoundation.common.block.itemblock;

import org.icannt.materialfoundation.common.block.state.EnumMetalMultiType;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by ICannt on 30/12/16.
 */
public class ItemBlockMetalMulti extends ItemBlock {

    public ItemBlockMetalMulti(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + EnumMetalMultiType.values()[stack.getItemDamage()].getName();
    }
    
    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumMetalMultiType.values()[stack.getItemDamage()].getRarity();
    }
}