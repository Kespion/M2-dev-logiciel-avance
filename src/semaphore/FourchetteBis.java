package semaphore;

import java.util.concurrent.Semaphore;

public class FourchetteBis extends Semaphore {

    private String nom;
    private boolean libre;

    public FourchetteBis(int permits, String nom) {
        super(permits);
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
