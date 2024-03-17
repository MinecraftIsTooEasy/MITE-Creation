//package mod.mitecreation.mixin.clinet;
//
//import net.minecraft.Debug;
//import net.minecraft.Minecraft;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.Redirect;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//@Mixin(Debug.class)
//public class DebugMixin {
//    @Shadow
//    public static boolean is_active;
//
//    @Redirect(method = {"a(FZII)V"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/Minecraft;inDevMode()Z", shift = At.Shift.BEFORE)})
//    private void injectIsActive(float par1, boolean par2, int par3, int par4, CallbackInfo ci) {
//        if (Minecraft.inDevMode()) {
//            is_active = true;
//        }
//    }
//}
