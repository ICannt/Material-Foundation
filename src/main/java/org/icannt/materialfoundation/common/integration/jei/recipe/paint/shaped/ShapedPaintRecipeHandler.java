package org.icannt.materialfoundation.common.integration.jei.recipe.paint.shaped;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import org.icannt.materialfoundation.common.recipe.paint.ShapedPaintRecipe;

/**
 * Created by ICannt on 17/1/17.
 */
public class ShapedPaintRecipeHandler implements IRecipeHandler<ShapedPaintRecipe> {

    private IJeiHelpers helper;

    public ShapedPaintRecipeHandler(IJeiHelpers helper) {
        this.helper = helper;
    }

    @Override
    public Class<ShapedPaintRecipe> getRecipeClass() {
        return ShapedPaintRecipe.class;
    }

    @Override
    public String getRecipeCategoryUid() {
        return VanillaRecipeCategoryUid.CRAFTING;
    }

    @Override
    public String getRecipeCategoryUid(ShapedPaintRecipe recipe) {
        return VanillaRecipeCategoryUid.CRAFTING;
    }

    @Override
    public IRecipeWrapper getRecipeWrapper(ShapedPaintRecipe recipe) {
        return new ShapedPaintRecipeWrapper(helper, recipe.getInput(), recipe.getPaint(), recipe.getRecipeOutput());
    }

    @Override
    public boolean isRecipeValid(ShapedPaintRecipe recipe) {
        return recipe.getRecipeOutput() != null;
    }
}
