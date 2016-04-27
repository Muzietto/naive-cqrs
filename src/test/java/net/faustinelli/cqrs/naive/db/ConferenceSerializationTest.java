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
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.After;
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

    @After
    public void tearDown() {
        this.session.close();
    }

    @Test
    public void conferenceSeatAvailabilityPersistenceTest() {

        Conference confy = new Conference("test_confy", 123);
        SeatAvailability avail = new SeatAvailability(confy);

        session.save(confy);
        session.save(avail);
        tx.commit();
        Long confId = confy.getId();

        session = getSession();
        tx = session.beginTransaction();

        confy = (Conference) session.load(Conference.class, confId);
        assertEquals("test_confy", confy.getTitle());

        avail = (SeatAvailability) session
                .createQuery("from SeatAvailability where CONFERENCE_ID = :id ")
                .setParameter("id", confId)
                .list().get(0);

        assertEquals(new Integer(123), avail.availableSeats());
        tx.commit();
    }
}
