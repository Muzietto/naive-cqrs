/*
 * Project: naive_cqrs
 * Author: Marco Faustinelli - Muzietto (contacts@faustinelli.net)
 * Web: http://faustinelli.wordpress.com/, http://www.github.com/muzietto, http://faustinelli.net/
 * Version: 1.0
 * The GPL 3.0 License - Copyright (c) 2015-2016 - The naive_cqrs Project
 */

package net.faustinelli.cqrs.naive.command.handler;

import net.faustinelli.cqrs.naive.command.Command;
import net.faustinelli.cqrs.naive.command.ExpireOrder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Marco Faustinelli (Muzietto) on 26/04/2016.
 */
public class CommandHandlerTest {

    @Test
    public void testCommandHandler() throws Exception {

        CommandHandler handler = new OrderCommandHandler();
        handler.handle(new ExpireOrder());
    }

    @Test
    public void testRegisterCommandHandler() throws Exception {
        CommandBus bus = new CommandBus();
        final TestCommandHandler handler = new TestCommandHandler(0);
        assertEquals(new Integer(0), handler.counter);
        bus.register(handler);
        final TestCommand testCommand = new TestCommand();
        bus.post(testCommand);
        assertEquals(new Integer(1), handler.counter);

    }

    private class TestCommandHandler extends CommandHandler {
        private Integer counter;

        private TestCommandHandler(Integer counter) {
            this.counter = counter;
        }

        public void handle(TestCommand command) {
            this.counter = this.counter + 1;
        }

        @Override
        public void handle(Command command) {
            System.out.println("working");
        }
    }

    private class TestCommand implements Command {

    }
}
