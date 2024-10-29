package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {

    public static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Serveur en attente de connexions sur le port " + PORT + "...");

            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("Client connecté : " + clientSocket.getInetAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String message = in.readLine();
                System.out.println("Message reçu du client : " + message);

                out.println("Message bien reçu !");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}