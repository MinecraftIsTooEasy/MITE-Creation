package mod.mitecreation.world.biome;

import mod.mitecreation.entity.EntityCTSpiderQueen;
import mod.mitecreation.util.CTBiomeUtils;
import moddedmite.rustedironcore.api.world.BiomeAPI;
import net.minecraft.*;
import java.util.Random;

public class BiomeCTUndergarden extends BiomeGenUnderworld {

    public BiomeCTUndergarden(int id) {
        super(id);
        this.topBlock = (byte) Block.mycelium.blockID;
        this.fillerBlock = (byte) Block.dirt.blockID;
        this.theBiomeDecorator.surface_mushrooms_per_chunk = 10;
        setColor(0xFF0000);
        setBiomeName("Undergarden");
        ((BiomeAPI) this).setBiomeUnlocalizedName("undergarden");
        setDisableRain();
        setTemperatureRainfall(1.0f, 0.0f);
        this.spawnableMonsterList.add(new SpawnListEntry(EntityCTSpiderQueen.class, 5, 1, 1));
    }

    @Override
    public void decorate(World world, Random random, int chunk_origin_x, int chunk_origin_z) {
//        CTBiomeUtils.decorateCTUndergarden(this, world, random, chunk_origin_x, chunk_origin_z);
        CTBiomeUtils.CTUndergardenRegenerateDeepslate(this, world, random, chunk_origin_x, chunk_origin_z);
        CTBiomeUtils.decorateCTUndergardenMushroom(this, world, random, chunk_origin_x, chunk_origin_z);
        super.decorate(world, random, chunk_origin_x, chunk_origin_z);
    }
}
