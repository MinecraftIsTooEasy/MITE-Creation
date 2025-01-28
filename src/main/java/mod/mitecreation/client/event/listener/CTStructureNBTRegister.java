package mod.mitecreation.client.event.listener;

import mod.mitecreation.world.structure.ComponentCTRuins;
import mod.mitecreation.world.structure.StructureCTRuinsStart;
import moddedmite.rustedironcore.api.event.events.StructureNBTRegisterEvent;

import java.util.function.Consumer;

public class CTStructureNBTRegister implements Consumer<StructureNBTRegisterEvent> {
    @Override
    public void accept(StructureNBTRegisterEvent structureNBTRegisterEvent) {
        structureNBTRegisterEvent.registerStructureStart(StructureCTRuinsStart.class, "Ruins");
        structureNBTRegisterEvent.registerStructureComponent(ComponentCTRuins.class, "Ruins");
    }
}
