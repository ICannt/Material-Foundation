package org.icannt.materialfoundation.client.proxy;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.icannt.materialfoundation.client.model.ModelHandler;
import org.icannt.materialfoundation.common.proxy.CommonProxy;
import org.icannt.materialfoundation.common.registry.BlockRegistry;
import org.icannt.materialfoundation.common.registry.ItemRegistry;

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
