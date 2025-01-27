package mod.mitecreation.client.audio;

import net.minecraft.StepSound;

public class CTStepSound extends StepSound {
    public final String namespace;
    public final String modSoundName;
    public final boolean hasSeparatePlaceSound;

    public CTStepSound(String sound, float volume, float pitch) {
        this(sound, volume, pitch, false);
    }

    public CTStepSound(String sound, float volume, float pitch, boolean hasSeparatePlaceSound) {
        super(sound, volume, pitch);

        if (sound.contains(":")) {
            String[] splitSound = sound.split(":");
            this.namespace = splitSound[0];
            this.modSoundName = splitSound[1];
        }
        else {
            this.namespace = "minecraft";
            this.modSoundName = sound;
        }

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
        }
        else {
            return this.getBreakSound();
        }
    }
}