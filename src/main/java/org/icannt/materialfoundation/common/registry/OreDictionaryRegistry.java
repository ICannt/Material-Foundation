package org.icannt.materialfoundation.common.registry;

import org.icannt.materialfoundation.common.item.metadata.EnumGenericType;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by ICannt on 24/09/17.
 */
public class OreDictionaryRegistry {

	public static void registerDictionaryOres() {
		
		for (EnumGenericType variant : EnumGenericType.values()) {
			OreDictionary.registerOre(variant.getOreDict(), new ItemStack(ItemRegistry.GENERIC, 1, variant.ordinal()));
		}
		
		// Registration of Vanilla items that are not registered :(, purely a guess at what other mods might use
		OreDictionary.registerOre("dustBlaze", new ItemStack(Items.BLAZE_POWDER));
	  
	}

}
