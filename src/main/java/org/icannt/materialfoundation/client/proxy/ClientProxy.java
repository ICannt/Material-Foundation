package org.icannt.materialfoundation.client.proxy;

import org.icannt.materialfoundation.client.model.ModelHandler;
import org.icannt.materialfoundation.common.proxy.CommonProxy;
import org.icannt.materialfoundation.common.registry.BlockRegistry;

/**
 * Created by ICannt on 20/12/16.
 */
public class ClientProxy implements CommonProxy {

    @Override
    public void preInit() {
        BlockRegistry.initBlockModels();
        ModelHandler.registerItemModels();
    }

    @Override
    public void init() {
    }

    @Override
    public void postInit() {

    }
}
