package mod.mitecreation.mixins.entity;

import mod.mitecreation.item.CreationItem;
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
        if (var2.itemID == CreationItem.rawCopperNugget.itemID || var2.itemID == CreationItem.rawSilverNugget.itemID || var2.itemID == CreationItem.rawGoldNugget.itemID || var2.itemID == CreationItem.rawRustedIronNugget.itemID || var2.itemID == CreationItem.rawTungstenNugget.itemID || var2.itemID == CreationItem.rawMithrilNugget.itemID || var2.itemID == CreationItem.rawAdamantiumNugget.itemID)
            par1EntityPlayer.triggerAchievement(AchievementList.nuggets);
    }
}
