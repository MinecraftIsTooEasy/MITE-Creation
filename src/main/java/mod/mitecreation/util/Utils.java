package mod.mitecreation.util;

import mod.mitecreation.init.CTRegistryInit;
import mod.mitecreation.world.biome.BiomeCTUndergarden;
import net.minecraft.*;

import java.util.List;
import java.util.Random;

public class Utils {

    public static boolean decorateCTUndergarden(BiomeCTUndergarden undergarden, World world, Random random, int chunk_origin_x, int chunk_origin_z){
        random = new Random(world.getSeed());
        for(int x = chunk_origin_x; x < chunk_origin_x + 16; ++x) {
            for(int z = chunk_origin_z; z < chunk_origin_z + 16; ++z) {
                random.setSeed(world.getSeed());
                for(int i =0;i < 256;++i) {
                    var y = i + world.underworld_y_offset;
                    if (world.isAirBlock(x, y + 1, z)) {
                        Block block = world.getBlock(x, y, z);
                        if (block != null && block.isAlwaysSolidOpaqueStandardFormCube()) {
                            world.getChunkFromBlockCoords(x, z).setHadNaturallyOccurringMycelium();
                            random.setSeed(world.getSeed() + (long) MathHelper.getIntPairHash(x, z));
                            random.nextInt();
                            if (random.nextInt(200) == 0)
                                undergarden.theBiomeDecorator.bigMushroomGen.generate(world, random, x, y + 1, z);
                            if (random.nextInt(20) == 0 && world.getBlock(x, y + 1, z) == null && world.getBlock(x,y,z) == Block.mycelium)
                                world.setBlock(x, y + 1, z, Block.mushroomBrown.blockID, 0, 2);
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean CTUndergardenRegenerateDeepslate(BiomeCTUndergarden undergarden, World world, Random random, int chunk_origin_x, int chunk_origin_z){
        random = new Random();
        ChunkPostField deepSlate_posts = new ChunkPostField(114514,world.getHashedSeed(),24,0.2f);
        for(int x = chunk_origin_x; x < chunk_origin_x + 16; ++x) {
            for(int z = chunk_origin_z; z < chunk_origin_z + 16; ++z) {
                List posts = deepSlate_posts.getNearbyPostsForBlockCoords(x, z);
                for(int i = 0; i < posts.size(); ++i) {
                    ChunkPost post = (ChunkPost)posts.get(i);
                    if (!(post.getDistanceSqFromBlockCoords(x, z) > (double)(deepSlate_posts.getPostMaxRadiusOfEffectSq())) ) {
                        random.setSeed(post.getSeed());
                        random.nextInt();
                        for(int i2 =0;i2 < 256;++i2) {
                            var y = i2 + world.underworld_y_offset;
                            if (world.getBlock(x,y,z) == Block.mycelium) {
                                world.setBlock(x,y,z,CTRegistryInit.deepSlate.blockID);
                                world.setBlock(x,y-1,z,CTRegistryInit.deepSlate.blockID);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
