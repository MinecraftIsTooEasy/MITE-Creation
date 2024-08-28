package mod.mitecreation.mixins.inventory.slot;

import mod.mitecreation.item.ItemRawNugget;
import net.minecraft.Item;
import net.minecraft.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Slot.class)
public class SlotMixin {
    @Inject(method = "isLargeItem", at = @At("TAIL"), cancellable = true)
    private static void addRawNuggetToLargeItem(Item item, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(item instanceof ItemRawNugget);
    }
}
