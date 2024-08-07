package huix.faustpotion.event

import com.google.common.eventbus.Subscribe
import huix.faustpotion.game_objects.block.FPBlocksKt
import huix.faustpotion.game_objects.item.FPItemsKt
import huix.faustpotion.game_objects.recipe.FPCraftTableRecipesKt
import huix.faustpotion.game_objects.recipe.FPFurnaceRecipesKt

import net.xiaoyu233.fml.reload.event.ItemRegistryEvent
import net.xiaoyu233.fml.reload.event.RecipeRegistryEvent

class FaustPotionEvents {

    @Subscribe
    fun onRecipeRegister(event: RecipeRegistryEvent) {
        FPFurnaceRecipesKt.registerRecipes()
        FPCraftTableRecipesKt.registerRecipes(event)
    }

    @Subscribe
    fun onItemRegister(event: ItemRegistryEvent) {
        FPItemsKt.registerItemsForFP(event)
        FPBlocksKt.registerBlocksForFP(event)
    }


}