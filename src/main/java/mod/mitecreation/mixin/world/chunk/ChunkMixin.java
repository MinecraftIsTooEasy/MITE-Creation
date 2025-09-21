package mod.mitecreation.mixin.world.chunk;

import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.*;
import net.xiaoyu233.fml.util.ReflectHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Chunk.class)
public abstract class ChunkMixin {
    @Shadow
    public ExtendedBlockStorage[] storageArrays;

    @Shadow public World worldObj;

    @Shadow private byte[] blockBiomeArray;

//    @Inject(method = "<init>(Lnet/minecraft/World;[BII)V", at = @At("TAIL"))
//    private void replaceStoneWithDeepslate(World par1World, byte[] par2ArrayOfByte, int par3, int par4, CallbackInfo ci) {
//        if (par1World.isUnderworld() && !(ReflectHelper.dyCast(this) instanceof EmptyChunk)) {
//            for (ExtendedBlockStorage storageArray : this.storageArrays) {
//                for (int var7 = 0; var7 < 16; ++var7) {
//                    for (int var8 = 0; var8 < 16; ++var8) {
//                        for (int var9 = 0; var9 < 16; ++var9) {
//                            if (storageArray != null && storageArray.getExtBlockID(var7, var8, var9) == Block.stone.blockID) storageArray.setExtBlockID(var7, var8, var9, CTRegistryInit.deepSlate.blockID);
//                        }
//                    }
//                }
//            }
//        }
//    }
}
