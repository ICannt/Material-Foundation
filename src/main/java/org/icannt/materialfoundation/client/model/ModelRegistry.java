package org.icannt.materialfoundation.client.model;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.icannt.materialfoundation.common.MaterialFoundation;
import org.icannt.materialfoundation.common.registry.BlockRegistry;
import org.icannt.materialfoundation.common.registry.ItemRegistry;

/**
 * Created by Liam on 20/12/16.
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
