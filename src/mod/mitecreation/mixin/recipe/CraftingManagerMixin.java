package mod.mitecreation.mixin.recipe;

import mod.mitecreation.block.Blocks;
import mod.mitecreation.item.Items;
import net.minecraft.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = CraftingManager.class)
public class CraftingManagerMixin {
    @Shadow
    private ShapedRecipes addRecipe(ItemStack itemStack, boolean b, Object[] objectArray) {
        return null;
    }
    @Shadow
    private ShapelessRecipes addShapelessRecipe(ItemStack itemStack, boolean b, Object[] objectArray) {
        return null;
    }
    @Redirect(method={"<init>"}, at=@At(value="INVOKE", target="Lnet/minecraft/RecipesMITE;addCraftingRecipes(Lnet/minecraft/CraftingManager;)V"))
    private void injectRegisterRecipes(CraftingManager craftingManager) {
        Items.itemRegister();
        Blocks.registerBlocks();
        RecipesMITE.addCraftingRecipes((CraftingManager)craftingManager);
        Items.recipeRegister(craftingManager);
    }
    public ShapedRecipes addRecipeP(ItemStack var1, boolean var2, Object ... var3){
        return this.addRecipe(var1,var2,var3);
    }
    public ShapelessRecipes addShapelessRecipeP(ItemStack var1, boolean var2, Object ... var3){
        return this.addShapelessRecipe(var1,var2,var3);
    }
}
