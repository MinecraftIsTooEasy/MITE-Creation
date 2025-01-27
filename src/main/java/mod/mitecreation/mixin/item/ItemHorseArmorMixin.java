package mod.mitecreation.mixin.item;

import mod.mitecreation.material.CTMaterials;
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
    @Inject(method = "getProtection", at = @At("HEAD"), cancellable = true)
    private void addTungstenHorseArmorProtection(CallbackInfoReturnable<Integer> cir) {
        if (this.effective_material == CTMaterials.tungsten) {
            cir.setReturnValue(6);
        }
    }
}
