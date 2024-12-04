import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Piscine {

    private final Semaphore semCabine;
    private final Semaphore semPanier;

    public Piscine(int nbCabines, int nbPaniers) {
        this.semCabine = new Semaphore(nbCabines);
        this.semPanier = new Semaphore(nbPaniers);
    }

    public boolean utiliserCabineEtPanier(Client client) throws InterruptedException {
        if (!semCabine.tryAcquire(500, TimeUnit.MILLISECONDS)) {
            //System.out.println(client.getName() + " n'a pas pu obtenir de cabine");
            return false;
        }
        //System.out.println(client.getName() + " a pris une cabine");

        if (!semPanier.tryAcquire(500, TimeUnit.MILLISECONDS)) {
            //System.out.println(client.getName() + " n'a pas pu obtenir de panier, il rend sa cabine");
            semCabine.release();
            return false;
        }
        //System.out.println(client.getName() + " a pris un panier");

        System.out.println(client.getName() + " se change...");
        Thread.sleep((int) (Math.random() * 3000) + 3000);

        semCabine.release();
        //System.out.println(client.getName() + " libère la cabine");
        return true;
    }

    public boolean retournerCabineEtPanier(Client client) throws InterruptedException {
        if (!semCabine.tryAcquire(500, TimeUnit.MILLISECONDS)) {
            //System.out.println(client.getName() + " n'a pas pu obtenir de cabine pour se rechanger");
            return false;
        }
        //System.out.println(client.getName() + " a repris une cabine");

        System.out.println(client.getName() + " se rechange...");
        Thread.sleep((int) (Math.random() * 3000) + 3000);

        semCabine.release();
        //System.out.println(client.getName() + " libère la cabine");

        semPanier.release();
        //System.out.println(client.getName() + " rend le panier");
        return true;
    }

}
