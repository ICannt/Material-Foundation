package org.icannt.materialfoundation.common.block.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import org.icannt.materialfoundation.common.block.state.EnumCompositeType;
import org.icannt.materialfoundation.common.block.state.EnumMetalType;

/**
 * Created by ICannt on 23/12/16.
 */
public class ItemBlockComposite extends ItemBlock {

    public ItemBlockComposite(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + EnumCompositeType.values()[stack.getItemDamage()].getName();
    }
    
    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumCompositeType.values()[stack.getItemDamage()].getRarity();
    }
}
