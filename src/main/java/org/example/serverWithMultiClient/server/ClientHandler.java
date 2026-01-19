package org.example.serverWithMultiClient.server;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.sql.SQLException;

public class ClientHandler extends Thread {

    private final Socket clientSocket;

    public ClientHandler(Socket socket) throws IOException {
        this.clientSocket = socket;
    }


    @Override
    public void run() {
        try {
            while (true) {

                ClientRequest clientRequest = new ClientRequest(clientSocket);
                clientRequest.chooseClientOperation();
            }
        } catch (SQLException | IOException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            System.err.println(e);
        }

    }
}
