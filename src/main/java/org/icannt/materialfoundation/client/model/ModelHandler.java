package org.icannt.materialfoundation.client.model;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import org.icannt.materialfoundation.common.registry.ItemRegistry;

/**
 * Created by Liam on 22/12/16.
 */
public class ModelHandler {

    public static void registerItemModels() {
        // Burnt Lime
        registerItemModel(ItemRegistry.BURNT_LIME);
        registerItemModel(ItemRegistry.FABRICATOR);
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
