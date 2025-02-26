package mod.mitecreation.world.biome;

import cn.tesseract.underbiome.biome.BiomeGenUnderBase;
import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.*;

import java.util.List;
import java.util.Random;

public class BiomeCTUndergarden extends BiomeGenUnderBase {

    public BiomeCTUndergarden(int par1) {
        super(par1);
        this.topBlock = (byte)Block.mycelium.blockID;
        this.fillerBlock = (byte) Block.dirt.blockID;
        setColor(0xFF0000);
        setBiomeName("Undergarden");
        setDisableRain();
        setTemperatureRainfall(1.0f, 0.0f);
    }

    @Override
    public void decorate(World world, Random random, int chunk_origin_x, int chunk_origin_z) {
        ChunkPostField deepslatePosts = new ChunkPostField(2, world.getHashedSeed(), 24, 0.2f);
        random = new Random(world.getSeed());
        int y;
        int height;
        for(int x = chunk_origin_x; x < chunk_origin_x + 16; ++x) {
            for(int z = chunk_origin_z; z < chunk_origin_z + 16; ++z) {
                List posts = deepslatePosts.getNearbyPostsForBlockCoords(x, z);
                /*
                for (int i = 0; i < posts.size(); ++i) {
                    ChunkPost post = (ChunkPost) posts.get(i);
                    random.setSeed(post.getSeed());
                    random.nextInt();
                    y = random.nextInt(random.nextBoolean() ? 16 : 72) + 24;
                    y += world.underworld_y_offset;
                    height = random.nextInt(5) + 1;
                    for (int dy = 0; dy < height; ++dy) {
                        if (world.isAirBlock(x, y + 1, z)) {
                            Block block = world.getBlock(x, y, z);
                            if (block != null && block.isAlwaysSolidOpaqueStandardFormCube() && !(block instanceof BlockMushroomCap)) {
                                block = world.getBlock(x, y - 1, z);
                                if (block != null && block.isAlwaysSolidOpaqueStandardFormCube()) {
                                    if(post.getDistanceSqFromBlockCoords(x, z) > (double) (deepslatePosts.getPostMaxRadiusOfEffectSq())){
                                        world.getChunkFromBlockCoords(x, z).setHadNaturallyOccurringMycelium();
                                        random.setSeed(world.getSeed() + (long)MathHelper.getIntPairHash(x, z));
                                        random.nextInt();
                                        if (random.nextInt(8) == 0) this.theBiomeDecorator.bigMushroomGen.generate(world, random, x, y + 1, z) ;
                                        if (random.nextInt(2) == 0 && world.getBlock(x, y + 1, z) == null) world.setBlock(x, y + 1, z, Block.mushroomBrown.blockID, 0, 2);
                                        continue;
                                    }
                                    world.setBlock(x,y,z,CTRegistryInit.deepSlate.blockID);
                                    world.setBlock(x,y-1,z,CTRegistryInit.deepSlate.blockID);
                                }
                            }
                        }
                        ++y;
                    }
                }
                */
                random.setSeed(world.getSeed());
                y = random.nextInt(random.nextBoolean() ? 16 : 72) + 24;
                y += world.underworld_y_offset;
                height = random.nextInt(5) + 1;
                for (int dy = 0; dy < height; ++dy) {
                    if (world.isAirBlock(x, y + 1, z)) {
                        Block block = world.getBlock(x, y, z);
                        if (block != null && block != CTRegistryInit.deepSlate && block.isAlwaysSolidOpaqueStandardFormCube() && !(block instanceof BlockMushroomCap)) {
                            block = world.getBlock(x, y - 1, z);
                            if (block != null && block.isAlwaysSolidOpaqueStandardFormCube()) {
                                world.getChunkFromBlockCoords(x, z).setHadNaturallyOccurringMycelium();
                                random.setSeed(world.getSeed() + (long)MathHelper.getIntPairHash(x, z));
                                random.nextInt();
                                if (random.nextInt(16) == 0) this.theBiomeDecorator.bigMushroomGen.generate(world, random, x, y + 1, z) ;
                                if (random.nextInt(1) == 0 && world.getBlock(x, y + 1, z) == null) world.setBlock(x, y + 1, z, Block.mushroomBrown.blockID, 0, 2);
                            }
                        }
                    }
                    ++y;
                }
            }
        }

        super.decorate(world, random, chunk_origin_x, chunk_origin_z);
    }
}
