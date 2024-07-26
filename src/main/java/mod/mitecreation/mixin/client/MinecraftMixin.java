package mod.mitecreation.mixin.client;

import net.minecraft.Minecraft;
import net.minecraft.RenderManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Inject(method = {"runTick"}, at = @At("HEAD"))
    private void devModeOpenDebugInfo(CallbackInfo ci) {
        if (!Minecraft.inDevMode() && RenderManager.field_85095_o == true) {
            RenderManager.field_85095_o = false;
        }
    }
//    @WrapWithCondition(method = "runTick", at = @At(value = "INVOKE", target = "Lorg/lwjgl/input/Keyboard;getEventKey()I"))
//    private boolean disableHitBox() {
//        return Minecraft.inDevMode();
//    }
}
