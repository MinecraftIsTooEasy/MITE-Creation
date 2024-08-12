package mod.mitecreation;

import mod.mitecreation.client.event.EventListeners;
import net.fabricmc.api.ModInitializer;

public class MITECreationMod implements ModInitializer {
    public static final String CreationNameSpace = "Creation";
    public static final String CreationModName = "Creation";
    public static final String CreationVersion = "0.0.4-BETA";

    @Override
    public void onInitialize() {
        EventListeners.registerAllEvents();
    }

}
