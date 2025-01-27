package mod.mitecreation.world.gen;

import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.*;

import java.util.Random;

public class WorldGenCTPeachTrees extends WorldGenerator {
    private final int minTreeHeight;
    private final boolean vinesGrow;
    private final int metaWood;
    private final int metaLeaves;

    public WorldGenCTPeachTrees(boolean par1) {
        this(par1, 4, 0, 0, false);
    }

    public WorldGenCTPeachTrees(boolean par1, int par2, int par3, int par4, boolean par5) {
        super(par1);
        this.minTreeHeight = par2;
        this.metaWood = par3;
        this.metaLeaves = par4;
        this.vinesGrow = par5;
    }

    public boolean generate(World par1World, Random par2Random, int x, int y, int z) {
        int var6 = par2Random.nextInt(3) + this.minTreeHeight;
        boolean var7 = true;

        if (y >= 1 && y + var6 + 1 <= 256) {
            int var8;
            byte radius;
            int yLevel;
            int yDistanceFromCenter;
            int maxHorizontalRadius;

            for (var8 = y; var8 <= y + 1 + var6; ++var8) {
                radius = 1;

                if (var8 == y) {
                    radius = 0;
                }

                if (var8 >= y + 1 + var6 - 2) {
                    radius = 2;
                }

                for (maxHorizontalRadius = x - radius; maxHorizontalRadius <= x + radius && var7; ++maxHorizontalRadius) {
                    for (yLevel = z - radius; yLevel <= z + radius && var7; ++yLevel) {
                        if (var8 >= 0 && var8 < 256) {
                            yDistanceFromCenter = par1World.getBlockId(maxHorizontalRadius, var8, yLevel);

                            if (yDistanceFromCenter != 0 && yDistanceFromCenter != CTRegistryInit.peachLeaves.blockID && yDistanceFromCenter != Block.grass.blockID && yDistanceFromCenter != Block.dirt.blockID && yDistanceFromCenter != CTRegistryInit.peachWood.blockID) {
                                var7 = false;
                            }
                        } else {
                            var7 = false;
                        }
                    }
                }
            }

            if (!var7) {
                return false;
            } else {
                maxHorizontalRadius = 0;
                var8 = par1World.getBlockId(x, y - 1, z);

                if ((var8 == Block.grass.blockID || var8 == Block.dirt.blockID) && y < 256 - var6 - 1) {
                    this.setBlock(par1World, x, y - 1, z, Block.dirt.blockID);
                    radius = 3;
                    byte baseOffset = 0;
                    int horizontalRadius;
                    int xIterator;
                    int zIterator;

                    for (yLevel = y - radius + var6; yLevel <= y + var6 + 2; ++yLevel) {
                        yDistanceFromCenter = yLevel - (y + var6);
                        horizontalRadius = baseOffset + 1 - yDistanceFromCenter / 2;

                        if (horizontalRadius > maxHorizontalRadius) {
                            maxHorizontalRadius = horizontalRadius;
                        }

                        for (xIterator = x - horizontalRadius; xIterator <= x + horizontalRadius; ++xIterator) {
                            int xDistanceFromCenter = xIterator - x;

                            for (zIterator = z - horizontalRadius; zIterator <= z + horizontalRadius; ++zIterator) {
                                int zDistanceFromCenter = zIterator - z;

                                if (xDistanceFromCenter != horizontalRadius || -xDistanceFromCenter != horizontalRadius || zDistanceFromCenter != horizontalRadius || -zDistanceFromCenter != horizontalRadius || par2Random.nextInt(2) != 0 && yDistanceFromCenter != 0) {
                                    int blockId = par1World.getBlockId(xIterator, yLevel, zIterator);

                                    if (blockId == 0 || blockId == CTRegistryInit.peachLeaves.blockID) {
                                        this.setBlockAndMetadata(par1World, xIterator, yLevel, zIterator, CTRegistryInit.peachLeaves.blockID, this.metaLeaves);
                                    }
                                }
                            }
                        }
                    }

                    for (yLevel = 0; yLevel < var6; ++yLevel) {
                        yDistanceFromCenter = par1World.getBlockId(x, y + yLevel, z);

                        if (yDistanceFromCenter == 0 || yDistanceFromCenter == CTRegistryInit.peachLeaves.blockID) {
                            this.setBlockAndMetadata(par1World, x, y + yLevel, z, CTRegistryInit.peachWood.blockID, this.metaWood);

                            if (this.vinesGrow && yLevel > 0) {
                                if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(x - 1, y + yLevel, z)) {
                                    this.setBlockAndMetadata(par1World, x - 1, y + yLevel, z, Block.vine.blockID, 8);
                                }

                                if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(x + 1, y + yLevel, z)) {
                                    this.setBlockAndMetadata(par1World, x + 1, y + yLevel, z, Block.vine.blockID, 2);
                                }

                                if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(x, y + yLevel, z - 1)) {
                                    this.setBlockAndMetadata(par1World, x, y + yLevel, z - 1, Block.vine.blockID, 1);
                                }

                                if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(x, y + yLevel, z + 1)) {
                                    this.setBlockAndMetadata(par1World, x, y + yLevel, z + 1, Block.vine.blockID, 4);
                                }
                            }
                        }
                    }

