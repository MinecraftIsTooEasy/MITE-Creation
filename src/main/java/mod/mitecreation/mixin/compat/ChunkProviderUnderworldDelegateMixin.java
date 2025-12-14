package mod.mitecreation.mixin.compat;

import com.llamalad7.mixinextras.sugar.Local;
import mod.mitecreation.world.biome.CTBiomes;
import moddedmite.rustedironcore.internal.delegate.world.ChunkProviderUnderworldDelegate;
import net.minecraft.BiomeGenBase;
import net.minecraft.Block;
import net.minecraft.Chunk;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(ChunkProviderUnderworldDelegate.class)
public class ChunkProviderUnderworldDelegateMixin {
    @Shadow private BiomeGenBase[] biomesForGeneration;
    @Shadow @Final private Random hellRNG;

    @Inject(method = "provideChunk", at = @At(value = "INVOKE", target = "Lmoddedmite/rustedironcore/internal/delegate/world/ChunkProviderUnderworldDelegate;replaceBlocksForBiome(II[B)V"))
    private void undergradenReplace(int chunkOriginX, int chunkOriginZ, CallbackInfoReturnable<Chunk> cir, @Local byte[] blocks) {
        for (int chunkX = 0; chunkX < 16; ++chunkX) {
            for (int chunkZ = 0; chunkZ < 16; ++chunkZ) {
                for (int chunkY = 127; chunkY >= 0; --chunkY) {
                    BiomeGenBase biome = this.biomesForGeneration[chunkZ + chunkX * 16];
                    if (biome == BiomeGenBase.underworld) continue;
                    this.hellRNG.nextDouble();
                    this.hellRNG.nextDouble();
                    this.hellRNG.nextDouble();
                    int blockIndex = (chunkZ * 16 + chunkX) * 128 + chunkY;
                    if (biome == CTBiomes.UNDERGARDEN) {
                        if (blocks[blockIndex] == 0 && blocks[blockIndex - 1] != Block.mycelium.blockID && blocks[blockIndex - 1] != Block.waterStill.blockID && blocks[blockIndex - 1] != 0) {
                            blocks[blockIndex - 1] = (byte) Block.mycelium.blockID;
                            if (blocks[blockIndex - 3] == 0) continue;
                            blocks[blockIndex - 2] = (byte) Block.dirt.blockID;
                        }
                    }
                }
            }
        }
    }
}
