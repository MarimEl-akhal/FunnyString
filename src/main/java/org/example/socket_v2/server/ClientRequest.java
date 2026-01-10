package org.example.socket_v2.server;


import org.example.StringFunifier;
import org.example.database.DataBaseManager;
import org.example.entity.FunnyStringEntity;
import org.example.entity.OperationRangeEntity;
import org.example.factory.FactoryDependency;
import org.example.operator.Operation;
import org.example.parsingg.IParsing;
import org.example.parsingg.Parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;

public class ClientRequest {

    private final PrintWriter out;
    private final BufferedReader in;


    private final IParsing parsing;
    private final StringFunifier funnyString;
    private final DataBaseManager dbManager;


    public ClientRequest(Socket socket) throws IOException {


        // the output that is connected to client
        this.out = new PrintWriter(socket.getOutputStream(), true);
        // Takes input from the client socket
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        this.parsing = FactoryDependency.getDependency(Parsing.class);
        this.funnyString = FactoryDependency.getDependency(StringFunifier.class);
        this.dbManager = FactoryDependency.getDependency(DataBaseManager.class);
    }


    public void chooseClientOperation() throws SQLException, IOException, InvocationTargetException, InstantiationException, IllegalAccessException {

//service.execut();
        ClientOption option = ClientOption.valueOf(in.readLine().toUpperCase());

        FunnyStringEntity funnyStringEntity ;
        OperationRangeEntity operationRangeEntity;
//        FunnyStringEntityResponse funnyStringEntityResponse = new FunnyStringEntityResponse();
//        FunnyStringEntityMapper funnyStringEntityMapper = new FunnyStringEntityMapper();

        // this  to edit because option null no read  client option
        switch (option) {
            case FUNRANGE: {
                String boring = in.readLine();
                String start = in.readLine();
                String end = in.readLine();

                List<Integer> startList = parsing.parseListOfIndexToken(start);
                List<Integer> endList = parsing.parseListOfIndexToken(end);
                String funRange = funnyString.getFunRanges(boring, startList, endList);

                funnyStringEntity = new FunnyStringEntity();
                funnyStringEntity.setBoringString(boring);
                funnyStringEntity.setFunRange(funRange);

                dbManager.insert(funnyStringEntity);
                long funny_Id = dbManager.getFunnyId();

                operationRangeEntity = new OperationRangeEntity();

                for (int i = 0; i < startList.size(); i++) {
                    operationRangeEntity.setStartIndex(startList.get(i));
                    operationRangeEntity.setEndIndex(endList.get(i));
                }
                operationRangeEntity.setFunnyStringId(funny_Id);
                dbManager.insert(operationRangeEntity);


                out.println("FUNNY_STRING_ID : "+ funny_Id);
                System.out.println(funnyStringEntity.getId());

                out.println("Boring_string : " + funnyStringEntity.getBoringString());
                System.out.println(funnyStringEntity.getBoringString());

                out.println("Fun_Range : " + funnyStringEntity.getFunRange());
                System.out.println(funnyStringEntity.getFunRange());

                out.println("Funny_string : " + funnyStringEntity.getFunnyString());
                System.out.println(funnyStringEntity.getFunnyString());


                break;
            }

            case FUNNYSTRING: {
                String boringString = in.readLine();
                String start = in.readLine();
                String end = in.readLine();
                String operation = in.readLine();

                List<Integer> startList = parsing.parseListOfIndexToken(start);
                List<Integer> endList = parsing.parseListOfIndexToken(end);
                List<Operation> opsList = parsing.parseListOfOperationToken(operation);

                String stringFunny = funnyString.getFunnyString(boringString, startList, endList, opsList);

                funnyStringEntity = new FunnyStringEntity();

                funnyStringEntity.setBoringString(boringString);
                funnyStringEntity.setFunnyString(stringFunny);

                dbManager.insert(funnyStringEntity);
                long funny_id = dbManager.getFunnyId();

                operationRangeEntity = new OperationRangeEntity();
                for (int i = 0; i < startList.size(); i++) {
                    operationRangeEntity.setStartIndex(startList.get(i));
                    operationRangeEntity.setEndIndex(endList.get(i));
                    operationRangeEntity.setOperation(opsList.get(i).name());
                }
                operationRangeEntity.setFunnyStringId(funny_id);
                dbManager.insert(operationRangeEntity);

                out.println("FUNNY_STRING_ID : "+ funny_id);
                System.out.println(funnyStringEntity.getId());

                out.println("Boring_string : " + funnyStringEntity.getBoringString());
                System.out.println(funnyStringEntity.getBoringString());

                out.println("Fun_Range : " + funnyStringEntity.getFunRange());
                System.out.println(funnyStringEntity.getFunRange());

                out.println("Funny_string : " + funnyStringEntity.getFunnyString());
                System.out.println(funnyStringEntity.getFunnyString());


                break;
            }

            case GET_FUNRANGEBYID: {
                long id = Long.parseLong(in.readLine().trim());

                funnyStringEntity = (FunnyStringEntity) dbManager.getById(id, FunnyStringEntity.class);
                if (funnyStringEntity == null) {
                    out.println("No data found for ID " + id);
                    return;
                }

                out.println("FUNNY_STRING_ID : "+ id);
                System.out.println(funnyStringEntity.getId());

                out.println("Boring_string : " + funnyStringEntity.getBoringString());
                System.out.println(funnyStringEntity.getBoringString());

                out.println("Fun_Range : " + funnyStringEntity.getFunRange());
                System.out.println(funnyStringEntity.getFunRange());

                out.println("Funny_string : " + funnyStringEntity.getFunnyString());
                System.out.println(funnyStringEntity.getFunnyString());

                break;
            }
            default:
                System.out.println("No data found for ID ");
                break;


        }
        System.out.println("------------------------------------------");



    }
}

