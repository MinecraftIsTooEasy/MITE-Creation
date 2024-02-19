package mod.mitecreation.mixin.recipe;

import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value= RecipesMITE.class)
public class RecipesCraftingMixin {
    @Inject(method="addCraftingRecipes",at=@At("INVOKE"))
    private static void recipesInjector(CraftingManager craftingManager, CallbackInfo callbackInfo) {
    }
}