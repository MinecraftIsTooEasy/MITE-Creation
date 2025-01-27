package mod.mitecreation.mixin.entity;

import mod.mitecreation.material.CTMaterials;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityDamageSource.class)
public class EntityDamageSourceMixin extends DamageSource {
    protected EntityDamageSourceMixin(String par1Str) {
        super(par1Str);
    }

    @Inject(method = "<init>(Ljava/lang/String;Lnet/minecraft/Entity;Lnet/minecraft/Entity;)V", at = @At("TAIL"))
    private void peachWoodSetSilverAspect(String par1Str, Entity immediate_entity, Entity responsible_entity, CallbackInfo ci) {
        if (!(immediate_entity instanceof EntityFireball) && responsible_entity instanceof EntityLivingBase entity_living_base) {
            ItemStack held_item = entity_living_base.getHeldItemStack();
            if (held_item != null) {
                if (held_item.hasMaterial(CTMaterials.peachWood)) {
                    this.setSilverAspect();
                }
            }
        }
    }
}
