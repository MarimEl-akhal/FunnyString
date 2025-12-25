package org.example.socket_v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerHandler {

    private Socket clientSocket;


    public ServerHandler() {
    }

    public ServerHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void handle() {
        while (true) {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //input from server
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); // we ready the input reader from console
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); // the output that is connected to server


                String boringString = input.readLine();
                out.println(boringString);

                String startIndices = input.readLine();
                out.println(startIndices);

                String endIndices = input.readLine();
                out.println(endIndices);

                String operations = input.readLine();
                out.println(operations);

                //read output from server
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }


                in.close();
                input.close();
                out.close();
                clientSocket.close();

            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
