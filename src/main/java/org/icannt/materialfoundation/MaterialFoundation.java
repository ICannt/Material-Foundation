package org.icannt.materialfoundation;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

import org.icannt.materialfoundation.lib.Constants;
import org.icannt.materialfoundation.lib.DB;
import org.icannt.materialfoundation.block.MFBlocks;
import org.icannt.materialfoundation.item.MFItems;
import org.icannt.materialfoundation.recipe.MFRecipes;


@Mod(modid = Constants.MODID, name = Constants.NAME, version = Constants.VERSION)

public class MaterialFoundation
{
	
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	MFBlocks.init();
    	MFItems.init();
    }
 
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
 
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	MFRecipes.init();
    }
}
