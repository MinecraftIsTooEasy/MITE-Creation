package mod.mitecreation.mixin.item;

import mod.mitecreation.materil.Materials;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemFishingRod.class)
public class ItemFishingRodMixin extends Item implements IDamageableItem {

    private Icon[] uncastIcons = new Icon[11];
    private Material hook_material;

    @Shadow
    public int getNumComponentsForDurability() {
        return 0;
    }

    @Inject(method = "getMaterialOrdinal", at = @At("HEAD"), cancellable = true)
    private void getMaterialOrdinalCreation(CallbackInfoReturnable<Integer> cir) {
        if (this.hook_material == Material.rusted_iron)
            cir.setReturnValue(9);
        if (this.hook_material == Materials.tungsten)
            cir.setReturnValue(10);
    }

    @Inject(method = "getMaterialByOrdinal", at = @At("HEAD"), cancellable = true)
    private void getMaterialByOrdinalCreation(int ordinal, CallbackInfoReturnable<Material> cir) {
        switch (ordinal) {
            case 9:
                cir.setReturnValue(Material.rusted_iron);
            case 10:
                cir.setReturnValue(Materials.tungsten);
        }
    }
}
