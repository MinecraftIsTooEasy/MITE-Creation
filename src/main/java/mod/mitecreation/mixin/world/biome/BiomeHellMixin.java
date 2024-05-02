package mod.mitecreation.mixin.world.biome;

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
    public void injectCtor(CallbackInfo callbackInfo) {
        this.spawnableMonsterList.add(new SpawnListEntry(EntityInfernalCreeper.class, 20, 1, 3));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityDemonSpider.class, 20, 1, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityHellhound.class, 20, 1, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySpirit.class, 10, 1, 2));
    }
}
