package mod.mitecreation.world.dimesion;

import net.minecraft.*;

public class WorldProviderCTRedSky extends WorldProvider {
    public WorldProviderCTRedSky() {
        super(9, "RedSky");
    }

    public void registerWorldChunkManager() {
        this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.sky, 0.0F, 0.0F);
    }

    public Vec3 getFogColor(float par1, float par2, EntityLivingBase viewer) {
        return this.worldObj.getWorldVec3Pool().getVecFromPool(0.20000000298023224D, 0.029999999329447746D, 0.029999999329447746D);
    }

    protected void generateLightBrightnessTable() {
        float var1 = 0.1F;

        for (int var2 = 0; var2 <= 15; ++var2) {
            float var3 = 1.0F - (float) var2 / 15.0F;
            this.lightBrightnessTable[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
        }
    }

    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderCTRedSky(this.worldObj, this.worldObj.getSeed());
    }

    public boolean canCoordinateBeSpawn(int par1, int par2) {
        return false;
    }

    public float calculateCelestialAngle(long par1, float par3) {
        return 0.5F;
    }

    public boolean canRespawnHere() {
        return true;
    }

    public boolean doesXZShowFog(int x, int y, int z) {
        return y < 256;
    }
}
