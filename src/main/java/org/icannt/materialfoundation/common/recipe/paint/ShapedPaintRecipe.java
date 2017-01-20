package org.icannt.materialfoundation.common.recipe.paint;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.oredict.OreDictionary;
import org.icannt.materialfoundation.common.init.ModItems;
import org.icannt.materialfoundation.common.item.ItemMetalTinPaint;
import org.icannt.materialfoundation.common.item.variant.EnumPaintType;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ICannt on 16/1/17.
 */
public class ShapedPaintRecipe implements IRecipe {

    private ArrayList<Object> input = new ArrayList<>();
    private ItemStack output;
    private EnumPaintType paint;
    private Object[] recipe;

    public ShapedPaintRecipe(ItemStack output, EnumPaintType paint, Object[] recipe) {
        this.output = output;
        this.paint = paint;
        this.recipe = recipe;

        for (Object in : recipe) {
            if (in instanceof ItemStack) {
                this.input.add(((ItemStack) in).copy());
            } else if (in instanceof String) {
                this.input.add(OreDictionary.getOres((String) in));
            } else if (in instanceof Block) {
                this.input.add(new ItemStack((Block) in));
            } else if (in instanceof Item) {
                this.input.add(new ItemStack((Item) in));
            } else if (in == null) {
                this.input.add(null);
            }
        }
    }

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            Object expected = recipe[i];

            if (stack == null && expected != null) {
                return false;
            }

            if (stack != null && expected instanceof ItemStack) {
                if (((ItemStack) expected).getItem() == ModItems.METAL_TIN_PAINT) {
                    if (!ItemMetalTinPaint.isColour(stack, paint))
                        return false;
                } else {
                    if (!OreDictionary.itemMatches((ItemStack) expected, stack, false)) {
                        return false;
                    }
                }
            } else if (stack != null && expected instanceof String) {
                List<ItemStack> ores = OreDictionary.getOres((String) expected);
                boolean found = false;

                for (ItemStack ore : ores) {
                    if (OreDictionary.itemMatches(ore, stack, false)) {
                        found = true;
                    }
                }

                if (!found)
                    return false;
            }

        }

        return true;
    }

    @Nullable
    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        return output.copy();
    }

    @Override
    public int getRecipeSize() {
        return recipe.length;
    }

    @Nullable
    @Override
    public ItemStack getRecipeOutput() {
        return output.copy();
    }

    @Override
    public ItemStack[] getRemainingItems(InventoryCrafting inv) {
        return ForgeHooks.defaultRecipeGetRemainingItems(inv);
    }

    public ArrayList<Object> getInput() {
        return this.input;
    }

    public EnumPaintType getPaint() {
        return this.paint;
    }
}
