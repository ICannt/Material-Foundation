package org.icannt.materialfoundation.common.proxy;

import org.icannt.materialfoundation.common.init.ModBlocks;
import org.icannt.materialfoundation.common.init.ModItems;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by ICannt on 20/12/16.
 */
public abstract class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        ModBlocks.init();
        ModItems.init();

    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    public abstract boolean isDedicatedServer();
}
