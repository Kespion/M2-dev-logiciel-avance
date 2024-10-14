package reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class Fourchette extends ReentrantLock {

    private String nom;
    private boolean libre;

    public Fourchette(String nom) {
        this.nom = nom;
        this.libre = true;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public synchronized boolean prendre() throws InterruptedException {
        while (!this.libre) {
            wait();
        }
        setLibre(false);
        return true;
    }

    public synchronized boolean relacher() {
        setLibre(true);
        notifyAll();
        return true;
    }

}
