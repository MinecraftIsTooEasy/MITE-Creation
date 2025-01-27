package mod.mitecreation.mixin.client.render;

import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.Minecraft;
import net.minecraft.RenderGlobal;
import net.minecraft.WorldClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RenderGlobal.class)
public class RenderGlobalMixin {
    @Shadow private WorldClient theWorld;
    @Shadow private Minecraft mc;

    @Inject(method = "loadRenderers", at = @At("HEAD"))
    private void setCTLeavesGraphicsLevel(CallbackInfo ci) {
        if (this.theWorld != null) {
            CTRegistryInit.peachLeaves.setGraphicsLevel(this.mc.gameSettings.isFancyGraphicsEnabled());
        }
    }
}
