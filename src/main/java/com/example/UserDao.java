package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class UserDao {
    private Session session;

    public UserDao(Session session) {
        this.session = session;
    }

    public void createUser(User user) {
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();
    }

    public User getUser(Long id) {
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    // Méthodes update et delete

    public void updateUser(User user) {
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
        session.close();
    }

    public void deleteUser(Long id) {
        Transaction tx = session.beginTransaction();
        session.delete(getUser(id));
        tx.commit();
        session.close();
    }

}