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
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * Created by Marco Faustinelli (Muzietto) on 4/25/2016.
 */
public class HibernateConfig implements DataAccess {
    private static HibernateConfig INSTANCE;
    private static SessionFactory THE_FACTORY = null;

    private HibernateConfig() {
        THE_FACTORY = new Configuration()
                .addAnnotatedClass(Conference.class)
                .addAnnotatedClass(SeatAvailability.class)
                .addAnnotatedClass(Message.class)
                .setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
                .setProperty("hibernate.connection.url", "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1")
                .setProperty("hibernate.current_session_context_class", "thread")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.hbm2ddl.auto", "create")
                .setProperty("javax.persistence.validation.mode", "none")
                .setProperty("log4j.logger.org.hibernate", "warn")
                .buildSessionFactory();
    }

    public static synchronized Session getSession() {
        if (THE_FACTORY == null) {
            INSTANCE = new HibernateConfig();
        }
        return THE_FACTORY.openSession();
    }

    public static synchronized SessionFactory getSessionFactory() {
        if (THE_FACTORY == null) {
            INSTANCE = new HibernateConfig();
        }
        return THE_FACTORY;
    }
}
