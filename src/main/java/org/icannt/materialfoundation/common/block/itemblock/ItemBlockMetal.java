package org.icannt.materialfoundation.common.block.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import org.icannt.materialfoundation.common.block.state.EnumMetalType;

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
}
