package org.icannt.materialfoundation.common.init;

import java.lang.reflect.InvocationTargetException;

import org.icannt.materialfoundation.common.MaterialFoundation;
import org.icannt.materialfoundation.common.block.blocks.BlockCompositeConcrete;
import org.icannt.materialfoundation.common.block.blocks.BlockCompositeWallPlaster;
import org.icannt.materialfoundation.common.block.blocks.BlockCompositeWallPlasterCombo;
import org.icannt.materialfoundation.common.block.blocks.BlockMetalCrateWithGrill;
import org.icannt.materialfoundation.common.block.blocks.BlockMetalCrateWithGrillExtra;
import org.icannt.materialfoundation.common.block.blocks.BlockMetalGrill;
import org.icannt.materialfoundation.common.block.blocks.BlockMetalGrillBox;
import org.icannt.materialfoundation.common.block.blocks.BlockMetalPaintedPlateChecker;
import org.icannt.materialfoundation.common.block.blocks.BlockMetalPaintedPlateFloorStuddedLarge;
import org.icannt.materialfoundation.common.block.blocks.BlockMetalPaintedPlateFloorStuddedMedium;
import org.icannt.materialfoundation.common.block.blocks.BlockMetalPaintedPlateFloorStuddedSmall;
import org.icannt.materialfoundation.common.block.blocks.BlockMetalPaintedPlateScale;
import org.icannt.materialfoundation.common.block.blocks.BlockMetalPaintedPlateWallStudded;
import org.icannt.materialfoundation.common.block.blocks.BlockMetalPlateChecker;
import org.icannt.materialfoundation.common.block.blocks.BlockMetalPlateCrate;
import org.icannt.materialfoundation.common.block.blocks.BlockMetalPlateFloorStuddedLarge;
import org.icannt.materialfoundation.common.block.blocks.BlockMetalPlateFloorStuddedMedium;
import org.icannt.materialfoundation.common.block.blocks.BlockMetalPlateFloorStuddedSmall;
import org.icannt.materialfoundation.common.block.blocks.BlockMetalPlateScale;
import org.icannt.materialfoundation.common.block.blocks.BlockMetalPlateWallStudded;
import org.icannt.materialfoundation.common.block.itemblock.ItemBlockComposite;
import org.icannt.materialfoundation.common.block.itemblock.ItemBlockCompositeWallPlaster;
import org.icannt.materialfoundation.common.block.itemblock.ItemBlockCompositeWallPlasterCombo;
import org.icannt.materialfoundation.common.block.itemblock.ItemBlockMetal;
import org.icannt.materialfoundation.common.block.itemblock.ItemBlockMetalGrill;
import org.icannt.materialfoundation.common.block.itemblock.ItemBlockMetalMulti;
import org.icannt.materialfoundation.common.block.itemblock.ItemBlockMetalMultiExtra;
import org.icannt.materialfoundation.common.block.itemblock.ItemBlockMetalPainted;
import org.icannt.materialfoundation.common.block.itemblock.ItemBlockMetalPlateCrate;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by ICannt on 29/12/16.
 */
public class ModBlocks {

    public static final BlockCompositeConcrete COMPOSITE_CONCRETE = new BlockCompositeConcrete();
    public static final BlockCompositeWallPlaster COMPOSITE_WALL_PLASTER = new BlockCompositeWallPlaster();
    public static final BlockCompositeWallPlasterCombo COMPOSITE_WALL_PLASTER_COMBO = new BlockCompositeWallPlasterCombo();
    // public static final BlockCompositeWallPlasterCombo01 COMPOSITE_WALL_PLASTER_COMBO_01 = new BlockCompositeWallPlasterCombo01(); // TODO: Implement stairwell blocks
    public static final BlockMetalPlateChecker METAL_PLATE_CHECKER = new BlockMetalPlateChecker();
    public static final BlockMetalPaintedPlateChecker METAL_PAINTED_PLATE_CHECKER = new BlockMetalPaintedPlateChecker();
    public static final BlockMetalPlateScale METAL_PLATE_SCALE = new BlockMetalPlateScale();
    public static final BlockMetalPaintedPlateScale METAL_PAINTED_PLATE_SCALE = new BlockMetalPaintedPlateScale();
    public static final BlockMetalPlateFloorStuddedSmall METAL_PLATE_FLOOR_STUDDED_SMALL = new BlockMetalPlateFloorStuddedSmall();
    public static final BlockMetalPaintedPlateFloorStuddedSmall METAL_PAINTED_PLATE_FLOOR_STUDDED_SMALL = new BlockMetalPaintedPlateFloorStuddedSmall();
    public static final BlockMetalPlateFloorStuddedMedium METAL_PLATE_FLOOR_STUDDED_MEDIUM = new BlockMetalPlateFloorStuddedMedium();
    public static final BlockMetalPaintedPlateFloorStuddedMedium METAL_PAINTED_PLATE_FLOOR_STUDDED_MEDIUM = new BlockMetalPaintedPlateFloorStuddedMedium();
    public static final BlockMetalPlateFloorStuddedLarge METAL_PLATE_FLOOR_STUDDED_LARGE = new BlockMetalPlateFloorStuddedLarge();
    public static final BlockMetalPaintedPlateFloorStuddedLarge METAL_PAINTED_PLATE_FLOOR_STUDDED_LARGE = new BlockMetalPaintedPlateFloorStuddedLarge();
    public static final BlockMetalPlateWallStudded METAL_PLATE_WALL_STUDDED = new BlockMetalPlateWallStudded();
    public static final BlockMetalPaintedPlateWallStudded METAL_PAINTED_PLATE_WALL_STUDDED = new BlockMetalPaintedPlateWallStudded();
    public static final BlockMetalGrill METAL_GRILL = new BlockMetalGrill();
    public static final BlockMetalGrillBox METAL_GRILL_BOX = new BlockMetalGrillBox();
    public static final BlockMetalPlateCrate METAL_PLATE_CRATE = new BlockMetalPlateCrate();
    public static final BlockMetalCrateWithGrill METAL_CRATE_WITH_GRILL = new BlockMetalCrateWithGrill();
    public static final BlockMetalCrateWithGrillExtra METAL_CRATE_WITH_GRILL_EXTRA = new BlockMetalCrateWithGrillExtra();
    
