package org.icannt.materialfoundation.common.recipe;

import java.util.Locale;

import org.apache.commons.lang3.text.WordUtils;
import org.icannt.materialfoundation.common.block.variant.EnumCompositeType;
import org.icannt.materialfoundation.common.block.variant.EnumMetalGrillType;
import org.icannt.materialfoundation.common.block.variant.EnumMetalMultiExtraType;
import org.icannt.materialfoundation.common.block.variant.EnumMetalMultiType;
import org.icannt.materialfoundation.common.block.variant.EnumMetalPaintedType;
import org.icannt.materialfoundation.common.block.variant.EnumMetalPlateCrateType;
import org.icannt.materialfoundation.common.block.variant.EnumMetalType;
import org.icannt.materialfoundation.common.init.ModBlocks;
import org.icannt.materialfoundation.common.init.ModItems;
import org.icannt.materialfoundation.common.item.ItemMetalTinPaint;
import org.icannt.materialfoundation.common.item.variant.EnumGenericType;
import org.icannt.materialfoundation.common.item.variant.EnumPaintType;
import org.icannt.materialfoundation.common.recipe.paint.PaintTinRecipe;
import org.icannt.materialfoundation.common.recipe.paint.ShapedPaintRecipe;
import org.icannt.materialfoundation.common.recipe.paint.ShapelessPaintRecipe;

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
    	
        Block resultBlock; // Used at the start of each block recipe to refer to the recipe result
        Item resultItem; // Used at the start of each item recipe to refer to the recipe result
        ItemStack crafter = new ItemStack(ModItems.TOOL_FABRICATOR); // The MF Fabricator, used in a large amount of recipes
        String variantName = ""; // Temp variant name used for string transformations
        String paintName = ""; // Temp paint name used for string transformations
        ItemStack ing1; // Ingredient temp ItemStack 1
        ItemStack ing2; // Ingredient temp ItemStack 2
        ItemStack ing3; // Ingredient temp ItemStack 3
        EnumPaintType paint = null; // Ingredient temp paint enum variant
        Block[] studdedBlocks = { ModBlocks.METAL_PLATE_WALL_STUDDED, ModBlocks.METAL_PLATE_FLOOR_STUDDED_SMALL, ModBlocks.METAL_PLATE_FLOOR_STUDDED_MEDIUM, ModBlocks.METAL_PLATE_FLOOR_STUDDED_LARGE };
        Block[] paintedStuddedBlocks = { ModBlocks.METAL_PAINTED_PLATE_WALL_STUDDED, ModBlocks.METAL_PAINTED_PLATE_FLOOR_STUDDED_SMALL, ModBlocks.METAL_PAINTED_PLATE_FLOOR_STUDDED_MEDIUM, ModBlocks.METAL_PAINTED_PLATE_FLOOR_STUDDED_LARGE };

        
        /***********************
         * Recipe Registration *
         ***********************/

        RecipeSorter.register("materialfoundation:paint_tin", PaintTinRecipe.class, RecipeSorter.Category.SHAPELESS, "after:forge:shapeless after:minecraft:shapeless");
        RecipeSorter.register("materialfoundation:shapeless_painted", ShapelessPaintRecipe.class, RecipeSorter.Category.SHAPELESS, "after:forge:shapeless after:minecraft:shapeless");
        RecipeSorter.register("materialfoundation:shaped_painted", ShapedPaintRecipe.class, RecipeSorter.Category.SHAPED, "after:forge:shaped after:minecraft:shaped");

        
        /****************
         * Item Recipes *
         ****************/
        
        // Fabricator - Crafting Bench Shaped
        resultItem = ModItems.TOOL_FABRICATOR;
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultItem),
        	"ISI",
        	" S ",
        	" C ",
        	'I', "ingotIron",
        	'S', "stickWood",
        	'C', Blocks.CARPET
        ));

        // Paint Tin Empty - Crafting Bench Shaped
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.METAL_TIN_PAINT_EMPTY),
        	"C",
        	"I",
        	"I",
        	'C', crafter,
        	'I', "ingotIron"
        ));

        // Paint Tins (currently hardcoded in the PaintTinRecipe class) - Crafting Bench Shapeless
        for (EnumPaintType colour : EnumPaintType.values()) {
            GameRegistry.addRecipe(new PaintTinRecipe(colour));
        }

        // Minerals (Besides Burnt Lime & Cement Clinker) - Crafting Bench Shapeless
        for (EnumGenericType variant : EnumGenericType.values()) {
        	variantName = variant.getName();
        	switch (variantName) {
        		case "mineral_burnt_lime":
        		case "mineral_clinker_cement":
        			continue;
        		case "mineral_cement_portland":
                    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.GENERIC, 1, variant.ordinal()),
                    	"XYX",
                    	"XXX",
                    	"XXX",
                    	'X', "dustCementClinker",
                    	'Y', crafter
                    ));
	                break;	                
                default:
		            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.GENERIC, 2, variant.ordinal()),
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

        // Cement Clinker - Furnace
        GameRegistry.addSmelting(Blocks.HARDENED_CLAY, new ItemStack(ModItems.GENERIC, 1, EnumGenericType.MINERAL_CLINKER_CEMENT.ordinal()), 0.1F);
        GameRegistry.addSmelting(Blocks.STAINED_HARDENED_CLAY, new ItemStack(ModItems.GENERIC, 1, EnumGenericType.MINERAL_CLINKER_CEMENT.ordinal()), 0.1F);
        
        
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
        resultBlock = ModBlocks.METAL_PAINTED_PLATE_CHECKER;
        for (EnumMetalPaintedType type : EnumMetalPaintedType.values()) {
            GameRegistry.addRecipe(new ShapelessPaintRecipe(new ItemStack(resultBlock, 1, type.ordinal()), type.getPaintColour(), new Object[] {
            	new ItemStack(ModBlocks.METAL_PLATE_CHECKER, 1, EnumMetalType.IRON.ordinal()),
            	ItemMetalTinPaint.create(type.getPaintColour(), true)
            }));
        }

        // Metal Scale Checker Plate - Crafting Bench Shaped
        resultBlock = ModBlocks.METAL_PLATE_SCALE;
        for (EnumMetalType variant : EnumMetalType.values()) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 8, variant.ordinal()),
                "YXX",
                " XX",
                'X', "ingot" + WordUtils.capitalize(variant.getName()),
                'Y', crafter
            ));
        }
        
        // Painted Metal Scale Plate - Crafting Bench Shapeless
        resultBlock = ModBlocks.METAL_PAINTED_PLATE_SCALE;
        for (EnumMetalPaintedType type : EnumMetalPaintedType.values()) {
            GameRegistry.addRecipe(new ShapelessPaintRecipe(new ItemStack(resultBlock, 1, type.ordinal()), type.getPaintColour(), new Object[] {
            	new ItemStack(ModBlocks.METAL_PLATE_SCALE, 1, EnumMetalType.IRON.ordinal()),
            	ItemMetalTinPaint.create(type.getPaintColour(), true)
            }));
        }

        // Metal Studded Wall Plate - Crafting Bench Shaped
        resultBlock = ModBlocks.METAL_PLATE_WALL_STUDDED;
        for (EnumMetalType variant : EnumMetalType.values()) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 8, variant.ordinal()),
            	"XX ",
            	"XXY",
            	'X', "ingot" + WordUtils.capitalize(variant.getName()),
            	'Y', crafter
            ));
        }
        for (Block craftBlock : studdedBlocks) {
        	if (resultBlock == craftBlock)
        		continue;
	        for (EnumMetalType variant : EnumMetalType.values()) {
	            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 1, variant.ordinal()),
	            	"X",
	            	"Y",
	            	'X', new ItemStack(craftBlock, 1, variant.ordinal()),
	            	'Y', crafter
	            ));
	        }
        }

        // Painted Studded Wall Plate - Crafting Bench Shapeless
        resultBlock = ModBlocks.METAL_PAINTED_PLATE_WALL_STUDDED;
        for (EnumMetalPaintedType type : EnumMetalPaintedType.values()) {
            GameRegistry.addRecipe(new ShapelessPaintRecipe(new ItemStack(resultBlock, 1, type.ordinal()), type.getPaintColour(), new Object[] {
            	new ItemStack(ModBlocks.METAL_PLATE_WALL_STUDDED, 1, EnumMetalType.IRON.ordinal()),
            	ItemMetalTinPaint.create(type.getPaintColour(), true)
            }));
        }
        for (Block craftBlock : paintedStuddedBlocks) {
        	if (resultBlock == craftBlock)
        		continue;
	        for (EnumMetalPaintedType variant : EnumMetalPaintedType.values()) {
	            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 1, variant.ordinal()),
	            	"Y",
	            	"X",
	            	'X', new ItemStack(craftBlock, 1, variant.ordinal()),
	            	'Y', crafter
	            ));
	        }
        } 
        
        // Metal Studded Floor Plate Small - Crafting Bench Shaped
        resultBlock = ModBlocks.METAL_PLATE_FLOOR_STUDDED_SMALL;
        for (Block craftBlock : studdedBlocks) {
        	if (resultBlock == craftBlock)
        		continue;
	        for (EnumMetalType variant : EnumMetalType.values()) {
	            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 1, variant.ordinal()),
	            	"Y",
	            	"X",
	            	'X', new ItemStack(craftBlock, 1, variant.ordinal()),
	            	'Y', crafter
	            ));
	        }
        }

        // Painted Studded Floor Plate Small - Crafting Bench Shaped
        resultBlock = ModBlocks.METAL_PAINTED_PLATE_FLOOR_STUDDED_SMALL;
        for (Block craftBlock : paintedStuddedBlocks) {
        	if (resultBlock == craftBlock)
        		continue;
	        for (EnumMetalPaintedType variant : EnumMetalPaintedType.values()) {
	            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 1, variant.ordinal()),
	            	"Y",
	            	"X",
	            	'X', new ItemStack(craftBlock, 1, variant.ordinal()),
	            	'Y', crafter
	            ));
	        }
        }        
                
        // Metal Studded Floor Plate Medium - Crafting Bench Shaped
        resultBlock = ModBlocks.METAL_PLATE_FLOOR_STUDDED_MEDIUM;
        for (Block craftBlock : studdedBlocks) {
        	if (resultBlock == craftBlock)
        		continue;
	        for (EnumMetalType variant : EnumMetalType.values()) {
	            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 1, variant.ordinal()),
	            	" Y",
	            	"X ",
	            	'X', new ItemStack(craftBlock, 1, variant.ordinal()),
	            	'Y', crafter
	            ));
	        }
        }
        
        // Painted Studded Floor Plate Medium - Crafting Bench Shaped
        resultBlock = ModBlocks.METAL_PAINTED_PLATE_FLOOR_STUDDED_MEDIUM;
        for (Block craftBlock : paintedStuddedBlocks) {
        	if (resultBlock == craftBlock)
        		continue;
	        for (EnumMetalPaintedType variant : EnumMetalPaintedType.values()) {
	            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 1, variant.ordinal()),
	            	" Y",
	            	"X ",
	            	'X', new ItemStack(craftBlock, 1, variant.ordinal()),
	            	'Y', crafter
	            ));
	        }
        }       
        
        // Metal Studded Floor Plate Large - Crafting Bench Shaped
        resultBlock = ModBlocks.METAL_PLATE_FLOOR_STUDDED_LARGE;
        for (Block craftBlock : studdedBlocks) {
        	if (resultBlock == craftBlock)
        		continue;
	        for (EnumMetalType variant : EnumMetalType.values()) {
	            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 1, variant.ordinal()),
	            	"XY",
	            	'X', new ItemStack(craftBlock, 1, variant.ordinal()),
	            	'Y', crafter
	            ));
	        }
        }
        
        // Painted Studded Floor Plate Large - Crafting Bench Shaped
        resultBlock = ModBlocks.METAL_PAINTED_PLATE_FLOOR_STUDDED_LARGE;
        for (Block craftBlock : studdedBlocks) {
        	if (resultBlock == craftBlock)
        		continue;
	        for (EnumMetalPaintedType variant : EnumMetalPaintedType.values()) {
	            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 1, variant.ordinal()),
	            	"XY",
	            	'X', new ItemStack(craftBlock, 1, variant.ordinal()),
	            	'Y', crafter
	            ));
	        }
        }     
        
        
        // Metal Grill - Crafting Bench Shaped and Shapeless
        resultBlock = ModBlocks.METAL_GRILL;
        for (EnumMetalGrillType variant : EnumMetalGrillType.values()) {
        	// Remove the grill type from the description, makes the switch statement and ingots simpler
        	variantName = variant.getName().replace("round_offset_", "").replace("square_angled_", "");
        	// Paint names already match some of the materials, only replace ones that don't match then capitalise to get the right Enum
        	paintName = variantName.replace("lapis", "blue").replace("dark", "black").replace("light", "white").toUpperCase(Locale.ENGLISH);
        	switch (variantName) {
        		case "gold":
        		case "iron":
        			// Pure metal grills, paint not needed
		            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 12, variant.ordinal()),
		            	"YX",
		            	'X', "ingot" + WordUtils.capitalize(variantName),
		            	'Y', crafter
		            ));
		            break;
        		case "blaze":
        		case "lapis":
        		case "slime":
        			// Only set the actual paint when we are not dealing with metals
        			paint = EnumPaintType.valueOf(paintName);
        			// Paint goes above ingot, crafter to the left
                    GameRegistry.addRecipe(new ShapedPaintRecipe(new ItemStack(resultBlock, 12, variant.ordinal()), paint, new Object[] {
                       	null, ItemMetalTinPaint.create(paint, true), null,
                    	crafter, "ingotIron", null,
                       	null, null, null
                    }));
                    break;
        		case "dark":
        		case "light":
        			// Only set the actual paint when we are not dealing with metals
        			paint = EnumPaintType.valueOf(paintName);
        			// Paint goes above ingot, crafter to the left
                    GameRegistry.addRecipe(new ShapedPaintRecipe(new ItemStack(resultBlock, 12, variant.ordinal()), paint, new Object[] {
                    	crafter, ItemMetalTinPaint.create(paint, true), null,
                    	null, "ingotIron", null,
                       	null, null, null
                    }));
                    break;
        	}
        	// Shapeless with already made iron grills, uses much more paint!
        	switch (variantName) {
	    		case "blaze":
	    		case "lapis":
	    		case "slime":
        			paint = EnumPaintType.valueOf(paintName);
                    GameRegistry.addRecipe(new ShapelessPaintRecipe(new ItemStack(resultBlock, 1, variant.ordinal()), paint, new Object[] {
                    	new ItemStack(ModBlocks.METAL_GRILL, 1, EnumMetalGrillType.ROUND_OFFSET_IRON.ordinal()),
                    	ItemMetalTinPaint.create(paint, true)
                    }));
                    break;
        	}
        }
        
        // Metal Grill Box - Shapeless, also includes going back to grills
        for (EnumMetalGrillType variant : EnumMetalGrillType.values()) {
        	ing1 = new ItemStack(ModBlocks.METAL_GRILL, 1, variant.ordinal());
        	ing2 = new ItemStack(ModBlocks.METAL_GRILL_BOX, 1, variant.ordinal());
            GameRegistry.addRecipe(new ShapelessOreRecipe(ing2,
        		ing1, ing1, ing1, ing1, ing1, ing1
        	));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.METAL_GRILL, 6, variant.ordinal()),
        		ing2
        	));
        }

        // Metal Crate Plate - Crafting Bench Shaped and Shapeless
        resultBlock = ModBlocks.METAL_PLATE_CRATE;
        for (EnumMetalPlateCrateType variant : EnumMetalPlateCrateType.values()) {
        	variantName = variant.getName();
        	switch (variantName) {
        		case "dark_steel":
        		case "iron":
        		case "tin":
        			// Pure metal crate plates, paint not needed
		            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 2, variant.ordinal()),
	                    "Y",
	                    "X",
	                    'X', "ingot" +  WordUtils.capitalize(variantName.replace("_", " ")).replace(" ", ""),
	                    'Y', crafter
		            ));
		            break;
        		case "fluxed":
        			// Shaped the same as the non paint recipes except with the paint tin on the left of the iron ingot
                    GameRegistry.addRecipe(new ShapedPaintRecipe(new ItemStack(resultBlock, 2, variant.ordinal()), EnumPaintType.FLUXED, new Object[] {
                       	null, crafter, null,
                       	ItemMetalTinPaint.create(EnumPaintType.FLUXED, true), "ingotIron", null,
                       	null, null, null
                    }));
                    // Shapeless with already made iron crate plate, uses much more paint!
        		    GameRegistry.addRecipe(new ShapelessPaintRecipe(new ItemStack(resultBlock, 1, variant.ordinal()), EnumPaintType.FLUXED, new Object[] {
    		    		new ItemStack(ModBlocks.METAL_PLATE_CRATE, 1, EnumMetalPlateCrateType.IRON.ordinal()),
		    			ItemMetalTinPaint.create(EnumPaintType.FLUXED, true)
		    		}));
        		    break;
        	}
        }

        // Metal Crate With Grill - Crafting Bench Shaped
        resultBlock = ModBlocks.METAL_CRATE_WITH_GRILL;
        for (EnumMetalMultiType variant : EnumMetalMultiType.values()) {
			ing1 = new ItemStack(ModBlocks.METAL_PLATE_CRATE, 1, EnumMetalPlateCrateType.valueOf(variant.getPlateName()).ordinal());
			ing2 = new ItemStack(ModBlocks.METAL_GRILL, 1, EnumMetalGrillType.valueOf(variant.getGrillName()).ordinal());
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 1, variant.ordinal()),
                "YYY",
                " X ",
                "YYY",
                'X', ing1,
                'Y', ing2
            ));
        }
        
        // Metal Crate With Grill Extra - Crafting Bench Shaped
        resultBlock = ModBlocks.METAL_CRATE_WITH_GRILL_EXTRA;
        for (EnumMetalMultiExtraType variant : EnumMetalMultiExtraType.values()) {
			ing1 = new ItemStack(ModBlocks.METAL_PLATE_CRATE, 1, EnumMetalPlateCrateType.valueOf(variant.getPlateName()).ordinal());
			ing2 = new ItemStack(ModBlocks.METAL_GRILL, 1, EnumMetalGrillType.valueOf(variant.getGrillName()).ordinal());
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 1, variant.ordinal()),
                "YYY",
                " X ",
                "YYY",
                'X', ing1,
                'Y', ing2
            ));
        }
                
        // Composite Concrete - Crafting Bench Shaped and Shapeless
        resultBlock = ModBlocks.COMPOSITE_CONCRETE;
        ing3 = new ItemStack(ModBlocks.COMPOSITE_CONCRETE, 1, EnumCompositeType.BASE.ordinal());
        for (EnumCompositeType variant : EnumCompositeType.values()) {
        	ing1 = null;
        	ing2 = null;
            switch (variant) {
                case REINFORCED_GRATING_DARK:
                    ing1 = new ItemStack(ModBlocks.METAL_GRILL_BOX, 1, EnumMetalGrillType.SQUARE_ANGLED_DARK.ordinal());
                    ing2 = new ItemStack(ModBlocks.METAL_GRILL, 1, EnumMetalGrillType.SQUARE_ANGLED_DARK.ordinal());
                    break;
                case REINFORCED_GRATING_LIGHT:
                    ing1 = new ItemStack(ModBlocks.METAL_GRILL_BOX, 1, EnumMetalGrillType.SQUARE_ANGLED_LIGHT.ordinal());
                    ing2 = new ItemStack(ModBlocks.METAL_GRILL, 1, EnumMetalGrillType.SQUARE_ANGLED_LIGHT.ordinal());
                    break;
                case REINFORCED_PLATED_ARMOR_IRON:
                    ing1 = new ItemStack(ModBlocks.METAL_PAINTED_PLATE_FLOOR_STUDDED_SMALL, 1, EnumMetalType.IRON.ordinal());
                    break;
				default:
					break;                	
            }
            // Shaped recipe with "paint"
            GameRegistry.addRecipe(new ShapedPaintRecipe(new ItemStack(resultBlock, 6, variant.ordinal()), EnumPaintType.SLURRY_CEMENT, new Object[] {
            	ItemMetalTinPaint.create(EnumPaintType.SLURRY_CEMENT, true), "sand", ing1,
            	"gravel", "dustBurntLime", null,
               	null, null, null
            }));
            // Shapeless recipe for 6x reinforced blocks
            if (variant == EnumCompositeType.BASE)
            	continue;
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(resultBlock, 6, variant.ordinal()),
        		ing3, ing3, ing3, ing3, ing3, ing3,
        		ing1
        	));
            // Shapeless recipe for 1x reinforced blocks, armour plated can't be done here at there is no separate plate pieces
            if (variant == EnumCompositeType.REINFORCED_PLATED_ARMOR_IRON)
            	continue;
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(resultBlock, 1, variant.ordinal()),
            	ing3,
        		ing2
        	));
        }
    }
}
