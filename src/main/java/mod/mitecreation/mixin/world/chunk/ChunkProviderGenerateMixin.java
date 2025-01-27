package mod.mitecreation.mixin.world.chunk;

import com.llamalad7.mixinextras.sugar.Local;
import mod.mitecreation.world.structure.MapGenCTRuins;
import net.minecraft.Chunk;
import net.minecraft.ChunkProviderGenerate;
import net.minecraft.IChunkProvider;
import net.minecraft.World;
import net.xiaoyu233.fml.util.ReflectHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(ChunkProviderGenerate.class)
public class ChunkProviderGenerateMixin {
    @Shadow private World worldObj;
    @Shadow private Random rand;
    @Unique private MapGenCTRuins ruinsGenerator = new MapGenCTRuins();

    @Inject(method = "provideChunk", at = @At(value = "FIELD", target = "Lnet/minecraft/ChunkProviderGenerate;scatteredFeatureGenerator:Lnet/minecraft/MapGenScatteredFeature;"))
    private void addCreationStructure(int par1, int par2, CallbackInfoReturnable<Chunk> cir, @Local(ordinal = 0) byte[] var3) {
        this.ruinsGenerator.generate(ReflectHelper.dyCast(this), this.worldObj, par1, par2, var3);
    }

    @Inject(method = "populate", at = @At(value = "FIELD", target = "Lnet/minecraft/ChunkProviderGenerate;scatteredFeatureGenerator:Lnet/minecraft/MapGenScatteredFeature;"))
    private void addCreationStructure(IChunkProvider par1IChunkProvider, int par2, int par3, CallbackInfo ci) {
        this.ruinsGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
    }

    @Inject(method = "recreateStructures", at = @At(value = "FIELD", target = "Lnet/minecraft/ChunkProviderGenerate;scatteredFeatureGenerator:Lnet/minecraft/MapGenScatteredFeature;"))
    private void addCreationStructure(int par1, int par2, CallbackInfo ci) {
        this.ruinsGenerator.generate(ReflectHelper.dyCast(this), this.worldObj, par1, par2, (byte[])null);
    }
}
