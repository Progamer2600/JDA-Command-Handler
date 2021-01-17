package me.progamer260.commandhandler.listeners;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public interface CommandListener {

    void onCommand(Member sender, TextChannel channel, String[] args, Message message);
}
