package mod.mitecreation.mixin.world.biome;

import mod.mitecreation.entity.EntitySpiderQueen;
import net.minecraft.BiomeGenBase;
import net.minecraft.BiomeGenUnderworld;
import net.minecraft.SpawnListEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BiomeGenUnderworld.class)
public class BiomeUnderworldMixin extends BiomeGenBase {
    protected BiomeUnderworldMixin(int par1) {
        super(par1);
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    public void creationUnderWorldMobSpawnableAdd(CallbackInfo callbackInfo) {
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySpiderQueen.class, 5, 1, 1));
    }

}
