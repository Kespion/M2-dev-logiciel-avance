package client;

import objects.Personne;

import java.io.*;
import java.net.Socket;

public class ClientTCP {

    public static final String HOST = "localhost";
    public static final int PORT = 12345;

    public static void main(String[] args) {

        Personne personne = new Personne("Anthony", 22);

        try (Socket socket = new Socket(HOST, PORT)) {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            oos.writeObject(personne);
            System.out.println("Message envoyé au serveur : " + personne);

            String response = in.readLine();
            System.out.println("Réponse du serveur : " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}