package mod.mitecreation.mixins.entity.player;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import mod.mitecreation.block.CreationBlock;
import mod.mitecreation.block.CreationWorkbench;
import mod.mitecreation.materil.CreationMaterial;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(ClientPlayer.class)
public class ClientPlayerMixin {

    @Shadow
    protected Minecraft mc;

    @WrapOperation(method = "getBenchAndToolsModifier", at = @At(value = "INVOKE", target = "Lnet/minecraft/BlockWorkbench;getToolMaterial(I)Lnet/minecraft/Material;"))
    private Material addCreationWorkBench(int metadata, Operation<Material> original, @Local ContainerWorkbench workbench) {
        if (workbench.world.getBlockId(workbench.x, workbench.y, workbench.z) == CreationBlock.creationWorkBench.blockID) {
            return CreationWorkbench.getToolMaterial(metadata);
        } else {
            return original.call(metadata);
        }
    }

    @Inject(method = "getBenchAndToolsModifier", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/BlockWorkbench;getToolMaterial(I)Lnet/minecraft/Material;", shift = At.Shift.AFTER), cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
    private void injectModifyWorkbenchModifier(Container container, CallbackInfoReturnable<Float> cir, ContainerWorkbench workbench, SlotCrafting slot_crafting, ItemStack item_stack, Item item, IRecipe recipe, Material material_to_check_tool_bench_hardness_against, Material benchMaterial) {
        if (benchMaterial.min_harvest_level < material_to_check_tool_bench_hardness_against.min_harvest_level) {
            cir.setReturnValue(0.0F);
        } else if (benchMaterial == CreationMaterial.tungsten) {
            float modifier = CreationWorkbench.getCraftingSpeedModifier(benchMaterial);
            if (modifier != 0.0f)
                cir.setReturnValue(modifier);
        }
    }
}
