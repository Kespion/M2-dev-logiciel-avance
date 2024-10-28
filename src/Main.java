import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final int NOMBRE_FICHIERS = 5;
    public static final int NOMBRE_WRITERS = 3;
    public static final int NOMBRE_READERS = 9;

    public static void main(String[] args) throws InterruptedException {

        List<Fichier> fichiers = new ArrayList<>();
        for (int i = 0; i < NOMBRE_FICHIERS; i++) {
            fichiers.add(new Fichier("Fichier N°" + i, ""));
        }

        List<User> users = new ArrayList<>();
        for (int i = 0; i < NOMBRE_READERS; i++) {
            users.add(new Reader("Reader N°" + i, fichiers));
        }
        for (int i = 0; i < NOMBRE_WRITERS; i++) {
            users.add(new Writer("Writer N°" + i, fichiers, "Hello from Writer N°" + i));
        }

        for (User user : users) {
            user.start();
        }

        for (User user : users) {
            user.join();
        }

    }

}