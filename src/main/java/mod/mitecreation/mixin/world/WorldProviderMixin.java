package mod.mitecreation.mixin.world;

import cn.tesseract.underbiome.world.WorldProviderUnderbiome;
import net.minecraft.*;
import mod.mitecreation.world.dimesion.WorldProviderCTRedSky;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WorldProvider.class)
public class WorldProviderMixin {
    @Inject(method = "getProviderForDimension", at = @At("HEAD"), cancellable = true)
    private static void getProviderForDimension(int par0, CallbackInfoReturnable<WorldProvider> cir) {
//        if (par0 == 9) {
//            cir.setReturnValue(new WorldProviderCTRedSky());
//        }
        if (par0 == -2)
            cir.setReturnValue(new WorldProviderUnderbiome());
    }
}
