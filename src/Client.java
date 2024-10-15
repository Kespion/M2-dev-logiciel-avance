import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Client extends Thread {

    private String nom;
    private Semaphore cabines, paniers;

    public Client(String nom, Semaphore cabines, Semaphore paniers) {
        this.nom = nom;
        this.cabines = cabines;
        this.paniers = paniers;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Semaphore getCabines() {
        return cabines;
    }

    public void setCabines(Semaphore cabines) {
        this.cabines = cabines;
    }

    public Semaphore getPaniers() {
        return paniers;
    }

    public void setPaniers(Semaphore paniers) {
        this.paniers = paniers;
    }

    private void seChanger() throws InterruptedException {
        System.out.println(nom + " se change...");
        Thread.sleep((int) (Math.random() * 3000) + 3000);
    }

    private void nager() throws InterruptedException {
        System.out.println(nom + " nage...");
        Thread.sleep((int) (Math.random() * 5000) + 5000);
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (cabines.tryAcquire(100, TimeUnit.MILLISECONDS)) {
                    try {
                        if (paniers.tryAcquire(100, TimeUnit.MILLISECONDS)) {
                            try {
                                seChanger();
                            } finally {
                                cabines.release();
                                //System.out.println(nom + " libere cabine");
                            }
                            nager();
                        }
                        if (cabines.tryAcquire(100, TimeUnit.MILLISECONDS)) {
                            try {
                                seChanger();
                            } finally {
                                cabines.release();
                                //System.out.println(nom + " libere cabine");
                                paniers.release();
                                //System.out.println(nom + " libere panier");
                            }
                        }
                    } finally {
                        cabines.release();
                        //System.out.println(nom + " libere cabine");
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
