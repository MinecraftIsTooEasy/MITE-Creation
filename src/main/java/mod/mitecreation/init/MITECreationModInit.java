package mod.mitecreation.init;

import mod.mitecreation.client.event.listener.EventListeners;
import net.fabricmc.api.ModInitializer;

public class MITECreationModInit implements ModInitializer {


    @Override
    public void onInitialize() {
        EventListeners.registerAllEvents();
    }

}
