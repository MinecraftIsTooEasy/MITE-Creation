package mod.mitecreation.recipe;

import moddedmite.rustedironcore.api.event.events.CraftingRecipeRegisterEvent;

public class CTRecipes {
    public static void registerRecipes(CraftingRecipeRegisterEvent event) {
        CTRecipesBlockExtend.registerRecipes(event);
        CTRecipesItemExtend.registerRecipes(event);
    }
}
