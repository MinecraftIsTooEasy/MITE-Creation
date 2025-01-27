package mod.mitecreation.client.render;

import mod.mitecreation.init.CreationModInit;
import moddedmite.rustedironcore.api.render.RenderAPI;
import net.minecraft.EntityLivingBase;
import net.minecraft.ModelArachnid;
import net.minecraft.RenderArachnid;
import org.lwjgl.opengl.GL11;

public class RenderCTSpiderQueen extends RenderArachnid implements RenderAPI {
    private final float scale;

    public RenderCTSpiderQueen(float scale) {
        super(new ModelArachnid(), new ModelArachnid(), scale);
        this.scale = scale;
    }

    public boolean forceGlowOverride() {
        return true;
    }

    @Override
    protected void setTextures() {
        this.setTexture(0, CreationModInit.RESOURCEID + "textures/entity/spider/" + this.getSubtypeName());
    }

    @Override
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
        super.preRenderCallback(par1EntityLivingBase, par2);
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    @Override
    public String getSubtypeName() {
        return "spider_queen";
    }
}