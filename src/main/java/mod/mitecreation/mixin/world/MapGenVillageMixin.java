package mod.mitecreation.mixin.world;

import mod.mitecreation.world.biome.CTBiomes;
import net.minecraft.MapGenVillage;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(MapGenVillage.class)
public class MapGenVillageMixin {
    @Shadow @Final public static List villageSpawnBiomes;

    @Inject(method = "<init>()V", at = @At("TAIL"))
    private void villageCanSpawnInTaoyuan(CallbackInfo ci) {
        villageSpawnBiomes.add(CTBiomes.TAOYUAN);
    }
}
