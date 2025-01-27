//package mod.mitecreation.mixin.client.render;
//
//import mod.mitecreation.init.MITECreationModInit;
//import mod.mitecreation.material.CreationMaterials;
//import net.minecraft.ItemArrow;
//import net.minecraft.Material;
//import net.minecraft.RenderArrow;
//import net.minecraft.ResourceLocation;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//@Mixin(RenderArrow.class)
//public class RenderArrowMixin {
//    @Shadow private static ResourceLocation[] textures;
//
//    @Inject(method = "addTextures", at = @At("TAIL"))
//    public void addTextures(CallbackInfo ci) {
//        textures = new ResourceLocation[ItemArrow.material_types.length];
//        for (int i = 0; i < textures.length; ++i) {
//            for (Material material : ItemArrow.material_types) {
//                if (material == CreationMaterials.tungsten)
//                    textures[i] = new ResourceLocation(MITECreationModInit.RESOURCEID + "textures/entity/arrows/" + ItemArrow.material_types[i].name + ".png");
//            }
//        }
//    }
//}
