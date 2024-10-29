package server;

import javax.swing.filechooser.FileSystemView;
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

                String home = System.getProperty("user.home");
                FileOutputStream fos = getFileOutputStream(home, clientSocket);
                fos.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static FileOutputStream getFileOutputStream(String home, Socket clientSocket) throws IOException {
        File downloadsFolder = new File(home, "Downloads");

        File outputFile = new File(downloadsFolder.getAbsolutePath() + "/recu_kermit_dead.jpg");
        FileOutputStream fos = new FileOutputStream(outputFile);
        InputStream in = clientSocket.getInputStream();

        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }
        fos.flush();
        return fos;
    }

}