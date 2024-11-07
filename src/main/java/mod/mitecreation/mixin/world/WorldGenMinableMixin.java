package mod.mitecreation.mixin.world;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import mod.mitecreation.block.ore.BlockOreDeepslate;
import mod.mitecreation.init.RegistryInit;
import net.minecraft.Block;
import net.minecraft.Minecraft;
import net.minecraft.World;
import net.minecraft.WorldGenMinable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(WorldGenMinable.class)
public abstract class WorldGenMinableMixin {
    @Shadow
    private int minableBlockId;

    @Shadow
    public abstract int getMinVeinHeight(World world);

    @Shadow
    public abstract int getMaxVeinHeight(World world);

    @WrapOperation(method = "generate(Lnet/minecraft/World;Ljava/util/Random;IIIZ)Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/WorldGenMinable;growVein(Lnet/minecraft/World;Ljava/util/Random;IIIIZZ)I"))
    private int prohibitGravelFromGeneratingOnTop(WorldGenMinable instance, World dx, Random dy, int dz, int axis, int attempts, int i, boolean world, boolean rand, Operation<Integer> original) {
        return this.growVein(dx, dy, dz, axis, attempts, i, dx.isUnderworld() && this.getMinableBlockId() == RegistryInit.gravelDeepSlate.blockID, rand);
    }

    @Inject(method = "getRandomVeinHeight", at = @At(value = "INVOKE", target = "Lnet/minecraft/Minecraft;setErrorMessage(Ljava/lang/String;)V"), cancellable = true)
    private void creationRandomVeinHeight(World world, Random rand, CallbackInfoReturnable<Integer> cir) {
        Block block = Block.blocksList[this.minableBlockId];
        if (world.isUnderworld()) {
            if (world.underworld_y_offset != 0) {
                if (block == RegistryInit.oreAdamantiumDeepslate) {
                    cir.setReturnValue(rand.nextInt(16 + world.underworld_y_offset));
                }

                if (block instanceof BlockOreDeepslate && rand.nextFloat() < 0.75F) {
                    cir.setReturnValue(rand.nextInt(16 + world.underworld_y_offset));
                }
            }
            cir.setReturnValue(rand.nextInt(256));
        } else {
            float relative_height;

            if (block == Block.dirt) {
                do {
                    relative_height = rand.nextFloat();
                }
                while (relative_height <= rand.nextFloat());
            } else if (block == RegistryInit.gravelDeepSlate) {
                do {
                    relative_height = rand.nextFloat();
                }
                while (relative_height <= rand.nextFloat());
            } else if (block == RegistryInit.oreCopperDeepslate) {
                if (rand.nextInt(2) == 0) {
                    relative_height = rand.nextFloat() * 0.6F + 0.4F;
                } else {
                    do {
                        relative_height = rand.nextFloat();
                    }
                    while (relative_height >= rand.nextFloat());
                }
            } else if (block == RegistryInit.oreSilverDeepslate) {
                do {
                    relative_height = rand.nextFloat();
                }
                while (relative_height >= rand.nextFloat());
            } else if (block == RegistryInit.oreGoldDeepslate) {
                do {
                    relative_height = rand.nextFloat();
                }
                while (relative_height >= rand.nextFloat());
            } else if (block == RegistryInit.oreIronDeepslate) {
                do {
                    relative_height = rand.nextFloat();
                }
                while (relative_height >= rand.nextFloat());
            } else if (block == RegistryInit.oreMithrilDeepslate) {
                do {
                    relative_height = rand.nextFloat();
                }
                while (relative_height >= rand.nextFloat());
            } else if (block != RegistryInit.oreAdamantiumDeepslate && block != RegistryInit.deepslateSilverFish) {
                if (block == RegistryInit.oreRedstoneDeepslate) {
                    do {
                        relative_height = rand.nextFloat();
                    }
                    while (relative_height >= rand.nextFloat());
                } else if (block == RegistryInit.oreDiamondDeepslate) {
                    do {
                        relative_height = rand.nextFloat();
                    }
                    while (relative_height >= rand.nextFloat());
                } else {
                    if (block != RegistryInit.oreLapisDeepslate) {
                        Minecraft.setErrorMessage("WorldGenMinableMixin: unknown ore id " + this.minableBlockId);
                        cir.setReturnValue(-1);
                    }

                    relative_height = (rand.nextFloat() + rand.nextFloat()) / 2.0F;
                }
            } else {
                do {
                    relative_height = rand.nextFloat();
                }
                while (relative_height >= rand.nextFloat());
            }

            int min_height = this.getMinVeinHeight(world);
            int height_range = this.getMaxVeinHeight(world) - min_height + 1;
            cir.setReturnValue(min_height + (int) (relative_height * (float) height_range));
        }
    }

    @Shadow
    public int getMinableBlockId() {
        return 0;
    }

    @Shadow
    public int growVein(World world, Random rand, int blocks_to_grow, int x, int y, int z, boolean must_be_supported, boolean is_dirt) {
        return 0;
    }
}
