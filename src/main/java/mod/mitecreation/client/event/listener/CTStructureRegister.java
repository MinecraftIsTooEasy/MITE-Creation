package mod.mitecreation.client.event.listener;

import mod.mitecreation.world.structure.MapGenCTRuins;
import moddedmite.rustedironcore.api.event.events.StructureRegisterEvent;
import moddedmite.rustedironcore.api.world.Dimension;
import org.spongepowered.asm.mixin.Unique;

import java.util.function.Consumer;

public class CTStructureRegister implements Consumer<StructureRegisterEvent> {
    @Unique private MapGenCTRuins ruinsGenerator = new MapGenCTRuins();

    @Override
    public void accept(StructureRegisterEvent structureRegisterEvent) {
        structureRegisterEvent.register(Dimension.OVERWORLD, ruinsGenerator);
    }
}
