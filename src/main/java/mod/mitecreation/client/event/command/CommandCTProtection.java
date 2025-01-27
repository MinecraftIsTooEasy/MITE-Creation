package mod.mitecreation.client.event.command;

import net.minecraft.*;

public class CommandCTProtection extends CommandBase {

    @Override
    public String getCommandName() {
        return "protection";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.protection.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] strings) {
        EntityPlayer entityPlayer = getCommandSenderAsPlayer(iCommandSender);
        entityPlayer.sendChatToPlayer(ChatMessageComponent.createFromText("You have " + entityPlayer.getTotalProtection(DamageSource.causeMobDamage(null)) + " protection").setColor(EnumChatFormatting.YELLOW));
    }
}
