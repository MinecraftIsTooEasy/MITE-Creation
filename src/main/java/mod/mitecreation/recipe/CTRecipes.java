package mod.mitecreation.recipe;

import net.xiaoyu233.fml.reload.event.RecipeRegistryEvent;

public class CTRecipes {
    public static void registerRecipes(RecipeRegistryEvent event) {
        CTRecipesBlockExtend.registerRecipes(event);
        CTRecipesItemExtend.registerRecipes(event);
    }
}
