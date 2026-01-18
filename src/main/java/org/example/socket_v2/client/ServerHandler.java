package org.example.socket_v2.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerHandler {
    private final Socket clientSocket;
    private final BufferedReader in;
    private final PrintWriter out;


    public ServerHandler(Socket socket) throws IOException {
        this.clientSocket = socket;
        this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //input from server
        this.out = new PrintWriter(clientSocket.getOutputStream(), true); // the output that is connected to server


    }

    public void handle() throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String option = sc.nextLine().toUpperCase();
            out.println(option);

            String message  = in.readLine();
            System.out.println(message);
            switch (option) {
                case "FUNRANGE": {
                    System.out.println("here funrange");
                    String boringString = sc.nextLine();
                    out.println(boringString);

                    String startIndices = sc.nextLine();
                    out.println(startIndices);

                    String endIndices = sc.nextLine();
                    out.println(endIndices);

//                    String line = in.readLine();
//                    System.out.println(line);

                    String run = in.readLine();
                    System.out.println(run);

                    String funnyId = in.readLine();

                    String boring = in.readLine();

                    String funnyString = in.readLine();

                    String funRange = in.readLine();

                    System.out.println(funnyId);
                    System.out.println(boring);
                    System.out.println(funnyString);
                    System.out.println(funRange);

                    String finishMessage  = in.readLine();
                    System.out.println(finishMessage);

                    System.out.println("end funrange");
                    break;
                }
                case "FUNNYSTRING": {

                    System.out.println("here funnystring");

                    String boringString = sc.nextLine();
                    out.println(boringString);

                    String startIndices = sc.nextLine();
                    out.println(startIndices);

                    String endIndices = sc.nextLine();
                    out.println(endIndices);

                    String operations = sc.nextLine();
                    out.println(operations);


//                    String line = in.readLine();
//                    System.out.println(line);

                    String run = in.readLine();
                    System.out.println(run);

                    String funnyId = in.readLine();

                    String boring = in.readLine();

                    String funnyString = in.readLine();

                    String funRange = in.readLine();

                    System.out.println(funnyId);
                    System.out.println(boring);
                    System.out.println(funnyString);
                    System.out.println(funRange);

                    String finishMessage  = in.readLine();
                    System.out.println(finishMessage);

                    System.out.println("end funnystring");
                    break;
                }
                case "GET_FUNRANGEBYID": {
                    System.out.println("get funrange by id ");

                    String id = sc.nextLine();
                    out.println(id);

                    String run = in.readLine();
                    System.out.println(run);

//                    String line = in.readLine();
//                    System.out.println(line);

                    String funnyId = in.readLine();

                    String boringString = in.readLine();

                    String funnyString = in.readLine();

                    String funRange = in.readLine();

                    System.out.println(funnyId);
                    System.out.println(boringString);
                    System.out.println(funnyString);
                    System.out.println(funRange);

                    String finishMessage  = in.readLine();
                    System.out.println(finishMessage);

                    System.out.println("end get funrange by id");

                    break;

                }
                default:
                    break;
            }
//            String finishMessage  = in.readLine();
//            System.out.println(finishMessage);

        }
    }
}
