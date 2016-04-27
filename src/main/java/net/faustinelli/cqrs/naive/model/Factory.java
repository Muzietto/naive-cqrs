/*
 * Project: naive-cqrs
 * Author: Marco Faustinelli - Muzietto (contacts@faustinelli.net)
 * Web: http://faustinelli.wordpress.com/, https://www.github.com/muzietto, http://faustinelli.net/
 * Version: 1.0
 * The GPL 3.0 License - Copyright (c) 2015-2016 - The naive-cqrs Project
 */

package net.faustinelli.cqrs.naive.model;

import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.proxy.HibernateProxy;

/**
 * Created by Marco Faustinelli (Muzietto) on 4/26/2016.
 */
public abstract class Factory {

    public Order ORDER(Conference conf, Integer seatsToBook) {
        final Order order = new Order(conf, seatsToBook);
        save(order);
        return order;
    }

    protected abstract Session getSession();
    protected abstract <T> T initializeAndUnproxy(T entity);

    public Conference CONFERENCE(String title, Integer numSeats) {
        final Conference conf = new Conference(title, numSeats);
        save(conf);
        save(new SeatAvailability(conf));
        return conf;
    }

    private void save(Object obj) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.save(obj);
        tx.commit();
        session.close();
    }

    public SeatAvailability SEAT_AVAILABILITY(Conference conf) {
        return (SeatAvailability) queryById(SeatAvailability.class, "from SeatAvailability where CONFERENCE_ID = :id ", conf.getId());
    }

    private Object queryById(Class clazz, String statement, Long id) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        return session
                .createQuery(statement)
                .setParameter("id", id)
                .list().get(0);
    }

    public Conference CONFERENCE(Long confId) {
        Conference entity = (Conference) load(Conference.class, confId);
        return entity;
    }

    private Object load(Class clazz, Long id) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        Object result = session.load(clazz, id);
        initializeAndUnproxy(result);
        tx.commit();
        session.close();
        return result;
    }
}
