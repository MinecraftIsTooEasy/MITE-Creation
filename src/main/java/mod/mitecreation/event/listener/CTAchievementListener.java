package mod.mitecreation.event.listener;

import mod.mitecreation.init.CTRegistryInit;
import moddedmite.rustedironcore.api.event.listener.IAchievementListener;
import net.minecraft.AchievementList;
import net.minecraft.EntityPlayer;
import net.minecraft.ItemStack;

public class CTAchievementListener implements IAchievementListener {
    public void onItemPickUp(EntityPlayer player, ItemStack stack) {
        if (stack.itemID == CTRegistryInit.rawCopperNugget.itemID ||
                stack.itemID == CTRegistryInit.rawSilverNugget.itemID ||
                stack.itemID == CTRegistryInit.rawGoldNugget.itemID ||
                stack.itemID == CTRegistryInit.rawRustedIronNugget.itemID ||
                stack.itemID == CTRegistryInit.rawTungstenNugget.itemID ||
                stack.itemID == CTRegistryInit.rawMithrilNugget.itemID ||
                stack.itemID == CTRegistryInit.rawAdamantiumNugget.itemID)
            player.triggerAchievement(AchievementList.nuggets);
    }
}
