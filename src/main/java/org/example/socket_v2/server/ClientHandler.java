package org.example.socket_v2.server;

import org.example.*;
import org.example.database.DataBaseManager;
import org.example.factory.FactoryDependency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;

public class ClientHandler extends Thread {

    private final Socket clientSocket;
    private final PrintWriter out;
    private final BufferedReader in;


    private final ClientRequest clientRequest;

    private final IParsing parsing;
    private final StringFunifier funnyString;
    private final DataBaseManager dbManager;


    public ClientHandler(Socket socket) throws IOException {
//        System.out.println("bnm,qwertyuisdfghjkxcvbn");
        this.clientSocket = socket;
        // the output that is connected to client
        this.out = new PrintWriter(clientSocket.getOutputStream(), true);
        // Takes input from the client socket
        this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        this.clientRequest = FactoryDependency.getDependency(ClientRequest.class);

        this.parsing = FactoryDependency.getDependency(Parsing.class);
        this.funnyString = FactoryDependency.getDependency(StringFunifier.class);
        this.dbManager = FactoryDependency.getDependency(DataBaseManager.class);

    }


    @Override
    public void run() {
        try {
            while (true) {
                String boringString = in.readLine();
                String startIndices = in.readLine();
                String endIndices = in.readLine();
                String operations = in.readLine();
                ClientOption option = ClientOption.valueOf(in.readLine());



//
                String stringFunny = "";
                String funRange = "";

                switch (option) {
                    case FUNRANGE:
                        funRange = funnyString.getFunRanges(boringString, parsing.parseListOfIndexToken(startIndices), parsing.parseListOfIndexToken(endIndices));
                        dbManager.insertFunnyString(boringString, funRange, null);
                        dbManager.insertOperationRange(parsing.parseListOfIndexToken(startIndices), parsing.parseListOfIndexToken(endIndices), parsing.parseListOfOperationToken(operations));
                        break;
                    case FUNNYSTRING:
                        stringFunny = funnyString.getFunnyString(boringString, parsing.parseListOfIndexToken(startIndices), parsing.parseListOfIndexToken(endIndices), parsing.parseListOfOperationToken(operations));
                        dbManager.insertFunnyString(boringString, null, stringFunny);
                        dbManager.insertOperationRange(parsing.parseListOfIndexToken(startIndices), parsing.parseListOfIndexToken(endIndices), parsing.parseListOfOperationToken(operations));
                        break;
//
//                    case GET_FUNRANGE:
//                        id = get id;
//                        createFunStringEntity
//                                dbManager.get(FunStringEntity);
//                        send to user the data;
                }
//

                out.println("boring String : " + boringString);
//                out.println("Fun Ranges: " + funRange);
//                out.println("Funny String: " + stringFunny);

            }
        } catch (IOException | SQLException e) {
            System.err.println(e);
        }

    }
}
