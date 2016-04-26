/*
 * Project: naive-cqrs
 * Author: Marco Faustinelli - Muzietto (contacts@faustinelli.net)
 * Web: http://faustinelli.wordpress.com/, https://www.github.com/muzietto, http://faustinelli.net/
 * Version: 1.0
 * The GPL 3.0 License - Copyright (c) 2015-2016 - The naive-cqrs Project
 */

package net.faustinelli.cqrs.naive.bus.command.handler;

import com.google.gwt.thirdparty.guava.common.eventbus.Subscribe;
import net.faustinelli.cqrs.naive.bus.command.CommandBus;
import net.faustinelli.cqrs.naive.bus.command.RegisterToConference;
import net.faustinelli.cqrs.naive.model.Factory;
import net.faustinelli.cqrs.naive.model.Order;

/**
 * Created by Marco Faustinelli (Muzietto) on 4/26/2016.
 */
public class OrderCommandHandler implements CommandHandler {

    private CommandBus commandBus;

    public OrderCommandHandler(CommandBus commandBus) {
        this.commandBus = commandBus;
        commandBus.register(this);
    }

    @Subscribe
    public void handle(RegisterToConference command) {
        Order order = Factory.ORDER(command.getConference(), command.getParticipants());

    }
}
