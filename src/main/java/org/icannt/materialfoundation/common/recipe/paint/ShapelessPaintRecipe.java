package org.icannt.materialfoundation.common.recipe.paint;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Nullable;

import org.icannt.materialfoundation.common.init.ModItems;
import org.icannt.materialfoundation.common.item.ItemMetalTinPaint;
import org.icannt.materialfoundation.common.item.variant.EnumPaintType;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by ICannt on 16/1/17.
 */
public class ShapelessPaintRecipe implements IRecipe {

    private ArrayList<Object> input = new ArrayList<>();
    private ItemStack output = null;
    private EnumPaintType paint;
    private ImmutableList<Object> recipe;

    public ShapelessPaintRecipe(ItemStack output, EnumPaintType paint, Object[] recipe) {
        this.output = output.copy();
        this.paint = paint;
        this.recipe = ImmutableList.copyOf(recipe);

        for (Object in : recipe) {
            if (in instanceof ItemStack) {
                this.input.add(((ItemStack) in).copy());
            } else if (in instanceof String) {
                this.input.add(OreDictionary.getOres((String) in));
            } else if (in instanceof Block) {
                this.input.add(new ItemStack((Block) in));
            } else if (in instanceof Item) {
                this.input.add(new ItemStack((Item) in));
            }
        }
    }

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        List<Object> inputs = new LinkedList<>(recipe);

        int found = 0;

        for (int slot = 0; slot < inv.getSizeInventory(); slot++) {
            ItemStack stack = inv.getStackInSlot(slot);

            if (stack == null)
                continue;

            found++;

            for (Object input : inputs) {
                if (input instanceof ItemStack) {
                    if (((ItemStack) input).getItem() == ModItems.METAL_TIN_PAINT) {
                        if (ItemMetalTinPaint.isColour(stack, paint)) {
                            inputs.remove(input);
                            break;
                        }
                    } else {
                        if (OreDictionary.itemMatches((ItemStack) input, stack, false)) {
                            inputs.remove(input);
                            break;
                        }
                    }
                } else if (input instanceof String) {
                    List<ItemStack> ores = OreDictionary.getOres((String) input);

                    for (ItemStack ore: ores) {
                        if (OreDictionary.itemMatches(ore, stack, false)) {
                            inputs.remove(input);
                            break;
                        }
                    }
                }
            }
        }

        return inputs.isEmpty() && found == recipe.size();
    }

    @Nullable
    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        return output.copy();
    }

    @Override
    public int getRecipeSize() {
        return recipe.size();
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

    public List<Object> getInputs() {
        return this.input;
    }

    public EnumPaintType getPaint() {
        return this.paint;
    }

    public ItemStack getResult() {
        return this.output;
    }
}
