package mod.mitecreation.mixin;

import net.minecraft.EnumChatFormat;
import net.minecraft.Minecraft;
import net.minecraft.client.main.Main;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value= Minecraft.class)
public class MinecraftMixin {
    @Overwrite
    public static String getVersionDescriptor(boolean include_formatting) {
        String red = include_formatting ? EnumChatFormat.RED.toString() : "";
        String white = include_formatting ? EnumChatFormat.WHITE.toString() : "";
        return "1.6.4-MITE" + (Main.is_MITE_DS ? "-DS" : "")  + (Minecraft.inDevMode() ? red + " DEV" : "")
                + white + " (MITE Creation Loaded)";
    }
//    @Overwrite
//    public static boolean inDevMode() {
//        return true;
//    }
}
