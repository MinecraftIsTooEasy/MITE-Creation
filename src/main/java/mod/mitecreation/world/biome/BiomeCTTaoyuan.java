package mod.mitecreation.world.biome;

import mod.mitecreation.world.gen.WorldGenCTPeachTrees;
import moddedmite.rustedironcore.api.world.BiomeAPI;
import net.minecraft.*;

import java.util.Random;

public class BiomeCTTaoyuan extends BiomeGenBase {
    protected WorldGenCTPeachTrees worldGeneratorPeachTrees;

    public BiomeCTTaoyuan(int par1) {
        super(par1);
        this.worldGeneratorPeachTrees = new WorldGenCTPeachTrees(false, 6, 0, 0, false);
        this.theBiomeDecorator.treesPerChunk = 10;
        this.theBiomeDecorator.flowersPerChunk = 10;
        this.theBiomeDecorator.grassPerChunk = 3;
        this.theBiomeDecorator.reedsPerChunk = 3;
        this.theBiomeDecorator.clayPerChunk = 1;
        this.theBiomeDecorator.waterlilyPerChunk = 1;
        this.topBlock = (byte) Block.grass.blockID;
        this.fillerBlock = (byte) Block.dirt.blockID;
        this.spawnableMonsterList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 70, 1, 2));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 90, 1, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 90, 1, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityCreeper.class, 90, 1, 2));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySlime.class, 90, 1, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 8, 1, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityGhoul.class, 8, 1, 1));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityWight.class, 8, 1, 1));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityInvisibleStalker.class, 8, 1, 1));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityDemonSpider.class, 8, 1, 1));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityHellhound.class, 8, 1, 2));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityWoodSpider.class, 15, 1, 1));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityShadow.class, 8, 1, 1));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityRevenant.class, 8, 1, 1));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityEarthElemental.class, 8, 1, 1));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityJelly.class, 25, 1, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityBlob.class, 15, 1, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityOoze.class, 15, 1, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityPudding.class, 25, 1, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityClayGolem.class, 40, 1, 1));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityBoneLord.class, 3, 1, 1));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityPhaseSpider.class, 3, 1, 4));
        setBiomeName("Taoyuan");
        ((BiomeAPI) this).setBiomeUnlocalizedName("taoyuan");
        setColor(0xB6EA4C);
        setMinMaxHeight(0.3F, 1.5F);
        setTemperatureRainfall(1.0F, 0.9F);
    }

    @Override
    public WorldGenerator getRandomWorldGenForTrees(Random par1Random) {
        return this.worldGeneratorPeachTrees;
    }

    @Override
    public int getBiomeGrassColor() {
        return 0xB6EA4C;
    }
}
