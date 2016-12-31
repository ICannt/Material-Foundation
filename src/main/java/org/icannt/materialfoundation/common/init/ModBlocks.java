package org.icannt.materialfoundation.common.init;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.icannt.materialfoundation.common.block.*;
import org.icannt.materialfoundation.common.block.itemblock.ItemBlockComposite;
import org.icannt.materialfoundation.common.block.itemblock.ItemBlockMetal;
import org.icannt.materialfoundation.common.block.itemblock.ItemBlockMetalMulti;
import org.icannt.materialfoundation.common.block.itemblock.ItemBlockMetalPainted;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by ICannt on 29/12/16.
 */
public class ModBlocks {

    public static final BlockCompositeConcrete COMPOSITE_CONCRETE = new BlockCompositeConcrete();

    public static final BlockMetalPlateChecker METAL_PLATE_CHECKER = new BlockMetalPlateChecker();

    public static final BlockMetalPaintedPlateChecker METAL_PAINTED_PLATE_CHECKER = new BlockMetalPaintedPlateChecker();

    public static final BlockMetalPlateScale METAL_PLATE_SCALE = new BlockMetalPlateScale();

    public static final BlockMetalPaintedPlateScale METAL_PAINTED_PLATE_SCALE = new BlockMetalPaintedPlateScale();

    public static final BlockMetalPlateWallStudded METAL_PLATE_WALL_STUDDED = new BlockMetalPlateWallStudded();

    public static final BlockMetalPaintedPlateWallStudded METAL_PAINTED_PLATE_WALL_STUDDED = new BlockMetalPaintedPlateWallStudded();

    public static final BlockMetalCrateWithGrill METAL_CRATE_WITH_GRILL = new BlockMetalCrateWithGrill();

    public static void init() {
        // Blocks
        GameRegistry.register(COMPOSITE_CONCRETE);
        GameRegistry.register(METAL_PLATE_CHECKER);
        GameRegistry.register(METAL_PAINTED_PLATE_CHECKER);
        GameRegistry.register(METAL_PLATE_SCALE);
        GameRegistry.register(METAL_PAINTED_PLATE_SCALE);
        GameRegistry.register(METAL_PLATE_WALL_STUDDED);
        GameRegistry.register(METAL_PAINTED_PLATE_WALL_STUDDED);
        GameRegistry.register(METAL_CRATE_WITH_GRILL);

        // ItemBlocks
        /*
        GameRegistry.register(new ItemBlockComposite(COMPOSITE_CONCRETE).setRegistryName(COMPOSITE_CONCRETE.getRegistryName()));
        GameRegistry.register(new ItemBlockMetal(METAL_PLATE_CHECKER).setRegistryName(METAL_PLATE_CHECKER.getRegistryName()));
        GameRegistry.register(new ItemBlockMetalPainted(METAL_PAINTED_PLATE_CHECKER).setRegistryName(METAL_PAINTED_PLATE_CHECKER.getRegistryName()));
        GameRegistry.register(new ItemBlockMetal(METAL_PLATE_SCALE).setRegistryName(METAL_PLATE_SCALE.getRegistryName()));
        GameRegistry.register(new ItemBlockMetalPainted(METAL_PAINTED_PLATE_SCALE).setRegistryName(METAL_PAINTED_PLATE_SCALE.getRegistryName()));
        GameRegistry.register(new ItemBlockMetal(METAL_PLATE_WALL_STUDDED).setRegistryName(METAL_PLATE_WALL_STUDDED.getRegistryName()));
        GameRegistry.register(new ItemBlockMetalPainted(METAL_PAINTED_PLATE_WALL_STUDDED).setRegistryName(METAL_PAINTED_PLATE_WALL_STUDDED.getRegistryName()));
        */
        registerItemBlock(COMPOSITE_CONCRETE, ItemBlockComposite.class);
        registerItemBlock(METAL_PLATE_CHECKER, ItemBlockMetal.class);
        registerItemBlock(METAL_PAINTED_PLATE_CHECKER, ItemBlockMetalPainted.class);
        registerItemBlock(METAL_PLATE_SCALE, ItemBlockMetal.class);
        registerItemBlock(METAL_PAINTED_PLATE_SCALE, ItemBlockMetalPainted.class);
        registerItemBlock(METAL_PLATE_WALL_STUDDED, ItemBlockMetal.class);
        registerItemBlock(METAL_PAINTED_PLATE_WALL_STUDDED, ItemBlockMetalPainted.class);
        registerItemBlock(METAL_CRATE_WITH_GRILL, ItemBlockMetalMulti.class);

    }

    private static void registerItemBlock(Block block, Class<? extends ItemBlock> clazz) {
        try {
            ItemBlock ib = clazz.getConstructor(Block.class).newInstance(block);
            ib.setRegistryName(block.getRegistryName());
            GameRegistry.register(ib);
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            System.out.println(String.format("Caught exception registering ItemBlock for %s using %s class", block.getRegistryName(), clazz.getName()));
            e.printStackTrace();
        }
    }
}
