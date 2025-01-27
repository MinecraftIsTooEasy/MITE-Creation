package mod.mitecreation.mixin.world;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.World;
import net.minecraft.WorldGenMinable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Random;

@Mixin(WorldGenMinable.class)
public abstract class WorldGenMinableMixin {

    @WrapOperation(method = "generate(Lnet/minecraft/World;Ljava/util/Random;IIIZ)Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/WorldGenMinable;growVein(Lnet/minecraft/World;Ljava/util/Random;IIIIZZ)I"))
    private int prohibitGravelFromGeneratingOnTop(WorldGenMinable instance, World dx, Random dy, int dz, int axis, int attempts, int i, boolean world, boolean rand, Operation<Integer> original) {
        return this.growVein(dx, dy, dz, axis, attempts, i, dx.isUnderworld() && this.getMinableBlockId() == CTRegistryInit.gravelDeepSlate.blockID, rand);
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
