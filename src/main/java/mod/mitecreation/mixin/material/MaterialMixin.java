package mod.mitecreation.mixin.material;

import net.minecraft.Material;
import net.xiaoyu233.fml.util.ReflectHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Material.class)
public class MaterialMixin {
    @Shadow @Final public static Material emerald;

    @Inject(method = "getDamageVsEntity", at = @At("HEAD"), cancellable = true)
    public void getDamageVsEntity(CallbackInfoReturnable<Float> cir) {
        if (ReflectHelper.dyCast(this) == emerald) {
            cir.setReturnValue(0.0F);
        }
    }
}
