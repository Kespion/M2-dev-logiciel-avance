package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class UserDao {
    private Session session;

    public UserDao(Session session) {
        this.session = session;
    }

    public void createUser(User user) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    public User getUser(Long id) {
        Transaction tx = null;
        User user = null;
        try {
            tx = session.beginTransaction();
            user = (User) session.get(User.class, id);
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return user;
    }

    // Méthodes update et delete

    public void updateUser(User user) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    public void deleteUser(Long id) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

}