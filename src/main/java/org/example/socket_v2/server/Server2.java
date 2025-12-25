package org.example.socket_v2;


import org.example.factory.FactoryDependency;

import java.io.IOException;
import java.net.ServerSocket;

public class Server2 {
    private ServerSocket serverSocket;
    private ClientHandler clientHandler;

    public Server2(int port) {
        this.clientHandler = FactoryDependency.getDependency(ClientHandler.class);
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server Started");
            System.out.println("Waiting for a clients.");
            while (true) {
                System.out.println("before");
                clientHandler = new ClientHandler(serverSocket.accept());
                System.out.println("Client accepted");
                Thread thread =new Thread(clientHandler);
                thread.start();

            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }

}
