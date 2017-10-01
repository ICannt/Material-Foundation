package org.icannt.materialfoundation.client.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

/**
 * Created by ICannt on 24/09/17.
 */
public class ItemBlockVariantBase extends ItemBlock {

    public ItemBlockVariantBase(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

}
