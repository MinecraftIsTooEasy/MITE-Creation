package mod.mitecreation.mixins.world.biome;

import mod.mitecreation.block.CreationBlock;
import net.minecraft.BiomeDecorator;
import net.minecraft.BiomeGenBase;
import net.minecraft.Block;
import net.minecraft.WorldGenMinable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BiomeGenBase.class)
public class BiomeGenBaseMixin {
    @Shadow public final int biomeID;

    public BiomeGenBaseMixin(int biomeID) {
        this.biomeID = biomeID;
    }

}
