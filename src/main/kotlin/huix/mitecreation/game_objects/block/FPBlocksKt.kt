package huix.faustpotion.game_objects.block

import net.minecraft.CreativeTabs
import net.minecraft.ItemStack
import net.xiaoyu233.fml.reload.event.ItemRegistryEvent

class FPBlocksKt {

    companion object {
        val obsidian_brick = BrickBlockKt(8.0F)
        val netherrack_brick = BrickBlockKt(10.0F)

        val obsidian_controller_block = ObsidianControllerBlockKt(true)
        val netherrack_controller_block = NetherrackControllerBlockKt(true)
        val obsidian_controller_block_idle = ObsidianControllerBlockKt(false).setCreativeTab(CreativeTabs.tabDecorations)
        val netherrack_controller_block_idle = NetherrackControllerBlockKt(false).setCreativeTab(CreativeTabs.tabDecorations)

        val obsidian_controller_core = BrickBlockKt(8.0F)
        val netherrack_controller_core = BrickBlockKt(10.0F)

        fun registerBlocksForFP(registry: ItemRegistryEvent){
            registry.registerItemBlock("Faust's potion", "obsidian_brick", obsidian_brick)
            registry.registerItemBlock("Faust's potion", "netherrack_brick", netherrack_brick)
            registry.registerItemBlock("Faust's potion", "obsidian_controller_block", obsidian_controller_block)
            registry.registerItemBlock("Faust's potion", "netherrack_controller_block", netherrack_controller_block)
            registry.registerItemBlock("Faust's potion", "obsidian_controller_block_idle", obsidian_controller_block_idle)
            registry.registerItemBlock("Faust's potion", "netherrack_controller_block_idle", netherrack_controller_block_idle)
            registry.registerItemBlock("Faust's potion", "obsidian_controller_core", obsidian_controller_core)
            registry.registerItemBlock("Faust's potion", "netherrack_controller_core", netherrack_controller_core)

        }
    }
}