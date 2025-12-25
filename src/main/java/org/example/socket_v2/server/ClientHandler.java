package org.example.socket_v2;

import org.example.*;
import org.example.factory.FactoryDependency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ClientHandler extends Thread {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;


    private IParsing parsing;
    private StringFunifier funnyString;

    public ClientHandler() {
    }

    public ClientHandler(Socket socket) {
        System.out.println("bnm,qwertyuisdfghjkxcvbn");
        this.clientSocket = socket;
        this.parsing = FactoryDependency.getDependency(Parsing.class);
        this.funnyString = FactoryDependency.getDependency(StringFunifier.class);
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Takes input from the client socket
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // the output that is connected to client
                out = new PrintWriter(clientSocket.getOutputStream(), true);

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

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    out.println(inputLine);
                }


                System.out.println("Closing Connection");
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
