package mod.mitecreation.event.command;

import net.minecraft.*;

public class CommandProtection extends CommandAbstract {
    @Override
    public String getCommandName() {
        return "protection";
    }

    @Override
    public String getCommandUsage(ICommandListener iCommandListener) {
        return "commands.protection.usage";
    }

    @Override
    public void processCommand(ICommandListener iCommandListener, String[] strings) {
        EntityPlayer entityPlayer = getCommandSenderAsPlayer(iCommandListener);
        entityPlayer.sendChatToPlayer(ChatMessage.createFromText("You have " + entityPlayer.getTotalProtection(DamageSource.causeMobDamage(null)) + " protection"));
    }
}
