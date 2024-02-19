package mod.mitecreation.mixin.world;

import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Chunk.class)
public abstract class ChunkMixin {
    @Shadow
    private int xPosition;
    @Shadow
    private int zPosition;

    @Shadow protected abstract double getMax(double a, double b);

    @Shadow public ChunkSection[] storageArrays;

    //@Redirect(method = "<init>(Lnet/minecraft/World;[BII)V",at = @At(value = "INVOKE_ASSIGN",target = "INVOKESPECIAL net/minecraft/Chunk.getMax(DD)D"))
    //double injectConstructor(World par1World, byte[] par2ArrayOfByte, int par3, int par4,int var6,int var7,int var8, CallbackInfo ci){
    //    FishModLoader.LOGGER.info("1");
    //    int var10;
    //    if (this.storageArrays[var10 = var8 >> 4] == null) {
    //        this.storageArrays[var10] = new ChunkSection(var10 << 4, !par1World.provider.hasNoSky);
    //    }
    //    this.storageArrays[var10].setExtBlockMetadata(var6, var8 & 0xF, var7, 1);
    //    int local_xz_index = var7 + var6 * 16;
    //    return this.getMax(ChunkProviderUnderworld.bedrock_strata_1a_noise[local_xz_index], ChunkProviderUnderworld.bedrock_strata_1b_noise[local_xz_index]);
    //}

    @Inject(method = "<init>(Lnet/minecraft/World;[BII)V",at = @At("TAIL"))
    void injectConstructor(World par1World, byte[] par2ArrayOfByte, int par3, int par4, CallbackInfo ci){
        if(par1World.isUnderworld() && !((Object)this instanceof EmptyChunk)){
            for (int var6 = 0; var6 < this.storageArrays.length; ++var6) {
                for (int var7 = 0; var7 < 16; ++var7) {
                    for(int var8 = 0;var8 < 16;++var8){
                        for(int var9 =0;var9 < 16;++var9){
                            if(this.storageArrays[var6] != null && this.storageArrays[var6].getExtBlockID(var7,var8,var9) == 1){
                                this.storageArrays[var6].setExtBlockMetadata(var7,var8,var9,1);
                            }
                        }
                    }
                }
            }
        }
    }

}
