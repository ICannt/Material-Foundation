package org.icannt.materialfoundation.common.recipe;

import com.google.common.collect.ImmutableList;
import net.minecraft.inventory.InventoryCrafting;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ICannt on 3/1/17.
 *
 * Code adapted from Botania by Vazkii
 * https://github.com/Vazkii/Botania/blob/master/src/main/java/vazkii/botania/api/recipe/RecipePetals.java
 */
public class CompositeConcreteRecipe implements IRecipe {

    ImmutableList<Object> recipe;
    ItemStack output;

    public CompositeConcreteRecipe(ItemStack output, Object ...inputs) {
        ImmutableList.Builder<Object> list = ImmutableList.builder();
        for (Object in : inputs) {
            if (in instanceof ItemStack || in instanceof String) {
                list.add(in);
            }
        }

        this.recipe = list.build();
        this.output = output;
    }


    @Override
    public boolean matches(InventoryCrafting inv, World world) {
        List<Object> missing = new ArrayList<>(recipe);

        for (int slot = 0; slot < inv.getSizeInventory(); slot++) {
            ItemStack stack = inv.getStackInSlot(slot);
            int stackIndex = -1, oredictIndex = -1;

            for (int index = 0; index < missing.size(); index++) {
                Object input = missing.get(index);

                if (input instanceof ItemStack && ((ItemStack) input).getItem() == ModItems.TIN_METAL_PAINT) {
                    if (stack == null) {
                        missing.remove(input);
                        break;
                    }
                } else if (stack == null) {
                    break;
                }

                if (input instanceof String) {
                    List<ItemStack> validStacks = OreDictionary.getOres((String) input);
                    boolean found = false;
                    for (ItemStack s : validStacks) {
                        ItemStack copy = s.copy();
                        if(copy.getItemDamage() == OreDictionary.WILDCARD_VALUE)
                            copy.setItemDamage(stack.getItemDamage());
                        if (stack.isItemEqual(copy)) {
                            oredictIndex = index;
                            found = true;
                            break;
                        }
                    }

                    if (found)
                        break;

                } else if (input instanceof ItemStack && isEqual((ItemStack) input, stack, ((ItemStack) input).getItem() == ModItems.TIN_METAL_PAINT)) {
                    stackIndex = index;
                    break;

                }
            }

            if (stackIndex != -1)
                missing.remove(stackIndex);
            else if (oredictIndex != -1)
                missing.remove(oredictIndex);
        }

        return missing.isEmpty();
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        ItemStack result = output;
        ItemStack paint = inv.getStackInSlot(1);

        for (EnumCompositeType variant : EnumCompositeType.values()) {
            switch (variant) {
                case REINFORCED_GRATING_DARK:
                    if (paint != null && ItemMetalTinPaint.isColour(paint, EnumPaintType.BLACK))
                        result = new ItemStack(ModBlocks.COMPOSITE_CONCRETE, 12, variant.ordinal());
                    break;
                case REINFORCED_GRATING_LIGHT:
                    if (paint != null && ItemMetalTinPaint.isColour(paint, EnumPaintType.WHITE))
                        result = new ItemStack(ModBlocks.COMPOSITE_CONCRETE, 12, variant.ordinal());
                    break;
                default:
                    result = new ItemStack(ModBlocks.COMPOSITE_CONCRETE, 12, EnumCompositeType.BASE.ordinal());
                    break;
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

        ItemStack[] stacks = new ItemStack[inv.getSizeInventory()];

        for (int i = 0; i < stacks.length; ++i)
        {
            ItemStack stack = inv.getStackInSlot(i);
            stacks[i] = ForgeHooks.getContainerItem(stack);
        }

        return stacks;
    }

    private boolean isEqual(ItemStack stack1, ItemStack stack2, boolean ignoreDamage) {
        if (stack1 == null || stack2 == null)
            return false;

        if (ignoreDamage) {
            if (stack1.getItem() == stack2.getItem())
                return true;
        } else {
            if (stack1.getItem() == stack2.getItem() && stack1.getItemDamage() == stack2.getItemDamage())
                return true;
        }

        return false;
    }
}
