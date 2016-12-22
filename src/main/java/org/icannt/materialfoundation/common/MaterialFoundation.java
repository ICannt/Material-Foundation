package org.icannt.materialfoundation.common;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.icannt.materialfoundation.common.proxy.CommonProxy;

/**
 * Created by Liam on 20/12/16.
 */
@Mod(modid = MaterialFoundation.MOD_ID, name = MaterialFoundation.MOD_NAME, version = MaterialFoundation.VERSION)
public class MaterialFoundation {

    public static final String MOD_ID = "materialfoundation";
    public static final String MOD_NAME = "Material Foundation 2";
    public static final String VERSION = "1.0";

    @Instance(MOD_ID)
    public static MaterialFoundation instance;

    @SidedProxy(serverSide = "org.icannt.materialfoundation.common.proxy.ServerProxy", clientSide = "org.icannt.materialfoundation.client.proxy.ClientProxy")
    public static CommonProxy proxy;


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
    }
}
