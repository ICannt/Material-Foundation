package org.icannt.materialfoundation.common.block.itemblock;

import org.icannt.materialfoundation.common.block.state.EnumMetalPaintedType;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by ICannt on 20/12/16.
 */
public class ItemBlockMetalPainted extends ItemBlock {

    public ItemBlockMetalPainted(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + EnumMetalPaintedType.values()[stack.getItemDamage()].getName();
    }
    
    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumMetalPaintedType.values()[stack.getItemDamage()].getRarity();
    }
}
