package mod.mitecreation.mixin.compat;

import moddedmite.rustedironcore.internal.delegate.world.biome.GenLayerUnderbiome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(GenLayerUnderbiome.class)
public class GenLayerUnderbiomeMixin {
    @ModifyConstant(method = "initializeAllBiomeGenerators", constant = @Constant(intValue = 3, ordinal = 1))
    private static int modifyStonesSize(int constant) {
        return 1;
    }
}
