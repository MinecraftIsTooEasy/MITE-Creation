package mod.mitecreation.client.audio;

import net.minecraft.StepSound;

public class StepSoundExtend extends StepSound {

    public StepSoundExtend(String par1Str, float par2, float par3) {
        super(par1Str, par2, par3);
    }

    @Override
    public String getPlaceSound() {
        return "place." + this.stepSoundName;
    }
}
