package org.icannt.materialfoundation.common.registry;

import java.util.HashSet;
import java.util.Set;

import org.icannt.materialfoundation.common.MaterialFoundation;
import org.icannt.materialfoundation.common.item.ItemMineralLimeBurnt;
import org.icannt.materialfoundation.common.item.ItemToolFabricator;
import org.icannt.materialfoundation.common.item.ItemMetalTinPaint;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by ICannt on 22/12/16.
 */
@GameRegistry.ObjectHolder(MaterialFoundation.MOD_ID)
public class ItemRegistry {

    @GameRegistry.ObjectHolder("tool_fabricator")
    public static final ItemToolFabricator TOOL_FABRICATOR = new ItemToolFabricator();
	
    @GameRegistry.ObjectHolder("mineral_lime_burnt")
    public static final ItemMineralLimeBurnt MINERAL_LIME_BURNT = new ItemMineralLimeBurnt();
    
    @GameRegistry.ObjectHolder("metal_tin_paint")
    public static final ItemMetalTinPaint METAL_TIN_PAINT = new ItemMetalTinPaint();

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        public static final Set<Item> ITEMS = new HashSet<>();

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            final Item[] items = {
            		TOOL_FABRICATOR,
                    MINERAL_LIME_BURNT,
                    METAL_TIN_PAINT
            };

            for (Item item : items) {
                event.getRegistry().register(item);
                ITEMS.add(item);
            }
            
            OreDictionary.registerOre("dustBurntLime", new ItemStack(MINERAL_LIME_BURNT));
            
        }
    }
}
