package cn.tesseract.underbiome.world;

import mod.mitecreation.init.CTRegistryInit;
import mod.mitecreation.world.biome.CTBiomes;
import net.minecraft.*;

import java.util.List;
import java.util.Random;

public class ChunkProviderUnderbiome implements IChunkProvider {
    private final Random hellRNG;
    private final NoiseGeneratorOctaves netherNoiseGen1;
    private final NoiseGeneratorOctaves netherNoiseGen2;
    private final NoiseGeneratorOctaves netherNoiseGen3;
    public NoiseGeneratorOctaves netherNoiseGen6;
    public NoiseGeneratorOctaves netherNoiseGen7;
    private final World worldObj;
    private BiomeGenBase[] biomesForGeneration;
    private double[] noiseField;
    double[] noiseData1;
    double[] noiseData2;
    double[] noiseData3;
    double[] noiseData4;
    double[] noiseData5;

    public ChunkProviderUnderbiome(World par1World, long par2) {
        this.worldObj = par1World;
        this.hellRNG = new Random(par2);
        this.netherNoiseGen1 = new NoiseGeneratorOctaves(this.hellRNG, 16);
        this.netherNoiseGen2 = new NoiseGeneratorOctaves(this.hellRNG, 16);
        this.netherNoiseGen3 = new NoiseGeneratorOctaves(this.hellRNG, 8);
        this.netherNoiseGen6 = new NoiseGeneratorOctaves(this.hellRNG, 10);
        this.netherNoiseGen7 = new NoiseGeneratorOctaves(this.hellRNG, 16);
        ChunkProviderUnderworld.noise_gen_bedrock_strata_1a = new NoiseGeneratorOctaves(this.hellRNG, 4);
        ChunkProviderUnderworld.noise_gen_bedrock_strata_1b = new NoiseGeneratorOctaves(this.hellRNG, 4);
        ChunkProviderUnderworld.noise_gen_bedrock_strata_2 = new NoiseGeneratorOctaves(this.hellRNG, 4);
        ChunkProviderUnderworld.noise_gen_bedrock_strata_3 = new NoiseGeneratorOctaves(this.hellRNG, 4);
        ChunkProviderUnderworld.noise_gen_bedrock_strata_4 = new NoiseGeneratorOctaves(this.hellRNG, 4);
        ChunkProviderUnderworld.noise_gen_bedrock_strata_1a_bump = new NoiseGeneratorOctaves(this.hellRNG, 4);
        ChunkProviderUnderworld.noise_gen_bedrock_strata_1b_bump = new NoiseGeneratorOctaves(this.hellRNG, 4);
        ChunkProviderUnderworld.noise_gen_bedrock_strata_1c_bump = new NoiseGeneratorOctaves(this.hellRNG, 4);
        ChunkProviderUnderworld.noise_gen_bedrock_strata_2_bump = new NoiseGeneratorOctaves(this.hellRNG, 4);
        ChunkProviderUnderworld.noise_gen_bedrock_strata_3_bump = new NoiseGeneratorOctaves(this.hellRNG, 4);
        ChunkProviderUnderworld.noise_gen_bedrock_strata_4_bump = new NoiseGeneratorOctaves(this.hellRNG, 4);
    }

