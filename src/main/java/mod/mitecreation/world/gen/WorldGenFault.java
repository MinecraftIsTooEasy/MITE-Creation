package mod.mitecreation.world.gen;

import mod.mitecreation.world.biome.CTBiomes;
import net.minecraft.BiomeGenBase;
import net.minecraft.MapGenRavine;

public class WorldGenFault extends MapGenRavine {

    @Override
    public boolean isGenAllowedInBiome(BiomeGenBase biome) {
        return biome == CTBiomes.FAULT;
    }

}
