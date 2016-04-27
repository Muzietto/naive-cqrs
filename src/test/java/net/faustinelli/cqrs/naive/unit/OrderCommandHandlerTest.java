/*
 * Project: naive-cqrs
 * Author: Marco Faustinelli - Muzietto (contacts@faustinelli.net)
 * Web: http://faustinelli.wordpress.com/, http://www.github.com/muzietto, http://faustinelli.net/
 * Version: 1.0
 * The GPL 3.0 License - Copyright (c) 2015-2016 - The naive-cqrs Project
 */

package net.faustinelli.cqrs.naive.unit;

import net.faustinelli.cqrs.naive.bus.Bus;
import net.faustinelli.cqrs.naive.bus.command.RegisterToConference;
import net.faustinelli.cqrs.naive.bus.command.handler.OrderCommandHandler;
import net.faustinelli.cqrs.naive.model.Conference;
import net.faustinelli.cqrs.naive.model.Factory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Marco Faustinelli (Muzietto) on 27/04/2016.
 */
public class OrderCommandHandlerTest {
    private Bus commandBus;
    private Factory factory;

    @Before
    public void setUp() {
        this.commandBus = new FakeCommandBus();
        this.factory = new FakeFactory();
    }

    @Test
    public void testXXXXXX() throws Exception {
        OrderCommandHandler och = new OrderCommandHandler(this.commandBus, this.factory);

        och.handle(new RegisterToConference(new Conference("test_conf"), 3));
        assertTrue(true);
    }
}