    public void generateNetherTerrain(int par1, int par2, byte[] par3ArrayOfByte) {
        byte var4 = 4;
        byte var5 = 32;
        int var6 = var4 + 1;
        byte var7 = 17;
        int var8 = var4 + 1;
        this.noiseField = this.initializeNoiseField(this.noiseField, par1 * var4, 0, par2 * var4, var6, var7, var8);

        for (int var9 = 0; var9 < var4; ++var9) {
            for (int var10 = 0; var10 < var4; ++var10) {
                for (int var11 = 0; var11 < 16; ++var11) {
                    double var12 = 0.125F;
                    double var14 = this.noiseField[((var9) * var8 + var10) * var7 + var11];
                    double var16 = this.noiseField[((var9) * var8 + var10 + 1) * var7 + var11];
                    double var18 = this.noiseField[((var9 + 1) * var8 + var10) * var7 + var11];
                    double var20 = this.noiseField[((var9 + 1) * var8 + var10 + 1) * var7 + var11];
                    double var22 = (this.noiseField[((var9) * var8 + var10) * var7 + var11 + 1] - var14) * var12;
                    double var24 = (this.noiseField[((var9) * var8 + var10 + 1) * var7 + var11 + 1] - var16) * var12;
                    double var26 = (this.noiseField[((var9 + 1) * var8 + var10) * var7 + var11 + 1] - var18) * var12;
                    double var28 = (this.noiseField[((var9 + 1) * var8 + var10 + 1) * var7 + var11 + 1] - var20) * var12;

                    for (int var30 = 0; var30 < 8; ++var30) {
                        double var31 = 0.25F;
                        double var33 = var14;
                        double var35 = var16;
                        double var37 = (var18 - var14) * var31;
                        double var39 = (var20 - var16) * var31;

                        for (int var41 = 0; var41 < 4; ++var41) {
                            int var42 = var41 + var9 * 4 << 11 | var10 * 4 << 7 | var11 * 8 + var30;
                            short var43 = 128;
                            double var44 = 0.25F;
                            double var46 = var33;
                            double var48 = (var35 - var33) * var44;

                            for (int var50 = 0; var50 < 4; ++var50) {
                                int var51 = 0;
                                if (var11 * 8 + var30 < var5 - 8) {
                                    var51 = Block.waterStill.blockID;
                                }

                                if (var46 > (double) 0.0F) {
                                    var51 = Block.stone.blockID;
                                }

                                par3ArrayOfByte[var42] = (byte) var51;
                                var42 += var43;
                                var46 += var48;
                            }

                            var33 += var37;
                            var35 += var39;
                        }

                        var14 += var22;
                        var16 += var24;
                        var18 += var26;
                        var20 += var28;
                    }
                }
            }
        }

    }

    //blocks[(x*16+z)*128+y] blocks[(x<<4|z)<<7|y]
    public void replaceBlocksForBiome(int par1, int par2, byte[] blocks) {
        for (int var7 = 0; var7 < 16; ++var7) {
            for (int var8 = 0; var8 < 16; ++var8) {
                for(int var15 = 127; var15 >= 0; --var15) {
                    //if(worldObj.getBlock(par1+var7,y,par2+var8) == null && worldObj.getBlock(par1+var7,y-1,par2+var8) != Block.mycelium && worldObj.getBlock(par1+var7,y,par2+var8) != null){
                    //    worldObj.setBlock(par1+var7,y-1,par2+var8,Block.mycelium.blockID);
                    //    worldObj.setBlock(par1+var7,y-2,par2+var8,Block.dirt.blockID);
                    //}
                    BiomeGenBase biome = biomesForGeneration[var8 + var7*16];
                    if (biome == BiomeGenBase.underworld) continue;
                    this.hellRNG.nextDouble();
                    this.hellRNG.nextDouble();
                    this.hellRNG.nextDouble();
                    int var16 = (var8 * 16 + var7) * 128 + var15;
                    if(biome == CTBiomes.UNDERGARDEN){
                        if(blocks[var16] == 0 && blocks[var16-1] != Block.mycelium.blockID && blocks[var16-1] != Block.waterStill.blockID && blocks[var16-1] != 0){
                            blocks[var16-1] = (byte) Block.mycelium.blockID;
                            if(blocks[var16-3] == 0) continue;
                            blocks[var16-2] = (byte) Block.dirt.blockID;
                        }
                    }

//                    if (biome == CTBiomes.UNDERGARDEN) {
//                        if (blocks[var16] == 0 && blocks[var16 - 1] != Block.mycelium.blockID && blocks[var16 - 1] != Block.waterStill.blockID && blocks[var16 - 1] != 0) {
//                            blocks[var16 - 1] = (byte) Block.mycelium.blockID;
//                            if (blocks[var16 - 3] == 0) continue;
//                            blocks[var16 - 2] = (byte) Block.dirt.blockID;
//                        }
//                    }
                    // if(worldObj.getBlock(par1+var7,y,par2+var8) == null){
                    //    System.out.println(blocks[(var7<<4|var8)<<7|y]); =1
                    //}

                    /*
                    for (int var15 = 127; var15 >= 0; --var15) {
                    int var16 = (var8 * 16 + var7) * 128 + var15;

                    if (blocks[var16] == 1)
                        blocks[var16] = (byte) (biomegenbase == BiomeGenBase.hell ? Block.netherrack.blockID : Block.whiteStone.blockID);
                    }
                     */
                }
            }
        }

    }

