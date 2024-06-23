package mod.mitecreation.mixin.entity;

import mod.mitecreation.materil.Materials;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(ClientPlayer.class)
public class ClientPlayerMixin {

    @Inject(method = "getBenchAndToolsModifier", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/BlockWorkbench;getToolMaterial(I)Lnet/minecraft/Material;", shift = At.Shift.AFTER), cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
    private void creationModifyWorkbenchModifier(Container container, CallbackInfoReturnable<Float> cir, ContainerWorkbench container_workbench, SlotCrafting slot_crafting, ItemStack item_stack, Item item, IRecipe recipe, Material material_to_check_tool_bench_hardness_against, Material benchMaterial) {
//        if (benchMaterial.min_harvest_level < material_to_check_tool_bench_hardness_against.min_harvest_level) {
//            cir.setReturnValue(0.0F);
//        } else if (benchMaterial == Material.flint || benchMaterial == Material.obsidian) {
//            cir.setReturnValue(0.2F);
//        } else if (benchMaterial == Material.copper || benchMaterial == Material.silver || benchMaterial == Material.gold) {
//            cir.setReturnValue(0.3F);
//        } else if (benchMaterial == Material.iron) {
//            cir.setReturnValue(0.4F);
//        } else if (benchMaterial == Material.ancient_metal) {
//            cir.setReturnValue(0.5F);
//        } else
            if (benchMaterial == Materials.tungsten) {
            cir.setReturnValue(0.55F);
//        } else if (benchMaterial == Material.mithril) {
//            cir.setReturnValue(0.6F);
//        } else if (benchMaterial == Material.adamantium) {
//            cir.setReturnValue(0.7F);
        } else {
            Minecraft.setErrorMessage("getBenchAndToolsModifier: unrecognized tool material " + benchMaterial);
            cir.setReturnValue(0.0F);
        }
    }
}
