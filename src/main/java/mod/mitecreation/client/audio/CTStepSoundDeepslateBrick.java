package mod.mitecreation.client.audio;

public class CTStepSoundDeepslateBrick extends CTStepSound {

    public CTStepSoundDeepslateBrick(String par1Str, float par2, float par3) {
        super(par1Str, par2, par3);
    }

    @Override
    public String getBreakSound() {
        return CTSounds.deepslateDig.toString();
    }
}