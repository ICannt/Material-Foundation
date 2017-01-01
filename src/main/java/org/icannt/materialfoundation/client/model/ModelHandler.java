package org.icannt.materialfoundation.client.model;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
        //registerItemModel(ModItems.GENERIC);        
        registerItemModelVariant();
                
        // Paint Tin
        List<ModelResourceLocation> modelsPaint = new ArrayList<>();
        for (EnumPaintType variant : EnumPaintType.values()) {
            modelsPaint.add(new ModelResourceLocation(ModItems.TIN_METAL_PAINT.getRegistryName() + "_" + variant.getName(), "inventory"));
        }

        ModelBakery.registerItemVariants(ModItems.TIN_METAL_PAINT, modelsPaint.toArray(new ModelResourceLocation[modelsPaint.size()]));
        ModelLoader.setCustomMeshDefinition(ModItems.TIN_METAL_PAINT, new ItemPaintTinMesher());
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
    
    
    public static void registerItemModelVariant() {
    	
        
        // [21:22:57] [Client thread/ERROR] [FML]: Exception loading blockstate for the variant materialfoundation:composite_concrete#composite=base: 
        // [21:45:02] [Client thread/ERROR] [FML]: Exception loading model for variant materialfoundation:generic#generic=mineral_lime_slime for item "materialfoundation:generic", blockstate location exception: 
        
        // materialfoundation:composite_concrete#composite=base 
        // materialfoundation:generic#generic=mineral_lime_slime
        // materialfoundation:generic#variant=mineral_lime_slime
        
        //[22:01:30] [Client thread/INFO] [STDOUT]: [org.icannt.materialfoundation.client.model.ModelHandler:registerItemModels:44]: -*->materialfoundation:generic
        //[22:01:30] [Client thread/INFO] [STDOUT]: [org.icannt.materialfoundation.client.model.ModelHandler:registerItemModels:45]: -*->mineral_lime_burnt
        //[22:01:30] [Client thread/INFO] [STDOUT]: [org.icannt.materialfoundation.client.model.ModelHandler:registerItemModels:45]: -*->mineral_lime_slime
        //[22:01:30] [Client thread/INFO] [STDOUT]: [org.icannt.materialfoundation.client.model.ModelHandler:registerItemModels:50]: -*->[materialfoundation:generic#mineral_lime_burnt, materialfoundation:generic#mineral_lime_slime]
        
        
        

        
        List<ModelResourceLocation> modelsGeneric = new ArrayList<>();
        
        System.out.println("-*->"+ModItems.GENERIC.getRegistryName());
        
        for (EnumGenericType variant : EnumGenericType.values()) {
        	
        	
        	System.out.println("-*->"+variant.getName());
        	
            modelsGeneric.add(new ModelResourceLocation(ModItems.GENERIC.getRegistryName(), "variant=" + variant.getName()));
        }
        
        System.out.println("-*->"+modelsGeneric);
        
        ModelBakery.registerItemVariants(ModItems.GENERIC, modelsGeneric.toArray(new ModelResourceLocation[modelsGeneric.size()]));
    	
        ModelLoader.setCustomMeshDefinition(ModItems.GENERIC, new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack) {
            	//System.out.println("-*->"+stack.getItem().getRegistryName());
                return new ModelResourceLocation(stack.getItem().getRegistryName(), "inventory");
            }
        });
        
        
        
    	
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
