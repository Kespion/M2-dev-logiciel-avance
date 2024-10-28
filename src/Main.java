import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final int NOMBRE_CLIENTS = 10;
    public static final int NOMBRE_CABINES = 5;
    public static final int NOMBRE_PANIERS = 8;

    public static void main(String[] args) throws InterruptedException {

        /**
         * Pour provoquer un deadlock :
         * - Mettre un nombre de paniers inférieur ou égal au nombre de cabines ET avoir un nombre de clients supérieur au nombre de cabines
         **/

        Piscine piscine = new Piscine(NOMBRE_CABINES, NOMBRE_PANIERS);

        List<Client> clients = new ArrayList<>();
        for (int i = 0; i < NOMBRE_CLIENTS; i++) {
            clients.add(new Client("Client " + i, piscine));
        }

        for (Client client : clients) {
            client.start();
        }

        for (Client client : clients) {
            client.join();
        }

    }

}