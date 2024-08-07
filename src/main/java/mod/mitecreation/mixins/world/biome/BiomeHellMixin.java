package mod.mitecreation.mixins.world.biome;

import mod.mitecreation.entity.EntityDevilBat;
import mod.mitecreation.entity.EntitySpirit;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BiomeGenHell.class)
public class BiomeHellMixin extends BiomeGenBase {

    protected BiomeHellMixin(int par1) {
        super(par1);
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    public void creationHellMobSpawnableAdd(CallbackInfo callbackInfo) {
        this.spawnableMonsterList.add(new SpawnListEntry(EntityInfernalCreeper.class, 20, 1, 3));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityDemonSpider.class, 20, 1, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityHellhound.class, 20, 1, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySpirit.class, 5, 1, 2));
        this.spawnableCaveCreatureList.add(new SpawnListEntry(EntityDevilBat.class, 10, 2, 2));
    }
}
