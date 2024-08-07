package mod.mitecreation.mixins.inventory.container;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import mod.mitecreation.block.CreationBlock;
import net.minecraft.Block;
import net.minecraft.ContainerWorkbench;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ContainerWorkbench.class)
public class ContainerWorkBenchMixin {
    @ModifyExpressionValue(method = "canInteractWith", at = @At(value = "INVOKE", target = "Lnet/minecraft/World;getBlockId(III)I"))
    private int enableCreationWorkBench(int original) {
        if (original == CreationBlock.creationWorkBench.blockID) return Block.workbench.blockID;
        return original;
    }
}
