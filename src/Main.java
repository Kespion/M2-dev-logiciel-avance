import reentrantlock.Fourchette;
import reentrantlock.Philosophe;
import semaphore.FourchetteBis;
import semaphore.PhilosopheBis;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final int NOMBRE_DE_PHILOSOPHES = 5;

    public static void main(String[] args) throws InterruptedException {

        //ScenarioReentrantLock();

        ScenarioSemaphore();

    }

    public static void ScenarioReentrantLock() throws InterruptedException {
        List<Fourchette> fourchettes = new ArrayList<>();
        for (int i = 0; i < NOMBRE_DE_PHILOSOPHES; i++) {
            fourchettes.add(new Fourchette("Fourchette " + i));
        }

        List<Philosophe> philosophes = new ArrayList<>();
        for (int i = 0; i < NOMBRE_DE_PHILOSOPHES; i++) {
            philosophes.add(new Philosophe("Philosophe " + i, fourchettes.get(i), fourchettes.get((i + 1) % NOMBRE_DE_PHILOSOPHES)));
        }

        for (Philosophe philosophe : philosophes) {
            philosophe.start();
        }

        for (Philosophe philosophe : philosophes) {
            philosophe.join();
        }
    }

    public static void ScenarioSemaphore() throws InterruptedException {
        List<FourchetteBis> fourchettes = new ArrayList<>();
        for (int i = 0; i < NOMBRE_DE_PHILOSOPHES; i++) {
            fourchettes.add(new FourchetteBis(1, "Fourchette " + i));
        }

        List<PhilosopheBis> philosophes = new ArrayList<>();
        for (int i = 0; i < NOMBRE_DE_PHILOSOPHES; i++) {
            philosophes.add(new PhilosopheBis("Philosophe " + i, fourchettes.get(i), fourchettes.get((i + 1) % NOMBRE_DE_PHILOSOPHES)));
        }

        for (PhilosopheBis philosophe : philosophes) {
            philosophe.start();
        }

        for (PhilosopheBis philosophe : philosophes) {
            philosophe.join();
        }
    }

}