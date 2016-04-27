/*
 * Project: naive-cqrs
 * Author: Marco Faustinelli - Muzietto (contacts@faustinelli.net)
 * Web: http://faustinelli.wordpress.com/, https://www.github.com/muzietto, http://faustinelli.net/
 * Version: 1.0
 * The GPL 3.0 License - Copyright (c) 2015-2016 - The naive-cqrs Project
 */

package net.faustinelli.cqrs.naive.db;

import net.faustinelli.cqrs.naive.model.Conference;
import net.faustinelli.cqrs.naive.model.Factory;
import net.faustinelli.cqrs.naive.model.Order;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Marco Faustinelli (Muzietto) on 4/27/2016.
 */
public class ConcreteFactoryTest {
    private Factory factory;
    private Session session;
    private Transaction tx;

    @Before
    public void setUp() {
        this.factory = new ConcreteFactory();
        this.session = HibernateConfig.getSession();
    }

    @After
    public void tearDown() {
        this.session.close();
    }

    @Test
    public void testCreateConference() {
        Conference conf = this.factory.CONFERENCE("test_conf", 100);
        Long confId = conf.getId();

        tx = this.session.beginTransaction();
        Conference dbConf = (Conference) session.load(Conference.class, confId);
        tx.commit();

        assertEquals("test_conf", dbConf.getTitle());
    }

    @Test
    public void testReadUpdateConference() {
        Conference conf = this.factory.CONFERENCE("test_conf2", 100);
        Long confId = conf.getId();

        Conference dbConf = this.factory.CONFERENCE(confId);
        dbConf.setTitle("test_conf3");

        tx = this.session.beginTransaction();
        this.session.update(dbConf);
        tx.commit();

        tx = this.session.beginTransaction();
        dbConf = this.factory.CONFERENCE(confId);
        assertEquals("test_conf3", dbConf.getTitle());
        tx.commit();
    }
}
