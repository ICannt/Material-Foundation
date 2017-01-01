package org.icannt.materialfoundation.common.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import org.icannt.materialfoundation.common.item.ItemGeneric;
import org.icannt.materialfoundation.common.item.ItemMetalTinPaint;
import org.icannt.materialfoundation.common.item.ItemToolFabricator;

/**
 * Created by ICannt on 29/12/16.
 */
public class ModItems {

    public static final ItemToolFabricator TOOL_FABRICATOR = new ItemToolFabricator();

    public static final ItemGeneric GENERIC = new ItemGeneric();

    public static final ItemMetalTinPaint TIN_METAL_PAINT = new ItemMetalTinPaint();

    public static void init() {
        GameRegistry.register(TOOL_FABRICATOR);
        GameRegistry.register(GENERIC);
        GameRegistry.register(TIN_METAL_PAINT);

        // TODO: Fix ore dictionary after converting minerals to variants        
        //OreDictionary.registerOre("dustBurntLime", new ItemStack(MINERAL_LIME_BURNT));

    }
}
