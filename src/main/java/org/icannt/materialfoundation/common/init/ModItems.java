package org.icannt.materialfoundation.common.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import org.icannt.materialfoundation.common.item.ItemGeneric;
import org.icannt.materialfoundation.common.item.ItemMetalTinPaint;
import org.icannt.materialfoundation.common.item.ItemMetalTinPaintEmpty;
import org.icannt.materialfoundation.common.item.ItemToolFabricator;
import org.icannt.materialfoundation.common.item.variant.EnumGenericType;

/**
 * Created by ICannt on 29/12/16.
 */
public class ModItems {

    public static final ItemToolFabricator TOOL_FABRICATOR = new ItemToolFabricator();
    public static final ItemGeneric GENERIC = new ItemGeneric();
    public static final ItemMetalTinPaint METAL_TIN_PAINT = new ItemMetalTinPaint();
    public static final ItemMetalTinPaintEmpty METAL_TIN_PAINT_EMPTY = new ItemMetalTinPaintEmpty();
    

    public static void init() {
        GameRegistry.register(TOOL_FABRICATOR);
        GameRegistry.register(GENERIC);
        GameRegistry.register(METAL_TIN_PAINT);
        GameRegistry.register(METAL_TIN_PAINT_EMPTY);

        // Register the generic items with the Ore Dictionary
        for (EnumGenericType variant : EnumGenericType.values()) {
      		OreDictionary.registerOre(variant.getOreDict(), new ItemStack(ModItems.GENERIC, 1, variant.ordinal()));
        }
        
        // Registration of Vanilla items that are not registered :(, purely a guess at what other mods might use
        OreDictionary.registerOre("dustBlaze", new ItemStack(Items.BLAZE_POWDER));
        
    }
}
