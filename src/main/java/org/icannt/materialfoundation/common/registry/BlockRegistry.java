package org.icannt.materialfoundation.common.registry;

import java.util.HashSet;
import java.util.Set;

import org.icannt.materialfoundation.MaterialFoundation;
import org.icannt.materialfoundation.client.block.itemblocks.ItemBlockMetalOne;
import org.icannt.materialfoundation.client.block.itemblocks.ItemBlockMetalPainted;
import org.icannt.materialfoundation.client.block.itemblocks.ItemBlockMetalThree;
import org.icannt.materialfoundation.client.block.itemblocks.ItemBlockMetalTwo;
import org.icannt.materialfoundation.common.block.blocks.BlockMetalOnePlateChecker;
import org.icannt.materialfoundation.common.block.blocks.BlockMetalOnePlateScale;
import org.icannt.materialfoundation.common.block.blocks.BlockMetalPaintedPlateChecker;
import org.icannt.materialfoundation.common.block.blocks.BlockMetalThreePlateChecker;
import org.icannt.materialfoundation.common.block.blocks.BlockMetalThreePlateScale;
import org.icannt.materialfoundation.common.block.blocks.BlockMetalTwoPlateChecker;
import org.icannt.materialfoundation.common.block.blocks.BlockMetalTwoPlateScale;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * Created by ICannt on 24/09/17.
 */

@GameRegistry.ObjectHolder(MaterialFoundation.MOD_ID)
public class BlockRegistry {

    @GameRegistry.ObjectHolder("metal_one_plate_checker")
    public static final BlockMetalOnePlateChecker METAL_ONE_PLATE_CHECKER = new BlockMetalOnePlateChecker();

    @GameRegistry.ObjectHolder("metal_two_plate_checker")
    public static final BlockMetalTwoPlateChecker METAL_TWO_PLATE_CHECKER = new BlockMetalTwoPlateChecker();
    
    @GameRegistry.ObjectHolder("metal_three_plate_checker")
    public static final BlockMetalThreePlateChecker METAL_THREE_PLATE_CHECKER = new BlockMetalThreePlateChecker();

    @GameRegistry.ObjectHolder("metal_painted_plate_checker")
    public static final BlockMetalPaintedPlateChecker METAL_PAINTED_PLATE_CHECKER = new BlockMetalPaintedPlateChecker();
    
    @GameRegistry.ObjectHolder("metal_one_plate_scale")
    public static final BlockMetalOnePlateScale METAL_ONE_PLATE_SCALE = new BlockMetalOnePlateScale();
    
    @GameRegistry.ObjectHolder("metal_two_plate_scale")
    public static final BlockMetalTwoPlateScale METAL_TWO_PLATE_SCALE = new BlockMetalTwoPlateScale();
    
    @GameRegistry.ObjectHolder("metal_three_plate_scale")
    public static final BlockMetalThreePlateScale METAL_THREE_PLATE_SCALE = new BlockMetalThreePlateScale();
    
    private static final Block[] blocks = {
    	METAL_ONE_PLATE_CHECKER,
    	METAL_TWO_PLATE_CHECKER,
    	METAL_THREE_PLATE_CHECKER,
    	METAL_PAINTED_PLATE_CHECKER,
    	METAL_ONE_PLATE_SCALE,
    	METAL_TWO_PLATE_SCALE,
    	METAL_THREE_PLATE_SCALE,
    };    
    
    private static final ItemBlock[] itemBlocks = {
        new ItemBlockMetalOne(METAL_ONE_PLATE_CHECKER),
        new ItemBlockMetalTwo(METAL_TWO_PLATE_CHECKER),
        new ItemBlockMetalThree(METAL_THREE_PLATE_CHECKER),
        new ItemBlockMetalPainted(METAL_PAINTED_PLATE_CHECKER),
        new ItemBlockMetalOne(METAL_ONE_PLATE_SCALE),
        new ItemBlockMetalTwo(METAL_TWO_PLATE_SCALE),
        new ItemBlockMetalThree(METAL_THREE_PLATE_SCALE)
    };
    
    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            final IForgeRegistry<Block> registry = event.getRegistry();
            registry.registerAll(blocks);
        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            final IForgeRegistry<Item> registry = event.getRegistry();
            for (ItemBlock iB : itemBlocks) {
                registry.register(iB.setRegistryName(iB.getBlock().getRegistryName()));
                ITEM_BLOCKS.add(iB);
            }
        }

    }
    
    @SideOnly(Side.CLIENT)
    public static void initModels() {
    	METAL_ONE_PLATE_CHECKER.initItemBlockModels();
    	METAL_TWO_PLATE_CHECKER.initItemBlockModels();
    	METAL_THREE_PLATE_CHECKER.initItemBlockModels();
    	METAL_PAINTED_PLATE_CHECKER.initItemBlockModels();
    	METAL_ONE_PLATE_SCALE.initItemBlockModels();
    	METAL_TWO_PLATE_SCALE.initItemBlockModels();
    	METAL_THREE_PLATE_SCALE.initItemBlockModels();
    }

}
