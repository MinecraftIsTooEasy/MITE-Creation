package mod.mitecreation.util;

import net.minecraft.BlockSubtypes;
import net.minecraft.Minecraft;

public class CTBlockOreMixinHelper {

    public static String[] setRichOrPoor(String string) {
        String[] stringArray = new String[]{"ore/poor/" + string + "_poor","ore/normal/" + string + "_normal","ore/rich/" + string + "_rich","ore/poor/" + string + "_poor_deepslate","ore/normal/" + string + "_normal_deepslate","ore/rich/" + string + "_rich_deepslate"};
        return stringArray;
    }

    public static String isRichOrPoorHelper(Integer n) {
        String string;
        if (n == 0) {
            string = "poor";
        } else if (n == 1) {
            string = "normal";
        } else if (n == 2) {
            string = "rich";
        } else {
            Minecraft.setErrorMessage("isRichOrPoor:unhandled subtype");
            string = null;
        }
        return string;
    }

    public static BlockSubtypes subtypesInitializer() {
        BlockSubtypes subtypes = new BlockSubtypes(new String[]{"poor_ore", "normal_ore", "rich_ore", "poor_ore_deepslate", "normal_ore_deepslate", "rich_ore_deepslate"});
        return subtypes;
    }
}
