package org.icannt.materialfoundation.common.registry;

import java.util.HashSet;
import java.util.Set;

import org.icannt.materialfoundation.MaterialFoundation;
import org.icannt.materialfoundation.common.item.items.ItemGeneric;
import org.icannt.materialfoundation.common.item.items.ItemMetalTinPaint;
import org.icannt.materialfoundation.common.item.items.ItemMetalTinPaintEmpty;
import org.icannt.materialfoundation.common.item.items.ItemToolFabricator;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * Created by ICannt on 01/10/17.
 */

@GameRegistry.ObjectHolder(MaterialFoundation.MOD_ID)
public class ItemRegistry {
	
	@GameRegistry.ObjectHolder("tool_fabricator")
    public static final ItemToolFabricator TOOL_FABRICATOR = new ItemToolFabricator();
	
	@GameRegistry.ObjectHolder("generic")
    public static final ItemGeneric GENERIC = new ItemGeneric();
	
	@GameRegistry.ObjectHolder("metal_tin_paint")
    public static final ItemMetalTinPaint METAL_TIN_PAINT = new ItemMetalTinPaint();
	
	@GameRegistry.ObjectHolder("metal_tin_paint_empty")
    public static final ItemMetalTinPaintEmpty METAL_TIN_PAINT_EMPTY = new ItemMetalTinPaintEmpty();
    
    private static final Item[] items = {
        TOOL_FABRICATOR,
        GENERIC,
        METAL_TIN_PAINT,
        METAL_TIN_PAINT_EMPTY
    };
        
    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        public static final Set<Item> ITEMS = new HashSet<>();

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            final IForgeRegistry<Item> registry = event.getRegistry();
            registry.registerAll(items);
        }

    }
	
    @SideOnly(Side.CLIENT)
    public static void initModels() {
    	TOOL_FABRICATOR.initItemModels();
    	GENERIC.initItemModels();
    	METAL_TIN_PAINT.initItemModels();
    	METAL_TIN_PAINT_EMPTY.initItemModels();
    }

}
