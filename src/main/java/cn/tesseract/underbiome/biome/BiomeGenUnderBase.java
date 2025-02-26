package cn.tesseract.underbiome.biome;

import net.minecraft.BiomeGenUnderworld;

public class BiomeGenUnderBase extends BiomeGenUnderworld {
    public BiomeGenUnderBase(int id) {
        super(id);
        GenLayerUnderbiome.biomes.add(this);
    }
}
