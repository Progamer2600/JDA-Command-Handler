package me.progamer260.commandhandler;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class CommandHandler {

    LinkedList<Command> commands = Registration.commands;

    public void registerCommands(Command... commands) {
        this.commands.addAll(Arrays.asList(commands));
    }

    public List<Command> getCommands() {
        return this.commands;
    }
    public void setPrefix(String prefix) {
        Registration.prefix = prefix;
    }

    public String getPrefix() {
        return Registration.prefix;
    }
}
