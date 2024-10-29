package client;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;

public class ClientUDP {

    public static final String HOST = "localhost";
    public static final int PORT = 12345;

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {

            String message = "Hello from ClientUDP";

            byte[] buffer = message.getBytes();

            DatagramPacket paquet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(HOST), PORT);

            socket.send(paquet);

            System.out.println("Message envoyé au serveur : " + message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}