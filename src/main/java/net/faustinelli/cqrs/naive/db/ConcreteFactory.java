/*
 * Project: naive-cqrs
 * Author: Marco Faustinelli - Muzietto (contacts@faustinelli.net)
 * Web: http://faustinelli.wordpress.com/, http://www.github.com/muzietto, http://faustinelli.net/
 * Version: 1.0
 * The GPL 3.0 License - Copyright (c) 2015-2016 - The naive-cqrs Project
 */

package net.faustinelli.cqrs.naive.db;

import net.faustinelli.cqrs.naive.model.Factory;
import org.hibernate.Hibernate;
import org.hibernate.classic.Session;
import org.hibernate.proxy.HibernateProxy;

/**
 * Created by Marco Faustinelli (Muzietto) on 27/04/2016.
 */
public class ConcreteFactory extends Factory {
    @Override
    protected Session getSession() {
        return HibernateConfig.getSessionFactory().openSession();
    }

    /**
     * http://stackoverflow.com/questions/2216547/converting-hibernate-proxy-to-real-object
     */
    protected <T> T initializeAndUnproxy(T entity) {
        if (entity == null) {
            throw new
                    NullPointerException("Entity passed for initialization is null");
        }

        Hibernate.initialize(entity);
        if (entity instanceof HibernateProxy) {
            entity = (T) ((HibernateProxy) entity).getHibernateLazyInitializer()
                    .getImplementation();
        }
        return entity;
    }
}
