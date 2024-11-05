package mod.mitecreation.mixins.item;

import mod.mitecreation.material.CreationMaterials;
import net.minecraft.ItemHorseArmor;
import net.minecraft.Material;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemHorseArmor.class)
public class ItemHorseArmorMixin {
    @Shadow public Material effective_material;
    @Inject(method = "getProtection", at = @At("TAIL"), cancellable = true)
    private void addTungstenHorseArmorProtection(CallbackInfoReturnable<Integer> cir) {
        if (this.effective_material == CreationMaterials.tungsten) {
            cir.setReturnValue(6);
        }
    }
}
