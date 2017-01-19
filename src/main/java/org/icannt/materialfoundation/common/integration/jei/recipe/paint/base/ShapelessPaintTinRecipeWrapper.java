package org.icannt.materialfoundation.common.integration.jei.recipe.paint.base;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IStackHelper;
import mezz.jei.api.recipe.wrapper.ICraftingRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import org.icannt.materialfoundation.common.init.ModItems;
import org.icannt.materialfoundation.common.item.ItemMetalTinPaint;
import org.icannt.materialfoundation.common.item.variant.EnumPaintType;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/**
 * Created by ICannt on 17/1/17.
 */
public class ShapelessPaintTinRecipeWrapper implements ICraftingRecipeWrapper {

    private IJeiHelpers helper;
    private List inputs;
    private ItemStack output;

    public ShapelessPaintTinRecipeWrapper(IJeiHelpers helper, List inputs, ItemStack output) {
        this.helper = helper;
        this.inputs = inputs;
        this.output = output;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        IStackHelper stackHelper = helper.getStackHelper();

        List<List<ItemStack>> input = stackHelper.expandRecipeItemStackInputs(this.inputs);

        ingredients.setInputLists(ItemStack.class, input);
        ingredients.setOutputs(ItemStack.class, this.getOutputs());
    }

    @Override
    public List getInputs() {
        return this.inputs;
    }

    @Override
    public List<ItemStack> getOutputs() {
        return Collections.singletonList(this.output);
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
