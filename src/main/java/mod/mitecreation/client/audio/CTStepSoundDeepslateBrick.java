package mod.mitecreation.client.audio;

import net.minecraft.ResourceLocation;

public class CTStepSoundDeepslateBrick extends CTStepSound {

    public CTStepSoundDeepslateBrick(ResourceLocation resource, float volume, float pitch) {
        super(resource, volume, pitch);
    }

    @Override
    public String getBreakSound() {
        return CTSounds.deepslateDig.toString();
    }
}