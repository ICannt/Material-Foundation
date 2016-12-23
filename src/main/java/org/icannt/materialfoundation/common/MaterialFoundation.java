package org.icannt.materialfoundation.common;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.icannt.materialfoundation.common.proxy.CommonProxy;
import org.icannt.materialfoundation.common.recipe.ModRecipes;

/**
 * Created by ICannt on 20/12/16.
 */
@Mod(modid = MaterialFoundation.MOD_ID, name = MaterialFoundation.MOD_NAME, version = MaterialFoundation.VERSION)
public class MaterialFoundation {

    @SidedProxy(serverSide = "org.icannt.materialfoundation.common.proxy.ServerProxy", clientSide = "org.icannt.materialfoundation.client.proxy.ClientProxy")
    public static CommonProxy proxy;

    public static final String MOD_ID = "materialfoundation";
    public static final String MOD_NAME = "Material Foundation";
    public static final String VERSION = "1.10.2-1.2";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
        ModRecipes.registerRecipes();
    }
}
