package me.progamer260.commandhandler;

import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Executor extends ListenerAdapter {

    CommandHandler commandHandler;

    public Executor(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

}
