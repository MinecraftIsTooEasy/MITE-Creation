package cn.tesseract.underbiome.world;

import cn.tesseract.underbiome.biome.GenLayerUnderbiome;
import net.minecraft.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WorldChunkManagerUnderbiome extends WorldChunkManager {
    private GenLayer genBiomes;
    private GenLayer biomeIndexLayer;
    private BiomeCache biomeCache;

    public WorldChunkManagerUnderbiome(World world) {
        this.biomeCache = new BiomeCache(this);
        GenLayer[] layers = GenLayerUnderbiome.initializeAllBiomeGenerators(world.getSeed());
        genBiomes = layers[0];
        biomeIndexLayer = layers[1];
    }

    public BiomeGenBase getBiomeGenAt(int par1, int par2) {
        return biomeCache.getBiomeGenAt(par1, par2);
    }

    public float[] getRainfall(float[] fs, int i, int j, int k, int l) {
        IntCache.resetIntCache();

        if (fs == null || fs.length < k * l) {
            fs = new float[k * l];
        }

        int[] var6 = biomeIndexLayer.getInts(i, j, k, l, j);

        for (int a = 0; a < k * l; ++a) {
            float var8 = BiomeGenBase.biomeList[var6[a]].getIntRainfall() / 65536.0F;

            if (var8 > 1.0F) {
                var8 = 1.0F;
            }

            fs[a] = var8;
        }

        return fs;
    }

    public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] biomes, int par2, int par3, int par4, int par5) {
        IntCache.resetIntCache();

        if (biomes == null || biomes.length < par4 * par5) {
            biomes = new BiomeGenBase[par4 * par5];
        }

        int[] var6 = genBiomes.getInts(par2, par3, par4, par5, par3);

        for (int var7 = 0; var7 < par4 * par5; ++var7) {
            biomes[var7] = BiomeGenBase.biomeList[var6[var7]];
        }

        return biomes;
    }

    public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] biomes, int par2, int par3, int par4, int par5) {
        return this.getBiomeGenAt(biomes, par2, par3, par4, par5, true);
    }

    public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] biomes, int par2, int par3, int par4, int par5, boolean par6) {
        IntCache.resetIntCache();

        if (biomes == null || biomes.length < par4 * par5) {
            biomes = new BiomeGenBase[par4 * par5];
        }

        if (par6 && par4 == 16 && par5 == 16 && (par2 & 15) == 0 && (par3 & 15) == 0) {
            BiomeGenBase[] var9 = biomeCache.getCachedBiomes(par2, par3);
            System.arraycopy(var9, 0, biomes, 0, par4 * par5);
            return biomes;
        } else {
            int[] var7 = biomeIndexLayer.getInts(par2, par3, par4, par5, par3);

            for (int var8 = 0; var8 < par4 * par5; ++var8) {
                biomes[var8] = BiomeGenBase.biomeList[var7[var8]];
            }

            return biomes;
        }
    }

    public boolean areBiomesViable(int par1, int par2, int par3, List par4List) {
        IntCache.resetIntCache();
        int var5 = par1 - par3 >> 2;
        int var6 = par2 - par3 >> 2;
        int var7 = par1 + par3 >> 2;
        int var8 = par2 + par3 >> 2;
        int var9 = var7 - var5 + 1;
        int var10 = var8 - var6 + 1;
        int[] var11 = genBiomes.getInts(var5, var6, var9, var10, var6);

        for (int var12 = 0; var12 < var9 * var10; ++var12) {
            BiomeGenBase var13 = BiomeGenBase.biomeList[var11[var12]];

            if (!par4List.contains(var13))
                return false;
        }

        return true;
    }

    public ChunkPosition findBiomePosition(int par1, int par2, int par3, List par4List, Random par5Random) {
        IntCache.resetIntCache();
        int var6 = par1 - par3 >> 2;
        int var7 = par2 - par3 >> 2;
        int var8 = par1 + par3 >> 2;
        int var9 = par2 + par3 >> 2;
        int var10 = var8 - var6 + 1;
        int var11 = var9 - var7 + 1;
        int[] var12 = genBiomes.getInts(var6, var7, var10, var11, var7);
        ChunkPosition var13 = null;
        int var14 = 0;

        for (int var15 = 0; var15 < var10 * var11; ++var15) {
            int var16 = var6 + var15 % var10 << 2;
            int var17 = var7 + var15 / var10 << 2;
            BiomeGenBase var18 = BiomeGenBase.biomeList[var12[var15]];

            if (par4List.contains(var18) && (var13 == null || par5Random.nextInt(var14 + 1) == 0)) {
                var13 = new ChunkPosition(var16, 0, var17);
                ++var14;
            }
        }

        return var13;
    }

    public float[] getTemperatures(float[] fs, int i, int j, int k, int l) {
        if (fs == null || fs.length < k * l) {
            fs = new float[k * l];
        }

        Arrays.fill(fs, 0, k * l, 1);
        return fs;
    }
}
