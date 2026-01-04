package org.example.socket_v2.server;


import org.example.StringFunifier;
import org.example.database.DataBaseManager;
import org.example.dto.FunnyStringEntityResponse;
import org.example.dto.OperationRangeEntityRequest;
import org.example.entity.FunnyStringEntity;
import org.example.entity.OperationRangeEntity;
import org.example.factory.FactoryDependency;
import org.example.mapper.FunnyStringEntityMapper;
import org.example.mapper.OperationRangeEntityMapper;
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

        ClientOption option = ClientOption.valueOf(in.readLine().toUpperCase());

        FunnyStringEntity funnyStringEntity ;
        FunnyStringEntityResponse funnyStringEntityResponse = new FunnyStringEntityResponse();
        FunnyStringEntityMapper funnyStringEntityMapper = new FunnyStringEntityMapper();

        // this  to edit because option null no read  client option
        switch (option) {
            case FUNRANGE: {
                String boring = in.readLine();
                String start = in.readLine();
                String end = in.readLine();

                String funRange = funnyString.getFunRanges(boring, parsing.parseListOfIndexToken(start), parsing.parseListOfIndexToken(end));

                funnyStringEntityResponse.setBoringString(boring);
                funnyStringEntityResponse.setFunRange(funRange);


                funnyStringEntity = funnyStringEntityMapper.toEntity(funnyStringEntityResponse);
                dbManager.insert(funnyStringEntity);
                long funny_Id = dbManager.getFunnyId();

                OperationRangeEntityRequest operationRangeEntityRequest =  createOperationRangeEntityRequest(start, end, null);


                List<OperationRangeEntity> ranges = new OperationRangeEntityMapper().toEntity(operationRangeEntityRequest, funny_Id);
                for (OperationRangeEntity operationRange : ranges) {
                    dbManager.insert(operationRange);
                }
                funnyStringEntityResponse = funnyStringEntityMapper.toRequest(funnyStringEntity);

                out.println("Boring_string : " + funnyStringEntityResponse.getBoringString());
                System.out.println(funnyStringEntityResponse.getBoringString());

                out.println("Fun_Range : " + funnyStringEntityResponse.getFunRange());
                System.out.println(funnyStringEntityResponse.getFunRange());

                out.println("Funny_string : " + funnyStringEntityResponse.getFunnyString());
                System.out.println(funnyStringEntityResponse.getFunnyString());


                break;
            }

            case FUNNYSTRING: {
                String boringString = in.readLine();
                String start = in.readLine();
                String end = in.readLine();
                String operation = in.readLine();

                String stringFunny = funnyString.getFunnyString(boringString, parsing.parseListOfIndexToken(start), parsing.parseListOfIndexToken(end), parsing.parseListOfOperationToken(operation));


                funnyStringEntityResponse.setBoringString(boringString);
                funnyStringEntityResponse.setFunnyString(stringFunny);


                funnyStringEntity = funnyStringEntityMapper.toEntity(funnyStringEntityResponse);
                dbManager.insert(funnyStringEntity);
                long funny_id = dbManager.getFunnyId();

                OperationRangeEntityRequest operationRangeEntityRequest =  createOperationRangeEntityRequest(start, end, operation);


                List<OperationRangeEntity> ranges = new OperationRangeEntityMapper().toEntity(operationRangeEntityRequest, funny_id);
                for (OperationRangeEntity operationRange : ranges) {
                    dbManager.insert(operationRange);
                }
                funnyStringEntityResponse = funnyStringEntityMapper.toRequest(funnyStringEntity);

                out.println("Boring_string : " + funnyStringEntityResponse.getBoringString());
                System.out.println(funnyStringEntityResponse.getBoringString());

                out.println("Fun_Range : " + funnyStringEntityResponse.getFunRange());
                System.out.println(funnyStringEntityResponse.getFunRange());

                out.println("Funny_string : " + funnyStringEntityResponse.getFunnyString());
                System.out.println(funnyStringEntityResponse.getFunnyString());


                break;
            }

            case GET_FUNRANGEBYID: {
                long id = Long.parseLong(in.readLine().trim());

                funnyStringEntity = (FunnyStringEntity) dbManager.getById(id, FunnyStringEntity.class);
                if (funnyStringEntity == null) {
                    out.println("No data found for ID " + id);
                    return;
                }
                funnyStringEntityResponse = funnyStringEntityMapper.toRequest(funnyStringEntity);

                out.println("Boring_string : " + funnyStringEntityResponse.getBoringString());
                System.out.println(funnyStringEntityResponse.getBoringString());

                out.println("Fun_Range : " + funnyStringEntityResponse.getFunRange());
                System.out.println(funnyStringEntityResponse.getFunRange());

                out.println("Funny_string : " + funnyStringEntityResponse.getFunnyString());
                System.out.println(funnyStringEntityResponse.getFunnyString());

                break;
            }
            default:
                System.out.println("No data found for ID ");
                break;


        }
        System.out.println("------------------------------------------");



    }
    private OperationRangeEntityRequest createOperationRangeEntityRequest(String start, String end, String operation){
        OperationRangeEntityRequest operationRangeEntityRequest = new OperationRangeEntityRequest();
        operationRangeEntityRequest.setStartIndices(parsing.parseListOfIndexToken(start));
        operationRangeEntityRequest.setEndIndices(parsing.parseListOfIndexToken(end));
        if(operation == null){
            operationRangeEntityRequest.setOperations(null);
        }else{
        operationRangeEntityRequest.setOperations(parsing.parseListOfOperationToken(operation));
        }

        return operationRangeEntityRequest;
    }
}

