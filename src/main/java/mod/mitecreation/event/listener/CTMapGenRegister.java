package mod.mitecreation.event.listener;

import mod.mitecreation.world.structure.MapGenCTRuins;
import moddedmite.rustedironcore.api.event.events.MapGenRegisterEvent;
import moddedmite.rustedironcore.api.world.Dimension;
import net.minecraft.MapGenCaves;
import net.minecraft.MapGenRavine;

import java.util.function.Consumer;

public class CTMapGenRegister implements Consumer<MapGenRegisterEvent> {

    @Override
    public void accept(MapGenRegisterEvent event) {
        MapGenCTRuins ruinsGenerator = new MapGenCTRuins();
        MapGenRavine ravine = new MapGenRavine();
        event.registerStructure(Dimension.OVERWORLD, ruinsGenerator);
        event.register(Dimension.UNDERWORLD, ravine);
    }
}
