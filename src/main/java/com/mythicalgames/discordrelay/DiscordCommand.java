package com.mythicalgames.discordrelay;

import org.allaymc.api.command.SenderType;
import org.allaymc.api.command.Command;
import org.allaymc.api.command.tree.CommandTree;

public class DiscordCommand extends Command {

    public DiscordCommand() {
        super("discord", "Get the Discord server link", "discordrelay.use");
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
