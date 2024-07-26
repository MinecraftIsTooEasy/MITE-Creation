package mod.mitecreation;

import mod.mitecreation.client.event.CreationEvents;
import net.fabricmc.api.ModInitializer;
import net.xiaoyu233.fml.reload.event.MITEEvents;

public class MITECreationMod implements ModInitializer {
    public static final String CreationNameSpace = "Creation";
    public static final String CreationModName = "Creation";
    public static final String CreationVersion = "0.0.4-BETA";

    @Override
    public void onInitialize() {
        MITEEvents.MITE_EVENT_BUS.register(new CreationEvents());
    }

}
