package mod.mitecreation.render;

import net.minecraft.*;
import org.lwjgl.opengl.GL11;

public class RenderSpiderQueen extends RenderArachnid {

    private float scale;

    protected boolean forceGlowOverride() {
        return true;
    }

    public RenderSpiderQueen(float scale) {
        super(new ModelArachnid(), new ModelArachnid(), scale);
        this.scale = scale;
    }

    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
        super.preRenderCallback(par1EntityLivingBase, par2);
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    public String getSubtypeName() {
        return "spider_queen";
    }

}