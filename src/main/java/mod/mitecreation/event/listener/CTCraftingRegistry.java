package mod.mitecreation.event.listener;

import mod.mitecreation.recipe.CTFurnaceRecipesExtend;
import mod.mitecreation.recipe.CTRecipes;
import moddedmite.rustedironcore.api.event.events.CraftingRecipeRegisterEvent;

import java.util.function.Consumer;

public class CTCraftingRegistry implements Consumer<CraftingRecipeRegisterEvent> {
    @Override
    public void accept(CraftingRecipeRegisterEvent event) {
        CTFurnaceRecipesExtend.furnaceRecipeRegister();
        CTRecipes.registerRecipes(event);
    }
}
