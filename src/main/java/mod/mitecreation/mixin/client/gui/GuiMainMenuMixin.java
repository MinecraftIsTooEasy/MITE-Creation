package mod.mitecreation.mixin.client.gui;

import mod.mitecreation.init.CreationModInit;
import mod.mitecreation.util.CTStringUtils;
import net.minecraft.GuiMainMenu;
import net.minecraft.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiMainMenu.class)
public class GuiMainMenuMixin extends GuiScreen {

    @Inject(method = "drawScreen", at = @At("RETURN"))
    private void drawScreen(int par1, int par2, float par3, CallbackInfo ci) {
        this.drawString(this.fontRenderer,  "MITE Creation " + CreationModInit.VERSION, 2, this.height - 30, CTStringUtils.getColor("0xFFEAEE57", 0));
    }
}
