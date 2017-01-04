package org.icannt.materialfoundation.common.recipe;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import org.icannt.materialfoundation.common.block.variant.EnumCompositeType;
import org.icannt.materialfoundation.common.init.ModItems;
import org.icannt.materialfoundation.common.item.ItemMetalTinPaint;

/**
 * Created by ICannt on 4/1/17.
 */
public class CompositeConcreteRecipe extends ShapedOreRecipe {

    public CompositeConcreteRecipe(ItemStack result, Object... recipe) {
        super(result, recipe);
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        ItemStack result = super.getCraftingResult(inv);

        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);

            if (stack != null && result != null && stack.getItem() == ModItems.TIN_METAL_PAINT) {
                switch (ItemMetalTinPaint.getVariant(stack)) {
                    case BLACK:
                        result.setItemDamage(EnumCompositeType.REINFORCED_GRATING_DARK.ordinal());
                        break;
                    case WHITE:
                        result.setItemDamage(EnumCompositeType.REINFORCED_GRATING_LIGHT.ordinal());
                        break;
                    default:
                        result = null;
                }
            }
        }

        return result;
    }
}
