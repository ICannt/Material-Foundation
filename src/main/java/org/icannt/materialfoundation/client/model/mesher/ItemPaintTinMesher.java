package org.icannt.materialfoundation.client.model.mesher;

import org.icannt.materialfoundation.common.init.ModItems;
import org.icannt.materialfoundation.common.item.ItemMetalTinPaint;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;

/**
 * Created by ICannt on 31/12/16.
 */
public class ItemPaintTinMesher implements ItemMeshDefinition {

    @Override
    public ModelResourceLocation getModelLocation(ItemStack stack) {
        if (!stack.getItem().equals(ModItems.METAL_TIN_PAINT))
            return null;

        String variant = ItemMetalTinPaint.getVariant(stack).isPresent() ? ItemMetalTinPaint.getVariant(stack).get().getName() : "empty";

        return new ModelResourceLocation(stack.getItem().getRegistryName() + "_" + variant, "inventory");
    }
}
