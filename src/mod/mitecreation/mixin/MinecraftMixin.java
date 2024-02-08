package mod.mitecreation.mixin;

import net.minecraft.EnumChatFormat;
import net.minecraft.Minecraft;
import net.minecraft.client.main.Main;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value= Minecraft.class)
public class MinecraftMixin {
    @Overwrite
    public static String getVersionDescriptor(boolean include_formatting) {
        String red = include_formatting ? EnumChatFormat.RED.toString() : "";
        return "1.6.4-MITE" + (Main.is_MITE_DS ? "-DS" : "")  + (Minecraft.inDevMode() ? red + " DEV" : "");
    }
    @Overwrite
    public static boolean inDevMode() {
        return true;
    }
}
