package com.litewolf101.magicmayhem.init;

import de.kitsunealex.silverfish.recipe.RecipeHandler;

public class ModCrafting {

    private static RecipeHandler RECIPE_HANDLER = new RecipeHandler();

    public static void registerRecipes() {
        RECIPE_HANDLER.registerRecipes();
    }

}
