package me.progamer260.commandhandler;

import me.progamer260.commandhandler.listeners.CommandListener;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.ArrayList;
import java.util.List;

public class Command {

    String[] aliases;
    String description;
    String usage;

    List<TextChannel> allowedChannels = new ArrayList<>();
    List<Permission> requiredPermissions = new ArrayList<>();

    int argsNumber = 0;
    CommandListener commandListener = new CommandListener() {
        @Override
        public void onCommand(Member sender, TextChannel channel, String[] args, Message message) {

        }
    };

    public Command() {

    }
}
