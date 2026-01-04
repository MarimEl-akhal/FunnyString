package org.example.socket_v2.server;

import org.example.entity.FunnyStringEntityRequest;
import org.example.entity.OperationRangeEntityRequest;
import org.example.mapper.FunnyStringEntityMapper;
import org.example.mapper.OperationRangeEntityMapper;
import org.example.parsingg.IParsing;
import org.example.parsingg.Parsing;
import org.example.StringFunifier;
import org.example.database.DataBaseManager;
import org.example.entity.FunnyStringEntity;
import org.example.entity.OperationRangeEntity;
import org.example.factory.FactoryDependency;

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

        System.out.println("here here :( :(  :(");
        ClientOption option = ClientOption.valueOf(in.readLine().toUpperCase());

        FunnyStringEntity funnyStringEntity = new FunnyStringEntity();
        FunnyStringEntityRequest funnyStringEntityRequest = new FunnyStringEntityRequest();

        OperationRangeEntityRequest operationRangeEntityRequest = new OperationRangeEntityRequest();

        FunnyStringEntityMapper funnyStringEntityMapper = new FunnyStringEntityMapper();

//
//
//
//        if(option.equals(ClientOption.FUNNYSTRING)){
//
//            String boringString = in.readLine();
//            String startIndices = in.readLine();
//            String endIndices = in.readLine();
//            String operations = in.readLine();
//
//            String stringFunny = funnyString.getFunnyString(boringString, parsing.parseListOfIndexToken(startIndices), parsing.parseListOfIndexToken(endIndices), parsing.parseListOfOperationToken(operations));
//
//
//            funnyStringEntityRequest.setBoringString(boringString);
//            funnyStringEntityRequest.setFunnyString(stringFunny);
//
//            funnyStringEntity = funnyStringEntityMapper.toEntity(funnyStringEntityRequest);
//            dbManager.insert(funnyStringEntity);
//            long funny_id = dbManager.getFunnyId();
//
//            operationRangeEntityRequest.setStartIndex(parsing.parseListOfIndexToken(startIndices));
//            operationRangeEntityRequest.setEndIndex(parsing.parseListOfIndexToken(endIndices));
//            operationRangeEntityRequest.setOperation(parsing.parseListOfOperationToken(operations));
//
//            List<OperationRangeEntity> ranges = new OperationRangeEntityMapper().toEntity(operationRangeEntityRequest, funny_id);
//            for (OperationRangeEntity operationRange : ranges) {
//                dbManager.insert(operationRange);
//            }
//
//
//        }
//        else if(option.equals("FUNRANGE")){
//            System.out.println(">>>>>>>>>>>>>>>>start");
//
//            String boring = in.readLine();
//            String start = in.readLine();
//            String end = in.readLine();
//
//            String funRange = funnyString.getFunRanges(boring, parsing.parseListOfIndexToken(start), parsing.parseListOfIndexToken(end));
//
//            funnyStringEntityRequest.setBoringString(boring);
//            funnyStringEntityRequest.setFunRange(funRange);
//
//
//            funnyStringEntity = funnyStringEntityMapper.toEntity(funnyStringEntityRequest);
//            dbManager.insert(funnyStringEntity);
//            long funny_Id = dbManager.getFunnyId();
//
//            operationRangeEntityRequest.setStartIndex(parsing.parseListOfIndexToken(start));
//            operationRangeEntityRequest.setEndIndex(parsing.parseListOfIndexToken(end));
//            operationRangeEntityRequest.setOperation(null);
//
//
//            List<OperationRangeEntity> ranges = new OperationRangeEntityMapper().toEntity(operationRangeEntityRequest, funny_Id);
//            for (OperationRangeEntity operationRange : ranges) {
//                dbManager.insert(operationRange);
//            }
//
//            System.out.println(">>>>>>>>>>>>>>>>end");
//
//        }else if (option.equals("GET_FUNRANGEBYID")){
//
//            long id = Long.parseLong(in.readLine().trim());
//
//            funnyStringEntity = (FunnyStringEntity) dbManager.getById(id, FunnyStringEntity.class);
//            if (funnyStringEntity == null) {
//                out.println("No data found for ID " + id);
//                return;
//            }
//        }
        // this  to edit because option null no read  client option
        switch (option) {
            case FUNRANGE: {
                String boring = in.readLine();
                String start = in.readLine();
                String end = in.readLine();

                String funRange = funnyString.getFunRanges(boring, parsing.parseListOfIndexToken(start), parsing.parseListOfIndexToken(end));

                funnyStringEntityRequest.setBoringString(boring);
                funnyStringEntityRequest.setFunRange(funRange);


               funnyStringEntity = funnyStringEntityMapper.toEntity(funnyStringEntityRequest);
                dbManager.insert(funnyStringEntity);
                long funny_Id = dbManager.getFunnyId();

                operationRangeEntityRequest.setStartIndex(parsing.parseListOfIndexToken(start));
                operationRangeEntityRequest.setEndIndex(parsing.parseListOfIndexToken(end));
                operationRangeEntityRequest.setOperation(null);


                List<OperationRangeEntity> ranges = new OperationRangeEntityMapper().toEntity(operationRangeEntityRequest, funny_Id);
                for (OperationRangeEntity operationRange : ranges) {
                    dbManager.insert(operationRange);
                }
                funnyStringEntityRequest = funnyStringEntityMapper.toRequest(funnyStringEntity);

                out.println("Boring_string : " + funnyStringEntityRequest.getBoringString());
                System.out.println(funnyStringEntityRequest.getBoringString());

                out.println("Fun_Range : " + funnyStringEntityRequest.getFunRange());
                System.out.println(funnyStringEntityRequest.getFunRange());

                out.println("Funny_string : " + funnyStringEntityRequest.getFunnyString());
                System.out.println(funnyStringEntityRequest.getFunnyString());


                break;
            }

            case FUNNYSTRING: {
                String boringString = in.readLine();
                String startIndices = in.readLine();
                String endIndices = in.readLine();
                String operations = in.readLine();

                String stringFunny = funnyString.getFunnyString(boringString, parsing.parseListOfIndexToken(startIndices), parsing.parseListOfIndexToken(endIndices), parsing.parseListOfOperationToken(operations));


                funnyStringEntityRequest.setBoringString(boringString);
                funnyStringEntityRequest.setFunnyString(stringFunny);

                funnyStringEntity = funnyStringEntityMapper.toEntity(funnyStringEntityRequest);
                dbManager.insert(funnyStringEntity);
                long funny_id = dbManager.getFunnyId();

                operationRangeEntityRequest.setStartIndex(parsing.parseListOfIndexToken(startIndices));
                operationRangeEntityRequest.setEndIndex(parsing.parseListOfIndexToken(endIndices));
                operationRangeEntityRequest.setOperation(parsing.parseListOfOperationToken(operations));

                List<OperationRangeEntity> ranges = new OperationRangeEntityMapper().toEntity(operationRangeEntityRequest, funny_id);
                for (OperationRangeEntity operationRange : ranges) {
                    dbManager.insert(operationRange);
                }
                funnyStringEntityRequest = funnyStringEntityMapper.toRequest(funnyStringEntity);

                out.println("Boring_string : " + funnyStringEntityRequest.getBoringString());
                System.out.println(funnyStringEntityRequest.getBoringString());

                out.println("Fun_Range : " + funnyStringEntityRequest.getFunRange());
                System.out.println(funnyStringEntityRequest.getFunRange());

                out.println("Funny_string : " + funnyStringEntityRequest.getFunnyString());
                System.out.println(funnyStringEntityRequest.getFunnyString());


                break;
            }

            case GET_FUNRANGEBYID: {
                long id = Long.parseLong(in.readLine().trim());

                funnyStringEntity = (FunnyStringEntity) dbManager.getById(id, FunnyStringEntity.class);
                if (funnyStringEntity == null) {
                    out.println("No data found for ID " + id);
                    return;
                }
                funnyStringEntityRequest = funnyStringEntityMapper.toRequest(funnyStringEntity);

                out.println("Boring_string : " + funnyStringEntityRequest.getBoringString());
                System.out.println(funnyStringEntityRequest.getBoringString());

                out.println("Fun_Range : " + funnyStringEntityRequest.getFunRange());
                System.out.println(funnyStringEntityRequest.getFunRange());

                out.println("Funny_string : " + funnyStringEntityRequest.getFunnyString());
                System.out.println(funnyStringEntityRequest.getFunnyString());

                break;
            }
            default:
               System.out.println("No data found for ID ");
                break;


        }

//        funnyStringEntityRequest = funnyStringEntityMapper.toRequest(funnyStringEntity);
//
//        out.println("Boring_string : " + funnyStringEntityRequest.getBoringString());
//        System.out.println(funnyStringEntityRequest.getBoringString());
//
//        out.println("Fun_Range : " + funnyStringEntityRequest.getFunRange());
//        System.out.println(funnyStringEntityRequest.getFunRange());
//
//        out.println("Funny_string : " + funnyStringEntityRequest.getFunnyString());
//        System.out.println(funnyStringEntityRequest.getFunnyString());


        System.out.println("------------------------------------------");

    }
}
