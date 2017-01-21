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

    // Used for JEI Integration
    private ArrayList<Object> input = new ArrayList<>();

    // Used for JEI Integration
    private ItemStack output;

    private EnumPaintType paint;

    public PaintTinRecipe(EnumPaintType paint) {
        this.paint = paint;
        this.input.add(new ItemStack(ModItems.METAL_TIN_PAINT_EMPTY));
        this.input.add(new ItemStack(ModItems.GENERIC, 1, EnumGenericType.MINERAL_LIME_BURNT.ordinal()));
        this.input.add(new ItemStack(Items.WATER_BUCKET));

        ArrayList<ItemStack> catalysts = new ArrayList<>();
        Stream.of(paint.getRecipeCatalyst()).forEach(catalyst -> {
            if (catalyst instanceof String) {
                catalysts.addAll(OreDictionary.getOres((String) catalyst));
            } else if (catalyst instanceof ItemStack) {
                catalysts.add((ItemStack) catalyst);
            }
        });
        this.input.add(catalysts);
        this.output = ItemMetalTinPaint.create(paint);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {

        List<Object> inputs = new LinkedList<>();
        inputs.add(new ItemStack(ModItems.METAL_TIN_PAINT_EMPTY));
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
                	if (((ItemStack) input).getItem() == ModItems.METAL_TIN_PAINT_EMPTY) {
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
        boolean found = false;

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
                                found = true;
                                break;
                            }
                        }
                    } else if (catalyst instanceof ItemStack) {
                        if (OreDictionary.itemMatches((ItemStack) catalyst, stack, false)) {
                            found = true;
                            break;
                        }
                    }
                }
        }

        if (found)
            return ItemMetalTinPaint.create(this.paint);

        return null;
    }

    @Override
    public int getRecipeSize() {
        return this.input.size();
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

    public ArrayList<Object> getInput() {
        return this.input;
    }

    public EnumPaintType getPaint() {
        return this.paint;
    }

    public ItemStack getOutput() {
        return this.output;
    }
}
