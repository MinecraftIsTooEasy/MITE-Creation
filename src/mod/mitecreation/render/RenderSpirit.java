package mod.mitecreation.render;

import net.minecraft.*;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.util.Random;

public class RenderSpirit extends bgk {
    public static final int body_texture = 0;
    private Random rnd = new Random();
    public RenderSpirit() {
    }
    protected void setTextures() {
        this.setTexture(0, "textures/entity/spirit","textures/entity/spirit_glow");
    }
    public void renderEnderman(EntityEnderman par1EntityEnderman, double par2, double par4, double par6, float par8, float par9) {
        if (par1EntityEnderman.isScreaming()) {
            double var10 = 0.02D;
            par2 += this.rnd.nextGaussian() * var10;
            par6 += this.rnd.nextGaussian() * var10;
        }

    }


    protected void renderCarrying(EntityEnderman par1EntityEnderman, float par2) {

        if (par1EntityEnderman.getCarried() > 0) {
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glPushMatrix();
            float var3 = 0.5F;
            GL11.glTranslatef(0.0F, 0.6875F, -0.75F);
            var3 *= 1.0F;
            GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(-var3, -var3, var3);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glPopMatrix();
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        }
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        this.renderEnderman((EntityEnderman)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.renderEnderman((EntityEnderman)par1Entity, par2, par4, par6, par8, par9);
    }
}
