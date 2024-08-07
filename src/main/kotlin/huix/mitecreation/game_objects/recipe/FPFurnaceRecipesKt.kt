package huix.faustpotion.game_objects.recipe

import huix.faustpotion.game_objects.item.FPItemsKt
import net.minecraft.FurnaceRecipes
import net.minecraft.Item
import net.minecraft.ItemStack

class FPFurnaceRecipesKt {

    companion object {
        fun registerRecipes() {
            registerFPFRecipes(Item.clay.itemID, ItemStack(FPItemsKt.bake_clay))
            registerFPFRecipes(FPItemsKt.clay_brick.itemID, ItemStack(Item.brick))
        }


        private fun registerFPFRecipes(input_id: Int, output_itemstack: ItemStack) {
            FurnaceRecipes.smelting().addSmelting(input_id, output_itemstack)
        }
    }
}