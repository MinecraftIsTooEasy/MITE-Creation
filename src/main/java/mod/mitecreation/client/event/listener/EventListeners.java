package mod.mitecreation.client.event.listener;

import mod.mitecreation.client.event.CreationFishEvents;
import mod.mitecreation.client.event.CreationRICEvents;
import net.xiaoyu233.fml.reload.event.MITEEvents;

public class EventListeners {
    public static void registerAllEvents() {
        MITEEvents.MITE_EVENT_BUS.register(new CreationFishEvents());
        CreationRICEvents.register();
    }
}
