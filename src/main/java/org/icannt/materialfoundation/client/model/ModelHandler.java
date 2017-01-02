package org.icannt.materialfoundation.client.model;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.client.model.ModelLoader;
import org.icannt.materialfoundation.client.model.mesher.ItemPaintTinMesher;
import org.icannt.materialfoundation.common.MaterialFoundation;
import org.icannt.materialfoundation.common.init.ModBlocks;
import org.icannt.materialfoundation.common.init.ModItems;
import org.icannt.materialfoundation.common.item.variant.EnumGenericType;
import org.icannt.materialfoundation.common.item.variant.EnumPaintType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ICannt on 22/12/16.
 */
public class ModelHandler {

    public static void registerItemModels() {
    	
        // MF Fabricator
        registerItemModel(ModItems.TOOL_FABRICATOR);
               
        // Generic Items
        for (EnumGenericType variant : EnumGenericType.values()) {
            ModelLoader.setCustomModelResourceLocation(ModItems.GENERIC, variant.ordinal(), new ModelResourceLocation(ModItems.GENERIC.getRegistryName() + "_" + variant.getName(), "inventory"));
        }
                
        // Paint Tin
        List<ModelResourceLocation> modelsPaint = new ArrayList<>();
        for (EnumPaintType variant : EnumPaintType.values()) {
            modelsPaint.add(new ModelResourceLocation(ModItems.TIN_METAL_PAINT.getRegistryName() + "_" + variant.getName(), "inventory"));
        }

        ModelBakery.registerItemVariants(ModItems.TIN_METAL_PAINT, modelsPaint.toArray(new ModelResourceLocation[modelsPaint.size()]));
        ModelLoader.setCustomMeshDefinition(ModItems.TIN_METAL_PAINT, new ItemPaintTinMesher());
    }

    public static void registerItemModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    public static void initBlockModels() {
        ModBlocks.COMPOSITE_CONCRETE.initClient();
        ModBlocks.METAL_PLATE_CHECKER.initClient();
        ModBlocks.METAL_PAINTED_PLATE_CHECKER.initClient();
        ModBlocks.METAL_PLATE_SCALE.initClient();
        ModBlocks.METAL_PAINTED_PLATE_SCALE.initClient();
        ModBlocks.METAL_PLATE_WALL_STUDDED.initClient();
        ModBlocks.METAL_PAINTED_PLATE_WALL_STUDDED.initClient();
        ModBlocks.METAL_CRATE_WITH_GRILL.initClient();
    }
}
