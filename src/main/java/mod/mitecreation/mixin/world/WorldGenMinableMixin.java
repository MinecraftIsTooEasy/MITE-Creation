package mod.mitecreation.mixin.world;

import mod.mitecreation.block.CreationBlock;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(value= WorldGenMinable.class)
public class WorldGenMinableMixin {
    @Shadow
    private int minableBlockId;
    @Shadow
    private int minable_block_metadata;
    @Shadow
    private int numberOfBlocks;
    @Shadow
    private int blockToReplace;
    @Shadow
    private boolean vein_size_increases_with_depth;
    
    @Overwrite
    public int growVein(World world, Random random, int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
        if (n < 1 || !world.blockExists(n2, n3, n4) || world.getBlockId(n2, n3, n4) != this.blockToReplace) {
            return 0;
        }
        if (bl && (n3 < 1 || world.isAirOrPassableBlock(n2, n3 - 1, n4, true))) {
            return 0;
        }
        if(world.getBiomeGenForCoords(n2,n4) == BiomeGenBase.underworld){
            if(Block.blocksList[this.minableBlockId] instanceof BlockOre && !(Block.blocksList[this.minableBlockId] instanceof BlockGoldOre) && !(Block.blocksList[this.minableBlockId] instanceof BlockRedstoneOre)){
                switch (random.nextInt(3)){
                    case 0:
                        this.minable_block_metadata = 3;
                        break;
                    case 1:
                        this.minable_block_metadata = 4;
                        break;
                    case 2:
                        this.minable_block_metadata = 5;
                        break;
                }
                world.setBlock(n2, n3, n4, this.minableBlockId, this.minable_block_metadata, 2);
            } else if(Block.blocksList[this.minableBlockId] instanceof BlockGoldOre || Block.blocksList[this.minableBlockId] instanceof BlockRedstoneOre){
                world.setBlock(n2, n3, n4, this.minableBlockId, this.minable_block_metadata, 2);
            }
        } else {
            if (bl2 && world.canBlockSeeTheSky(n2, n3 + 1, n4)) {
                BiomeGenBase biomeBase = world.getBiomeGenForCoords(n2, n4);
                world.setBlock(n2, n3, n4, biomeBase == BiomeGenBase.desert || biomeBase == BiomeGenBase.desertHills ? Block.sand.blockID : Block.grass.blockID, 0, 2);
            } else {
                world.setBlock(n2, n3, n4, this.minableBlockId, this.minable_block_metadata, 2);
            }
        }
        int n5 = 1;
        for (int i = 0; i < 16; ++i) {
            int n6 = 0;
            int n7 = 0;
            int n8 = 0;
            int n9 = random.nextInt(3);
            if (n9 == 0) {
                n6 = random.nextInt(2) == 0 ? -1 : 1;
            } else if (n9 == 1) {
                n7 = random.nextInt(2) == 0 ? -1 : 1;
            } else {
                n8 = random.nextInt(2) == 0 ? -1 : 1;
            }
            n5 += this.growVein(world, random, n - n5, n2 + n6, n3 + n7, n4 + n8, bl, bl2);
            if (n5 == n) break;
        }
        return n5;
    }

    @Inject(method = "getMinVeinHeight", at = @At(value = "INVOKE", target = "Lnet/minecraft/Minecraft;setErrorMessage(Ljava/lang/String;)V"), cancellable = true)
    private void creationMinVeinHeight(World world, CallbackInfoReturnable<Integer> cir) {
        Block block = Block.blocksList[this.minableBlockId];
        if (block == CreationBlock.oreTungsten)
            cir.setReturnValue(0);
    }

    @Inject(method = "getMaxVeinHeight", at = @At(value = "INVOKE", target = "Lnet/minecraft/Minecraft;setErrorMessage(Ljava/lang/String;)V"), cancellable = true)
    private void creationMaxVeinHeight(World world, CallbackInfoReturnable<Integer> cir) {
        Block block = Block.blocksList[this.minableBlockId];
        if (block == CreationBlock.oreTungsten)
            cir.setReturnValue(32);
    }
}
