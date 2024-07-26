package mod.mitecreation.mixin.client.gui;

import mod.mitecreation.util.Util;
import net.minecraft.EnumChatFormatting;
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
        this.drawString(this.fontRenderer, EnumChatFormatting.YELLOW + "MITE Creation Version: " + Util.modVerStr, 2, this.height - 30, 16777215);
    }
}
