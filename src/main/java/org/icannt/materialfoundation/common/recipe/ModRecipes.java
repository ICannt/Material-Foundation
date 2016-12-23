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
import org.icannt.materialfoundation.common.block.state.EnumCompositeType;
import org.icannt.materialfoundation.common.block.state.EnumMetalType;
import org.icannt.materialfoundation.common.registry.BlockRegistry;
import org.icannt.materialfoundation.common.registry.ItemRegistry;

/**
 * Created by ICannt on 23/12/16.
 */
public class ModRecipes {


    public static void registerRecipes() {
        Block resultBlock;
        Item resultItem;
        ItemStack container = new ItemStack(ItemRegistry.FABRICATOR);

        // Metal Checker
        resultBlock = BlockRegistry.METAL_CHECKER;
        for (EnumMetalType metal : EnumMetalType.values()) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 1, metal.ordinal()),
                    "XXY",
                    "XX ",
                    'X', "ingot" + WordUtils.capitalize(metal.getName()),
                    'Y', container));
        }

        // Scale Checker
        resultBlock = BlockRegistry.METAL_SCALE_CHECKER;
        for (EnumMetalType metal : EnumMetalType.values()) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 1, metal.ordinal()),
                    "XX ",
                    "XXY",
                    'X', "ingot" + WordUtils.capitalize(metal.getName()),
                    'Y', container));
        }

        // Metal Scale
        resultBlock = BlockRegistry.METAL_SCALE;
        for (EnumMetalType metal : EnumMetalType.values()) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultBlock, 1, metal.ordinal()),
                    "YXX",
                    " XX",
                    'X', "ingot" + WordUtils.capitalize(metal.getName()),
                    'Y', container
            ));
        }

        // Composite Concrete
        resultBlock = BlockRegistry.COMPOSITE;
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

        // Fabricator
        resultItem = ItemRegistry.FABRICATOR;
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(resultItem),
                "ISI",
                " S ",
                " C ",
                'I', "ingotIron",
                'S', "stickWood",
                'C', Blocks.CARPET
        ));

        // Burnt Lime - Smelting
        for (ItemStack stack : OreDictionary.getOres("sandstone"))
        {
        	GameRegistry.addSmelting(stack, new ItemStack(ItemRegistry.BURNT_LIME, 8, 0), 0.1F);
        }
    }
}
