package huix.faustpotion.game_objects.client.render.gui

import huix.faustspotion.game_objects.inventory.container.ReforgeContainer
import huix.faustspotion.game_objects.tileentity.ReforgeTileEntity
import net.minecraft.EntityPlayer
import net.minecraft.GuiContainer
import net.minecraft.ResourceLocation
import org.lwjgl.opengl.GL11

class ReforgeGui(player: EntityPlayer, reforgeTile: ReforgeTileEntity) : GuiContainer(ReforgeContainer(player, reforgeTile)) {

    private val REFORGE_TEXTURE = ResourceLocation("textures/gui/reforge.png")

    override fun initGui() {
        super.initGui()
    }


    override fun drawGuiContainerBackgroundLayer(f: Float, i: Int, j: Int) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f)
        this.drawDefaultBackground()
        this.mc.textureManager.bindTexture(REFORGE_TEXTURE)
        val x = (this.width - this.xSize) / 2
        val y = (this.height - this.ySize) / 2
        //Args: x, y, u, v, width, height
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize)

    }
}