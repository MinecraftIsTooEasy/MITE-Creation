package mod.mitecreation.world.gen;

import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.*;

import java.util.Random;

public class WorldGenUnderLakes extends WorldGenLakes {
    private int blockIndex;

    public WorldGenUnderLakes(int blockId) {
        super(blockId);
        this.blockIndex = blockId;
    }

    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5) {
        par3 -= 8;

        for(par5 -= 8; par4 > 5 && par1World.isAirBlock(par3, par4, par5); --par4) {
        }

        if (par4 <= 4) {
            return false;
        } else {
            par4 -= 4;
            boolean[] var6 = new boolean[2048];
            int var7 = par2Random.nextInt(8) + 6;

            for(int var8 = 0; var8 < var7; ++var8) {
                double var9 = par2Random.nextDouble() * (double)8.0F + (double)4.0F;
                double var11 = par2Random.nextDouble() * (double)8.0F + (double)6.0F;
                double var13 = par2Random.nextDouble() * (double)8.0F + (double)4.0F;
                double var15 = par2Random.nextDouble() * ((double)16.0F - var9 - (double)2.0F) + (double)1.0F + var9 / (double)2.0F;
                double var17 = par2Random.nextDouble() * ((double)8.0F - var11 - (double)4.0F) + (double)2.0F + var11 / (double)2.0F;
                double var19 = par2Random.nextDouble() * ((double)16.0F - var13 - (double)2.0F) + (double)1.0F + var13 / (double)2.0F;

                for(int var21 = 1; var21 < 15; ++var21) {
                    for(int var22 = 1; var22 < 15; ++var22) {
                        for(int var23 = 1; var23 < 7; ++var23) {
                            double var24 = ((double)var21 - var15) / (var9 / (double)2.0F);
                            double var26 = ((double)var23 - var17) / (var11 / (double)2.0F);
                            double var28 = ((double)var22 - var19) / (var13 / (double)2.0F);
                            double var30 = var24 * var24 + var26 * var26 + var28 * var28;
                            if (var30 < (double)1.0F) {
                                var6[(var21 * 16 + var22) * 8 + var23] = true;
                            }
                        }
                    }
                }
            }

            for(int var35 = 0; var35 < 16; ++var35) {
                for(int var32 = 0; var32 < 16; ++var32) {
                    for(int var10 = 0; var10 < 8; ++var10) {
                        boolean var33 = !var6[(var35 * 16 + var32) * 8 + var10] && (var35 < 15 && var6[((var35 + 1) * 16 + var32) * 8 + var10] || var35 > 0 && var6[((var35 - 1) * 16 + var32) * 8 + var10] || var32 < 15 && var6[(var35 * 16 + var32 + 1) * 8 + var10] || var32 > 0 && var6[(var35 * 16 + (var32 - 1)) * 8 + var10] || var10 < 7 && var6[(var35 * 16 + var32) * 8 + var10 + 1] || var10 > 0 && var6[(var35 * 16 + var32) * 8 + (var10 - 1)]);
                        if (var33) {
                            Material var12 = par1World.getBlockMaterial(par3 + var35, par4 + var10, par5 + var32);
                            if (var10 >= 4 && var12.isLiquid()) {
                                return false;
                            }

                            if (var10 < 4 && !var12.isSolid() && par1World.getBlockId(par3 + var35, par4 + var10, par5 + var32) != this.blockIndex) {
                                return false;
                            }
                        }
                    }
                }
            }

            for(int var36 = 0; var36 < 16; ++var36) {
                int var8_times_16 = var36 * 16;

                for(int var32 = 0; var32 < 16; ++var32) {
                    int var8_times_128_plus_var32_times_8 = (var8_times_16 + var32) * 8;

                    for(int var10 = 0; var10 < 8; ++var10) {
                        if (var6[var8_times_128_plus_var32_times_8 + var10]) {
                            if (var10 < 3) {
                                Block block = par1World.getBlock(par3 + var36, par4 + var10 + 1, par5 + var32);
                                if (block == Block.wood) {
                                    return false;
                                }
                            } else if (var10 >= 4) {
                                Block block = par1World.getBlock(par3 + var36, par4 + var10, par5 + var32);
                                if (block == Block.wood || block == Block.leaves || block == Block.planks) {
                                    var6[(var36 * 16 + var32) * 8 + var10] = false;
                                }
                            } else {
                                Block block = par1World.getBlock(par3 + var36, par4 + var10 + 1, par5 + var32);
                                if (block == Block.wood) {
                                    var6[(var36 * 16 + var32) * 8 + var10] = false;
                                }
                            }
                        }
                    }
                }
            }

            Block lake_block = Block.getBlock(this.blockIndex);

            for(int var37 = 0; var37 < 16; ++var37) {
                for(int var32 = 0; var32 < 16; ++var32) {
                    for(int var10 = 0; var10 < 8; ++var10) {
                        if (var6[(var37 * 16 + var32) * 8 + var10]) {
                            int x = par3 + var37;
                            int y = par4 + var10;
                            int z = par5 + var32;
                            int block_id;
                            if (var10 >= 4) {
                                block_id = 0;
                            } else {
                                block_id = this.blockIndex;
                            }

                            par1World.setBlock(x, y, z, block_id, 0, 2);
                            Block block_above = par1World.getBlock(par3 + var37, par4 + var10 + 1, par5 + var32);
                            if (block_above != null && !block_above.isLegalOn(par1World.getBlockMetadata(par3 + var37, par4 + var10 + 1, par5 + var32), lake_block, 0)) {
                                par1World.setBlock(par3 + var37, par4 + var10 + 1, par5 + var32, 0, 0, 2);
                                int y_above = par4 + var10 + 1;

                                while(true) {
                                    ++y_above;
                                    if (y_above >= 256) {
                                        break;
                                    }

                                    block_above = par1World.getBlock(x, y_above, z);
                                    if (block_above == null || block_above.isLegalOn(par1World.getBlockMetadata(x, y_above, z), (Block)null, 0)) {
                                        break;
                                    }

                                    par1World.setBlock(x, y_above, z, 0, 0, 2);
                                }
                            }
                        }
                    }
                }
            }

            for(int var38 = 0; var38 < 16; ++var38) {
                for(int var32 = 0; var32 < 16; ++var32) {
                    for(int var10 = 4; var10 < 8; ++var10) {
                        if (var6[(var38 * 16 + var32) * 8 + var10] && par1World.getBlockId(par3 + var38, par4 + var10 - 1, par5 + var32) == Block.dirt.blockID && par1World.getSavedLightValue(EnumSkyBlock.Sky, par3 + var38, par4 + var10, par5 + var32) > 0) {
                            BiomeGenBase var35 = par1World.getBiomeGenForCoords(par3 + var38, par5 + var32);
                            if (var35.topBlock == Block.mycelium.blockID) {
                                par1World.setBlock(par3 + var38, par4 + var10 - 1, par5 + var32, Block.mycelium.blockID, 0, 2);
                            } else {
                                par1World.setBlock(par3 + var38, par4 + var10 - 1, par5 + var32, Block.grass.blockID, 0, 2);
                            }
                        }
                    }
                }
            }

            if (Block.blocksList[this.blockIndex].blockMaterial == Material.lava) {
                for(int var39 = 0; var39 < 16; ++var39) {
                    for(int var32 = 0; var32 < 16; ++var32) {
                        for(int var10 = 0; var10 < 8; ++var10) {
                            boolean var33 = !var6[(var39 * 16 + var32) * 8 + var10] && (var39 < 15 && var6[((var39 + 1) * 16 + var32) * 8 + var10] || var39 > 0 && var6[((var39 - 1) * 16 + var32) * 8 + var10] || var32 < 15 && var6[(var39 * 16 + var32 + 1) * 8 + var10] || var32 > 0 && var6[(var39 * 16 + (var32 - 1)) * 8 + var10] || var10 < 7 && var6[(var39 * 16 + var32) * 8 + var10 + 1] || var10 > 0 && var6[(var39 * 16 + var32) * 8 + (var10 - 1)]);
                            if (var33 && (var10 < 4 || par2Random.nextInt(2) != 0) && par1World.getBlockMaterial(par3 + var39, par4 + var10, par5 + var32).isSolid()) {
                                par1World.setBlock(par3 + var39, par4 + var10, par5 + var32, CTRegistryInit.deepSlate.blockID, 0, 2);
                            }
                        }
                    }
                }
            }

            for(int var40 = 0; var40 < 16; ++var40) {
                for(int var32 = 0; var32 < 16; ++var32) {
                    int x = par3 + var40;
                    int z = par5 + var32;
                    if (par1World.getBiomeGenForCoords(x, z).isFreezing()) {
                        int y = par1World.getPrecipitationHeight(x, z) - 1;
                        Block topmost_block = par1World.getBlock(x, y, z);
                        if (topmost_block == Block.waterStill) {
                            par1World.setBlock(x, y, z, Block.ice.blockID, 0, 2);
                        } else if (topmost_block != Block.ice && par1World.isBlockTopFlatAndSolid(x, y, z) && par1World.isAirBlock(x, y + 1, z)) {
                            par1World.setBlock(x, y + 1, z, Block.snow.blockID, 0, 2);
                        }

                        for(int dy = 7; dy >= 0; --dy) {
                            y = par4 + dy;
                            if (par1World.getBlock(x, y, z) == Block.waterStill && par1World.isAirBlock(x, y + 1, z)) {
                                par1World.setBlock(x, y, z, Block.ice.blockID, 0, 2);
                            }
                        }
                    } else {
                        int y = par1World.getPrecipitationHeight(x, z) - 1;
                        Block topmost_block = par1World.getBlock(x, y, z);
                        if (topmost_block == Block.dirt) {
                            par1World.setBlock(x, y, z, Block.grass.blockID, 0, 2);
                        }
                    }

                    for(int dy = 7; dy >= 0; --dy) {
                        int y = par4 + dy;
                        if (par1World.isAirOrPassableBlock(x, y, z, true)) {
                            Block block_above = par1World.getBlock(x, y + 1, z);
                            if (block_above == Block.wood) {
                                int metadata = par1World.getBlockMetadata(x, y + 1, z);
                                BlockLog log = (BlockLog)block_above;
                                if (log.getAxis(metadata).isUpDown()) {
                                    par1World.setBlock(x, y, z, Block.wood.blockID, metadata, 2);
                                }
                            }
                        }
                    }
                }
            }

            return true;
        }
    }
}
