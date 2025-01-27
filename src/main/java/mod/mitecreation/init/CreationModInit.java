package mod.mitecreation.init;

import mod.mitecreation.client.event.listener.CTEventListeners;
import net.fabricmc.api.ModInitializer;
import net.xiaoyu233.fml.FishModLoader;
import net.xiaoyu233.fml.ModResourceManager;

public class CreationModInit implements ModInitializer {
    public static final String ID = "creation";
    public static final String RESOURCEID = "creation:";
    public static final String NAMESPACE = "Creation";
    public static final String NAME = "MITE: Creation";
    public static final String VERSION = FishModLoader.getModsMap().get(ID).getMetadata().getVersion().toString();
    public static final String MODEL_DIR = RESOURCEID + "textures/model/";
    public static final String GUI_DIR = RESOURCEID + "textures/gui/";
    public static final String ENVRIO_DIR = RESOURCEID + "textures/environment/";
    public static final String ARMOR_DIR = RESOURCEID + "textures/armor/";

    @Override
    public void onInitialize() {
        CTEventListeners.registerAllEvents();
        ModResourceManager.addResourcePackDomain(ID);
    }
}
