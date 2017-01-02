package org.icannt.materialfoundation.client.proxy;

import org.icannt.materialfoundation.client.model.ModelHandler;
import org.icannt.materialfoundation.common.proxy.CommonProxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by ICannt on 20/12/16.
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        ModelHandler.registerItemModels();
        ModelHandler.initBlockModels();
    }

    @Override
    public void init(FMLInitializationEvent event) {
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Override
    public boolean isDedicatedServer() {
        return false;
    }
}
