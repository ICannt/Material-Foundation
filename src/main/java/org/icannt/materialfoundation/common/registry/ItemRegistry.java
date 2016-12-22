package org.icannt.materialfoundation.common.registry;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.icannt.materialfoundation.common.MaterialFoundation;
import org.icannt.materialfoundation.common.item.ItemBurntLime;
import org.icannt.materialfoundation.common.item.ItemFabricator;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Liam on 22/12/16.
 */
@GameRegistry.ObjectHolder(MaterialFoundation.MOD_ID)
public class ItemRegistry {

    @GameRegistry.ObjectHolder("burnt_lime")
    public static final ItemBurntLime BURNT_LIME = new ItemBurntLime();

    @GameRegistry.ObjectHolder("fabricator")
    public static final ItemFabricator FABRICATOR = new ItemFabricator();

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        public static final Set<Item> ITEMS = new HashSet<>();

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            final Item[] items = {
                    BURNT_LIME,
                    FABRICATOR
            };

            for (Item item : items) {
                event.getRegistry().register(item);
                ITEMS.add(item);
            }
        }
    }
}
