/*
 * Project: naive-cqrs
 * Author: Marco Faustinelli - Muzietto (contacts@faustinelli.net)
 * Web: http://faustinelli.wordpress.com/, https://www.github.com/muzietto, http://faustinelli.net/
 * Version: 1.0
 * The GPL 3.0 License - Copyright (c) 2015-2016 - The naive-cqrs Project
 */

package net.faustinelli.cqrs.naive.db;

import net.faustinelli.cqrs.naive.model.Conference;
import net.faustinelli.cqrs.naive.model.Message;
import net.faustinelli.cqrs.naive.model.SeatAvailability;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Before;
import org.junit.Test;

import static net.faustinelli.cqrs.naive.db.HibernateConfig.getSession;
import static org.junit.Assert.assertEquals;

/**
 * Created by Marco Faustinelli (Muzietto) on 4/25/2016.
 */
public class ConferenceSerializationTest {
    private Session session;
    private Transaction tx;

    @Before
    public void setUp() {
        this.session = getSession();
        this.tx = session.beginTransaction();
    }

    @Test
    public void conferenceSeatAvailabilityPersistenceTest() {

        Conference confy = new Conference("test_confy", 123);
        SeatAvailability avail = new SeatAvailability(confy);

        session.save(confy);
        session.save(avail);
        tx.commit();

        session = getSession();
        tx = session.beginTransaction();

        confy = (Conference) session.load(Conference.class, new Long(1));
        assertEquals("test_confy", confy.getTitle());

        avail = (SeatAvailability) session.load(SeatAvailability.class, new Long(1));
        assertEquals(new Integer(123), avail.availableSeats());
        tx.commit();
    }
}
