import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final int NOMBRE_DE_PHILOSOPHES = 5;

    public static void main(String[] args) throws InterruptedException {

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

}