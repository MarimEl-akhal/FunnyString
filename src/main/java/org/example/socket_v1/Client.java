package org.example.socket_v1;

import java.io.*;
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

        } catch (UnknownHostException u) {
            System.out.println(u);
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

//    public void startConnection(String ip, int port) throws IOException {
//        clientSocket = new Socket(ip, port);
//        out = new PrintWriter(clientSocket.getOutputStream(), true);
//        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//    }
//
//    public void sendInputsFromUser() throws IOException {
//        Scanner userInput = new Scanner(clientSocket.);
//
//        while (true) {
//            String boringString = userInput.nextLine();
//            out.println(boringString);
//
//            String startIndices = userInput.nextLine();
//            out.println(startIndices);
//
//            String endIndices = userInput.nextLine();
//            out.println(endIndices);
//
//            String operations = userInput.nextLine();
//            out.println(operations);
//
//            String line;
//            while ((line = in.readLine()) != null) {
//                System.out.println(line);
//            }
//
//        }
//
//
//    }
//    public void stopConnection() throws IOException {
//        in.close();
//        out.close();
//        clientSocket.close();
//    }
}


