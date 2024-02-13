package mod.mitecreation.mixin.clinet.gui;

import mod.mitecreation.item.Items;
import net.minecraft.*;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(axa.class)
public class GuiBeaconMixin extends awy {
    private static final bjo t = new bjo("textures/gui/container/beacon.png");
    private TileEntityBeacon u;

    public GuiBeaconMixin(EntityPlayer player, TileEntityBeacon par2TileEntityBeacon) {
        super(new ContainerBeacon(player, par2TileEntityBeacon));
        this.u = par2TileEntityBeacon;
        this.c = 230;
        this.d = 219;
    }


    @Override
    protected void a(float par1, int par2, int par3) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.f.J().a(t);
        int var4 = (this.g - this.c) / 2;
        int var5 = (this.h - this.d) / 2;
        this.b(var4, var5, 0, 0, this.c, this.d);
        axa.b.f = 100.0f;
        b.b(this.o, this.f.J(), new ItemStack(Item.emerald), var4 + 42, var5 + 109);
        b.b(this.o, this.f.J(), new ItemStack(Item.diamond), var4 + 42 + 22, var5 + 109);
        b.b(this.o, this.f.J(), new ItemStack(Items.ingotTungsten), var4 + 42 + 44, var5 + 109);
        b.b(this.o, this.f.J(), new ItemStack(Item.ingotMithril), var4 + 42 + 66, var5 + 109);
        axa.b.f = 0.0f;
    }
}
