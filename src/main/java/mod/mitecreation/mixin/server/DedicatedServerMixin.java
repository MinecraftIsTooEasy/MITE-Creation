package mod.mitecreation.mixin.server;

import mod.mitecreation.util.Constant;
import net.minecraft.ChatMessageComponent;
import net.minecraft.DedicatedServer;
import net.minecraft.EnumChatFormatting;
import net.minecraft.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DedicatedServer.class)
public class DedicatedServerMixin {

    @Inject(method = "playerLoggedIn",at = @At("RETURN"))
    public void playerLoggedIn(ServerPlayer player, CallbackInfo callbackInfo) {
        player.sendChatToPlayer(ChatMessageComponent.createFromTranslationKey("[Server] ").appendComponent(ChatMessageComponent.createFromTranslationKey(Constant.CreationModName + "Successful Load,Version: ").setColor(EnumChatFormatting.WHITE)).appendComponent(ChatMessageComponent.createFromText(Constant.modVerStr)));
    }
}
