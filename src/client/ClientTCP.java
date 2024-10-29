package client;

import java.io.*;
import java.net.Socket;

public class ClientTCP {

    public static final String HOST = "localhost";
    public static final int PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PORT)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String message = "Bonjour serveur !";
            out.println(message);
            System.out.println("Message envoyé au serveur : " + message);

            String response = in.readLine();
            System.out.println("Réponse du serveur : " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
