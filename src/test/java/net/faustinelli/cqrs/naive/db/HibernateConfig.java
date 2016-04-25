/*
 * Project: naive-cqrs
 * Author: Marco Faustinelli - Muzietto (contacts@faustinelli.net)
 * Web: http://faustinelli.wordpress.com/, http://www.github.com/muzietto, http://faustinelli.net/
 * Version: 1.0
 * The GPL 3.0 License - Copyright (c) 2015-2016 - The naive-cqrs Project
 */

package net.faustinelli.cqrs.naive.db;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Entity;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * Created by Marco Faustinelli (Muzietto) on 4/25/2016.
 */
public class HibernateConfig {

    public static void main(String[] args) throws Exception {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Entity.class)
                .addAnnotatedClass(Message.class)
                .setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
                .setProperty("hibernate.connection.url", "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1")
                .setProperty("hibernate.current_session_context_class", "thread")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.hbm2ddl.auto", "create")
                .setProperty("log4j.logger.org.hibernate", "warn")
                .buildSessionFactory();

        Session session;
        Message message;
        Transaction tx;

        session = sessionFactory.getCurrentSession();
        tx = session.beginTransaction();

        // PLAY HERE

        message = new Message("Hello World");
        session.save(message);
        tx.commit();

        session = sessionFactory.getCurrentSession();
        tx = session.beginTransaction();
        // 1 is the generated id of the first message
        message = (Message) session.load(Message.class, new Long(1));
        System.out.println("---------------> " + message.getText() + " <------------------------");
        message.setText("Greetings Earthling");
        Message nextMessage = new Message("Take me to your leader (please)");
        message.setNextMessage(nextMessage);
        tx.commit();


//        session.close();


    }
}
