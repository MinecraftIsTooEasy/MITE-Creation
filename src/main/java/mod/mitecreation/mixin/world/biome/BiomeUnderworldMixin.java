package mod.mitecreation.mixin.world.biome;

import mod.mitecreation.entity.EntityCTSpiderQueen;
import net.minecraft.BiomeGenBase;
import net.minecraft.BiomeGenUnderworld;
import net.minecraft.SpawnListEntry;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BiomeGenUnderworld.class)
public class BiomeUnderworldMixin extends BiomeGenBase {
    protected BiomeUnderworldMixin(int par1) {
        super(par1);
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    public void creationUnderWorldMobSpawnableAdd(CallbackInfo callbackInfo) {
        this.spawnableMonsterList.add(new SpawnListEntry(EntityCTSpiderQueen.class, 5, 1, 1));
    }

//    @Redirect(method = "decorate", at = @At(value = "INVOKE", target = "net/minecraft/BiomeGenUnderworld.placeMycelium(Lnet/minecraft/World;II)V"))
//    private void doNotPlaceMycelium(BiomeGenUnderworld instance, World dy, int post, int y){
//        //do nothing
//    }
}
