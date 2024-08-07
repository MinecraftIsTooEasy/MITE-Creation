package huix.faustpotion.start

import huix.faustpotion.event.FaustPotionEvents
import net.fabricmc.api.ModInitializer
import net.xiaoyu233.fml.reload.event.MITEEvents

class MainKt : ModInitializer {



    override fun onInitialize() {
        MITEEvents.MITE_EVENT_BUS.register(FaustPotionEvents())
    }


}