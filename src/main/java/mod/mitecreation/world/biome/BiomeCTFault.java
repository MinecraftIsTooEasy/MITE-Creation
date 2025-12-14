package mod.mitecreation.world.biome;

import mod.mitecreation.util.CTBiomeUtils;
import mod.mitecreation.world.gen.WorldGenUnderLakes;
import moddedmite.rustedironcore.api.world.BiomeAPI;
import net.minecraft.*;

import java.util.Random;

public class BiomeCTFault extends BiomeGenUnderworld {
    private WorldGenUnderLakes lavaLakeGenerator;

    public BiomeCTFault(int id) {
        super(id);
        this.setColor(0xFF0000);
        this.setBiomeName("Fault");
        ((BiomeAPI) this).setBiomeUnlocalizedName("fault");
        this.setDisableRain();
        this.setTemperatureRainfall(1.0f, 0.0f);
        this.spawnableMonsterList.add(new SpawnListEntry(EntityMagmaCube.class, 40, 1, 2));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityPigZombie.class, 10, 1, 2));
        this.lavaLakeGenerator = new WorldGenUnderLakes(Block.lavaStill.blockID);
    }

    @Override
    public void decorate(World world, Random random, int chunk_origin_x, int chunk_origin_z) {
        CTBiomeUtils.CTFaultGenerateBasalt(this, world, random, chunk_origin_x, chunk_origin_z);
        CTBiomeUtils.CTFaultRegenerateNetherrack(this, world, random, chunk_origin_x, chunk_origin_z);
        CTBiomeUtils.CTFaultRegenerateNetherOres(this, world, random, chunk_origin_x, chunk_origin_z);
        if (this.lavaLakeGenerator != null) {
            int x = chunk_origin_x + random.nextInt(8) + 8;
            int y = random.nextInt(world.underworld_y_offset + random.nextInt(160));
            int z = chunk_origin_z + random.nextInt(8) + 8;

            if (y < 255 || random.nextInt(2) == 0) {
                this.lavaLakeGenerator.generate(world, random, x, y, z);
            }
        }
        super.decorate(world, random, chunk_origin_x, chunk_origin_z);
    }

}
