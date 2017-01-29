package org.icannt.materialfoundation.common.integration.jei;

import org.icannt.materialfoundation.common.init.ModItems;
import org.icannt.materialfoundation.common.integration.jei.recipe.paint.base.ShapelessPaintTinRecipeHandler;
import org.icannt.materialfoundation.common.integration.jei.recipe.paint.shaped.ShapedPaintRecipeHandler;
import org.icannt.materialfoundation.common.integration.jei.recipe.paint.shapeless.ShapelessPaintRecipeHandler;

import mezz.jei.api.IJeiRuntime;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.ISubtypeRegistry;
import mezz.jei.api.ingredients.IModIngredientRegistration;

/**
 * Created by ICannt on 17/1/17.
 */
@mezz.jei.api.JEIPlugin
public class JEIPlugin implements IModPlugin {

    @Override
    public void registerItemSubtypes(ISubtypeRegistry subtypeRegistry) {

        // Read "colour" NBT on Paint Tins for recipes
        ISubtypeRegistry.ISubtypeInterpreter interpreter = stack -> {
                return stack.getTagCompound() != null && stack.getTagCompound().hasKey("colour") ? stack.getTagCompound().getString("colour") : null;
        };
        subtypeRegistry.registerNbtInterpreter(ModItems.METAL_TIN_PAINT, interpreter);
    }

    @Override
    public void registerIngredients(IModIngredientRegistration registry) {

    }

    @Override
    public void register(IModRegistry registry) {
        // Shapeless Paint Recipe
        registry.addRecipeHandlers(new ShapelessPaintRecipeHandler());

        // Shaped Paint Recipe
        registry.addRecipeHandlers(new ShapedPaintRecipeHandler(registry.getJeiHelpers()));

        // Base Paint Tin Recipe
        registry.addRecipeHandlers(new ShapelessPaintTinRecipeHandler(registry.getJeiHelpers()));
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {

    }
}
