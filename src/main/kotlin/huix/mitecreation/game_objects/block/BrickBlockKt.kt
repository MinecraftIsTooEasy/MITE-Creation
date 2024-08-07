package huix.faustpotion.game_objects.block

import net.minecraft.Block
import net.minecraft.BlockConstants
import net.minecraft.CreativeTabs
import net.minecraft.Material
import net.xiaoyu233.fml.reload.utils.IdUtil

class BrickBlockKt() : Block(IdUtil.getNextBlockID(), Material.stone, BlockConstants()) {

    constructor(hardness: Float) : this() {
        this.setHardness(hardness)
        this.setStepSound(Block.soundStoneFootstep)
        this.setCreativeTab(CreativeTabs.tabDecorations)
    }

}