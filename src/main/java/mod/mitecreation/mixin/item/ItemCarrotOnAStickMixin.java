package mod.mitecreation.mixin.item;

import mod.mitecreation.init.CTRegistryInit;
import mod.mitecreation.material.CTMaterials;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemCarrotOnAStick.class)
public class ItemCarrotOnAStickMixin extends Item implements IDamageableItem {

    @Shadow
    protected Material hook_material;

    @Shadow
    public int getNumComponentsForDurability() {
        return 0;
    }


    @Inject(method = "getFishingRodItem", at = @At("HEAD"), cancellable = true)
    public void getFishingRodItem(CallbackInfoReturnable<ItemFishingRod> cir) {
        if (this.hook_material == CTMaterials.tungsten)
            cir.setReturnValue(CTRegistryInit.fishingRodTungsten);
        if (this.hook_material == Material.rusted_iron)
            cir.setReturnValue(CTRegistryInit.fishingRodRustedIron);
    }
}
