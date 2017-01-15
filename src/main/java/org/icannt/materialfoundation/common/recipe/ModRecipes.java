package org.icannt.materialfoundation.common.recipe;

import java.util.Locale;

import org.apache.commons.lang3.text.WordUtils;
import org.icannt.materialfoundation.common.block.variant.EnumCompositeType;
import org.icannt.materialfoundation.common.block.variant.EnumMetalGrillType;
import org.icannt.materialfoundation.common.block.variant.EnumMetalMultiType;
import org.icannt.materialfoundation.common.block.variant.EnumMetalPlateCrateType;
import org.icannt.materialfoundation.common.block.variant.EnumMetalType;
import org.icannt.materialfoundation.common.init.ModBlocks;
import org.icannt.materialfoundation.common.init.ModItems;
import org.icannt.materialfoundation.common.item.ItemMetalTinPaint;
import org.icannt.materialfoundation.common.item.variant.EnumGenericType;
import org.icannt.materialfoundation.common.item.variant.EnumPaintType;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

/**
 * Created by ICannt on 23/12/16.
 */
public class ModRecipes {


    public static void registerRecipes() {
    	
        Block resultBlock;        
        Item resultItem;        
        ItemStack crafter = new ItemStack(ModItems.TOOL_FABRICATOR);       
        ItemStack specialItem;        
        String line1 = "";
        String line2 = "";
        String line3 = "";
        String variantName = "";
        ItemStack crateIngredient = null;
        ItemStack grillIngredient = null;

        /****************
         * Item Recipes *
         ****************/
        
        // Fabricator - Crafting Bench
        resultItem = ModItems.TOOL_FABRICATOR;
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultItem),
                "ISI",
                " S ",
                " C ",
                'I', "ingotIron",
                'S', "stickWood",
                'C', Blocks.CARPET
        ));

        // Paint Tin Empty - Crafting Bench
        GameRegistry.addRecipe(new ShapedOreRecipe(ItemMetalTinPaint.create(EnumPaintType.EMPTY),
                "C",
                "I",
                "I",
                'C', crafter,
                'I', "ingotIron"
        ));

        // Paint Tins - Crafting Bench
        // TODO: Needs support for new "dyes", has to be done at the same time as the new paints are added or it will crash
        for (EnumPaintType variant : EnumPaintType.values()) {
        	if (variant != EnumPaintType.EMPTY) {
	            GameRegistry.addRecipe(new ShapelessOreRecipe(ItemMetalTinPaint.create(variant),
	                    "dye" + WordUtils.capitalize(variant.getName().replace("_", " ")).replace(" ", ""),
	                    new ItemStack(ModItems.TIN_METAL_PAINT),
	                    "dustBurntLime"
	            ));
        	}
        }

        // Minerals (Besides Burnt Lime) - Crafting Bench
        for (EnumGenericType variant : EnumGenericType.values()) {
        	if (variant != EnumGenericType.MINERAL_LIME_BURNT) {
		        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.GENERIC, 1, variant.ordinal()),
		                variant.getCraftWith(),
		                "dustBurntLime"
		        ));
        	}
        }
        
        // Burnt Lime - Furnace
        for (ItemStack stack : OreDictionary.getOres("sandstone"))
        {
        	GameRegistry.addSmelting(stack, new ItemStack(ModItems.GENERIC, 6, EnumGenericType.MINERAL_LIME_BURNT.ordinal()), 0.1F);
        }

        
        /*****************
         * Block Recipes *
         *****************/
        
        // Metal Checker Plate - Crafting Bench
        resultBlock = ModBlocks.METAL_PLATE_CHECKER;
        for (EnumMetalType variant : EnumMetalType.values()) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 8, variant.ordinal()),
                    "XXY",
                    "XX ",
                    'X', "ingot" + WordUtils.capitalize(variant.getName()),
                    'Y', crafter
            ));
        }

        // Metal Scale Checker Plate - Crafting Bench
        resultBlock = ModBlocks.METAL_PLATE_WALL_STUDDED;
        for (EnumMetalType variant : EnumMetalType.values()) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 8, variant.ordinal()),
                    "XX ",
                    "XXY",
                    'X', "ingot" + WordUtils.capitalize(variant.getName()),
                    'Y', crafter
            ));
        }

        // Metal Studded Wall Plate - Crafting Bench
        resultBlock = ModBlocks.METAL_PLATE_SCALE;
        for (EnumMetalType variant : EnumMetalType.values()) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 8, variant.ordinal()),
                    "YXX",
                    " XX",
                    'X', "ingot" + WordUtils.capitalize(variant.getName()),
                    'Y', crafter
            ));
        }

        // Metal Grill - Crafting Bench
    	// TODO: Only covers iron and gold so far, other round grills will be a shapeless craft with the right paint and an already made iron grill, "lapis" is just blue paint
    	// TODO: Square grills will require paint on creation as there is no "plain" variant, light or dark only, so it needs to be shaped, on top of the iron ingot
        resultBlock = ModBlocks.METAL_GRILL;
        for (EnumMetalGrillType variant : EnumMetalGrillType.values()) {
        	variantName = variant.getName().replace("round_offset_", "").replace("square_angled_", "");
        	switch (variantName) {
        		case "gold":
        		case "iron":
		            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 12, variant.ordinal()),
		                    "YX",
		                    'X', "ingot" + WordUtils.capitalize(variantName),
		                    'Y', crafter
		            ));
		            break;
        		case "blaze":
        		case "lapis":
        		case "slime":
        			// TODO: Need code here for painted round grill recipes
        			break;
        		case "dark":
        		case "light":
        			// TODO: Need code here for painted square grill recipes
        	}
        }
        
        // Metal Crate Plate - Crafting Bench
        // TODO: Only covers dark steel, iron and tin so far, fluxed will be a shapeless craft with fluxed paint and an already made iron plate
        resultBlock = ModBlocks.METAL_PLATE_CRATE;
        for (EnumMetalPlateCrateType variant : EnumMetalPlateCrateType.values()) {
        	variantName = variant.getName();
        	switch (variantName) {
        		case "dark_steel":
        		case "iron":
        		case "tin":
		            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 2, variant.ordinal()),
		                    "Y",
		                    "X",
		                    'X', "ingot" +  WordUtils.capitalize(variantName.replace("_", " ")).replace(" ", ""),
		                    'Y', crafter
		            ));
		            break;
        		case "fluxed":
        			// TODO: Need code here for fluxed crate plate recipe
        	}
        }
        
        resultBlock = ModBlocks.METAL_CRATE_WITH_GRILL;
        for (EnumMetalMultiType variant : EnumMetalMultiType.values()) {
        	variantName = variant.getName();
        	switch (variantName) {
        		case "iron":
        			crateIngredient = new ItemStack(ModBlocks.METAL_PLATE_CRATE, 1, EnumMetalPlateCrateType.IRON.ordinal());
        			grillIngredient = new ItemStack(ModBlocks.METAL_GRILL, 1, EnumMetalGrillType.ROUND_OFFSET_IRON.ordinal());
        			break;
        		case "iron_gold":
        			crateIngredient = new ItemStack(ModBlocks.METAL_PLATE_CRATE, 1, EnumMetalPlateCrateType.IRON.ordinal());
        			grillIngredient = new ItemStack(ModBlocks.METAL_GRILL, 1, EnumMetalGrillType.ROUND_OFFSET_GOLD.ordinal());
        			break;
        		case "tin_iron":
        			crateIngredient = new ItemStack(ModBlocks.METAL_PLATE_CRATE, 1, EnumMetalPlateCrateType.TIN.ordinal());
        			grillIngredient = new ItemStack(ModBlocks.METAL_GRILL, 1, EnumMetalGrillType.ROUND_OFFSET_IRON.ordinal());
        			break;
        		case "fluxed_gold":
        			crateIngredient = new ItemStack(ModBlocks.METAL_PLATE_CRATE, 1, EnumMetalPlateCrateType.FLUXED.ordinal());
        			grillIngredient = new ItemStack(ModBlocks.METAL_GRILL, 1, EnumMetalGrillType.ROUND_OFFSET_GOLD.ordinal());
        			break;
        		case "dark_steel_blaze":
        		case "dark_steel_lapis":
        		case "dark_steel_slime":
        			crateIngredient = new ItemStack(ModBlocks.METAL_PLATE_CRATE, 1, EnumMetalPlateCrateType.DARK_STEEL.ordinal());
        			variantName = variantName.replace("dark_steel_", "round_offset_").toUpperCase(Locale.ENGLISH);
        			grillIngredient = new ItemStack(ModBlocks.METAL_GRILL, 1, EnumMetalGrillType.valueOf(variantName).ordinal());
        	}
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 2, variant.ordinal()),
                    "YYY",
                    " X ",
                    "YYY",
                    'X', crateIngredient,
                    'Y', grillIngredient
            ));
        }
                
        // Composite Concrete - Crafting Bench
        // TODO: Final recipe uses the square grills, not paints to make the reinforced concrete
        RecipeSorter.register("materialfoundation:compositerecipe", CompositeConcreteRecipe.class, RecipeSorter.Category.SHAPED, "after:forge:shaped before:minecraft:shapeless");
        resultBlock = ModBlocks.COMPOSITE_CONCRETE;
        for (EnumCompositeType variant : EnumCompositeType.values()) {
            line1 = "SQS";
            switch (variant) {
                case REINFORCED_GRATING_DARK:
                case REINFORCED_GRATING_LIGHT:
                    specialItem = new ItemStack(ModItems.TIN_METAL_PAINT);
                    specialItem.setItemDamage(OreDictionary.WILDCARD_VALUE);
                    break;
                default:
                    specialItem = new ItemStack(Blocks.AIR);
                    line1 = "S S";
                    break;
            }
            GameRegistry.addRecipe(new CompositeConcreteRecipe(new ItemStack(resultBlock, 12, variant.ordinal()),
                    line1,
                    "BWB",
                    "GCG",
                    'Q', specialItem,
                    'W', Items.WATER_BUCKET,
                    'S', "sand",
                    'G', "gravel",
                    'C', Items.CLAY_BALL,
                    'B', "dustBurntLime"
            ));
        }
    }
}
