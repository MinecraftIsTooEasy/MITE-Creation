package mod.mitecreation.mixin.server;

import mod.mitecreation.util.Util;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DedicatedServer.class)
public class DedicatedServerMixin {
    @Inject(method = "playerLoggedIn",at = @At("RETURN"))
    public void playerLoggedIn(ServerPlayer player, CallbackInfo callbackInfo) {
        player.sendChatToPlayer(ChatMessage.createFromTranslationKey("[Server] ").appendComponent(ChatMessage.createFromTranslationKey("MITE Creation Successful Load,Version: ").setColor(EnumChatFormat.WHITE)).appendComponent(ChatMessage.createFromText(Util.modVerStr)));
    }
}
