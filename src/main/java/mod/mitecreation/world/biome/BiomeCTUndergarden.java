package mod.mitecreation.world.biome;

import cn.tesseract.underbiome.biome.BiomeGenUnderBase;
import mod.mitecreation.util.Utils;
import net.minecraft.*;
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
        Utils.CTUndergardenRegenerateDeepslate(this,world,random,chunk_origin_x,chunk_origin_z);
        Utils.decorateCTUndergarden(this,world,random,chunk_origin_x,chunk_origin_z);
        super.decorate(world,random,chunk_origin_x,chunk_origin_z);
    }
}
