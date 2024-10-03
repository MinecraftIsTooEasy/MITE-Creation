package mod.mitecreation.mixins.item;

import mod.mitecreation.material.CreationMaterial;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemBow.class)
public abstract class ItemBowMixin extends Item {
    @Final
    @Shadow
    @Mutable
    private static Material[] possible_arrow_materials;

    @Mutable
    @Shadow
    @Final
    public static String[] bow_pull_icon_name_array;

//    @Inject(method = "<clinit>", at = @At("TAIL"))
//    private static void addCreationBowArrowMaterials(CallbackInfo ci) {
//        Material[] original = possible_arrow_materials;
//        Material[] expanded = new Material[original.length + 1];
//        System.arraycopy(original, 0, expanded, 0, original.length);
//        expanded[original.length] = CreationMaterial.tungsten;
//        possible_arrow_materials = expanded;
//
//        bow_pull_icon_name_array = new String[possible_arrow_materials.length * 3];
//
//        for (int arrow_index = 0; arrow_index < possible_arrow_materials.length; ++arrow_index) {
//            Material material = possible_arrow_materials[arrow_index];
//            for (int icon_index = 0; icon_index < 3; ++icon_index) {
//                ItemBow.bow_pull_icon_name_array[arrow_index * 3 + icon_index] = material.name + "_arrow_" + icon_index;
//            }
//        }
//    }
}

