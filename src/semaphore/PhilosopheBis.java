package semaphore;

import java.util.concurrent.TimeUnit;

public class PhilosopheBis extends Thread {

    private String nom;
    private FourchetteBis gauche, droite;

    public PhilosopheBis(String nom, FourchetteBis gauche, FourchetteBis droite) {
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

    public FourchetteBis getGauche() {
        return gauche;
    }

    public void setGauche(FourchetteBis gauche) {
        this.gauche = gauche;
    }

    public FourchetteBis getDroite() {
        return droite;
    }

    public void setDroite(FourchetteBis droite) {
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
                if (gauche.tryAcquire(100, TimeUnit.MILLISECONDS)) {
                    //Thread.sleep((int)(Math.random() * 3000) + 3000); // Pour créer un dealock
                    try {
                        if (droite.tryAcquire(100, TimeUnit.MILLISECONDS)) {
                            //Thread.sleep((int)(Math.random() * 3000) + 3000); // Pour créer un deadlock
                            try {
                                manger();
                            } finally {
                                droite.release();
                            }
                            penser();
                        }
                    } finally {
                        gauche.release();
                    }
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
