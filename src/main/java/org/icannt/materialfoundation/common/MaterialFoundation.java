package org.icannt.materialfoundation.common;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.icannt.materialfoundation.common.proxy.CommonProxy;
import org.icannt.materialfoundation.common.recipe.ModRecipes;

/**
 * Created by ICannt on 20/12/16.
 */
@Mod(modid = MaterialFoundation.MOD_ID, name = MaterialFoundation.MOD_NAME, version = MaterialFoundation.VERSION)
public class MaterialFoundation {

    public static final String MOD_ID = "materialfoundation";
    public static final String MOD_NAME = "Material Foundation";
    public static final String VERSION = "1.10.2-2.0";

    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);

    @SidedProxy(serverSide = "org.icannt.materialfoundation.common.proxy.ServerProxy", clientSide = "org.icannt.materialfoundation.client.proxy.ClientProxy")
    public static CommonProxy proxy;

    @Mod.Instance(MOD_ID)
    public static MaterialFoundation instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
        ModRecipes.registerRecipes();
    }
}
