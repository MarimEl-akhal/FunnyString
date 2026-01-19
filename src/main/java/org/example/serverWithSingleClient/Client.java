package org.example.serverWithSingleClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private Socket clientSocket;
    private BufferedReader in, input;
    private PrintWriter out;


    public Client(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            System.out.println("connected");

            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //input from server

            input = new BufferedReader(new InputStreamReader(System.in)); // we ready the input reader from console
            out = new PrintWriter(clientSocket.getOutputStream(), true); // the output that is connected to server

        } catch (IOException i) {
            System.out.println(i);
        }

        while (true) {
            try {
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


            } catch (IOException e) {
                System.out.println(e);
            }

            try {
                System.out.println("client closed connection");
                in.close();
                input.close();
                out.close();
                clientSocket.close();
            } catch (IOException i) {
                System.out.println(i);
            }

        }


    }
}