    public Chunk loadChunk(int par1, int par2) {
        return this.provideChunk(par1, par2);
    }

    public Chunk provideChunk(int par1, int par2) {
        if (!this.worldObj.isChunkWithinBlockDomain(par1, par2)) {
            Chunk chunk = new Chunk(this.worldObj, par1, par2);
            chunk.generateHeightMap(false);
            return chunk;
        } else {
            this.hellRNG.setSeed((long) par1 * 341873128712L + (long) par2 * 132897987541L);
            byte[] var3 = new byte['耀'];
            this.generateNetherTerrain(par1, par2, var3);
            biomesForGeneration = worldObj.getWorldChunkManager().loadBlockGeneratorData(biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
            this.replaceBlocksForBiome(par1, par2, var3);
            ChunkProviderGenerate.placeRandomCobwebs(par1, par2, var3, this.hellRNG);
            Chunk var4 = new Chunk(this.worldObj, var3, par1, par2);
            BiomeGenBase[] var5 = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(null, par1 * 16, par2 * 16, 16, 16);
            byte[] var6 = var4.getBiomeArray();

            for (int var7 = 0; var7 < var6.length; ++var7) {
                var6[var7] = (byte) var5[var7].biomeID;
            }

            var4.generateHeightMap(false);
            var4.resetRelightChecks();
            return var4;
        }
    }

    private double[] initializeNoiseField(double[] par1ArrayOfDouble, int par2, int par3, int par4, int par5, int par6, int par7) {
        if (par1ArrayOfDouble == null) {
            par1ArrayOfDouble = new double[par5 * par6 * par7];
        }

        double var8 = 684.412;
        double var10 = 2053.236;
        this.noiseData4 = this.netherNoiseGen6.generateNoiseOctaves(this.noiseData4, par2, par3, par4, par5, 1, par7, 1.0F, 0.0F, 1.0F);
        this.noiseData5 = this.netherNoiseGen7.generateNoiseOctaves(this.noiseData5, par2, par3, par4, par5, 1, par7, 100.0F, 0.0F, 100.0F);
        this.noiseData1 = this.netherNoiseGen3.generateNoiseOctaves(this.noiseData1, par2, par3, par4, par5, par6, par7, var8 / (double) 80.0F, var10 / (double) 60.0F, var8 / (double) 80.0F);
        this.noiseData2 = this.netherNoiseGen1.generateNoiseOctaves(this.noiseData2, par2, par3, par4, par5, par6, par7, var8, var10, var8);
        this.noiseData3 = this.netherNoiseGen2.generateNoiseOctaves(this.noiseData3, par2, par3, par4, par5, par6, par7, var8, var10, var8);
        int var12 = 0;
        double[] var14 = new double[par6];

        for (int var15 = 0; var15 < par6; ++var15) {
            var14[var15] = Math.cos((double) var15 * Math.PI * (double) 6.0F / (double) par6) * (double) 2.0F;
            double var16 = var15;
            if (var15 > par6 / 2) {
                var16 = par6 - 1 - var15;
            }

            if (var16 < (double) 4.0F) {
                var16 = (double) 4.0F - var16;
                var14[var15] -= var16 * var16 * var16 * (double) 10.0F;
            }
        }

        for (int var361 = 0; var361 < par5; ++var361) {
            for (int var36 = 0; var36 < par7; ++var36) {
                double var19 = 0.0F;

                for (int var23 = 0; var23 < par6; ++var23) {
                    double var24;
                    double var26 = var14[var23];
                    double var28 = this.noiseData2[var12] / (double) 512.0F;
                    double var30 = this.noiseData3[var12] / (double) 512.0F;
                    double var32 = (this.noiseData1[var12] / (double) 10.0F + (double) 1.0F) / (double) 2.0F;
                    if (var32 < (double) 0.0F) {
                        var24 = var28;
                    } else if (var32 > (double) 1.0F) {
                        var24 = var30;
                    } else {
                        var24 = var28 + (var30 - var28) * var32;
                    }

                    var24 -= var26;
                    if (var23 > par6 - 4) {
                        double var34 = (float) (var23 - (par6 - 4)) / 3.0F;
                        var24 = var24 * ((double) 1.0F - var34) + (double) -10.0F * var34;
                    }

                    if ((double) var23 < var19) {
                        double var34 = (var19 - (double) var23) / (double) 4.0F;
                        if (var34 < (double) 0.0F) {
                            var34 = 0.0F;
                        }

                        if (var34 > (double) 1.0F) {
                            var34 = 1.0F;
                        }

                        var24 = var24 * ((double) 1.0F - var34) + (double) -10.0F * var34;
                    }

                    par1ArrayOfDouble[var12] = var24;
                    ++var12;
                }
            }
        }

        return par1ArrayOfDouble;
    }

    public boolean chunkExists(int par1, int par2) {
        return true;
    }

    public Chunk getChunkIfItExists(int chunk_x, int chunk_z) {
        Minecraft.setErrorMessage("getChunkIfItExists: called for ChunkProviderUnderworld");
        return null;
    }

    public void populate(IChunkProvider par1IChunkProvider, int par2, int par3) {
        BlockFalling.fallInstantly = true;
        int var4 = par2 * 16;
        int var5 = par3 * 16;
        if (this.worldObj.underworld_y_offset != 0) {
            for (int i = 0; i < 16; ++i) {
                int x = var4 + this.hellRNG.nextInt(16) + 8;
                int y = this.hellRNG.nextInt(32) + 20 + this.worldObj.underworld_y_offset;
                int z = var5 + this.hellRNG.nextInt(16) + 8;
                (new WorldGenDungeons()).generate(this.worldObj, this.hellRNG, x, y, z);
            }
        }

        BiomeGenBase biome = this.worldObj.getBiomeGenForCoords(var4 + 16, var5 + 16);
        biome.decorate(this.worldObj, this.worldObj.rand, var4, var5);
        BlockFalling.fallInstantly = false;
    }

    public boolean saveChunks(boolean par1, IProgressUpdate par2IProgressUpdate) {
        return true;
    }

    public void saveExtraData() {
    }

    public boolean unloadQueuedChunks() {
        return false;
    }

    public boolean canSave() {
        return true;
    }

    public String makeString() {
        return "UnderworldRandomLevelSource";
    }

    public List getPossibleCreatures(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4) {
        BiomeGenBase var5 = this.worldObj.getBiomeGenForCoords(par2, par4);
        return var5 == null ? null : var5.getSpawnableList(par1EnumCreatureType);
    }

    public ChunkPosition findClosestStructure(World par1World, String par2Str, int par3, int par4, int par5) {
        return null;
    }

    public int getLoadedChunkCount() {
        return 0;
    }

    public void recreateStructures(int par1, int par2) {
    }
}
