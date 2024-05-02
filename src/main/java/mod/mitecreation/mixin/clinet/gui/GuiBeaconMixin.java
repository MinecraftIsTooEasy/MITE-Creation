package mod.mitecreation.mixin.clinet.gui;

import net.minecraft.*;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;


@Mixin(GuiBeacon.class)
public class GuiBeaconMixin extends GuiContainer {

    private static final ResourceLocation beaconGuiTextures = new ResourceLocation("textures/gui/container/beacon.png");
    private TileEntityBeacon beacon;

    public GuiBeaconMixin(EntityPlayer player, TileEntityBeacon par2TileEntityBeacon) {
        super(new ContainerBeacon(player, par2TileEntityBeacon));
        this.beacon = par2TileEntityBeacon;
        this.xSize = 230;
        this.ySize = 219;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(beaconGuiTextures);
        int var4 = (this.width - this.xSize) / 2;
        int var5 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var4, var5, 0, 0, this.xSize, this.ySize);
        GuiBeacon.itemRenderer.zLevel = 100.0f;
        itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.getTextureManager(), new ItemStack(Item.emerald), var4 + 42, var5 + 109);
        itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.getTextureManager(), new ItemStack(Item.diamond), var4 + 42 + 22, var5 + 109);
        itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.getTextureManager(), new ItemStack(Item.ingotGold), var4 + 42 + 44, var5 + 109);
        itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.getTextureManager(), new ItemStack(Item.ingotIron), var4 + 42 + 66, var5 + 109);
        GuiBeacon.itemRenderer.zLevel = 0.0f;
    }
}
