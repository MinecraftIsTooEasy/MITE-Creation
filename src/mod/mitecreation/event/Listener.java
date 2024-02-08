package mod.mitecreation.event;

import net.xiaoyu233.fml.reload.event.MITEEvents;

public class Listener {
    public static void registerAllEvents() {
        MITEEvents.MITE_EVENT_BUS.register(new Events());
    }
}
