package mod.mitecreation.mixin.recipe;

import mod.mitecreation.item.Items;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value= RecipesMITE.class)
public class RecipesMITEMixin {
    @Inject(method="addFurnaceRecipes",at=@At("RETURN"))
    private static void furnaceRecipesInjector(RecipesFurnace recipesFurnace, CallbackInfo callbackInfo) {
        Items.furnaceRecipeRegister(recipesFurnace);
    }
}
