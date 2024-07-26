package mod.mitecreation.mixin.client.gui;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import mod.mitecreation.block.CreationBlock;
import mod.mitecreation.block.CreationWorkbench;
import net.minecraft.ContainerWorkbench;
import net.minecraft.GuiContainer;
import net.minecraft.GuiScreen;
import net.minecraft.Material;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(GuiContainer.class)
public abstract class GuiContainerMixin extends GuiScreen {
    @WrapOperation(method = "drawItemStackTooltip(Lnet/minecraft/ItemStack;IILnet/minecraft/Slot;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/BlockWorkbench;getToolMaterial(I)Lnet/minecraft/Material;"))
    private Material drawItemStackTooltipCreation(int metadata, Operation<Material> original, @Local ContainerWorkbench workbench) {
        if (workbench.world.getBlockId(workbench.x, workbench.y, workbench.z) == CreationBlock.creationWorkBench.blockID) {
            return CreationWorkbench.getToolMaterial(metadata);
        } else {
            return original.call(metadata);
        }
    }
}
