package mod.mitecreation.command;

import net.minecraft.*;

import java.util.Arrays;
import java.util.List;

public class CommandCTDimensionTP extends CommandBase {
    public String getCommandName() {
        return "dimensiontp";
    }

    public String getCommandUsage(ICommandSender ICommandSender2) {
        return "commands.dimensiontp.usage";
    }

    public int getRequiredPermissionLevel() {
        return 2;
    }

    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
        return par2ArrayOfStr.length == 1 ? CommandCTDimensionTP.getListOfStringsMatchingLastWord((String[])par2ArrayOfStr, (String[])((String[]) Arrays.stream(EnumDimension.values()).map(x -> x.en_name).toArray(String[]::new))) : null;
    }

    public void processCommand(ICommandSender iCommandSender, String[] strings) {
        if (strings.length != 1) {
            throw new WrongUsageException("commands.dimensiontp.usage", new Object[0]);
        }
        Arrays.stream(EnumDimension.values()).filter(x -> x.en_name.equals(strings[0])).findAny().ifPresentOrElse(x -> {
            if (iCommandSender.getEntityWorld().provider.dimensionId != x.id) {
                ServerPlayer player = CommandCTDimensionTP.getCommandSenderAsPlayer((ICommandSender)iCommandSender);
                player.timeUntilPortal = 100;
                player.travelToDimension(x.id);
                iCommandSender.sendChatToPlayer(ChatMessageComponent.createFromTranslationWithSubstitutions((String)"commands.dimensiontp.success", (Object[])new Object[]{x.getUnlocalizedName()}).setColor(EnumChatFormatting.WHITE));
            } else {
                iCommandSender.sendChatToPlayer(ChatMessageComponent.createFromTranslationWithSubstitutions((String)"commands.dimensiontp.duplicateDestination", (Object[])new Object[]{x.getUnlocalizedName()}).setColor(EnumChatFormatting.RED));
            }
        }, () -> iCommandSender.sendChatToPlayer(ChatMessageComponent.createFromTranslationKey((String)"commands.dimensiontp.dimensionNotFound").setColor(EnumChatFormatting.RED)));
    }

    private static enum EnumDimension {
        OverWorld(0, "overWorld", "主世界"),
        Hell(-1, "hell", "地狱"),
        UnderWorld(-2, "underWorld", "地下世界"),
        End(1, "end", "末地"),
        RedSky(9, "redSky", "赤空");

        final int id;
        final String en_name;
        final String zh_name;

        private EnumDimension(int id, String en_name, String zh_name) {
            this.id = id;
            this.en_name = en_name;
            this.zh_name = zh_name;
        }

        public String getUnlocalizedName() {
            return "commands.dimensiontp." + this.en_name;
        }
    }
}

