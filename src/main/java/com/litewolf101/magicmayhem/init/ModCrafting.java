package com.litewolf101.magicmayhem.init;

import com.litewolf101.magicmayhem.util.EnumTreeType;
import de.kitsunealex.silverfish.recipe.RecipeHandler;
import net.minecraft.item.ItemStack;

public class ModCrafting {

    private static RecipeHandler RECIPE_HANDLER = new RecipeHandler();

    public static void registerRecipes() {
        for(EnumTreeType type : EnumTreeType.values()) {
            RECIPE_HANDLER.addShapelessRecipe(new ItemStack(ModBlocks.PLANKS, 4, type.ordinal()), new ItemStack(ModBlocks.LOG, 1, type.ordinal()));
        }

        RECIPE_HANDLER.registerRecipes();
    }

}
