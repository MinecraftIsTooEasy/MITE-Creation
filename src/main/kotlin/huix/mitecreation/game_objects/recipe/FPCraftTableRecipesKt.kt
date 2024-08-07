package huix.faustpotion.game_objects.recipe

import huix.faustpotion.game_objects.item.FPItemsKt
import net.minecraft.Item
import net.minecraft.ItemStack
import net.xiaoyu233.fml.reload.event.RecipeRegistryEvent

class FPCraftTableRecipesKt {
    companion object {
        fun registerRecipes(register: RecipeRegistryEvent) {
            register.registerShapedRecipe(
                ItemStack(FPItemsKt.gold_pan_empty, 3),
                true,
                "# #",
                " # ",
                '#', FPItemsKt.bake_clay
            )

            register.registerShapedRecipe(
                ItemStack(FPItemsKt.clay_brick, 3),
                true,
                "###",
                '#', Item.clay
            )
        }
    }
}