package mod.mitecreation.client.render;

import mod.mitecreation.entity.EntityCTSpirit;
import mod.mitecreation.init.CreationModInit;
import moddedmite.rustedironcore.api.render.RenderAPI;
import net.minecraft.*;
import org.lwjgl.opengl.GL11;

import java.util.Random;

public class RenderCTSpirit extends RenderLiving implements RenderAPI {

    private ModelEnderman endermanModel;
    private Random rand = new Random();

    public RenderCTSpirit() {
        super(new ModelEnderman(), 0.5F);
        this.endermanModel = (ModelEnderman)super.mainModel;
        this.setRenderPassModel(this.endermanModel);
    }

    public boolean forceGlowOverride() {
        return true;
    }

    public void renderSpirit(EntityCTSpirit par1EntityCTSpirit, double par2, double par4, double par6, float par8, float par9) {
        this.endermanModel.isCarrying = par1EntityCTSpirit.getCarried() > 0;
        this.endermanModel.isAttacking = par1EntityCTSpirit.isScreaming();
        if (par1EntityCTSpirit.isScreaming()) {
            double var10 = 0.02;
            par2 += this.rand.nextGaussian() * var10;
            par6 += this.rand.nextGaussian() * var10;
        }

        super.doRenderLiving(par1EntityCTSpirit, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getSpiritTextures(EntityCTSpirit par1EntityCTSpirit) {
        return this.textures[0];
    }

    protected void renderCarrying(EntityCTSpirit par1EntityCTSpirit, float par2) {
        super.renderEquippedItems(par1EntityCTSpirit, par2);
        if (par1EntityCTSpirit.getCarried() > 0) {
            GL11.glEnable(32826);
//            GL11.glEnable(GL_BLEND);
//            GL11.glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
            GL11.glPushMatrix();
            float var3 = 0.5F;
            GL11.glTranslatef(0.0F, 0.6875F, -0.75F);
            var3 *= 1.0F;
            GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(-var3, -var3, var3);
            int var4 = par1EntityCTSpirit.getBrightnessForRender(par2);
            int var5 = var4 % 65536;
            int var6 = var4 / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)var5 / 1.0F, (float)var6 / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.bindTexture(TextureMap.locationBlocksTexture);
            this.renderBlocks.renderBlockAsItem(Block.blocksList[par1EntityCTSpirit.getCarried()], par1EntityCTSpirit.getCarryingData(), 1.0F);
            GL11.glPopMatrix();
            GL11.glDisable(32826);
        }

    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        this.renderSpirit((EntityCTSpirit)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    protected void renderEquippedItems(EntityLivingBase par1EntityLivingBase, float par2) {
        this.renderCarrying((EntityCTSpirit)par1EntityLivingBase, par2);
    }

    public void doRenderLiving(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9) {
        this.renderSpirit((EntityCTSpirit)par1EntityLivingBase, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getEntityTexture(Entity par1Entity) {
        return this.getSpiritTextures((EntityCTSpirit)par1Entity);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.renderSpirit((EntityCTSpirit)par1Entity, par2, par4, par6, par8, par9);
    }

    protected void setTextures() {
        this.setTexture(0, CreationModInit.COLON_ID + "textures/entity/spirit");
    }

    public float getModelOpacity(Entity entity) {
        return 0.4F;
    }
}

