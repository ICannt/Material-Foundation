package org.icannt.materialfoundation.common.recipe;

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
import org.apache.commons.lang3.text.WordUtils;
import org.icannt.materialfoundation.common.block.variant.*;
import org.icannt.materialfoundation.common.init.ModBlocks;
import org.icannt.materialfoundation.common.init.ModItems;
import org.icannt.materialfoundation.common.item.ItemMetalTinPaint;
import org.icannt.materialfoundation.common.item.variant.EnumGenericType;
import org.icannt.materialfoundation.common.item.variant.EnumPaintType;
import org.icannt.materialfoundation.common.recipe.paint.PaintTinRecipe;
import org.icannt.materialfoundation.common.recipe.paint.ShapedPaintRecipe;
import org.icannt.materialfoundation.common.recipe.paint.ShapelessPaintRecipe;

import java.util.Locale;

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
        String variantName = "";
        ItemStack crateIngredient = null;
        ItemStack grillIngredient = null;

        
        /***********************
         * Recipe Registration *
         ***********************/

        RecipeSorter.register("materialfoundation:paint_tin", PaintTinRecipe.class, RecipeSorter.Category.SHAPELESS, "after:forge:shapeless after:minecraft:shapeless");
        RecipeSorter.register("materialfoundation:shapeless_painted", ShapelessPaintRecipe.class, RecipeSorter.Category.SHAPELESS, "after:forge:shapeless after:minecraft:shapeless");
        RecipeSorter.register("materialfoundation:shaped_painted", ShapedPaintRecipe.class, RecipeSorter.Category.SHAPED, "after:forge:shaped after:minecraft:shaped");

        
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


        // Paint Tins - Crafting Bench Shapeless
        for (EnumPaintType colour : EnumPaintType.values()) {
            if (colour == EnumPaintType.EMPTY)
                continue;
            GameRegistry.addRecipe(new PaintTinRecipe(colour));
        }

        // Minerals (Besides Burnt Lime) - Crafting Bench Shapeless
        for (EnumGenericType variant : EnumGenericType.values()) {
            if (variant == EnumGenericType.MINERAL_LIME_BURNT)
                continue;
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.GENERIC, 1, variant.ordinal()),
            	variant.getCraftWith(),
            	"dustBurntLime"
            ));
        }
        
        // Burnt Lime - Furnace
        for (ItemStack stack : OreDictionary.getOres("sandstone"))
        {
        	GameRegistry.addSmelting(stack, new ItemStack(ModItems.GENERIC, 6, EnumGenericType.MINERAL_LIME_BURNT.ordinal()), 0.1F);
        }

        
        /*****************
         * Block Recipes *
         *****************/
        
        // Metal Checker Plate - Crafting Bench Shaped
        resultBlock = ModBlocks.METAL_PLATE_CHECKER;
        for (EnumMetalType variant : EnumMetalType.values()) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 8, variant.ordinal()),
            	"XXY",
            	"XX ",
            	'X', "ingot" + WordUtils.capitalize(variant.getName()),
            	'Y', crafter
            ));
        }

        // Painted Metal Checker Plate - Crafting Bench Shapeless
        for (EnumMetalPaintedType type : EnumMetalPaintedType.values()) {
            GameRegistry.addRecipe(new ShapelessPaintRecipe(new ItemStack(ModBlocks.METAL_PAINTED_PLATE_CHECKER, 1, type.ordinal()), type.getPaintColour(), new Object[] {
            	new ItemStack(ModBlocks.METAL_PLATE_CHECKER, 1, EnumMetalType.IRON.ordinal()),
            	ItemMetalTinPaint.create(type.getPaintColour(), true)
            }));
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

        // Painted Metal Scale Checker Plate - Crafting Bench Shapeless
        for (EnumMetalPaintedType type : EnumMetalPaintedType.values()) {
            GameRegistry.addRecipe(new ShapelessPaintRecipe(new ItemStack(ModBlocks.METAL_PAINTED_PLATE_SCALE, 1, type.ordinal()), type.getPaintColour(), new Object[] {
            	new ItemStack(ModBlocks.METAL_PLATE_SCALE, 1, EnumMetalType.IRON.ordinal()),
            	ItemMetalTinPaint.create(type.getPaintColour(), true)
            }));
        }

        // Metal Studded Wall Plate - Crafting Bench Shaped
        resultBlock = ModBlocks.METAL_PLATE_SCALE;
        for (EnumMetalType variant : EnumMetalType.values()) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 8, variant.ordinal()),
                "YXX",
                " XX",
                'X', "ingot" + WordUtils.capitalize(variant.getName()),
                'Y', crafter
            ));
        }

        // Painted Studded Wall Plate - Crafting Bench Shapeless
        for (EnumMetalPaintedType type : EnumMetalPaintedType.values()) {
            GameRegistry.addRecipe(new ShapelessPaintRecipe(new ItemStack(ModBlocks.METAL_PAINTED_PLATE_WALL_STUDDED, 1, type.ordinal()), type.getPaintColour(), new Object[] {
            	new ItemStack(ModBlocks.METAL_PLATE_WALL_STUDDED, 1, EnumMetalType.IRON.ordinal()),
            	ItemMetalTinPaint.create(type.getPaintColour(), true)
            }));
        }

        // Metal Grill - Crafting Bench Shaped
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
                    GameRegistry.addRecipe(new ShapelessPaintRecipe(new ItemStack(resultBlock, 1, variant.ordinal()), EnumPaintType.BLAZE, new Object[] {
                    	new ItemStack(ModBlocks.METAL_GRILL, 1, EnumMetalGrillType.ROUND_OFFSET_IRON.ordinal()),
                    	ItemMetalTinPaint.create(EnumPaintType.BLAZE, true)
                    }));
        		    break;
        		case "lapis":
                    GameRegistry.addRecipe(new ShapelessPaintRecipe(new ItemStack(resultBlock, 1, variant.ordinal()), EnumPaintType.BLUE, new Object[] {
                    	new ItemStack(ModBlocks.METAL_GRILL, 1, EnumMetalGrillType.ROUND_OFFSET_IRON.ordinal()),
                    	ItemMetalTinPaint.create(EnumPaintType.BLUE, true)
                    }));
                    break;
        		case "slime":
        		    GameRegistry.addRecipe(new ShapedPaintRecipe(new ItemStack(resultBlock, 12, variant.ordinal()), EnumPaintType.SLIME, new Object[] {
        		    	new ItemStack(ModItems.TOOL_FABRICATOR), "ingotIron", ItemMetalTinPaint.create(EnumPaintType.SLIME, true),
        		    	null, null, null,
        		    	null, null, null
                    }));
        			break;
        		case "dark":
                    GameRegistry.addRecipe(new ShapedPaintRecipe(new ItemStack(resultBlock, 12, variant.ordinal()), EnumPaintType.BLACK, new Object[] {
                    	new ItemStack(ModItems.TOOL_FABRICATOR), "ingotIron", ItemMetalTinPaint.create(EnumPaintType.BLACK, true),
                    	null, null, null,
                    	null, null, null
                    }));
                    break;
        		case "light":
                    GameRegistry.addRecipe(new ShapedPaintRecipe(new ItemStack(resultBlock, 12, variant.ordinal()), EnumPaintType.WHITE, new Object[] {
                    	new ItemStack(ModItems.TOOL_FABRICATOR), "ingotIron", ItemMetalTinPaint.create(EnumPaintType.WHITE, true),
                    	null, null, null,
                    	null, null, null
                    }));
                    break;
        	}
        }
        
        // Metal Crate Plate - Crafting Bench Shaped
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
        		    GameRegistry.addRecipe(new ShapelessPaintRecipe(new ItemStack(resultBlock, 2, variant.ordinal()), EnumPaintType.FLUXED, new Object[] {
        		    	new ItemStack(ModBlocks.METAL_PLATE_CRATE, 1, EnumMetalPlateCrateType.IRON.ordinal()),
    		    		ItemMetalTinPaint.create(EnumPaintType.FLUXED, true)
    		    		}));
        		    break;
        	}
        }

        // Metal Crate with Grill - Crafting Bench Shaped
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
                
        // Composite Concrete - Crafting Bench Shaped
        resultBlock = ModBlocks.COMPOSITE_CONCRETE;
        for (EnumCompositeType variant : EnumCompositeType.values()) {
            line1 = "SQS";
            switch (variant) {
                case REINFORCED_GRATING_DARK:
                    specialItem = new ItemStack(ModBlocks.METAL_GRILL, 1, EnumMetalGrillType.SQUARE_ANGLED_DARK.ordinal());
                    break;
                case REINFORCED_GRATING_LIGHT:
                    specialItem = new ItemStack(ModBlocks.METAL_GRILL, 1, EnumMetalGrillType.SQUARE_ANGLED_LIGHT.ordinal());
                    break;
                default:
                    specialItem = new ItemStack(Blocks.AIR);
                    line1 = "S S";
                    break;
            }
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 12, variant.ordinal()),
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
