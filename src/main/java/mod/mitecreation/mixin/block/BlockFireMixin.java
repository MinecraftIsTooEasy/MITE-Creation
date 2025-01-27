package mod.mitecreation.mixin.block;

import net.minecraft.BlockFire;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockFire.class)
public abstract class BlockFireMixin {
    @Shadow protected abstract void setBurnRate(int par1, int par2, int par3);

    @Inject(method = "initializeBlock", at = @At("HEAD"))
    public void initializeBlock(CallbackInfo ci) {
//        this.setBurnRate(RegistryInit.peachPlanks.blockID, 5, 20);
////        this.setBurnRate(Block.stairsWoodOak.blockID, 5, 20);
//        this.setBurnRate(RegistryInit.peachWood.blockID, 5, 5);
//        this.setBurnRate(RegistryInit.peachLeaves.blockID, 30, 60);
    }
}
