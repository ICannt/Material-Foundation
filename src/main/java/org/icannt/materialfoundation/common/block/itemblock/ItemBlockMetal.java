package org.icannt.materialfoundation.common.block.itemblock;

import org.icannt.materialfoundation.common.block.state.EnumMetalType;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by ICannt on 20/12/16.
 */
public class ItemBlockMetal extends ItemBlock {

    public ItemBlockMetal(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + EnumMetalType.values()[stack.getItemDamage()].getName();
    }
    
    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumMetalType.values()[stack.getItemDamage()].getRarity();
    }
}
