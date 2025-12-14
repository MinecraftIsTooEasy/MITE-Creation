package mod.mitecreation.mixin.entity;

import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.Block;
import net.minecraft.EntityCubic;
import net.minecraft.EntityLiving;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityCubic.class)
public abstract class EntityCubicMixin extends EntityLiving {
    public EntityCubicMixin(World par1World) {
        super(par1World);
    }

    @Shadow public abstract boolean isGelatinousCube();
    @Shadow public abstract boolean isSlime();
    @Shadow public abstract boolean isAcidic();

    @Inject(method = "getCanSpawnHere", at = @At("HEAD"), cancellable = true)
    private void addSpawnFormDeepslate(boolean perform_light_check, CallbackInfoReturnable<Boolean> cir) {
        if (this.isGelatinousCube() && !this.isSlime()) {
            if (this.isAcidic() && this.getBlockBelow() == CTRegistryInit.deepSlate) {
                cir.setReturnValue(true);
            }
        }
    }
}
