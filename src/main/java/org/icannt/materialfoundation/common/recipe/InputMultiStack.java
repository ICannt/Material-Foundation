package org.icannt.materialfoundation.common.recipe;

import net.minecraft.item.ItemStack;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ICannt on 4/1/17.
 */

public class InputMultiStack {

    List<ItemStack> stacks = new LinkedList<>();

    public InputMultiStack(ItemStack ...inputs) {
        for (ItemStack stack : inputs) {
            if (stack != null)
                stacks.add(stack);
        }
    }

    public List<ItemStack> getStacks() {
        return stacks;
    }
}
