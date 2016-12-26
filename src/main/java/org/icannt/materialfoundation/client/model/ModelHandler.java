package org.icannt.materialfoundation.client.model;

import org.icannt.materialfoundation.common.registry.ItemRegistry;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;

/**
 * Created by ICannt on 22/12/16.
 */
public class ModelHandler {

    public static void registerItemModels() {
    	
        // MF Fabricator
        registerItemModel(ItemRegistry.TOOL_FABRICATOR);
        
        // Burnt Lime
        registerItemModel(ItemRegistry.MINERAL_LIME_BURNT);
        
        // Paint Tin
        registerItemModel(ItemRegistry.METAL_TIN_PAINT);
        
    }

    public static void registerItemModel(Item item) {
        ModelBakery.registerItemVariants(item, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack) {
                return new ModelResourceLocation(stack.getItem().getRegistryName(), "inventory");
            }
        });
    }
}