                    if (this.vinesGrow) {
                        for (yLevel = y - 3 + var6; yLevel <= y + var6; ++yLevel) {
                            yDistanceFromCenter = yLevel - (y + var6);
                            horizontalRadius = 2 - yDistanceFromCenter / 2;

                            for (xIterator = x - horizontalRadius; xIterator <= x + horizontalRadius; ++xIterator) {
                                for (zIterator = z - horizontalRadius; zIterator <= z + horizontalRadius; ++zIterator) {
                                    if (par1World.getBlockId(xIterator, yLevel, zIterator) ==  CTRegistryInit.peachLeaves.blockID) {
                                        if (par2Random.nextInt(4) == 0 && par1World.getBlockId(xIterator - 1, yLevel, zIterator) == 0) {
                                            this.growVines(par1World, xIterator - 1, yLevel, zIterator, 8);
                                        }

                                        if (par2Random.nextInt(4) == 0 && par1World.getBlockId(xIterator + 1, yLevel, zIterator) == 0) {
                                            this.growVines(par1World, xIterator + 1, yLevel, zIterator, 2);
                                        }

                                        if (par2Random.nextInt(4) == 0 && par1World.getBlockId(xIterator, yLevel, zIterator - 1) == 0) {
                                            this.growVines(par1World, xIterator, yLevel, zIterator - 1, 1);
                                        }

                                        if (par2Random.nextInt(4) == 0 && par1World.getBlockId(xIterator, yLevel, zIterator + 1) == 0) {
                                            this.growVines(par1World, xIterator, yLevel, zIterator + 1, 4);
                                        }
                                    }
                                }
                            }
                        }

                        if (par2Random.nextInt(5) == 0 && var6 > 5) {
                            for (yLevel = 0; yLevel < 2; ++yLevel) {
                                for (yDistanceFromCenter = 0; yDistanceFromCenter < 4; ++yDistanceFromCenter) {
                                    if (par2Random.nextInt(4 - yLevel) == 0) {
                                        horizontalRadius = par2Random.nextInt(3);
                                        this.setBlockAndMetadata(par1World, x + Direction.offsetX[Direction.rotateOpposite[yDistanceFromCenter]], y + var6 - 5 + yLevel, z + Direction.offsetZ[Direction.rotateOpposite[yDistanceFromCenter]], Block.cocoaPlant.blockID, horizontalRadius << 2 | yDistanceFromCenter);
                                    }
                                }
                            }
                        }
                    }

                    if (par1World.decorating) {
                        par1World.placeNaturallyOccurringSnow(x - maxHorizontalRadius, z - maxHorizontalRadius, x + maxHorizontalRadius, z + maxHorizontalRadius);
                    }

                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }
    
    private void growVines(World par1World, int par2, int par3, int par4, int par5) {
        this.setBlockAndMetadata(par1World, par2, par3, par4, Block.vine.blockID, par5);
        int var6 = 4;

        while (true) {
            --par3;

            if (par1World.getBlockId(par2, par3, par4) != 0 || var6 <= 0) {
                return;
            }

            this.setBlockAndMetadata(par1World, par2, par3, par4, Block.vine.blockID, par5);
            --var6;
        }
    }
}
