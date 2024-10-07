package mod.mitecreation.client.event;

import mod.mitecreation.client.event.listener.BeaconListener;
import mod.mitecreation.client.event.listener.FurnaceListener;
import mod.mitecreation.client.event.listener.
        PropertyRegistry;
import mod.mitecreation.item.CreationItem;
import mod.mitecreation.material.CreationMaterial;
import moddedmite.rustedironcore.api.event.Handlers;
import moddedmite.rustedironcore.api.event.handler.GravelDropHandler;

public class CreationRICEvents extends Handlers {
        public static void register() {
            FurnaceUpdate.register(new FurnaceListener());
            BeaconUpdate.register(new BeaconListener());

            GravelDrop.registerGravelLootEntry(new GravelDropHandler.GravelLootEntry((float) (GravelDropHandler.MithrilEntry.weight() * 1.25), info -> CreationItem.rawTungstenNugget.itemID));

            ArrowRegister.register(floatProperty -> {
                floatProperty.register(CreationMaterial.tungsten, 0.8F);
            });

            PropertiesRegistry.register(new PropertyRegistry());
        }
}
