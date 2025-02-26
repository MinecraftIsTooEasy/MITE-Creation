package cn.tesseract.underbiome.world;

import net.minecraft.IChunkProvider;
import net.minecraft.WorldProviderUnderworld;

public class WorldProviderUnderbiome extends WorldProviderUnderworld {
    public void registerWorldChunkManager() {
        this.worldChunkMgr = new WorldChunkManagerUnderbiome(worldObj);
    }

    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderUnderbiome(this.worldObj, this.worldObj.getSeed());
    }
}
