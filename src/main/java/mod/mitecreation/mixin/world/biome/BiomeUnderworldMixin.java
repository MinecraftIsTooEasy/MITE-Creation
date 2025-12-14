package mod.mitecreation.mixin.world.biome;

import net.minecraft.BiomeGenBase;
import net.minecraft.BiomeGenUnderworld;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BiomeGenUnderworld.class)
public class BiomeUnderworldMixin extends BiomeGenBase {
    protected BiomeUnderworldMixin(int par1) {
        super(par1);
    }

    @Redirect(method = "decorate", at = @At(value = "INVOKE",target = "net/minecraft/BiomeGenUnderworld.placeMycelium(Lnet/minecraft/World;II)V"))
    private void doNotPlaceMycelium(BiomeGenUnderworld instance, World dy, int post, int y){
        //do nothing
    }
}
