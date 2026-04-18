package com.mythicalgames.discordrelay;

import org.allaymc.api.command.SenderType;
import org.allaymc.api.command.Command;
import org.allaymc.api.command.tree.CommandTree;
import org.allaymc.api.permission.OpPermissionCalculator;

public class DiscordCommand extends Command {

    public DiscordCommand() {
        super("discord", "Get the Discord server link", "discordrelay.use");
        OpPermissionCalculator.NON_OP_PERMISSIONS.addAll(this.permissions);
    }

    @Override
    public void prepareCommandTree(CommandTree tree) {
        tree.getRoot().exec((context, sender) -> {
            String discordMessage = DiscordRelay.INSTANCE.CONFIG.discordCommandText();

            if (discordMessage == null || discordMessage.isEmpty()) {
                sender.sendMessage("§cThe Discord message is not set in the config.");
                return context.fail();
            }

            sender.sendMessage(discordMessage);
            return context.success();
        }, SenderType.ANY);
    }
}
