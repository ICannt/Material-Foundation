package org.icannt.materialfoundation.common.integration.jei.recipe.paint.base;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import org.icannt.materialfoundation.common.recipe.paint.PaintTinRecipe;

/**
 * Created by Liam on 17/1/17.
 */
public class ShapelessPaintTinRecipeHandler implements IRecipeHandler<PaintTinRecipe> {

    private IJeiHelpers helper;

    public ShapelessPaintTinRecipeHandler(IJeiHelpers helper) {
        this.helper = helper;
    }

    @Override
    public Class<PaintTinRecipe> getRecipeClass() {
        return PaintTinRecipe.class;
    }

    @Override
    public String getRecipeCategoryUid() {
        return VanillaRecipeCategoryUid.CRAFTING;
    }

    @Override
    public String getRecipeCategoryUid(PaintTinRecipe recipe) {
        return VanillaRecipeCategoryUid.CRAFTING;
    }

    @Override
    public IRecipeWrapper getRecipeWrapper(PaintTinRecipe recipe) {
        return new ShapelessPaintTinRecipeWrapper(helper, recipe.getInput(), recipe.getOutput());
    }

    @Override
    public boolean isRecipeValid(PaintTinRecipe recipe) {
        return recipe.getOutput() != null;
    }
}
