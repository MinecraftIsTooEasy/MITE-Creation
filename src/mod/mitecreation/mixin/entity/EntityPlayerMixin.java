package mod.mitecreation.mixin.entity;

import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value= EntityPlayer.class)
public abstract class EntityPlayerMixin extends EntityLiving {
    public EntityPlayerMixin(World par1World) {
        super(par1World);
    }
    public float getProtection(DamageSource damageSource, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        float f = 0.0f;
        if (bl) {
            f += this.getNaturalDefense(damageSource);
        }
        if (bl2) {
            f += this.getProtectionFromArmor(damageSource, bl3);
        }
        if (bl4) {
            f += this.getTotalProtectionOfPotionEffects(damageSource);
        }
        f += this.getExperienceLevel() * 0.1f;
        return f;
    }
    @Shadow
    public final int getExperienceLevel() {
        return 0;
    }
    @Overwrite
    public final float getReach(Block block, int n) {
        float f = 2.75f;
        ItemStack itemStack = this.getHeldItemStack();
        return itemStack == null ? f : f + itemStack.getItem().getReachBonus(block, n) + this.getExperienceLevel() * 0.005f;
    }
    @Overwrite
    public float getReach(EnumEntityReachContext enumEntityReachContext, Entity entity) {
        float f;
        float f2 = (float)(this.posY - (double)this.yOffset - (entity.posY - (double)entity.yOffset));
        if (f2 < -0.5f) {
            f = (f2 + 0.5f) * 0.5f;
            if (f < -1.0f) {
                f = -1.0f;
            }
        } else if (f2 > 0.5f) {
            f = (f2 - 0.5f) * 0.5f;
            if (f > 1.0f) {
                f = 1.0f;
            }
        } else {
            f = 0.0f;
        }
        ItemStack itemStack = this.getHeldItemStack();
        try {
            if (enumEntityReachContext == EnumEntityReachContext.FOR_MELEE_ATTACK) {
                return entity.adjustPlayerReachForAttacking((EntityPlayer) entity, 1.5f + f + (itemStack == null ? 0.0f : itemStack.getItem().getReachBonus()) + getExperienceLevel() * 0.005f);
            }
            if (enumEntityReachContext == EnumEntityReachContext.FOR_INTERACTION) {
                return entity.adjustPlayerReachForInteraction((EntityPlayer) entity, 2.5f + f + (itemStack == null ? 0.0f : itemStack.getItem().getReachBonus(entity)) + getExperienceLevel() * 0.01f);
            }
        }catch (ClassCastException e){
        }
        return 1.5f + itemStack.getItem().getReachBonus();
    }
}
