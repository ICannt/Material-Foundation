package org.icannt.materialfoundation.recipe;

import org.icannt.materialfoundation.block.MFBlocks;
import org.icannt.materialfoundation.item.MFItems;
import org.icannt.materialfoundation.lib.DB;
import org.icannt.materialfoundation.lib.MFMaterial;

import net.minecraftforge.fml.common.registry.GameRegistry;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by trab
 */

public class MFRecipes
{
	public static void init()
	{
		
		Block result = MFBlocks.blockMetalPlateChecker;
		String mIngot = "ingot";
		String mMetal[] = MFMaterial.Metal;
		String mComposite[] = MFMaterial.Composite;
		String mCurrent = "";
		ItemStack crafter = new ItemStack(MFItems.mfBlockFabricator, 1, -1);
		
		for (int i = 0; i < mMetal.length; i++)
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(result, 1, i), false, new Object[]
			{
		        "XXY",
		        "XX ",
		        Character.valueOf('X'), mIngot + mMetal[i],
		        Character.valueOf('Y'), crafter
	        }));
		}
		
		result = MFBlocks.blockMetalPlateScaleChecker;
		
		for (int i = 0; i < mMetal.length; i++)
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(result, 1, i), false, new Object[]
			{
		        "XX ",
		        "XXY",
		        Character.valueOf('X'), mIngot + mMetal[i],
		        Character.valueOf('Y'), crafter
	        }));
		}

		result = MFBlocks.blockMetalPlateScaleScale;
		
		for (int i = 0; i < mMetal.length; i++)
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(result, 1, i), false, new Object[]
			{
		        "YXX",
		        " XX",
		        Character.valueOf('X'), mIngot + mMetal[i],
		        Character.valueOf('Y'), crafter
	        }));
		}
		
		result = MFBlocks.blockCompositeConcreteWall;
		
		for (int i = 0; i < mComposite.length; i++)
		{
			//mCurrent = mComposite[i] != "Basic" ? mComposite[i] : "";
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(result, 12, i), false, new Object[]
			{
		        "SCS",
				"BWB",
				"GCG",
		        Character.valueOf('W'), Items.WATER_BUCKET,
		        Character.valueOf('S'), Blocks.SAND,
		        Character.valueOf('G'), Blocks.GRAVEL,
		        Character.valueOf('C'), Items.CLAY_BALL,
		        Character.valueOf('B'), MFItems.mineralBurntLime
	        }));
			// Future Idea - more advanced process to produce concrete faster, will require a Burnt Lime Block, which would be a caustic material 
			/*
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(result, 16, i), false, new Object[]
			{
		        "SCS",
				"BWB",
				"GCG",
		        Character.valueOf('W'), Items.water_bucket,
		        Character.valueOf('S'), Blocks.sandstone,
		        Character.valueOf('G'), Blocks.cobblestone,
		        Character.valueOf('C'), Items.clay_ball,
		        Character.valueOf('B'), MFItems.mineralBurntLime
	        }));
	        */
		}
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MFItems.mfBlockFabricator, 1, 0), true, new Object[]
		{
	        "ISI",
	        " S ",
	        " C ",
	        Character.valueOf('I'), "ingotIron",
	        Character.valueOf('S'), "stickWood",
	        Character.valueOf('C'), Blocks.CARPET	        
        }));
		
		
		/*
		 *   --- SMELTING --- 
		 */
		
		GameRegistry.addSmelting(Blocks.SANDSTONE, new ItemStack(MFItems.mineralBurntLime, 8, 0), 0.1F);
		
	}
}
