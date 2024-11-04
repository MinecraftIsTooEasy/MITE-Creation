package mod.mitecreation.init;

import mod.mitecreation.client.event.listener.EventListeners;
import mod.mitecreation.util.Util;
import net.fabricmc.api.ModInitializer;

public class MITECreationModInit implements ModInitializer {
    public static final String CreationNameSpace = "Creation";
    public static final String CreationModName = "Creation";
    public static final String CreationVersion = Util.modVerStr;

    @Override
    public void onInitialize() {
        EventListeners.registerAllEvents();
    }

}
