package mod.mitecreation.client.render;

import mod.mitecreation.init.CreationModInit;
import moddedmite.rustedironcore.api.render.RenderAPI;
import net.minecraft.RenderCreeper;

public class RenderCTDecayCreeper extends RenderCreeper implements RenderAPI {
    @Override
    protected void setTextures() {
        this.setTexture(0, CreationModInit.COLON_ID + "textures/entity/creeper/" + this.getSubtypeName());
        this.setTexture(1, "textures/entity/creeper/creeper_armor");
    }

    @Override
    public String getSubtypeName() {
        return "decay_creeper";
    }

    @Override
    public boolean forceGlowOverride() {
        return true;
    }

}
