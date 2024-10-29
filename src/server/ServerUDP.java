package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

public class ServerUDP {

    public static final int PORT = 12345;

    public static void main(String[] args) {
        try (DatagramSocket serverSocket = new DatagramSocket(PORT)) {
            System.out.println("Serveur en attente de connexions sur le port " + PORT + "...");

            byte[] buffer = new byte[4096];

            DatagramPacket paquet = new DatagramPacket(buffer, buffer.length);

            serverSocket.receive(paquet);

            String messageRecu = new String(paquet.getData(), 0, paquet.getLength(), StandardCharsets.UTF_8);
            System.out.println("Message reçu : " + messageRecu);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
