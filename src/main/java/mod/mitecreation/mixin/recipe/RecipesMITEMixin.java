package mod.mitecreation.mixin.recipe;

import net.minecraft.FurnaceRecipes;
import net.minecraft.ItemStack;
import net.minecraft.RecipesMITE;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(RecipesMITE.class)
public class RecipesMITEMixin {
    @Redirect(method = "addFurnaceRecipes", at = @At(value = "INVOKE", target = "Lnet/minecraft/FurnaceRecipes;addSmelting(ILnet/minecraft/ItemStack;)V", ordinal = 14))
    private static void removeMithrilSmeltRecipe(FurnaceRecipes instance, int input_item_id, ItemStack output_item_stack) {
    }
    @Redirect(method = "addFurnaceRecipes", at = @At(value = "INVOKE", target = "Lnet/minecraft/FurnaceRecipes;addSmelting(ILnet/minecraft/ItemStack;)V", ordinal = 15))
    private static void removeAdamantiumSmeltRecipe(FurnaceRecipes instance, int input_item_id, ItemStack output_item_stack) {
    }
}
