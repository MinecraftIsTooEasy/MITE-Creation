package mod.mitecreation.mixins.entity;

import mod.mitecreation.init.RegistryInit;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(EntityItem.class)
public class EntityItemMixin {
    @Inject(method = "onCollideWithPlayer", at = @At(value = "INVOKE", target = "Lnet/minecraft/EntityItem;playSound(Ljava/lang/String;FF)V"), locals = LocalCapture.CAPTURE_FAILSOFT)
    private void achievements(EntityPlayer par1EntityPlayer, CallbackInfo ci, boolean was_empty_handed_before, ItemStack var2, int var3) {
        if (var2.itemID == RegistryInit.rawCopperNugget.itemID || var2.itemID == RegistryInit.rawSilverNugget.itemID || var2.itemID == RegistryInit.rawGoldNugget.itemID || var2.itemID == RegistryInit.rawRustedIronNugget.itemID || var2.itemID == RegistryInit.rawTungstenNugget.itemID || var2.itemID == RegistryInit.rawMithrilNugget.itemID || var2.itemID == RegistryInit.rawAdamantiumNugget.itemID)
            par1EntityPlayer.triggerAchievement(AchievementList.nuggets);
    }
}
