package org.icannt.materialfoundation.common.integration.jei.recipe.paint.shapeless;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.wrapper.ICraftingRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import org.icannt.materialfoundation.common.init.ModItems;
import org.icannt.materialfoundation.common.item.ItemMetalTinPaint;
import org.icannt.materialfoundation.common.item.variant.EnumPaintType;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ICannt on 17/1/17.
 */
public class ShapelessPaintRecipeWrapper implements ICraftingRecipeWrapper {

    private List inputs;
    private EnumPaintType paint;
    private ItemStack output;

    public ShapelessPaintRecipeWrapper(List inputs, EnumPaintType paint, ItemStack output) {
        this.inputs = inputs;
        this.paint = paint;
        this.output = output;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        List<ItemStack> input = new ArrayList<>(this.getInputs());
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).getItem() == ModItems.METAL_TIN_PAINT)
                input.set(i, ItemMetalTinPaint.create(this.paint));
        }

        ingredients.setInputs(ItemStack.class, input);
        ingredients.setOutputs(ItemStack.class, this.getOutputs());
    }

    @Override
    public List getInputs() {
        return inputs;
    }

    @Override
    public List<ItemStack> getOutputs() {
        return Collections.singletonList(output);
    }

    @Override
    public List<FluidStack> getFluidInputs() {
        return null;
    }

    @Override
    public List<FluidStack> getFluidOutputs() {
        return null;
    }

    @Override
    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {

    }

    @Override
    public void drawAnimations(Minecraft minecraft, int recipeWidth, int recipeHeight) {

    }

    @Nullable
    @Override
    public List<String> getTooltipStrings(int mouseX, int mouseY) {
        return null;
    }

    @Override
    public boolean handleClick(Minecraft minecraft, int mouseX, int mouseY, int mouseButton) {
        return false;
    }
}
