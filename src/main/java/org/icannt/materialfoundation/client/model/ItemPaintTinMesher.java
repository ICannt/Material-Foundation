package org.icannt.materialfoundation.client.model;

import org.icannt.materialfoundation.common.item.items.ItemMetalTinPaint;
import org.icannt.materialfoundation.common.registry.ItemRegistry;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;

/**
 * Created by ICannt on 01/10/17.
 */
public class ItemPaintTinMesher implements ItemMeshDefinition {

    @Override
    public ModelResourceLocation getModelLocation(ItemStack stack) {
    	
        if (!stack.getItem().equals(ItemRegistry.METAL_TIN_PAINT))
            return null;

        String variant = ItemMetalTinPaint.getVariant(stack).isPresent() ? ItemMetalTinPaint.getVariant(stack).get().getName() : "empty";

        return new ModelResourceLocation(stack.getItem().getRegistryName() + "_" + variant, "inventory");
    }
}
