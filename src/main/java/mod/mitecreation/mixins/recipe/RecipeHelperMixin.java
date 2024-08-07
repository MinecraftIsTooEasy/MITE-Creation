package mod.mitecreation.mixins.recipe;

import mod.mitecreation.block.CreationBlock;
import mod.mitecreation.block.CreationWorkbench;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RecipeHelper.class)
public class RecipeHelperMixin {
    @Inject(method = "addRecipe", at = @At("TAIL"))
    private static void addCreationRecipe(IRecipe recipe, boolean include_in_lowest_crafting_difficulty_determination, CallbackInfo ci) {
        ItemStack recipe_output = recipe.getRecipeOutput();
        if (recipe_output == null) return;

        Item output_item = recipe_output.getItem();

        if (output_item.itemID == CreationBlock.creationWorkBench.blockID) {
            recipe.setMaterialToCheckToolBenchHardnessAgainst(CreationWorkbench.getMaterialToCheckToolBenchHardnessAgainst(recipe_output.getItemSubtype()));
        }
    }
}
