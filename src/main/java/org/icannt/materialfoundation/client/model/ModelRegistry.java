package org.icannt.materialfoundation.client.model;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.icannt.materialfoundation.common.MaterialFoundation;

/**
 * Created by Liam on 20/12/16.
 */
@SideOnly(Side.CLIENT)
@GameRegistry.ObjectHolder(MaterialFoundation.MOD_ID)
public class ModelRegistry {

    @SubscribeEvent
    public void registerAllModels(ModelRegistryEvent event) {

    }

}
