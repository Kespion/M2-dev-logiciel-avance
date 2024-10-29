package client;

import java.io.*;
import java.net.Socket;

public class ClientTCP {

    public static final String HOST = "localhost";
    public static final int PORT = 12345;

    public static void main(String[] args) {

        try (Socket socket = new Socket(HOST, PORT)) {
            File file = new File("resources/kermit_dead.jpg");
            FileInputStream fis = new FileInputStream(file);
            OutputStream out = socket.getOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            out.flush();
            fis.close();

            System.out.println("Le fichier " + file.getName() + " a été envoyé");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}