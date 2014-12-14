package org.icannt.materialfoundation.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class MFItems
{
	
    public static ItemMFBlockFabricator mfBlockFabricator = new ItemMFBlockFabricator();
    
    public static ItemMineralBurntLime mineralBurntLime = new ItemMineralBurntLime();
	
	public static void init()
	{
        GameRegistry.registerItem(mfBlockFabricator, "mfBlockFabricator");
        GameRegistry.registerItem(mineralBurntLime, "mineralBurntLime");
	}
}
