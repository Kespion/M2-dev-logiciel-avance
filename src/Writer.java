import java.util.List;

public class Writer extends User {

    private String message;

    public Writer(String nom, List<Fichier> fichiers, String message) {
        super(nom, fichiers);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void run() {

        while (true) {

            Fichier fichier = getRandomFichier();

            if (!fichier.isWriteLocked()) {
                try {
                    fichier.ecrire(this);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            try {
                System.out.println(getNom() + " sleep()...");
                Thread.sleep((int)(Math.random() * 2000) + 2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

}