    public static void init() {
    	
        // Blocks
        GameRegistry.register(COMPOSITE_CONCRETE);
        GameRegistry.register(COMPOSITE_WALL_PLASTER);
        GameRegistry.register(COMPOSITE_WALL_PLASTER_COMBO);
        // GameRegistry.register(COMPOSITE_WALL_PLASTER_COMBO_01); // TODO: Implement stairwell blocks
        GameRegistry.register(METAL_PLATE_CHECKER);
        GameRegistry.register(METAL_PAINTED_PLATE_CHECKER);
        GameRegistry.register(METAL_PLATE_SCALE);
        GameRegistry.register(METAL_PAINTED_PLATE_SCALE);
        GameRegistry.register(METAL_PLATE_FLOOR_STUDDED_SMALL);
        GameRegistry.register(METAL_PAINTED_PLATE_FLOOR_STUDDED_SMALL);
        GameRegistry.register(METAL_PLATE_FLOOR_STUDDED_MEDIUM);
        GameRegistry.register(METAL_PAINTED_PLATE_FLOOR_STUDDED_MEDIUM);
        GameRegistry.register(METAL_PLATE_FLOOR_STUDDED_LARGE);
        GameRegistry.register(METAL_PAINTED_PLATE_FLOOR_STUDDED_LARGE);
        GameRegistry.register(METAL_PLATE_WALL_STUDDED);
        GameRegistry.register(METAL_PAINTED_PLATE_WALL_STUDDED);
        GameRegistry.register(METAL_GRILL);
        GameRegistry.register(METAL_GRILL_BOX);
        GameRegistry.register(METAL_PLATE_CRATE);
        GameRegistry.register(METAL_CRATE_WITH_GRILL);
        GameRegistry.register(METAL_CRATE_WITH_GRILL_EXTRA);

        // ItemBlocks
        registerItemBlock(COMPOSITE_CONCRETE, ItemBlockComposite.class);
        registerItemBlock(COMPOSITE_WALL_PLASTER, ItemBlockCompositeWallPlaster.class);
        registerItemBlock(COMPOSITE_WALL_PLASTER_COMBO, ItemBlockCompositeWallPlasterCombo.class);
        // registerItemBlock(COMPOSITE_WALL_PLASTER_COMBO_01, ItemBlockCompositeWallPlasterCombo01.class); // TODO: Implement stairwell blocks
        registerItemBlock(METAL_PLATE_CHECKER, ItemBlockMetal.class);
        registerItemBlock(METAL_PAINTED_PLATE_CHECKER, ItemBlockMetalPainted.class);
        registerItemBlock(METAL_PLATE_SCALE, ItemBlockMetal.class);
        registerItemBlock(METAL_PAINTED_PLATE_SCALE, ItemBlockMetalPainted.class);
        registerItemBlock(METAL_PLATE_FLOOR_STUDDED_SMALL, ItemBlockMetal.class);
        registerItemBlock(METAL_PAINTED_PLATE_FLOOR_STUDDED_SMALL, ItemBlockMetalPainted.class);
        registerItemBlock(METAL_PLATE_FLOOR_STUDDED_MEDIUM, ItemBlockMetal.class);
        registerItemBlock(METAL_PAINTED_PLATE_FLOOR_STUDDED_MEDIUM, ItemBlockMetalPainted.class);
        registerItemBlock(METAL_PLATE_FLOOR_STUDDED_LARGE, ItemBlockMetal.class);
        registerItemBlock(METAL_PAINTED_PLATE_FLOOR_STUDDED_LARGE, ItemBlockMetalPainted.class);
        registerItemBlock(METAL_PLATE_WALL_STUDDED, ItemBlockMetal.class);
        registerItemBlock(METAL_PAINTED_PLATE_WALL_STUDDED, ItemBlockMetalPainted.class);
        registerItemBlock(METAL_GRILL, ItemBlockMetalGrill.class);
        registerItemBlock(METAL_GRILL_BOX, ItemBlockMetalGrill.class);
        registerItemBlock(METAL_PLATE_CRATE, ItemBlockMetalPlateCrate.class);
        registerItemBlock(METAL_CRATE_WITH_GRILL, ItemBlockMetalMulti.class);
        registerItemBlock(METAL_CRATE_WITH_GRILL_EXTRA, ItemBlockMetalMultiExtra.class);

    }

    private static void registerItemBlock(Block block, Class<? extends ItemBlock> clazz) {
        try {
            ItemBlock ib = clazz.getConstructor(Block.class).newInstance(block);
            ib.setRegistryName(block.getRegistryName());
            GameRegistry.register(ib);
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            MaterialFoundation.LOGGER.warn(String.format("Caught exception registering ItemBlock for %s using %s class", block.getRegistryName(), clazz.getName()));
            e.printStackTrace();
        }
    }
}
