package mod.mitecreation.mixin.client;

import net.minecraft.Minecraft;
import net.minecraft.RenderManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Inject(method = "runTick", at = @At("HEAD"))
    private void disableHitBox(CallbackInfo ci) {
        if (!Minecraft.inDevMode() && RenderManager.field_85095_o) {
            RenderManager.field_85095_o = false;
        }
    }
}
