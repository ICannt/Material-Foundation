package org.icannt.materialfoundation.common.recipe;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.oredict.OreDictionary;
import org.icannt.materialfoundation.common.block.variant.EnumCompositeType;
import org.icannt.materialfoundation.common.init.ModBlocks;
import org.icannt.materialfoundation.common.init.ModItems;
import org.icannt.materialfoundation.common.item.ItemMetalTinPaint;
import org.icannt.materialfoundation.common.item.variant.EnumPaintType;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ICannt on 4/1/17.
 */
public class CompositeRecipe implements IRecipe {

    private static final Object[] recipe = new Object[]{"sand", new InputMultiStack(getPaintStack(), new ItemStack(Blocks.STONE)), "sand", "dustBurntLime", new ItemStack(Items.WATER_BUCKET), "dustBurntLime", "gravel", new ItemStack(Items.CLAY_BALL), "gravel"};


    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        List<Object> inputs = new LinkedList<>(Arrays.asList(recipe));

        for (int index = 0; index < inv.getSizeInventory(); index++) {
            if (isValidCrafting(inv.getStackInSlot(index), recipe[index]))
                inputs.remove(recipe[index]);
        }

        return inputs.isEmpty();
    }

    /**
     * Required method to support damage values on paint stacks
     * @return
     */
    private static ItemStack getPaintStack() {
        ItemStack out = new ItemStack(ModItems.TIN_METAL_PAINT);
        out.setItemDamage(OreDictionary.WILDCARD_VALUE);
        return out;
    }

    /**
     * Helper method that returns whether the input matches the stack in the crafting grid
     * @param stack ItemStack The stack in the crafting grid
     * @param input ItemStack The expected recipe stack
     * @return Boolean True of match, or false
     */
    private boolean isValidCrafting(ItemStack stack, Object input) {
        if (input == null && stack == null) {
            return true;

        } else if (stack != null && input instanceof String) {
            List<ItemStack> stacks = OreDictionary.getOres((String) input);
            for (ItemStack s : stacks) {
                ItemStack c = s.copy();
                if (c.getItemDamage() == OreDictionary.WILDCARD_VALUE)
                    c.setItemDamage(stack.getItemDamage());
                if (stack.isItemEqual(c))
                    return true;
            }

        } else if (stack != null && input instanceof ItemStack && stack.isItemEqual((ItemStack) input)) {
            return true;

        } else if (stack != null && input instanceof InputMultiStack) {
            boolean match = false;
            for (ItemStack s : (((InputMultiStack) input).getStacks())) {
                ItemStack c = s.copy();
                if (c.getItemDamage() == OreDictionary.WILDCARD_VALUE)
                    c.setItemDamage(s.getItemDamage());
                if (s.isItemEqual(c))
                    match = true;
            }
            return match;
        }
        return false;
    }

    /**
     * Used to determine the colour of the paint tins and catalyst item to return to correct result
     * @param inv
     * @return
     */
    @Nullable
    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        ItemStack catalyst = inv.getStackInSlot(1);
        ItemStack result = null;

        for (EnumCompositeType variant : EnumCompositeType.values()) {
            switch (variant) {
                case REINFORCED_GRATING_DARK:
                    if (catalyst != null && catalyst.getItem() == ModItems.TIN_METAL_PAINT && ItemMetalTinPaint.isColour(catalyst, EnumPaintType.BLACK))
                        result = new ItemStack(ModBlocks.COMPOSITE_CONCRETE, 12, variant.ordinal());
                    break;
                case REINFORCED_GRATING_LIGHT:
                    if (catalyst != null && catalyst.getItem() == ModItems.TIN_METAL_PAINT && ItemMetalTinPaint.isColour(catalyst, EnumPaintType.WHITE))
                        result = new ItemStack(ModBlocks.COMPOSITE_CONCRETE, 12, variant.ordinal());
                    break;
                default:
                    if (catalyst != null || catalyst.getItem() == Item.getItemFromBlock(Blocks.STONE)) {
                        result = new ItemStack(ModBlocks.COMPOSITE_CONCRETE, 12, variant.ordinal());
                    }
            }
        }

        return result;

    }

    @Override
    public int getRecipeSize() {
        return 9;
    }

    @Nullable
    @Override
    public ItemStack getRecipeOutput() {
        return null;
    }

    @Override
    public ItemStack[] getRemainingItems(InventoryCrafting inv) {
        return ForgeHooks.defaultRecipeGetRemainingItems(inv);
    }
}
