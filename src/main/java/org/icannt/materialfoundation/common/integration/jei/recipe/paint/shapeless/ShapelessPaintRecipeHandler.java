package org.icannt.materialfoundation.common.integration.jei.recipe.paint.shapeless;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import org.icannt.materialfoundation.common.recipe.paint.ShapelessPaintRecipe;

/**
 * Created by ICannt on 17/1/17.
 */
public class ShapelessPaintRecipeHandler implements IRecipeHandler<ShapelessPaintRecipe> {
    @Override
    public Class<ShapelessPaintRecipe> getRecipeClass() {
        return ShapelessPaintRecipe.class;
    }

    @Override
    public String getRecipeCategoryUid() {
        return VanillaRecipeCategoryUid.CRAFTING;
    }

    @Override
    public String getRecipeCategoryUid(ShapelessPaintRecipe recipe) {
        return VanillaRecipeCategoryUid.CRAFTING;
    }

    @Override
    public IRecipeWrapper getRecipeWrapper(ShapelessPaintRecipe recipe) {
        return new ShapelessPaintRecipeWrapper(recipe.getInputs(), recipe.getPaint(), recipe.getRecipeOutput());
    }

    @Override
    public boolean isRecipeValid(ShapelessPaintRecipe recipe) {
        return recipe.getRecipeOutput() != null;
    }
}
