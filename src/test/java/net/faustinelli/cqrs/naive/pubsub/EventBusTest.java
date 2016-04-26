/*
 * Project: naive-cqrs
 * Author: Marco Faustinelli - Muzietto (contacts@faustinelli.net)
 * Web: http://faustinelli.wordpress.com/, http://www.github.com/muzietto, http://faustinelli.net/
 * Version: 1.0
 * The GPL 3.0 License - Copyright (c) 2015-2016 - The naive-cqrs Project
 */

package net.faustinelli.cqrs.naive.pubsub;

import com.google.gwt.thirdparty.guava.common.eventbus.EventBus;
import com.google.gwt.thirdparty.guava.common.eventbus.Subscribe;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Marco Faustinelli (Muzietto) on 4/26/2016.
 */
public class EventBusTest {

    @Test
    public void eventBusTest() throws Exception {
        EventBus eventBus = new EventBus("test");
        EventAscolter ascolter = new EventAscolter();

        eventBus.register(ascolter);
        assertEquals(new Integer(0), ascolter.getLastMessage());

        eventBus.post(new OurTestEvent(200));
        assertEquals(new Integer(200), ascolter.getLastMessage());
    }


    private class EventAscolter {
        public int lastMessage = 0;

        public int getLastMessage() {
            return lastMessage;
        }

        @Subscribe
        public void listen(OurTestEvent event) {
            lastMessage = event.getMessage();
        }
    }

    private class OurTestEvent {

        private int message;

        public OurTestEvent(int i) {
            message = i;
        }

        public int getMessage() {
            return message;
        }
    }
}
