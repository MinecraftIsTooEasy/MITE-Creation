package mod.mitecreation.recipe;

import net.xiaoyu233.fml.reload.event.RecipeRegistryEvent;

public class RecipesMITECreation {
    public static void registerRecipes(RecipeRegistryEvent event) {
        RecipesBlockExtend.registerRecipes(event);
        RecipesItemExtend.registerRecipes(event);
    }
}
