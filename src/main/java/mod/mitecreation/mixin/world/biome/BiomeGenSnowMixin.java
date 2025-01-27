package mod.mitecreation.mixin.world.biome;

import net.minecraft.BiomeGenBase;
import net.minecraft.BiomeGenSnow;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BiomeGenSnow.class)
public class BiomeGenSnowMixin extends BiomeGenBase {
    protected BiomeGenSnowMixin(int par1) {
        super(par1);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void addSnowBerry(int par1, CallbackInfo ci) {
        this.theBiomeDecorator.bush_patches_per_chunk_tenths = 25;
    }
}
