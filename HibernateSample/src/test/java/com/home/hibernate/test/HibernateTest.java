package com.home.hibernate.test;

import com.home.hibernate.entity.Person;
import com.home.hibernate.entity.Phone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HibernateTest {

    private static SessionFactory sessionFactory = null;

    @BeforeClass
    public static void setUp(){
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void savePerson(){
        Phone phone = new Phone();
        phone.setNumber("800-555-35-35");
        phone.setPrefix("8");

        Person person1 = new Person("John", "john@gmail.com", phone);
        Person person2 = new Person("Eleni", "eleni@gmail.com", phone);

        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(person1);
        session.save(person2);

        session.flush();

        session.getTransaction().commit();

        session.close();
    }

    @AfterClass
    public static void tearDown(){
        sessionFactory.close();
    }
}