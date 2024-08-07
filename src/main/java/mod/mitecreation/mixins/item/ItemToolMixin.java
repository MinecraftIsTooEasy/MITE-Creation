package mod.mitecreation.mixins.item;

import net.minecraft.*;
import mod.mitecreation.materil.CreationMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemTool.class)
public class ItemToolMixin extends Item {

    @Inject(method = "getMaterialHarvestEfficiency", at = @At(value = "INVOKE", target = "Lnet/minecraft/Minecraft;setErrorMessage(Ljava/lang/String;)V"), cancellable = true)
    private void getMaterialHarvestEfficiencyCreation(CallbackInfoReturnable<Float> cir) {
        cir.setReturnValue(this.creationMaterialHarvestEfficiency());
    }

    @Unique
    private float creationMaterialHarvestEfficiency() {
        if (this.effective_material == CreationMaterial.tungsten)
            return 2.25F;
        return 0;
    }

    @Shadow
    private Material effective_material;

}
