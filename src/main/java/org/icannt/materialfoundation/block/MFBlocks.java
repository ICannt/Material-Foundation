package org.icannt.materialfoundation.block;

import org.icannt.materialfoundation.lib.Constants;
import org.icannt.materialfoundation.lib.MFMaterial;

import net.minecraftforge.fml.common.registry.GameRegistry;

import net.minecraft.item.ItemBlock;
import net.minecraft.block.Block;

/**
 * Created by trab
 */

public final class MFBlocks
{
	
    public static final BlockMetalPlateChecker blockMetalPlateChecker = new BlockMetalPlateChecker
    (
        	"Metal", "Plate", "Checker", MFMaterial.Metal, MFMaterial.MetalLight,
        	MFMaterial.MetalHardness, MFMaterial.MetalResistance, MFMaterial.MetalRarity
    );
    
    public static final BlockMetalPlateScaleChecker blockMetalPlateScaleChecker = new BlockMetalPlateScaleChecker
    (
        	"Metal", "Plate", "Scale_Side:Checker", MFMaterial.Metal, MFMaterial.MetalLight,
        	MFMaterial.MetalHardness, MFMaterial.MetalResistance, MFMaterial.MetalRarity
    );
    
    public static final BlockMetalPlateScaleScale blockMetalPlateScaleScale = new BlockMetalPlateScaleScale
    (
        	"Metal", "Plate", "Scale_Side:Scale_TopBottom", MFMaterial.Metal, MFMaterial.MetalLight,
        	MFMaterial.MetalHardness, MFMaterial.MetalResistance, MFMaterial.MetalRarity
    );

    public static final BlockCompositeConcreteWall blockCompositeConcreteWall = new BlockCompositeConcreteWall
    (
        	"Composite", "Concrete", "Wall", MFMaterial.Composite, MFMaterial.CompositeLight,
        	MFMaterial.CompositeHardness, MFMaterial.CompositeResistance, MFMaterial.CompositeRarity
    );

    public static void init()
	{
        GameRegistry.registerBlock(blockMetalPlateChecker, ItemBlockMetalPlateChecker.class, "blockMetalPlateChecker");
        GameRegistry.registerBlock(blockMetalPlateScaleChecker, ItemBlockMetalPlateScaleChecker.class, "blockMetalPlateScaleChecker");
        GameRegistry.registerBlock(blockMetalPlateScaleScale, ItemBlockMetalPlateScaleScale.class, "blockMetalPlateScaleScale");
        GameRegistry.registerBlock(blockCompositeConcreteWall, ItemBlockCompositeConcreteWall.class, "blockCompositeConcreteWall");
	}
}