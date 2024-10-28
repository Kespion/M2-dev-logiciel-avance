package reentrantlock;

import java.util.concurrent.TimeUnit;

public class Philosophe extends Thread {

    private String nom;
    private Fourchette gauche, droite;

    public Philosophe(String nom, Fourchette gauche, Fourchette droite) {
        this.nom = nom;
        this.gauche = gauche;
        this.droite = droite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Fourchette getGauche() {
        return gauche;
    }

    public void setGauche(Fourchette gauche) {
        this.gauche = gauche;
    }

    public Fourchette getDroite() {
        return droite;
    }

    public void setDroite(Fourchette droite) {
        this.droite = droite;
    }

    private void manger() throws InterruptedException {
        System.out.println(this.nom + " mange...");
        Thread.sleep((int)(Math.random() * 5000) + 5000);
    }

    private void penser() throws InterruptedException {
        System.out.println(this.nom + " pense...");
        Thread.sleep((int)(Math.random() * 3000) + 3000);
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (gauche.tryLock(100, TimeUnit.MILLISECONDS)) {
                    //Thread.sleep((int)(Math.random() * 3000) + 3000); // Pour créer un deadlock
                    try {
                        gauche.prendre();
                        //System.out.println(nom + " a pris " + gauche.getNom());
                        if (droite.tryLock(100, TimeUnit.MILLISECONDS)) {
                            //Thread.sleep((int)(Math.random() * 3000) + 3000); // Pour créer un dealock
                            try {
                                droite.prendre();
                                //System.out.println(nom + " a pris " + droite.getNom());
                                manger();
                            } finally {
                                droite.unlock();
                                droite.relacher();
                                //System.out.println(nom + " a relâché " + droite.getNom());
                            }
                            penser();
                        }
                    } finally {
                        gauche.unlock();
                        gauche.relacher();
                        //System.out.println(nom + " a relâché " + gauche.getNom());
                    }
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
