package org.example.socket_v2.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerHandler {
    private final Socket clientSocket;
    private final BufferedReader in, input;
    private final PrintWriter out;


    public ServerHandler(Socket socket) throws IOException {
        this.clientSocket = socket;
        this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //input from server
        this.input = new BufferedReader(new InputStreamReader(System.in)); // we ready the input reader from console
        this.out = new PrintWriter(clientSocket.getOutputStream(), true); // the output that is connected to server

    }

    public void handle() throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String boringString = sc.nextLine();
            out.println(boringString);

            String startIndices = sc.nextLine();
            out.println(startIndices);

            String endIndices = sc.nextLine();
            out.println(endIndices);

            String operations = sc.nextLine();
            out.println(operations);

            String option = sc.nextLine().toUpperCase();
            out.println(option.toUpperCase());

            String res1 = in.readLine();

            String res2 = in.readLine();

            String res3 = in.readLine();

            System.out.println(res1);
            System.out.println(res2);
            System.out.println(res3);


        }
    }
}
