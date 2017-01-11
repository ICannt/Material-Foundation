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
import org.icannt.materialfoundation.common.block.variant.EnumCompositeType;
import org.icannt.materialfoundation.common.block.variant.EnumMetalType;
import org.icannt.materialfoundation.common.init.ModBlocks;
import org.icannt.materialfoundation.common.init.ModItems;
import org.icannt.materialfoundation.common.item.ItemMetalTinPaint;
import org.icannt.materialfoundation.common.item.variant.EnumGenericType;
import org.icannt.materialfoundation.common.item.variant.EnumPaintType;

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

        // Paint Tin Empty
        GameRegistry.addRecipe(new ShapedOreRecipe(ItemMetalTinPaint.create(EnumPaintType.EMPTY),
                "C",
                "I",
                "I",
                'C', crafter,
                'I', Items.IRON_INGOT
        ));

        // Paint Tins - Crafting Bench
        for (EnumPaintType variant : EnumPaintType.values()) {
        	if (variant != EnumPaintType.EMPTY) {
	            GameRegistry.addRecipe(new ShapelessOreRecipe(ItemMetalTinPaint.create(variant),
	                    "dye" + WordUtils.capitalize(variant.getName().replace("_", " ")).replace(" ", ""),
	                    new ItemStack(ModItems.TIN_METAL_PAINT),
	                    "dustBurntLime"
	            ));
        	}
        }

        // Slime Lime - Crafting Bench
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.GENERIC, 6, EnumGenericType.MINERAL_LIME_SLIME.ordinal()),
                "slimeball",
                "dustBurntLime"
        ));
        
        // Burnt Lime - Smelting
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

        
        // Scale Checker Plate - Crafting Bench
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

        // Composite Concrete
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
