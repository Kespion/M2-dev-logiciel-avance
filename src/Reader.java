import java.util.List;

public class Reader extends User {

    public Reader(String nom, List<Fichier> fichiers) {
        super(nom, fichiers);
    }

    @Override
    public void run() {

        while (true) {

            Fichier fichier = getRandomFichier();

            try {
                fichier.lire(this);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

}
