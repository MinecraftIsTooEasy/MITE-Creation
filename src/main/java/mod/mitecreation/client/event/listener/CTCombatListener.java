package mod.mitecreation.client.event.listener;

import moddedmite.rustedironcore.api.event.listener.ICombatListener;
import net.minecraft.*;

public class CTCombatListener implements ICombatListener {
    @Override
    public float onPlayerBlockReachModify(EntityPlayer player, Block block, int metadata, float original) {
        return original + (float) player.getExperienceLevel() / 100;
    }

    @Override
    public float onPlayerEntityReachModify(EntityPlayer player, EnumEntityReachContext context, Entity entity, float original) {
        return original + (float) player.getExperienceLevel() / 100;
    }
}

