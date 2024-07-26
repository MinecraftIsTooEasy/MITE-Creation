package mod.mitecreation.mixin.item;

import mod.mitecreation.block.CreationBlock;
import mod.mitecreation.block.CreationWorkbench;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemBlock.class)
public class ItemBlockMixin extends Item {
    @Shadow
    public Block getBlock() {
        return null;
    }

    @Inject(method = "getItemDisplayName", at = @At("HEAD"), cancellable = true)
    private void itfWorkbench(ItemStack item_stack, CallbackInfoReturnable<String> cir) {
        if (item_stack != null && this.getBlock() == CreationBlock.creationWorkBench) {
            cir.setReturnValue(Translator.get("tile.toolbench." + CreationWorkbench.getToolMaterial(item_stack.getItemSubtype()).name + ".name"));
        }
    }
}