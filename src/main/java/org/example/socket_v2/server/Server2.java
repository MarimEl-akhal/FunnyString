package org.example.socket_v2.server;


import org.example.factory.FactoryDependency;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    private ServerSocket serverSocket;
    private ClientHandler clientHandler;

    public Server2(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server Started");
            System.out.println("Waiting for a client.");
            while (true) {
//                System.out.println("before");
                Socket clientSocket = serverSocket.accept();
                clientHandler = new ClientHandler(clientSocket);
                System.out.println("Client accepted");
                Thread thread =new Thread(clientHandler);
                thread.start();

            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }

}
