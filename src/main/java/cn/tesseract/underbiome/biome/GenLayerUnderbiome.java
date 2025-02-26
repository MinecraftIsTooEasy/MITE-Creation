package cn.tesseract.underbiome.biome;

import mod.mitecreation.world.biome.CTBiomes;
import net.minecraft.*;

import java.util.ArrayList;

public class GenLayerUnderbiome extends GenLayer {
    public static ArrayList<BiomeGenBase> biomes = new ArrayList<>();

    static {
        biomes.add(BiomeGenBase.underworld);
    }

    public GenLayerUnderbiome(long seed, GenLayer layer) {
        super(seed);
        this.parent = layer;
    }

    public static GenLayer[] initializeAllBiomeGenerators(long seed) {
        GenLayer obj = new GenLayerIsland(1L);
        obj = new GenLayerFuzzyZoom(2000L, obj);

        for (int i = 1; i < 3; i++) {
            obj = new GenLayerFuzzyZoom(2000L + i, obj);
        }

        obj = GenLayerZoom.magnify(1000L, obj, 0);
        obj = new GenLayerUnderbiome(200L, obj);
        obj = GenLayerZoom.magnify(1000L, obj, 2);

        int biomesize = 3;
        for (int j = 0; j < biomesize; j++) {
            obj = new GenLayerZoom(1000L + j, obj);
        }

        GenLayerVoronoiZoom genlayervoronoizoom = new GenLayerVoronoiZoom(10L, obj);
        obj.initWorldGenSeed(seed);
        genlayervoronoizoom.initWorldGenSeed(seed);
        return (new GenLayer[]{obj, genlayervoronoizoom});
    }


    @Override
    public int[] getInts(int i, int j, int k, int l, int m) {
        int[] ints = IntCache.getIntCache(k * l);

        for (int x = 0; x < l; ++x) {
            for (int z = 0; z < k; ++z) {
                this.initChunkSeed(z + i, x + j);
                ints[z + x * k] = biomes.get(this.nextInt(biomes.size())).biomeID;
            }
        }

        return ints;
    }
}
