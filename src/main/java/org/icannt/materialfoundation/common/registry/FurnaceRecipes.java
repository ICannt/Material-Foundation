package org.icannt.materialfoundation.common.registry;

import org.icannt.materialfoundation.common.item.metadata.EnumGenericType;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by ICannt on 24/09/17.
 */
public class FurnaceRecipes {
	
	public static void registerFurnaceRecipes() {
		
        // Burnt Lime - Furnace
        for (ItemStack stack : OreDictionary.getOres("sandstone"))
        {
        	GameRegistry.addSmelting(stack, new ItemStack(ItemRegistry.GENERIC, 6, EnumGenericType.MINERAL_LIME_BURNT.ordinal()), 0.1F);
        }
        
	}
}
