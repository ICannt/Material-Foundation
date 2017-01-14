package org.icannt.materialfoundation.common.recipe;

import java.util.HashMap;

import org.icannt.materialfoundation.common.block.variant.EnumCompositeType;
import org.icannt.materialfoundation.common.init.ModBlocks;
import org.icannt.materialfoundation.common.init.ModItems;
import org.icannt.materialfoundation.common.item.ItemMetalTinPaint;
import org.icannt.materialfoundation.common.item.variant.EnumPaintType;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Created by ICannt on 4/1/17.
 */
public class CompositeConcreteRecipe extends ShapedOreRecipe {

    private HashMap<EnumPaintType, ItemStack> PAINT_LOOKUP = new HashMap<>();

    public CompositeConcreteRecipe(ItemStack result, Object... recipe) {
        super(result, recipe);
        PAINT_LOOKUP.put(EnumPaintType.BLACK, new ItemStack(ModBlocks.COMPOSITE_CONCRETE, 12, EnumCompositeType.REINFORCED_GRATING_DARK.ordinal()));
        PAINT_LOOKUP.put(EnumPaintType.WHITE, new ItemStack(ModBlocks.COMPOSITE_CONCRETE, 12, EnumCompositeType.REINFORCED_GRATING_LIGHT.ordinal()));
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);

            if (stack != null && stack.getItem() == ModItems.TIN_METAL_PAINT) {
                EnumPaintType paint = ItemMetalTinPaint.getVariant(stack);
                if (PAINT_LOOKUP.containsKey(paint)) {
                    output = PAINT_LOOKUP.get(paint);
                }

            }
        }
        return output.copy();
    }

    @Override
    public ItemStack[] getRemainingItems(InventoryCrafting inv) {
        return ForgeHooks.defaultRecipeGetRemainingItems(inv);
    }
}
