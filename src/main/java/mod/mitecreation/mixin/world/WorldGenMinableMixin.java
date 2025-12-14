package mod.mitecreation.mixin.world;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import mod.mitecreation.init.CTRegistryInit;
import mod.mitecreation.world.biome.CTBiomes;
import net.minecraft.World;
import net.minecraft.WorldGenMinable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Random;

@Mixin(WorldGenMinable.class)
public abstract class WorldGenMinableMixin {

    @Shadow public abstract int getMinableBlockId();
    @Shadow public abstract int growVein(World world, Random rand, int blocks_to_grow, int x, int y, int z, boolean must_be_supported, boolean is_dirt);

    @WrapOperation(method = "generate(Lnet/minecraft/World;Ljava/util/Random;IIIZ)Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/WorldGenMinable;growVein(Lnet/minecraft/World;Ljava/util/Random;IIIIZZ)I"))
    private int prohibitGravelFromGeneratingOnTop(WorldGenMinable instance, World world, Random random, int vein_size, int x, int y, int z, boolean must_be_supported, boolean is_dirt, Operation<Integer> original) {
//        if (!(world.getBiomeGenForCoords(x, y) == CTBiomes.STONES))
            must_be_supported = world.isUnderworld() && this.getMinableBlockId() == CTRegistryInit.gravelDeepSlate.blockID;
        return this.growVein(world, random, vein_size, x, y, z, must_be_supported, is_dirt);
    }
}
