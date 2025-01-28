package mod.mitecreation.client.event.listener;

import mod.mitecreation.world.structure.MapGenCTRuins;
import moddedmite.rustedironcore.api.event.events.StructureRegisterEvent;
import moddedmite.rustedironcore.api.world.Dimension;

import java.util.function.Consumer;

public class CTStructureRegister implements Consumer<StructureRegisterEvent> {
    private MapGenCTRuins ruinsGenerator = null;

    @Override
    public void accept(StructureRegisterEvent structureRegisterEvent) {
        ruinsGenerator = new MapGenCTRuins();
        structureRegisterEvent.register(Dimension.OVERWORLD, ruinsGenerator);
    }
}
