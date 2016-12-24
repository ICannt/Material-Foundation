package org.icannt.materialfoundation.client.model;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by ICannt on 20/12/16.
 */
@Mod.EventBusSubscriber(Side.CLIENT)
public class ModelRegistry {

    public static final ModelRegistry INSTANCE = new ModelRegistry();

    private ModelRegistry() {

    }

    @SubscribeEvent
    public void registerAllModels(ModelRegistryEvent event) {

    }
}
