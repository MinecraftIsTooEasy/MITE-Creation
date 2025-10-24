package mod.mitecreation.world.biome;

import cn.tesseract.underbiome.biome.BiomeGenUnderBase;
import mod.mitecreation.entity.EntityCTSpiderQueen;
import mod.mitecreation.util.CTBiomeUtils;
import moddedmite.rustedironcore.api.world.BiomeAPI;
import net.minecraft.*;

import java.util.Random;

public class BiomeCTFault extends BiomeGenUnderBase {

    public BiomeCTFault(int id) {
        super(id);
        setColor(0xFF0000);
        setBiomeName("Fault");
        ((BiomeAPI) this).setBiomeUnlocalizedName("fault");
        setDisableRain();
        setTemperatureRainfall(1.0f, 0.0f);
        this.spawnableMonsterList.add(new SpawnListEntry(EntityCTSpiderQueen.class, 5, 1, 1));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityMagmaCube.class, 40, 1, 2));
    }

    @Override
    public void decorate(World world, Random random, int chunk_origin_x, int chunk_origin_z) {
        CTBiomeUtils.CTFaultGenerateBasalt(this,world,random,chunk_origin_x,chunk_origin_z);
        super.decorate(world,random,chunk_origin_x,chunk_origin_z);
    }

}
