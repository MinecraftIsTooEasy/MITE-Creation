//package mod.mitecreation.mixin.item;
//
//import mod.mitecreation.init.MITECreationModInit;
//import mod.mitecreation.material.CreationMaterials;
//import net.minecraft.Icon;
//import net.minecraft.IconRegister;
//import net.minecraft.ItemBow;
//import net.minecraft.Material;
//import org.spongepowered.asm.mixin.Final;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Redirect;
//
//@Mixin(ItemBow.class)
//public class ItemBowMixin {
//    @Shadow @Final private static Material[] possible_arrow_materials;
//
//    @Redirect(method = "registerIcons", at = @At(value = "INVOKE", target = "Lnet/minecraft/IconRegister;registerIcon(Ljava/lang/String;)Lnet/minecraft/Icon;", ordinal = 1))
//    public Icon registerIcons(IconRegister instance, String string) {
//        for (Material material : possible_arrow_materials) {
//            if (material == CreationMaterials.tungsten) {
//                return instance.registerIcon(MITECreationModInit.RESOURCEID + string);
//            } else {
//                return instance.registerIcon(string);
//            }
//        }
//        return instance.registerIcon(string);
//    }
//}
