package mod.mitecreation.mixin;

import net.minecraft.EnumChatFormatting;
import net.minecraft.Minecraft;
import net.minecraft.client.main.Main;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Minecraft.class)
public class MinecraftMixin {

    @Inject(method = "getVersionDescriptor",at = @At("HEAD"), cancellable = true)
    private static void getVersionDescriptorCreation(boolean include_formatting, CallbackInfoReturnable<String> cir) {

        String red = include_formatting ? EnumChatFormatting.RED.toString() : "";
        String white = include_formatting ? EnumChatFormatting.WHITE.toString() : "";

        cir.setReturnValue("1.6.4-MITE" + (Main.is_MITE_DS ? "-DS" : "")  + (Minecraft.inDevMode() ? red + " DEV" : "")
                + white + " (MITE Creation Loaded)");
    }

    @Inject(method = "inDevMode", at = @At("RETURN"), cancellable = true)
    private static void inDevModeCreation(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }
}
