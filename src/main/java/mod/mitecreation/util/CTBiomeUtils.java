package mod.mitecreation.util;

import mod.mitecreation.init.CTRegistryInit;
import mod.mitecreation.world.biome.BiomeCTFault;
import mod.mitecreation.world.biome.BiomeCTUndergarden;
import mod.mitecreation.world.biome.CTBiomes;
import net.minecraft.*;

import java.util.List;
import java.util.Random;

public class CTBiomeUtils {
    public static boolean decorateCTUndergarden(BiomeCTUndergarden undergarden, World world, Random random, int chunk_origin_x, int chunk_origin_z) {
        for (int x = chunk_origin_x; x < chunk_origin_x + 16; ++x) {
            for (int z = chunk_origin_z; z < chunk_origin_z + 16; ++z) {
                for (int y = 255; y >= 0; --y) {
                    if (world.isAirBlock(x, y, z) && world.getBlockId(x, y - 1, z) == CTRegistryInit.deepSlate.blockID && world.getBlockId(x, y - 1, z) != Block.waterStill.blockID && world.getBlockId(x, y - 1, z) != 0) {
                        world.setBlock(x, y - 1, z, Block.mycelium.blockID);
                        if (!world.isAirBlock(x, y - 3, z)) {
                            world.setBlock(x, y - 2, z, Block.dirt.blockID);
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void decorateCTUndergardenMushroom(BiomeCTUndergarden undergarden, World world, Random random, int chunk_origin_x, int chunk_origin_z) {
        for (int x = chunk_origin_x; x < chunk_origin_x + 16; ++x) {
            for (int z = chunk_origin_z; z < chunk_origin_z + 16; ++z) {
                random.setSeed(world.getSeed());
                for (int i = 0; i < 128; ++i) {
                    var y = i + world.underworld_y_offset;
                    if (world.isAirBlock(x, y + 1, z)) {
                        Block block = world.getBlock(x, y, z);
                        if (block != null && block.isAlwaysSolidOpaqueStandardFormCube()) {
                            world.getChunkFromBlockCoords(x, z).setHadNaturallyOccurringMycelium();
                            random.setSeed(world.getSeed() + (long) MathHelper.getIntPairHash(x, z));
                            random.nextInt();
                            if (random.nextInt(200) == 0)
                                undergarden.theBiomeDecorator.bigMushroomGen.generate(world, random, x, y + 1, z);
                            if (random.nextInt(20) == 0 && world.getBlock(x, y + 1, z) == null && world.getBlock(x, y, z) == Block.mycelium)
                                world.setBlock(x, y + 1, z, Block.mushroomBrown.blockID, 0, 2);
                        }
                    }
                }
            }
        }
    }

    public static void CTUndergardenRegenerateDeepslate(BiomeCTUndergarden undergarden, World world, Random random, int chunk_origin_x, int chunk_origin_z) {
        ChunkPostField deepSlate_posts = new ChunkPostField(114514, world.getHashedSeed(), 16, 0.2f);
        for (int x = chunk_origin_x; x < chunk_origin_x + 16; ++x) {
            for (int z = chunk_origin_z; z < chunk_origin_z + 16; ++z) {
                if (world.getBiomeGenForCoords(x, z) != CTBiomes.UNDERGARDEN) continue;
                List<ChunkPost> posts = deepSlate_posts.getNearbyPostsForBlockCoords(x, z);
                for (ChunkPost post : posts) {
                    if (!(post.getDistanceSqFromBlockCoords(x, z) > (double) (deepSlate_posts.getPostMaxRadiusOfEffectSq()))) {
                        random.setSeed(post.getSeed());
                        random.nextInt();
                        for (int i2 = 0; i2 < 128; ++i2) {
                            var y = i2 + world.underworld_y_offset;
                            if (world.getBlock(x, y, z) == Block.mycelium) {
                                world.setBlock(x, y, z, CTRegistryInit.deepSlate.blockID);
                                world.setBlock(x, y - 1, z, CTRegistryInit.deepSlate.blockID);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void CTFaultGenerateBasalt(BiomeCTFault fault, World world, Random random, int chunk_origin_x, int chunk_origin_z) {
        for (int x = chunk_origin_x; x < chunk_origin_x + 16; ++x) {
            for (int z = chunk_origin_z; z < chunk_origin_z + 16; ++z) {
                for (int i2 = 0; i2 < 256; ++i2) {
                    var y = i2 + world.underworld_y_offset;
                    if (world.getBiomeGenForCoords(x, z) == fault) {
                        if (world.getBlock(x, y, z) == CTRegistryInit.deepSlate) {
                            if (hasAirNeighbor(world, x, y, z)) {
                                world.setBlock(x, y, z, CTRegistryInit.basalt.blockID);
                                for (int dx = -2; dx <= 2; dx++) {
                                    for (int dy = -2; dy <= 2; dy++) {
                                        for (int dz = -2; dz <= 2; dz++) {
                                            int nx = x + dx;
                                            int ny = y + dy;
                                            int nz = z + dz;
                                            if (dx == 0 && dy == 0 && dz == 0) continue;
                                            if (ny >= world.underworld_y_offset && ny < world.underworld_y_offset + 256) {
                                                if (world.getBlock(nx, ny, nz) == CTRegistryInit.deepSlate) {
                                                    world.setBlock(nx, ny, nz, CTRegistryInit.basalt.blockID);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void CTFaultRegenerateNetherrack(BiomeCTFault fault, World world, Random random, int chunk_origin_x, int chunk_origin_z) {
        ChunkPostField deepSlate_posts = new ChunkPostField(114514, world.getHashedSeed(), 12, 0.04f);
        for (int x = chunk_origin_x; x < chunk_origin_x + 16; ++x) {
            for (int z = chunk_origin_z; z < chunk_origin_z + 16; ++z) {
                if (world.getBiomeGenForCoords(x, z) != CTBiomes.FAULT) continue;
                List<ChunkPost> posts = deepSlate_posts.getNearbyPostsForBlockCoords(x, z);
                for (ChunkPost post : posts) {
                    if (!(post.getDistanceSqFromBlockCoords(x, z) > (double) (deepSlate_posts.getPostMaxRadiusOfEffectSq()))) {
                        random.setSeed(post.getSeed());
                        random.nextInt();
                        for (int i2 = 0; i2 < 128; ++i2) {
                            var y = i2 + world.underworld_y_offset;
                            if (world.getBlock(x, y, z) == CTRegistryInit.basalt) {
                                world.setBlock(x, y, z, Block.netherrack.blockID);
                                world.setBlock(x, y - 1, z, Block.netherrack.blockID);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void CTFaultRegenerateNetherOres(BiomeCTFault fault, World world, Random random, int chunk_origin_x, int chunk_origin_z) {
        int freq = 128 + random.nextInt(256);
        for (int i = 0; i < freq; ++i) {
            int x = chunk_origin_x + random.nextInt(16);
            int y = world.underworld_y_offset + random.nextInt(120);
            int z = chunk_origin_z + random.nextInt(16);
            int blockId = world.getBlockId(x, y, z);

            if (blockId == Block.netherrack.blockID) {
                world.setBlock(x, y, z, Block.oreNetherQuartz.blockID, 0, 2);
            }
        }
    }

    public static boolean hasAirNeighbor(World world, int x, int y, int z) {
        return world.isAirBlock(x + 1, y, z) ||
               world.isAirBlock(x - 1, y, z) ||
               world.isAirBlock(x, y + 1, z) ||
               world.isAirBlock(x, y - 1, z) ||
               world.isAirBlock(x, y, z + 1) ||
               world.isAirBlock(x, y, z - 1);
    }
}
