package mod.mitecreation.world.biome;

import moddedmite.rustedironcore.api.world.BiomeAPI;
import net.minecraft.BiomeGenUnderworld;

public class BiomeCTStones extends BiomeGenUnderworld {
    public BiomeCTStones(int id) {
        super(id);
        this.setBiomeName("Stones");
        ((BiomeAPI) this).setBiomeUnlocalizedName("stones");
    }
}
