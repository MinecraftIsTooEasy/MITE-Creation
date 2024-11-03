package mod.mitecreation.mixins.block.titleentity;

import mod.mitecreation.init.RegistryInit;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TileEntityFurnace.class)
public class TileEntityFurnaceMixin extends TileEntity {

    @Inject(method = "getHeatLevelRequired", at = @At("HEAD"), cancellable = true)
    private static void creationInjectGetHeatLevelRequired(int item_id, CallbackInfoReturnable<Integer> cir) {
        if (item_id == RegistryInit.rawAdamantiumNugget.itemID)
            cir.setReturnValue(4);
        if (item_id == RegistryInit.rawMithrilNugget.itemID || item_id == RegistryInit.rawTungstenNugget.itemID)
            cir.setReturnValue(3);
        if (item_id == RegistryInit.rawRustedIronNugget.itemID || item_id == RegistryInit.rustedIronNugget.itemID || item_id == RegistryInit.rawAncientMetalNugget.itemID)
            cir.setReturnValue(2);
        if (item_id == RegistryInit.rawCopperNugget.itemID || item_id == RegistryInit.rawSilverNugget.itemID || item_id == RegistryInit.rawGoldNugget.itemID)
            cir.setReturnValue(1);
    }
}
