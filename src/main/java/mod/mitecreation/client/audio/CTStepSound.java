package mod.mitecreation.client.audio;

import net.minecraft.ResourceLocation;
import net.minecraft.StepSound;

public class CTStepSound extends StepSound {
    public final String namespace;
    public final String modSoundName;
    public final boolean hasSeparatePlaceSound;

    public CTStepSound(ResourceLocation sound, float volume, float pitch) {
        this(sound, volume, pitch, false);
    }

    public CTStepSound(ResourceLocation sound, float volume, float pitch, boolean hasSeparatePlaceSound) {
        super(sound.toString(), volume, pitch);
        this.namespace = sound.getResourceDomain();
        this.modSoundName = sound.getResourcePath();

        this.hasSeparatePlaceSound = hasSeparatePlaceSound;
    }

    @Override
    public String getBreakSound() {
        return this.namespace + ":block." + this.modSoundName + ".break";
    }

    @Override
    public String getStepSound() {
        return this.namespace + ":block." + this.modSoundName + ".step";
    }

    @Override
    public String getPlaceSound() {
        if (this.hasSeparatePlaceSound) {
            return this.namespace + ":block." + this.modSoundName + ".place";
        } else {
            return this.getBreakSound();
        }
    }
}