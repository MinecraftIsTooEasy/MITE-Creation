package mod.mitecreation;

import mod.mitecreation.event.CreationEvents;
import net.fabricmc.api.ModInitializer;
import net.minecraft.Debug;
import net.minecraft.Minecraft;
import net.xiaoyu233.fml.reload.event.MITEEvents;

public class MITECreationMod implements ModInitializer {
    public static final String CreationNameSpace = "Creation";

    @Override
    public void onInitialize() {
        MITEEvents.MITE_EVENT_BUS.register(new CreationEvents());
        if (Minecraft.inDevMode()) {
            Debug.is_active = true;
        }
    }

}
