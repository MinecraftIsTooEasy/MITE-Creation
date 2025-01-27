package mod.mitecreation.mixin.world;

import mod.mitecreation.world.biome.CTBiomes;
import net.minecraft.MapGenStructure;
import net.minecraft.MapGenVillage;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(MapGenVillage.class)
public abstract class MapGenVillageMixin extends MapGenStructure {
    @Mutable @Shadow @Final public static List villageSpawnBiomes;

    @Inject(method = "<init>()V", at = @At("TAIL"))
    private void villageCanSpawnInTaoyuan(CallbackInfo ci) {
        List oldList = villageSpawnBiomes;
        villageSpawnBiomes = new ArrayList();
        villageSpawnBiomes.addAll(oldList);
        villageSpawnBiomes.add(CTBiomes.TAOYUAN);
    }
}
