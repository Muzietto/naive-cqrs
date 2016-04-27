/*
 * Project: naive-cqrs
 * Author: Marco Faustinelli - Muzietto (contacts@faustinelli.net)
 * Web: http://faustinelli.wordpress.com/, http://www.github.com/muzietto, http://faustinelli.net/
 * Version: 1.0
 * The GPL 3.0 License - Copyright (c) 2015-2016 - The naive-cqrs Project
 */

package net.faustinelli.cqrs.naive.unit;

import net.faustinelli.cqrs.naive.model.Conference;
import net.faustinelli.cqrs.naive.model.SeatAvailability;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Marco Faustinelli (Muzietto) on 27/04/2016.
 */
public class SeatAvailabilityUnitTest {
    @Test
    public void testBookSeats() throws Exception {
        SeatAvailability avail = new SeatAvailability(new Conference("test_confy"));
        assertEquals(new Integer(100), avail.availableSeats());

        avail.bookSeats(15);
        assertEquals(new Integer(85), avail.availableSeats());
    }
}
