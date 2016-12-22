package org.icannt.materialfoundation.client.proxy;

import net.minecraftforge.fml.common.registry.GameRegistry;
import org.icannt.materialfoundation.common.proxy.CommonProxy;
import org.icannt.materialfoundation.common.registry.BlockRegistry;

/**
 * Created by Liam on 20/12/16.
 */
public class ClientProxy implements CommonProxy {

    @Override
    public void preInit() {
        BlockRegistry.initModels();
    }

    @Override
    public void init() {
    }

    @Override
    public void postInit() {

    }
}
