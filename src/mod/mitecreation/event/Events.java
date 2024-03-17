package mod.mitecreation.event;

import com.google.common.eventbus.Subscribe;
import mod.mitecreation.util.Util;
import net.minecraft.*;
import net.xiaoyu233.fml.reload.event.HandleChatCommandEvent;
import net.xiaoyu233.fml.reload.event.PlayerLoggedInEvent;

public class Events {
//    @Subscribe
//    public void handleChatCommand(HandleChatCommandEvent handleChatCommandEvent) {
//        String string = handleChatCommandEvent.getCommand();
//        EntityPlayer entityPlayer = handleChatCommandEvent.getPlayer();
//        ICommandListener iCommandListener = handleChatCommandEvent.getListener();
//        if (string.startsWith("protection")) {
//            entityPlayer.sendChatToPlayer(ChatMessage.createFromText("You have " + entityPlayer.getTotalProtection(DamageSource.causeMobDamage(null)) + " protection"));
//        }
//    }

    @Subscribe
    public void onPlayerLoggedIn(PlayerLoggedInEvent event) {
        event.getPlayer().sendChatToPlayer(ChatMessageComponent.createFromTranslationKey("[Client] ").appendComponent(ChatMessageComponent.createFromTranslationKey("MITE Creation Successful Load,Version: ").setColor(EnumChatFormatting.WHITE)).appendComponent(ChatMessageComponent.createFromText(Util.modVerStr)));
    }

}
