package org.icannt.materialfoundation.common.registry;

import java.util.HashSet;
import java.util.Set;

import org.icannt.materialfoundation.common.MaterialFoundation;
import org.icannt.materialfoundation.common.block.BlockCompositeConcrete;
import org.icannt.materialfoundation.common.block.BlockMetalPlateChecker;
import org.icannt.materialfoundation.common.block.BlockMetalPlateScale;
import org.icannt.materialfoundation.common.block.BlockMetalPlateWallStudded;
import org.icannt.materialfoundation.common.block.itemblock.ItemBlockComposite;
import org.icannt.materialfoundation.common.block.itemblock.ItemBlockMetal;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.IForgeRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by ICannt on 20/12/16.
 */

@GameRegistry.ObjectHolder(MaterialFoundation.MOD_ID)
public class BlockRegistry {

    @GameRegistry.ObjectHolder("metal_plate_checker")
    public static final BlockMetalPlateChecker METAL_PLATE_CHECKER = new BlockMetalPlateChecker();

    @GameRegistry.ObjectHolder("metal_plate_scale")
    public static final BlockMetalPlateScale METAL_PLATE_SCALE = new BlockMetalPlateScale();
    
    @GameRegistry.ObjectHolder("metal_plate_wall_studded")
    public static final BlockMetalPlateWallStudded METAL_PLATE_WALL_STUDDED = new BlockMetalPlateWallStudded();

    @GameRegistry.ObjectHolder("composite_concrete")
    public static final BlockCompositeConcrete COMPOSITE_CONCRETE = new BlockCompositeConcrete();

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            final IForgeRegistry<Block> registry = event.getRegistry();

            final Block[] blocks = {
                    METAL_PLATE_CHECKER,
                    METAL_PLATE_SCALE,
                    METAL_PLATE_WALL_STUDDED,
                    COMPOSITE_CONCRETE
            };

            registry.registerAll(blocks);
        }

        @SubscribeEvent
        public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
            final IForgeRegistry<Item> registry = event.getRegistry();

            final ItemBlock[] items = {
                new ItemBlockMetal(METAL_PLATE_CHECKER),
                new ItemBlockMetal(METAL_PLATE_SCALE),
                new ItemBlockMetal(METAL_PLATE_WALL_STUDDED),
                new ItemBlockComposite(COMPOSITE_CONCRETE)
            };

            for (ItemBlock item : items) {
                registry.register(item.setRegistryName(item.getBlock().getRegistryName()));
                ITEM_BLOCKS.add(item);
            }
        }

    }

    @SideOnly(Side.CLIENT)
    public static void initBlockModels() {
        METAL_PLATE_CHECKER.initClient();
        METAL_PLATE_SCALE.initClient();
        METAL_PLATE_WALL_STUDDED.initClient();
        COMPOSITE_CONCRETE.initClient();
    }
}
