package mod.mitecreation.world.biome;

import cn.tesseract.underbiome.biome.BiomeGenUnderBase;
import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.*;

import java.util.List;
import java.util.Random;

public class BiomeCTUndergarden extends BiomeGenUnderBase {

    public BiomeCTUndergarden(int par1) {
        super(par1);
        this.topBlock = (byte) Block.mycelium.blockID;
        this.fillerBlock = (byte) Block.dirt.blockID;
        this.theBiomeDecorator.surface_mushrooms_per_chunk = 10;
        setColor(0xFF0000);
        setBiomeName("Undergarden");
        setDisableRain();
        setTemperatureRainfall(1.0f, 0.0f);
    }

    @Override
    public void decorate(World world, Random random, int chunk_origin_x, int chunk_origin_z) {
        this.placeMycelium(world, random, chunk_origin_x, chunk_origin_z);
        super.decorate(world, random, chunk_origin_x, chunk_origin_z);
    }

    private void placeMycelium(World world, Random random, int chunk_origin_x, int chunk_origin_z) {
        for (int x = chunk_origin_x; x < chunk_origin_x + 16; ++x) {
            for (int z = chunk_origin_z; z < chunk_origin_z + 16; ++z) {
                int y = world.underworld_y_offset + random.nextInt(120);
                if (world.isAirBlock(x, y + 1, z)) {
                    Block block = world.getBlock(x, y, z);
                    if (block != null && block.isAlwaysSolidOpaqueStandardFormCube() && !(block instanceof BlockMushroomCap)) {
                        world.getChunkFromBlockCoords(x, z).setHadNaturallyOccurringMycelium();
                        random.setSeed(world.getSeed() + (long) MathHelper.getIntPairHash(x, z));
                        random.nextInt();
                        if (random.nextInt(8) == 0 && world.getBlock(x, y, z) == Block.mycelium) {
                            this.theBiomeDecorator.bigMushroomGen.generate(world, random, x, y + 1, z);
                        }
                        if (world.isAirBlock(x, y + 1, z) && world.getBlock(x, y, z) == Block.mycelium) {
                            world.setBlock(x, y + 1, z, Block.mushroomBrown.blockID, 0, 2);
                        }
                    }
                }
            }
        }
    }
}
