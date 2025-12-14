package mod.mitecreation.world.biome;

import net.minecraft.BiomeGenBase;
import net.minecraft.BiomeGenUnderworld;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class CTBiomes extends BiomeGenBase {
    public static final BiomeGenBase TAOYUAN = new BiomeCTTaoyuan(IdUtil.getNextBiomeId());
    // underworld
    public static final BiomeGenBase UNDERGARDEN = new BiomeCTUndergarden(IdUtil.getNextBiomeId());
    public static final BiomeGenBase FAULT = new BiomeCTFault(IdUtil.getNextBiomeId());
//    public static final BiomeGenBase STONES = new BiomeCTStones(IdUtil.getNextBiomeId());

    protected CTBiomes(int id) {
        super(id);
    }
}
