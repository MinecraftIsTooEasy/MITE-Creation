package mod.mitecreation.mixin.item;

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

    @Inject(method = "<clinit>",at = @At("RETURN"))
    private static void injectClinit(CallbackInfo callback) {
        material_types = new Material[]{
                Material.flint, Material.obsidian, Material.copper, Material.silver, Material.gold, Material.iron,
                Material.rusted_iron, Material.ancient_metal, CreationMaterial.tungsten, Material.mithril, Material.adamantium};
    }

    @Inject(method = "getChanceOfRecovery", at = @At("HEAD"), cancellable = true)
    private void getChanceOfRecoveryCreation(CallbackInfoReturnable<Float> cir) {
        if (ReflectHelper.dyCast(this) == CreationItem.arrowTungsten) {
            cir.setReturnValue(0.8F);
        } else {
            cir.setReturnValue(0.0F);
        }
    }

    @Shadow
    @Final
    @Mutable
    public static Material[] material_types;
    @Shadow
    @Final
    public Material arrowhead_material;

}
