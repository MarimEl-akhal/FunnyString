package org.example.socket_v2.server;

import org.example.factory.FactoryDependency;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.sql.SQLException;

public class ClientHandler extends Thread {

    private final Socket clientSocket;
//    private final PrintWriter out;
//    private final BufferedReader in;


//    private final ClientRequest clientRequest;

//    private final IParsing parsing;
//    private final StringFunifier funnyString;
//    private final DataBaseManager dbManager;


    public ClientHandler(Socket socket) throws IOException {
//        System.out.println("bnm,qwertyuisdfghjkxcvbn");
        this.clientSocket = socket;
//        // the output that is connected to client
//        this.out = new PrintWriter(clientSocket.getOutputStream(), true);
//        // Takes input from the client socket
//        this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//
//        this.clientRequest = FactoryDependency.getDependency(ClientRequest.class);

//        this.parsing = FactoryDependency.getDependency(Parsing.class);
//        this.funnyString = FactoryDependency.getDependency(StringFunifier.class);
//        this.dbManager = FactoryDependency.getDependency(DataBaseManager.class);

    }


    @Override
    public void run() {
        try {
            while (true) {


                ClientRequest clientRequest = new ClientRequest(clientSocket);
                clientRequest.chooseClientOperation();


//
//                String stringFunny = "";
//                String funRange = "";
//
//                switch (option) {
//                    case FUNRANGE:
//                    { String boringString = in.readLine();
//                        String startIndices = in.readLine();
//                        String endIndices = in.readLine();
//                        funRange = funnyString.getFunRanges(boringString, parsing.parseListOfIndexToken(startIndices), parsing.parseListOfIndexToken(endIndices));
//                        dbManager.insert(new FunnyStringEntity());
//                        dbManager.insert(new OperationRangeEntity());
//                    }
//                        break;
//                    case FUNNYSTRING:
//                    {String boringString = in.readLine();
//                        String startIndices = in.readLine();
//                        String endIndices = in.readLine();
//                        String operations = in.readLine();
//                        stringFunny = funnyString.getFunnyString(boringString, parsing.parseListOfIndexToken(startIndices), parsing.parseListOfIndexToken(endIndices), parsing.parseListOfOperationToken(operations));
//                        dbManager.insertFunnyString(boringString, null, stringFunny);
//                        dbManager.insertOperationRange(parsing.parseListOfIndexToken(startIndices), parsing.parseListOfIndexToken(endIndices), parsing.parseListOfOperationToken(operations));}
//                        break;
////
////                    case GET_FUNRANGE:
////                        id = get id;
////                        createFunStringEntity
////                                dbManager.get(FunStringEntity);
////                        send to user the data;
//                }
////
//
//                out.println("boring String : " + boringString);
////                out.println("Fun Ranges: " + funRange);
////                out.println("Funny String: " + stringFunny);

            }
        } catch (SQLException | IOException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            System.err.println(e);
        }

    }
}
