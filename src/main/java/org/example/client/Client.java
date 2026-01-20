package org.example.client;

import java.io.IOException;
import java.net.Socket;


public class Client {
    private Socket clientSocket;
    private ServerHandler serverHandler;


    public Client(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            System.out.println("Client connected");
            serverHandler = new ServerHandler(clientSocket);
            System.out.println("Server connected");
            serverHandler.handle();
            System.out.println("Server stopped");

        } catch (IOException e) {
            System.err.println(e);
        }

    }


}
