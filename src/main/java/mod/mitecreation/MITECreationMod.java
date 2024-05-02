package mod.mitecreation;

import mod.mitecreation.event.CreationEvents;
import net.fabricmc.api.ModInitializer;
import net.xiaoyu233.fml.reload.event.MITEEvents;

public class MITECreationMod implements ModInitializer {

    @Override
    public void onInitialize() {
        MITEEvents.MITE_EVENT_BUS.register(new CreationEvents());
    }
}
