package mod.mitecreation.init;

import mod.mitecreation.event.CreationEvents;
import net.fabricmc.api.ModInitializer;
import net.minecraft.ResourceLocation;
import net.xiaoyu233.fml.FishModLoader;
import net.xiaoyu233.fml.ModResourceManager;
import net.xiaoyu233.fml.reload.event.MITEEvents;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreationModInit implements ModInitializer {
    public static final String ID = "creation";
    public static final String COLON_ID = ID + ":";
    public static final String NAMESPACE = FishModLoader.getModsMap().get(ID).getMetadata().getName();
    public static final String VERSION = FishModLoader.getModsMap().get(ID).getMetadata().getVersion().toString();
    public static final ResourceLocation MODEL_DIR = new ResourceLocation(ID, "textures/model/");
    public static final ResourceLocation GUI_DIR = new ResourceLocation(ID,  "textures/gui/");
    public static final ResourceLocation ENVRIO_DIR = new ResourceLocation(ID, "textures/environment/");
    public static final ResourceLocation ARMOR_DIR = new ResourceLocation(ID, "textures/item/armor/");
    public static final Logger LOGGER = LogManager.getLogger(NAMESPACE);

    @Override
    public void onInitialize() {
        MITEEvents.MITE_EVENT_BUS.register(new CreationEvents());
        CreationEvents.register();
        ModResourceManager.addResourcePackDomain(ID);
    }
}
