package mod.mitecreation.world.structure;

import mod.mitecreation.world.biome.CTBiomes;
import net.minecraft.*;

import java.util.*;

public class MapGenCTRuins extends MapGenStructure {
    private static List biomelist = Arrays.asList(BiomeGenBase.plains, BiomeGenBase.forest, CTBiomes.TAOYUAN);
    private List scatteredFeatureSpawnList;
    private int maxDistanceBetweenScatteredFeatures;
    private int minDistanceBetweenScatteredFeatures;

    public MapGenCTRuins() {
        this.scatteredFeatureSpawnList = new ArrayList();
        this.maxDistanceBetweenScatteredFeatures = 40;
        this.minDistanceBetweenScatteredFeatures = 20;
    }

    public MapGenCTRuins(Map par1Map) {
        this();

        for (Object o : par1Map.entrySet()) {
            Map.Entry var3 = (Map.Entry) o;

            if ((var3.getKey()).equals("distance")) {
                this.maxDistanceBetweenScatteredFeatures = MathHelper.parseIntWithDefaultAndMax((String) var3.getValue(), this.maxDistanceBetweenScatteredFeatures, this.minDistanceBetweenScatteredFeatures + 1);
            }
        }
    }

    public String func_143025_a() {
        return "Ruins";
    }

    public boolean canSpawnStructureAtCoords(int par1, int par2) {
        int var3 = par1;
        int var4 = par2;

        if (par1 < 0) {
            par1 -= this.maxDistanceBetweenScatteredFeatures - 1;
        }

        if (par2 < 0) {
            par2 -= this.maxDistanceBetweenScatteredFeatures - 1;
        }

        int var5 = par1 / this.maxDistanceBetweenScatteredFeatures;
        int var6 = par2 / this.maxDistanceBetweenScatteredFeatures;
        Random var7 = new Random((long) var5 * 341873128712L + (long) var6 * 132897987541L + this.worldObj.getWorldInfo().getSeed() + 14357617L);
        var5 *= this.maxDistanceBetweenScatteredFeatures;
        var6 *= this.maxDistanceBetweenScatteredFeatures;
        var5 += var7.nextInt(this.maxDistanceBetweenScatteredFeatures - this.minDistanceBetweenScatteredFeatures);
        var6 += var7.nextInt(this.maxDistanceBetweenScatteredFeatures - this.minDistanceBetweenScatteredFeatures);

        if (var3 == var5 && var4 == var6) {
            BiomeGenBase var8 = this.worldObj.getWorldChunkManager().getBiomeGenAt(var3 * 16 + 8, var4 * 16 + 8);

            for (Object o : biomelist) {
                BiomeGenBase var10 = (BiomeGenBase) o;

                if (var8 == var10) {
                    return true;
                }
            }
        }

        return false;
    }

    protected StructureStart getStructureStart(int par1, int par2) {
        return new StructureCTRuinsStart(this.worldObj, this.rand, par1, par2);
    }

    public boolean func_143030_a(int par1, int par2, int par3) {
        StructureStart var4 = this.func_143028_c(par1, par2, par3);

        if (var4 instanceof StructureCTRuinsStart && !var4.getComponents().isEmpty()) {
            StructureComponent var5 = (StructureComponent) var4.getComponents().getFirst();
            return var5 instanceof ComponentCTRuins;
        } else {
            return false;
        }
    }

    public List getScatteredFeatureSpawnList() {
        return this.scatteredFeatureSpawnList;
    }
}

