package mod.mitecreation.mixin.clinet;

import net.minecraft.Debug;
import net.minecraft.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Debug.class)
public class DebugMixin {
//    @Shadow
//    public static boolean is_active;
//
//    @Inject(method = {"<clinit>"}, at = @At("HEAD"))
//    private static void injectIsActive(CallbackInfo ci) {
//        if (Minecraft.inDevMode()) {
//            boolean is_active = true;
//        }
//    }
}
