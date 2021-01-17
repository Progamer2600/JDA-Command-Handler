package me.progamer260.commandhandler;

import net.dv8tion.jda.api.JDA;

import java.util.LinkedList;

@SuppressWarnings("unused")
public class Registration {

    CommandHandler handler;

    private static JDA jda;
    public static LinkedList<Command> commands = new LinkedList<>();
    public static String prefix = "$";
    private final LinkedList<CommandCreate> commandCreates = new LinkedList<>();

    public Registration(JDA jda) {
        Registration.jda = jda;
    }

    public void completeRegistration() {
        this.handler = new CommandHandler();
        commandCreates.forEach(c -> c.getCommand().register());
        jda.addEventListener(new Executor(handler));
    }

    public void registerCommandCreate(CommandCreate commandCreate) {
        commandCreates.add(commandCreate);
    }
}
