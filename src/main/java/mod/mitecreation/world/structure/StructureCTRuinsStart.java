package mod.mitecreation.world.structure;

import net.minecraft.*;

import java.util.Random;

public class StructureCTRuinsStart extends StructureStart {
    public StructureCTRuinsStart() {
    }

    public StructureCTRuinsStart(World par1World, Random par2Random, int par3, int par4) {
        super(par3, par4);
        BiomeGenBase var5 = par1World.getBiomeGenForCoords(par3 * 16 + 8, par4 * 16 + 8);

        double var6 = par1World.getDistanceFromWorldSpawn(par3 * 16, par4 * 16);

        if (var5 == BiomeGenBase.plains) {
            ComponentCTRuins var9 = new ComponentCTRuins(par2Random, par3 * 16, par4 * 16);
            this.components.add(var9);
        }

        this.updateBoundingBox();
    }
}
