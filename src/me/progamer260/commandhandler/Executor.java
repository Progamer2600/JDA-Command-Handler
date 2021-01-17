package me.progamer260.commandhandler;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


import java.util.Arrays;
import java.util.Objects;

public class Executor extends ListenerAdapter {

    CommandHandler commandHandler;

    public Executor(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @SuppressWarnings("unused")
    public void messageReceived(GuildMessageReceivedEvent event) {
        String command = event.getMessage().getContentRaw().split(" ")[0];
        String[] args = Arrays.copyOfRange(event.getMessage().getContentRaw()
                        .split(" "), 1, event.getMessage()
                        .getContentRaw().split(" ").length);
        Member member = event.getMember();
        TextChannel textChannel = event.getChannel();
        Message message = event.getMessage();

        for (Command cmd : commandHandler.getCommands()) {
            for (String aliases : cmd.getAliases()) {
                if (command.equalsIgnoreCase(commandHandler.getPrefix() + aliases)) {
                    if (cmd.getRequiredPermissions().isEmpty()) {
                        if (args.length >= cmd.getArgsNumber()) {
                            if (cmd.getAllowedChannels().isEmpty()) {
                                cmd.getCommandListener().onCommand(member, textChannel, args, message);
                            } else {
                                if (cmd.getAllowedChannels().contains(textChannel)) {
                                    cmd.getCommandListener().onCommand(member, textChannel, args, message);
                                }  else {
                                    for (Permission permissions : cmd.getRequiredPermissions()) {
                                        if (!Objects.requireNonNull(event.getMember()).getPermissions().contains(permissions)) {
                                            return;
                                        }
                                    }
                                    if (args.length >= cmd.getArgsNumber()) {
                                        if (cmd.getAllowedChannels().isEmpty()) {
                                            cmd.getCommandListener().onCommand(member, textChannel, args, message);
                                        } else {
                                            if (cmd.getAllowedChannels().contains(textChannel)) {
                                                cmd.getCommandListener().onCommand(member, textChannel, args, message);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
