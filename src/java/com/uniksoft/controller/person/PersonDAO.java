package com.uniksoft.controller.person;

import com.uniksoft.model.Person;
import com.uniksoft.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PersonDAO {

    void saveOrUpdate(Person person) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Transaction t = null;
        try {
            Session s = sf.openSession();
            t = s.beginTransaction();
            s.saveOrUpdate(person);
            t.commit();
        } catch(Exception e) {
            if (t != null) t.rollback();
        }
    }

    List<Person> listUser() {
        List<Person> persons = null;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Transaction t = null;
        try {
            Session s = sf.openSession();
            t = s.beginTransaction();
            persons = s.createQuery("from Person").list();
            t.commit();
        } catch (Exception e) {
            if (t != null) t.rollback();
        }
        return persons;
    }

    Person listPersonById(int personId) {
        Person person = null;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Transaction t = null;
        try {
            Session s = sf.openSession();
            t = s.beginTransaction();
            person = (Person) s.get(Person.class, personId);
            t.commit();
        } catch (Exception e) {
            if (t != null) t.rollback();
        }
        return person;
    }

    void deletePerson(int personId) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Transaction t = null;
        try {
            Session s = sf.openSession();
            t = s.beginTransaction();
            Person person = (Person) s.get(Person.class, personId);
            s.delete(person);
            t.commit();
        } catch (Exception e) {
            if (t != null) t.rollback();
        }
    }
}
