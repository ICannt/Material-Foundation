package org.icannt.materialfoundation.common.recipe.paint;

import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.oredict.OreDictionary;
import org.icannt.materialfoundation.common.init.ModItems;
import org.icannt.materialfoundation.common.item.ItemMetalTinPaint;
import org.icannt.materialfoundation.common.item.variant.EnumGenericType;
import org.icannt.materialfoundation.common.item.variant.EnumPaintType;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by ICannt on 16/1/17.
 */
public class PaintTinRecipe implements IRecipe {

    private EnumPaintType paint;

    public PaintTinRecipe(EnumPaintType paint) {
        this.paint = paint;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {

        List<Object> inputs = new LinkedList<>();
        inputs.add(ItemMetalTinPaint.create(EnumPaintType.EMPTY));
        inputs.add(new ItemStack(ModItems.GENERIC, 1, EnumGenericType.MINERAL_LIME_BURNT.ordinal()));
        inputs.add(new ItemStack(Items.WATER_BUCKET));

        ArrayList<ItemStack> catalysts = new ArrayList<>();
        Stream.of(paint.getRecipeCatalyst()).forEach(catalyst -> {
            if (catalyst instanceof String) {
                catalysts.addAll(OreDictionary.getOres((String) catalyst));
            } else if (catalyst instanceof ItemStack) {
                catalysts.add((ItemStack) catalyst);
            }
        });
        inputs.add(catalysts);

        final int expected = inputs.size();
        int found = 0;

        for (int slot = 0; slot < inv.getSizeInventory(); slot++) {
            ItemStack stack = inv.getStackInSlot(slot);

            if (stack == null)
                continue;

            found++;

            for (Object input : inputs) {
                if (input instanceof ItemStack) {
                    if (((ItemStack) input).getItem() == ModItems.TIN_METAL_PAINT && ItemMetalTinPaint.isColour(stack, EnumPaintType.EMPTY)) {
                        inputs.remove(input);
                        break;
                    } else {
                        if (OreDictionary.itemMatches((ItemStack) input, stack, false)) {
                            inputs.remove(input);
                            break;
                        }
                    }
                } else if (input instanceof List) {
                    Optional<ItemStack> in = ((List<ItemStack>) input).stream().filter(catalyst -> OreDictionary.itemMatches(catalyst, stack, false)).findAny();
                    if (in.isPresent()) {
                        inputs.remove(input);
                        break;
                    }
                }
            }
        }

        if (inputs.isEmpty() && found == expected)
            return true;

        return false;
    }

    @Nullable
    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        for (int slot = 0; slot < inv.getSizeInventory(); slot++) {
            ItemStack stack = inv.getStackInSlot(slot);

            if (stack == null)
                    continue;

                Object[] catalysts = paint.getRecipeCatalyst();

                for (Object catalyst : catalysts) {
                    if (catalyst instanceof String) {
                        List<ItemStack> ores = OreDictionary.getOres((String) catalyst);
                        for (ItemStack ore : ores) {
                            if (OreDictionary.itemMatches(ore, stack, false)) {
                                return ItemMetalTinPaint.create(paint);
                            }
                        }
                    } else if(catalyst instanceof ItemStack) {
                        if (OreDictionary.itemMatches((ItemStack) catalyst, stack, false))
                            return ItemMetalTinPaint.create(paint);
                    }
                }
        }

        return null;
    }

    @Override
    public int getRecipeSize() {
        return 10;
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
