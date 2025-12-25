package org.example.socket_v1;

import org.example.*;
import org.example.factory.FactoryDependency;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    private IParsing parsing = FactoryDependency.getDependency(Parsing.class);
    private StringFunifier funnyString = FactoryDependency.getDependency(StringFunifier.class);


    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            clientSocket = serverSocket.accept();
            System.out.println("Client accepted");

            // Takes input from the client socket
            in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            out = new PrintWriter(clientSocket.getOutputStream(), true); // the output that is connected to client


            while (true) {

                String boringString = in.readLine();
                String startIndices = in.readLine();
                String endIndices = in.readLine();
                String operations = in.readLine();

                List<Integer> startList = parsing.parseListOfIndexToken(startIndices);
                List<Integer> endList = parsing.parseListOfIndexToken(endIndices);
                List<Operation> opsList = parsing.parseListOfOperationToken(operations);

                String funRanges = funnyString.getFunRanges(boringString, startList, endList);
                String stringFunny = funnyString.getFunnyString(boringString, startList, endList, opsList);

                out.println("boring String : " + boringString);
                out.println("Fun Ranges: " + funRanges);
                out.println("Funny String: " + stringFunny);

            }


        } catch (IOException i) {
            System.err.println(i);
        }

        try {
            System.out.println("closed connection");
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.err.println(e);
        }


    }
}
