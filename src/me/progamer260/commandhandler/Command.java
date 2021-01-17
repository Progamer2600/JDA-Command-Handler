package me.progamer260.commandhandler;

import me.progamer260.commandhandler.listeners.CommandListener;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class Command {

    String[] aliases;
    String description = "";
    String usage = "";

    List<TextChannel> allowedChannels = new ArrayList<>();
    List<Permission> requiredPermissions = new ArrayList<>();

    int argsNumber = 0;

    CommandListener commandListener = (sender, channel, args, message) -> {

    };

    public Command(String[] aliases) {
        this.aliases = aliases;
    }
    public void register() {
        CommandHandler commandHandler = new CommandHandler();
        commandHandler.registerCommands(this);
    }

    public CommandListener getCommandListener() {
        return commandListener;
    }

    public String getDescription() {
        return description;
    }

    public String getUsage() {
        return usage;
    }

    public List<TextChannel> getAllowedChannels() {
        return allowedChannels;
    }

    public List<Permission> getRequiredPermissions() {
        return requiredPermissions;
    }

    public int getArgsNumber() {
        return argsNumber;
    }

    public String[] getAliases() {
        return aliases;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public void setAllowedChannels(TextChannel... allowedChannels) {
        this.allowedChannels.addAll(Arrays.asList(allowedChannels));
    }

    public void setAllowedChannels(Guild guild, String... channelNames) {
        for (String channels : channelNames) {
            this.allowedChannels.addAll(guild.getTextChannelsByName(channels, true));
        }
    }

    public void setRequiredPermissions(Permission... permissions) {
        this.requiredPermissions.addAll(Arrays.asList(permissions));
    }

    public void setArgsNumber(int argsNumber) {
        this.argsNumber = argsNumber;
    }

    public void setCommandListener(CommandListener commandListener) {
        this.commandListener = commandListener;
    }
}