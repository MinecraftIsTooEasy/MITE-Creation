package mod.mitecreation.mixin.entity;

import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import static net.xiaoyu233.fml.FishModLoader.LOGGER;

@Mixin(value= EntityPlayer.class)
public abstract class EntityPlayerMixin extends EntityLivingBase {

    public EntityPlayerMixin(World par1World) {
        super(par1World);
    }

    public float getProtection(DamageSource damageSource, boolean par2, boolean par3, boolean par4, boolean par5) {
        float protection = 0.0f;
        if (par2) {
            protection += this.getNaturalDefense(damageSource);
        }
        if (par3) {
            protection += this.getProtectionFromArmor(damageSource, par4);
        }
        if (par5) {
            protection += this.getTotalProtectionOfPotionEffects(damageSource);
        }
        protection += this.getExperienceLevel() * 0.025f;
        return protection;
    }

    @Shadow
    public final int getExperienceLevel() {
        return 0;
    }

//    @Overwrite
//    public final float getReach(Block block, int n) {
//        LOGGER.info(0);
//        float f = 2.75f;
//        LOGGER.info(1);
//        ItemStack itemStack = this.getHeldItemStack();
//        LOGGER.info(2);
//        return itemStack == this.getHeldItemStack() ? f : f + itemStack.getItem().getReachBonus(block, n) + this.getExperienceLevel() * 0.005f;
//    }
//    @Overwrite
//    public float getReach(EnumEntityReachContext enumEntityReachContext, Entity entity) {
//        LOGGER.info(3);
//        float f;
//        LOGGER.info(4);
//        float f2 = (float)(this.posY - (double)this.yOffset - (entity.posY - (double)entity.yOffset));
//        LOGGER.info(5);
//        if (f2 < -0.5f) {
//            LOGGER.info(6);
//            f = (f2 + 0.5f) * 0.5f;
//            LOGGER.info(7);
//            if (f < -1.0f) {
//                LOGGER.info(8);
//                f = -1.0f;
//                LOGGER.info(9);
//            }
//        } else if (f2 > 0.5f) {
//            LOGGER.info(10);
//            f = (f2 - 0.5f) * 0.5f;
//            LOGGER.info(11);
//            if (f > 1.0f) {
//                LOGGER.info(12);
//                f = 1.0f;
//                LOGGER.info(13);
//            }
//        } else {
//            LOGGER.info(14);
//            f = 0.0f;
//            LOGGER.info(15);
//        }
//        ItemStack itemStack = this.getHeldItemStack();
//        LOGGER.info(16);
//        try {
//            LOGGER.info(17);
//            if (enumEntityReachContext == EnumEntityReachContext.FOR_MELEE_ATTACK) {
//                LOGGER.info(18);
//                return entity.adjustPlayerReachForAttacking((EntityPlayer) entity, 1.5f + f + (itemStack == null ? 0.0f : itemStack.getItem().getReachBonus()) + getExperienceLevel() * 0.005f);
//            }
//            LOGGER.info(19);
//            if (enumEntityReachContext == EnumEntityReachContext.FOR_INTERACTION) {
//                LOGGER.info(20);
//                return entity.adjustPlayerReachForInteraction((EntityPlayer) entity, 2.5f + f + (itemStack == null ? 0.0f : itemStack.getItem().getReachBonus(entity)) + getExperienceLevel() * 0.01f);
//            }
//            LOGGER.info(21);
//        } catch (ClassCastException e){
//            LOGGER.info(22);
//        }
//        return 1.5f + itemStack.getItem().getReachBonus();
//    }
}
