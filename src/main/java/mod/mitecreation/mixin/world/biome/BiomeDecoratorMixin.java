package mod.mitecreation.mixin.world.biome;

import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(BiomeDecorator.class)
public class BiomeDecoratorMixin {
    @Shadow protected int chunk_X;
    @Shadow protected int chunk_Z;
    @Shadow protected Random randomGenerator;
    @Shadow protected World currentWorld;
    @Shadow public int bush_patches_per_chunk_tenths;
    @Unique protected WorldGenPlants snow_bush_gen;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void addSnowBerry(BiomeGenBase par1BiomeGenBase, CallbackInfo ci) {
        this.snow_bush_gen = new WorldGenPlants(CTRegistryInit.snowBerry);
    }

    @Inject(method = "decorate()V", at = @At(value = "FIELD", target = "Lnet/minecraft/BiomeDecorator;generateLakes:Z"))
    private void addSnowBerry(CallbackInfo ci) {
        int bush_patches_per_chunk = this.bush_patches_per_chunk_tenths / 10 + (this.randomGenerator.nextInt(10) < this.bush_patches_per_chunk_tenths % 10 ? 1 : 0);
        for (int var2 = 0; var2 < bush_patches_per_chunk; ++var2) {
            int var3 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            int var4 = this.randomGenerator.nextInt(128);
            int var7 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            this.snow_bush_gen.setMetadata(BlockBush.getMetadataForBushWithBerries(0));
            this.snow_bush_gen.generate(this.currentWorld, this.randomGenerator, var3, var4, var7);
        }
    }

}
