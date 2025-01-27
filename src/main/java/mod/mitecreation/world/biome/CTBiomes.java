package mod.mitecreation.world.biome;

import net.minecraft.BiomeGenBase;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class CTBiomes extends BiomeGenBase {
    public static final BiomeGenBase TAOYUAN = new BiomeCTTaoyuan(IdUtil.getNextBiomeId());

    protected CTBiomes(int par1) {
        super(par1);
    }
}
