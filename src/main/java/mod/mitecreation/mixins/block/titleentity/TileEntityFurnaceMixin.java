package mod.mitecreation.mixins.block.titleentity;

import mod.mitecreation.item.CreationItem;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TileEntityFurnace.class)
public class TileEntityFurnaceMixin extends TileEntity {

    @Inject(method = "getHeatLevelRequired", at = @At("HEAD"), cancellable = true)
    private static void creationInjectGetHeatLevelRequired(int item_id, CallbackInfoReturnable<Integer> cir) {
        if (item_id == CreationItem.rawAdamantiumNugget.itemID)
            cir.setReturnValue(4);
        if (item_id == CreationItem.rawMithrilNugget.itemID || item_id == CreationItem.rawTungstenNugget.itemID)
            cir.setReturnValue(3);
        if (item_id == CreationItem.rawRustedIronNugget.itemID || item_id == CreationItem.rustedIronNugget.itemID || item_id == CreationItem.rawAncientMetalNugget.itemID)
            cir.setReturnValue(2);
        if (item_id == CreationItem.rawCopperNugget.itemID || item_id == CreationItem.rawSilverNugget.itemID || item_id == CreationItem.rawGoldNugget.itemID)
            cir.setReturnValue(1);
    }
}
