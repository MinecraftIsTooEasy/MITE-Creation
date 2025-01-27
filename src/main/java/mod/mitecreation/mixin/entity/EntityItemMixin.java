package mod.mitecreation.mixin.entity;

import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.AchievementList;
import net.minecraft.EntityItem;
import net.minecraft.EntityPlayer;
import net.minecraft.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(EntityItem.class)
public class EntityItemMixin {
    @Inject(method = "onCollideWithPlayer", at = @At(value = "INVOKE", target = "Lnet/minecraft/EntityItem;playSound(Ljava/lang/String;FF)V"), locals = LocalCapture.CAPTURE_FAILSOFT)
    private void achievements(EntityPlayer par1EntityPlayer, CallbackInfo ci, boolean was_empty_handed_before, ItemStack var2, int var3) {
        if (var2.itemID == CTRegistryInit.rawCopperNugget.itemID || var2.itemID == CTRegistryInit.rawSilverNugget.itemID || var2.itemID == CTRegistryInit.rawGoldNugget.itemID || var2.itemID == CTRegistryInit.rawRustedIronNugget.itemID || var2.itemID == CTRegistryInit.rawTungstenNugget.itemID || var2.itemID == CTRegistryInit.rawMithrilNugget.itemID || var2.itemID == CTRegistryInit.rawAdamantiumNugget.itemID)
            par1EntityPlayer.triggerAchievement(AchievementList.nuggets);
    }
}
