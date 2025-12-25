package org.example.socket_v2;

import org.example.factory.FactoryDependency;

import java.io.IOException;
import java.net.Socket;


public class Client2 {
    private Socket clientSocket;
    private ServerHandler serverHandler;


    public Client2(String ip, int port) {
        this.serverHandler = FactoryDependency.getDependency(ServerHandler.class);
        try {
            clientSocket = new Socket(ip, port);
            System.out.println("connected");
            serverHandler = new ServerHandler(clientSocket);
            serverHandler.handle();

        } catch (IOException e) {
            System.err.println(e);
        }

    }

}
