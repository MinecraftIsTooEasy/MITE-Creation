package mod.mitecreation.mixin.command;

import net.minecraft.ServerCommandManager;
import net.minecraft.CommandHandler;
import mod.mitecreation.event.command.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerCommandManager.class)
public class CommandDispatcherMixin extends CommandHandler {

    @Inject(method = "<init>", at = @At("RETURN"))
    private void injectInit(CallbackInfo callbackInfo) {
        this.registerCommand(new CommandProtection());
    }
}
