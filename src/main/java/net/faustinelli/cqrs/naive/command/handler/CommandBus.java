/*
 * Project: naive_cqrs
 * Author: Marco Faustinelli - Muzietto (contacts@faustinelli.net)
 * Web: http://faustinelli.wordpress.com/, http://www.github.com/muzietto, http://faustinelli.net/
 * Version: 1.0
 * The GPL 3.0 License - Copyright (c) 2015-2016 - The naive_cqrs Project
 */

package net.faustinelli.cqrs.naive.command.handler;

import net.faustinelli.cqrs.naive.command.Command;
import net.faustinelli.cqrs.naive.command.RegisterToConference;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marco Faustinelli (Muzietto) on 26/04/2016.
 */
public class CommandBus {
    private List<CommandHandler> handlers = new ArrayList<CommandHandler>();

    public void register(CommandHandler commandHandler) {
        this.handlers.add(commandHandler);
    }

    public void post(Command command) {
        for (CommandHandler handler : this.handlers) {
          handler.handle(command);
        }
    }
}
