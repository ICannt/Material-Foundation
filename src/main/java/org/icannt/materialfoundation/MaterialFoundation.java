package org.icannt.materialfoundation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.icannt.materialfoundation.proxies.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by ICannt on 24/09/17.
 */

@Mod(modid = MaterialFoundation.MOD_ID,
	name = MaterialFoundation.MOD_NAME,
	version = MaterialFoundation.VERSION,
	acceptedMinecraftVersions = "[1.12,1.13)",
	dependencies = "required-after:forge@[14.21.0.2348,);")

public class MaterialFoundation {

    public static final String MOD_ID = "materialfoundation";
    public static final String MOD_NAME = "Material Foundation";
    public static final String VERSION = "1.12.1-3.0";

    @SidedProxy(clientSide = "org.icannt.materialfoundation.proxies.ClientProxy", serverSide = "org.icannt.materialfoundation.proxies.ServerProxy")
    public static CommonProxy proxy;
    
    @Mod.Instance(MOD_ID)
    public static MaterialFoundation instance;
    
    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);

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
    }
}