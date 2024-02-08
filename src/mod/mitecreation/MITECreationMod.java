package mod.mitecreation;

import mod.mitecreation.event.Listener;
import mod.mitecreation.util.Util;
import net.xiaoyu233.fml.AbstractMod;
import net.xiaoyu233.fml.FishModLoader;
import net.xiaoyu233.fml.classloading.Mod;
import net.xiaoyu233.fml.config.InjectionConfig;
import net.xiaoyu233.fml.util.ModInfo;
import org.spongepowered.asm.mixin.MixinEnvironment;
import mod.mitecreation.mixin.MinecraftMixin;
import javax.annotation.Nonnull;
import javax.swing.*;

@Mod
public class MITECreationMod extends AbstractMod {
    private static final int MOD_LOADER_MIN_VER_NUM = 142;
    private static final String MOD_LOADER_MIN_VER_STRING = "v1.4.2";
    public void preInit() {
    }
    @Nonnull
    public InjectionConfig getInjectionConfig() {
        return InjectionConfig.Builder.of((String)"MITE Creation", (Package)MinecraftMixin.class.getPackage(), (MixinEnvironment.Phase) MixinEnvironment.Phase.INIT).setRequired().build();
    }
    @Override
    public void postInit() {
        ModInfo modLoader = FishModLoader.getModsMap().get("FishModLoader");
        int modLoaderNum = modLoader.getModVerNum();
        if (modLoaderNum < MOD_LOADER_MIN_VER_NUM){
            JFrame diaFrame = new JFrame();
            diaFrame.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(diaFrame,"MITE Creation Mod加载错误: 模组加载器版本过低\nFishModLoader模组加载器需要至少" + MOD_LOADER_MIN_VER_STRING + "版本 \n当前版本:" + modLoader.getModVerStr(),"错误", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        Listener.registerAllEvents();
    }
    public String modId() {
        return "MITE Creation";
    }
    public int modVerNum() {
        return Util.modVerNum;
    }
    public String modVerStr() {
        return Util.modVerStr;
    }
}
