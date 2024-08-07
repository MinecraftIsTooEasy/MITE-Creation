package huix.faustpotion.game_objects.block

import huix.faustspotion.game_objects.block.ControllerBlock
import net.minecraft.Block
import net.minecraft.IconRegister
import net.minecraft.Material

class ObsidianControllerBlockKt(isActive: Boolean) : ControllerBlock(Material.obsidian, isActive) {



    override fun registerIcons(iconRegister: IconRegister) {
        this.blockIcon = iconRegister.registerIcon("controller/obsidian/side");
        this.iconFront = iconRegister.registerIcon(if (this.isActive) "controller/obsidian/front_on" else "controller/obsidian/front_off");
    }

    override fun getIdleBlockID(): Int {
        return FPBlocksKt.obsidian_controller_block_idle.blockID
    }

    override fun getActiveBlockID(): Int {
        return FPBlocksKt.obsidian_controller_block.blockID
    }

    override fun getBrickBlock(): Block {
        return FPBlocksKt.obsidian_brick
    }

    override fun getCoreBlock(): Block {
        return FPBlocksKt.obsidian_controller_core
    }

}