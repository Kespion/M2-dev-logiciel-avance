package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        // Configuration Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(User.class);

        // Création de la SessionFactory
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            // Ouverture d'une session
            try (Session session = sessionFactory.openSession()) {
                // Démarrage d'une transaction
                Transaction transaction = session.beginTransaction();

                // Création d'un utilisateur
                User user = new User();
                user.setUsername("john_doe2");
                user.setPassword("secure_password2");

                // Sauvegarde de l'utilisateur dans la base
                session.save(user);

                // Validation de la transaction
                transaction.commit();

                // Récupération de l'utilisateur
                User retrievedUser = session.get(User.class, user.getId());
                System.out.println("Utilisateur récupéré : " + retrievedUser.getUsername());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
