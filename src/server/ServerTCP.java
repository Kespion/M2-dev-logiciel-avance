package server;

import objects.Personne;

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

                ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                Personne p = (Personne) ois.readObject();
                System.out.println("Message reçu du client : " + p);

                out.println("Perosnne " + p + " bien reçue !");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}