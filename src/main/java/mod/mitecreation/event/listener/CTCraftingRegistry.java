package mod.mitecreation.event.listener;

import mod.mitecreation.recipe.CTFurnaceRecipesExtend;
import mod.mitecreation.recipe.CTRecipesBlockExtend;
import mod.mitecreation.recipe.CTRecipesItemExtend;
import moddedmite.rustedironcore.api.event.events.CraftingRecipeRegisterEvent;

import java.util.function.Consumer;

public class CTCraftingRegistry implements Consumer<CraftingRecipeRegisterEvent> {
    @Override
    public void accept(CraftingRecipeRegisterEvent event) {
        CTFurnaceRecipesExtend.registerFurnaceRecipe();
        CTRecipesBlockExtend.registerBlockRecipes(event);
        CTRecipesItemExtend.registerItemRecipes(event);
    }
}
