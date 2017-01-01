package org.icannt.materialfoundation.common.recipe;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import org.apache.commons.lang3.text.WordUtils;
import org.icannt.materialfoundation.common.block.variant.EnumCompositeType;
import org.icannt.materialfoundation.common.block.variant.EnumMetalType;
import org.icannt.materialfoundation.common.init.ModBlocks;
import org.icannt.materialfoundation.common.init.ModItems;

/**
 * Created by ICannt on 23/12/16.
 */
public class ModRecipes {


    public static void registerRecipes() {
        Block resultBlock;
        Item resultItem;
        ItemStack crafter = new ItemStack(ModItems.TOOL_FABRICATOR);

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

        // TODO: Fix Burnt Lime recipe
        // Burnt Lime - Smelting
/*        for (ItemStack stack : OreDictionary.getOres("sandstone"))
        {
        	GameRegistry.addSmelting(stack, new ItemStack(ModItems.MINERAL_LIME_BURNT, 8, 0), 0.1F);
        }*/
      
        
        /*****************
         * Block Recipes *
         *****************/
        
        // Metal Checker Plate - Crafting Bench
        resultBlock = ModBlocks.METAL_PLATE_CHECKER;
        for (EnumMetalType metal : EnumMetalType.values()) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 1, metal.ordinal()),
                    "XXY",
                    "XX ",
                    'X', "ingot" + WordUtils.capitalize(metal.getName()),
                    'Y', crafter
            ));
        }
               
        // Metal Checker Plate - Crafting Bench
        resultBlock = ModBlocks.METAL_PLATE_CHECKER;
        for (EnumMetalType metal : EnumMetalType.values()) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 1, metal.ordinal()),
                    "XXY",
                    "XX ",
                    'X', "ingot" + WordUtils.capitalize(metal.getName()),
                    'Y', crafter
            ));
        }

        
        // Scale Checker Plate - Crafting Bench
        resultBlock = ModBlocks.METAL_PLATE_WALL_STUDDED;
        for (EnumMetalType metal : EnumMetalType.values()) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 1, metal.ordinal()),
                    "XX ",
                    "XXY",
                    'X', "ingot" + WordUtils.capitalize(metal.getName()),
                    'Y', crafter
            ));
        }

        // Metal Studded Wall Plate - Crafting Bench
        resultBlock = ModBlocks.METAL_PLATE_SCALE;
        for (EnumMetalType metal : EnumMetalType.values()) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 1, metal.ordinal()),
                    "YXX",
                    " XX",
                    'X', "ingot" + WordUtils.capitalize(metal.getName()),
                    'Y', crafter
            ));
        }

        // Composite Concrete - Crafting Bench
        resultBlock = ModBlocks.COMPOSITE_CONCRETE;
        for (EnumCompositeType composite : EnumCompositeType.values()) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 12, composite.ordinal()),
                    "SWS",
                    "BWB",
                    "GCG",
                    'W', Items.WATER_BUCKET,
                    'S', "sand",
                    'G', "gravel",
                    'C', Items.CLAY_BALL,
                    'B', "dustBurntLime"
            ));
        }
    }
}
