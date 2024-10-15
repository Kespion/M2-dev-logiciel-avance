import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {

    public static final int NOMBRE_CLIENTS = 10;
    public static final int NOMBRE_CABINES = 5;
    public static final int NOMBRE_PANIERS = 5;

    public static void main(String[] args) throws InterruptedException {

        Semaphore cabines = new Semaphore(NOMBRE_CABINES);
        Semaphore paniers = new Semaphore(NOMBRE_PANIERS);

        List<Client> clients = new ArrayList<>();
        for (int i = 0; i < NOMBRE_CLIENTS; i++) {
            clients.add(new Client("Client " + i, cabines, paniers));
        }

        for (Client client : clients) {
            client.start();
        }

        for (Client client : clients) {
            client.join();
        }

    }

}