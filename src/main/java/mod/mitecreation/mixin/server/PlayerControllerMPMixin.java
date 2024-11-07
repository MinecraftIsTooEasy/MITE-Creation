package mod.mitecreation.mixin.server;

import mod.mitecreation.init.RegistryInit;
import net.minecraft.Block;
import net.minecraft.Minecraft;
import net.minecraft.PlayerControllerMP;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerControllerMP.class)
public abstract class PlayerControllerMPMixin {
    @Shadow public Block auto_harvest_block;

    @Shadow @Final private Minecraft mc;

    @Shadow public abstract boolean autoHarvestModeHasExpired();

    @Inject(method = "matchesAutoHarvestBlock", at = @At("HEAD"), cancellable = true)
    private void addCreationBlock(int x, int y, int z, CallbackInfoReturnable<Boolean> cir) {
     if (this.auto_harvest_block != null && this.mc.thePlayer.hasFoodEnergy() && !this.mc.thePlayer.isDead && !this.mc.thePlayer.inBed() && !this.autoHarvestModeHasExpired()) {
         Block block = this.mc.theWorld.getBlock(x, y, z);
         if (this.auto_harvest_block == RegistryInit.oreRedstoneDeepslateGlowing && block == RegistryInit.oreRedstoneDeepslate) {
             cir.setReturnValue(true);
         }
     }
    }
}
