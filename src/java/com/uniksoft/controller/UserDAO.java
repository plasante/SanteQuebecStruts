package com.uniksoft.controller;

import com.uniksoft.model.User;
import com.uniksoft.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserDAO {

    public String addUser(User user) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Transaction t = null;
        try {
            Session s = sf.openSession();
            t = s.beginTransaction();
            s.persist(user);
            t.commit();
            return "success";
        } catch(Exception e) {
            if (e.getMessage().indexOf("could not insert") >= 0) {
                return "duplicated";
            } else {
                return "error";
            }
        }
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Transaction t = null;
        try {
            Session s = sf.openSession();
            t = s.beginTransaction();
            users = s.createQuery("from User").list();
            t.commit();
        } catch(Exception e) {
            if( t != null ) t.rollback();
        }
        return users;
    }

    public User getUser(int id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Transaction t = null;
        User user = null;
        try {
            Session s = sf.openSession();
            t = s.beginTransaction();
            Query query = s.createQuery("from User u where u.id = :id");
            query.setInteger("id", id);
            user = (User) query.uniqueResult();
            t.commit();
        } catch (Exception e) {
            if ( t != null ) t.rollback();
        }
        return user;
    }

    public void updateUser(User user) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Transaction t = null;
        try {
            Session s = sf.openSession();
            t = s.beginTransaction();
            s.saveOrUpdate(user);
            t.commit();
        } catch(Exception e) {
            if ( t != null ) t.rollback();
        }
    }
}
