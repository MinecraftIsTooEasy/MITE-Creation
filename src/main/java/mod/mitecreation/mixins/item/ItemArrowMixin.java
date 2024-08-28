package mod.mitecreation.mixins.item;

import mod.mitecreation.item.CreationItem;
import mod.mitecreation.materil.CreationMaterial;
import net.minecraft.*;
import net.xiaoyu233.fml.util.ReflectHelper;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.xiaoyu233.fml.util.ReflectHelper.dyCast;

@Mixin(ItemArrow.class)
public class ItemArrowMixin extends Item {
    @Shadow
    @Final
    @Mutable
    public static Material[] material_types;
    @Shadow
    @Final
    public Material arrowhead_material;

    @Inject(method = "<clinit>()V", at = @At("RETURN"))
    private static void addCreationArrow(CallbackInfo callback) {
        Material[] original = material_types;
        Material[] expanded = new Material[original.length + 1];
        System.arraycopy(original, 0, expanded, 0, original.length);
        expanded[original.length] = CreationMaterial.tungsten;
        material_types = expanded;
    }

    @Inject(method = "getChanceOfRecovery", at = @At("HEAD"), cancellable = true)
    private void getChanceOfRecoveryCreation(CallbackInfoReturnable<Float> cir) {
        if (ReflectHelper.dyCast(this) == CreationItem.arrowTungsten)
            cir.setReturnValue(0.8F);
    }

}
