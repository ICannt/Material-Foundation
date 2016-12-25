package org.icannt.materialfoundation.common.registry;

import java.util.HashSet;
import java.util.Set;

import org.icannt.materialfoundation.common.MaterialFoundation;
import org.icannt.materialfoundation.common.block.BlockCompositeConcrete;
import org.icannt.materialfoundation.common.block.BlockMetalPaintedPlateChecker;
import org.icannt.materialfoundation.common.block.BlockMetalPaintedPlateScale;
import org.icannt.materialfoundation.common.block.BlockMetalPaintedPlateWallStudded;
import org.icannt.materialfoundation.common.block.BlockMetalPlateChecker;
import org.icannt.materialfoundation.common.block.BlockMetalPlateScale;
import org.icannt.materialfoundation.common.block.BlockMetalPlateWallStudded;
import org.icannt.materialfoundation.common.block.itemblock.ItemBlockComposite;
import org.icannt.materialfoundation.common.block.itemblock.ItemBlockMetal;
import org.icannt.materialfoundation.common.block.itemblock.ItemBlockMetalPainted;

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

    @GameRegistry.ObjectHolder("composite_concrete")
    public static final BlockCompositeConcrete COMPOSITE_CONCRETE = new BlockCompositeConcrete();
	
    @GameRegistry.ObjectHolder("metal_plate_checker")
    public static final BlockMetalPlateChecker METAL_PLATE_CHECKER = new BlockMetalPlateChecker();
    
    @GameRegistry.ObjectHolder("metal_painted_plate_checker")
    public static final BlockMetalPaintedPlateChecker METAL_PAINTED_PLATE_CHECKER = new BlockMetalPaintedPlateChecker();

    @GameRegistry.ObjectHolder("metal_plate_scale")
    public static final BlockMetalPlateScale METAL_PLATE_SCALE = new BlockMetalPlateScale();

    @GameRegistry.ObjectHolder("metal_painted_plate_scale")
    public static final BlockMetalPaintedPlateScale METAL_PAINTED_PLATE_SCALE = new BlockMetalPaintedPlateScale();
    
    @GameRegistry.ObjectHolder("metal_plate_wall_studded")
    public static final BlockMetalPlateWallStudded METAL_PLATE_WALL_STUDDED = new BlockMetalPlateWallStudded();
    
    @GameRegistry.ObjectHolder("metal_painted_plate_wall_studded")
    public static final BlockMetalPaintedPlateWallStudded METAL_PAINTED_PLATE_WALL_STUDDED = new BlockMetalPaintedPlateWallStudded();

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            final IForgeRegistry<Block> registry = event.getRegistry();

            final Block[] blocks = {
                    COMPOSITE_CONCRETE,
                    METAL_PLATE_CHECKER,
                    METAL_PAINTED_PLATE_CHECKER,
                    METAL_PLATE_SCALE,
                    METAL_PAINTED_PLATE_SCALE,
                    METAL_PLATE_WALL_STUDDED,
                    METAL_PAINTED_PLATE_WALL_STUDDED
            };

            registry.registerAll(blocks);
        }

        @SubscribeEvent
        public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
            final IForgeRegistry<Item> registry = event.getRegistry();

            final ItemBlock[] items = {
                new ItemBlockComposite(COMPOSITE_CONCRETE),
                new ItemBlockMetal(METAL_PLATE_CHECKER),
                new ItemBlockMetalPainted(METAL_PAINTED_PLATE_CHECKER),
                new ItemBlockMetal(METAL_PLATE_SCALE),
                new ItemBlockMetalPainted(METAL_PAINTED_PLATE_SCALE),
                new ItemBlockMetal(METAL_PLATE_WALL_STUDDED),
                new ItemBlockMetalPainted(METAL_PAINTED_PLATE_WALL_STUDDED)
            };

            for (ItemBlock item : items) {
                registry.register(item.setRegistryName(item.getBlock().getRegistryName()));
                ITEM_BLOCKS.add(item);
            }
        }

    }

    @SideOnly(Side.CLIENT)
    public static void initBlockModels() {
        COMPOSITE_CONCRETE.initClient();
        METAL_PLATE_CHECKER.initClient();
        METAL_PAINTED_PLATE_CHECKER.initClient();
        METAL_PLATE_SCALE.initClient();
        METAL_PAINTED_PLATE_SCALE.initClient();
        METAL_PLATE_WALL_STUDDED.initClient();
        METAL_PAINTED_PLATE_WALL_STUDDED.initClient();
    }
}
