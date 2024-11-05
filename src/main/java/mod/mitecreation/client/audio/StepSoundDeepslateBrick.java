package mod.mitecreation.client.audio;

public class StepSoundDeepslateBrick extends StepSoundExtend {

    public StepSoundDeepslateBrick(String par1Str, float par2, float par3) {
        super(par1Str, par2, par3);
    }

    @Override
    public String getBreakSound() {
        return "dig.deepslate";
    }
}