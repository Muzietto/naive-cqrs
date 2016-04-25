package net.faustinelli.cqrs.naive.db;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;

import static net.faustinelli.cqrs.naive.db.HibernateConfig.getSession;
import static org.junit.Assert.assertEquals;

/**
 * Created by R597423 on 4/25/2016.
 */
public class H2DbTest {

    @Test
    public void firstDbTest() {
        Session session;
        Message message;
        Transaction tx;

        session = getSession();
        tx = session.beginTransaction();

        // PLAY HERE

        message = new Message("Hello World");
        session.save(message);
        tx.commit();

        session = getSession();
        tx = session.beginTransaction();
        // 1 is the generated id of the first message
        message = (Message) session.load(Message.class, new Long(1));
        message.setText("Greetings Earthling");
        assertEquals("Greetings Earthling", message.getText());
        Message nextMessage = new Message("Take me to your leader (please)");
        message.setNextMessage(nextMessage);
        tx.commit();


        session = getSession();
        tx = session.beginTransaction();
        message = (Message) session.load(Message.class, new Long(2));
        assertEquals("Take me to your leader (please)", message.getText());
        tx.commit();
    }

    @Test
    public void secondDbTest() {
        Session session;
        Message message;
        Transaction tx;

        session = getSession();
        tx = session.beginTransaction();

        // PLAY HERE

        message = new Message("Hello World");
        session.save(message);
        tx.commit();

        session = getSession();
        tx = session.beginTransaction();
        // 1 is the generated id of the first message
        message = (Message) session.load(Message.class, new Long(1));
        message.setText("Greetings Earthling");
        assertEquals("Greetings Earthling", message.getText());
        Message nextMessage = new Message("Take me to your leader (please)");
        message.setNextMessage(nextMessage);
        tx.commit();

        session = getSession();
        tx = session.beginTransaction();
        message = (Message) session.load(Message.class, new Long(2));
        assertEquals("Take me to your leader (please)", message.getText());
        tx.commit();
    }

}
