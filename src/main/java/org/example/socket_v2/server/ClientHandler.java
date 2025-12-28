package org.example.socket_v2.server;

import org.example.*;
import org.example.factory.FactoryDependency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ClientHandler extends Thread {

    private final Socket clientSocket;
    private final PrintWriter out;
    private final BufferedReader in;


    private final IParsing parsing;
    private final StringFunifier funnyString;


    public ClientHandler(Socket socket) throws IOException {
//        System.out.println("bnm,qwertyuisdfghjkxcvbn");
        this.clientSocket = socket;
        // the output that is connected to client
        this.out = new PrintWriter(clientSocket.getOutputStream(), true);
        // Takes input from the client socket
        this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        this.parsing = FactoryDependency.getDependency(Parsing.class);
        this.funnyString = FactoryDependency.getDependency(StringFunifier.class);
    }


    @Override
    public void run() {
        try {
            while (true) {
                String boringString = in.readLine();
                String startIndices = in.readLine();
                String endIndices = in.readLine();
                String operations = in.readLine();

                System.out.println(boringString);
                System.out.println(startIndices);
                System.out.println(endIndices);
                System.out.println(operations);


                List<Integer> startList = parsing.parseListOfIndexToken(startIndices);
                List<Integer> endList = parsing.parseListOfIndexToken(endIndices);
                List<Operation> opsList = parsing.parseListOfOperationToken(operations);

                String funRanges = funnyString.getFunRanges(boringString, startList, endList);
                String stringFunny = funnyString.getFunnyString(boringString, startList, endList, opsList);


                System.out.println("boring String : " + boringString);
                System.out.println("Fun Ranges: " + funRanges);
                System.out.println("Funny String: " + stringFunny);

                out.println("boring String : " + boringString);
                out.println("Fun Ranges: " + funRanges);
                out.println("Funny String: " + stringFunny);

                System.out.println("here here here");
//                String line = in.readLine();
//                while ((line) != null) {
//                    out.println(line);
//                }

//                System.out.println("Closing Connection");
//                in.close();
//                out.close();
//                clientSocket.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}
