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

        ClientOption option = ClientOption.valueOf(in.readLine().toUpperCase());

        // this  to edit because option null no read  client option
        switch (option) {
            case FUNRANGE: {
                String boring = in.readLine();

//                System.out.println(boring);
                String start = in.readLine();

                String end = in.readLine();


                String funRange = funnyString.getFunRanges(boring, parsing.parseListOfIndexToken(start), parsing.parseListOfIndexToken(end));

                FunnyStringEntityRequest funnyReq = new FunnyStringEntityRequest();
                funnyReq.setBoringString(boring);
                funnyReq.setFunRange(funRange);


                FunnyStringEntity funnyStringEntity = new FunnyStringEntityMapper().toEntity(funnyReq);
                dbManager.insert(funnyStringEntity);
                long funny_Id = dbManager.getFunnyId();

                OperationRangeEntityRequest operationRangeEntityRequest = new OperationRangeEntityRequest();
                operationRangeEntityRequest.setStartIndex(parsing.parseListOfIndexToken(start));
                operationRangeEntityRequest.setEndIndex(parsing.parseListOfIndexToken(end));
                operationRangeEntityRequest.setOperation(null);


                List<OperationRangeEntity> ranges = new OperationRangeEntityMapper().toEntity(operationRangeEntityRequest, funny_Id);
                for (OperationRangeEntity operationRange : ranges) {
                    dbManager.insert(operationRange);
                }

                out.println("inserted fun_range in database");
            }


            case FUNNYSTRING: {
                String boringString = in.readLine();
                String startIndices = in.readLine();
                String endIndices = in.readLine();
                String operations = in.readLine();

                String stringFunny = funnyString.getFunnyString(boringString, parsing.parseListOfIndexToken(startIndices), parsing.parseListOfIndexToken(endIndices), parsing.parseListOfOperationToken(operations));
                FunnyStringEntityRequest funnyStringEntityRequest = new FunnyStringEntityRequest();
                funnyStringEntityRequest.setBoringString(boringString);
                funnyStringEntityRequest.setFunnyString(stringFunny);

                FunnyStringEntity funnyStringEntity = new FunnyStringEntityMapper().toEntity(funnyStringEntityRequest);
                dbManager.insert(funnyStringEntity);
                long funny_id = dbManager.getFunnyId();

                OperationRangeEntityRequest operationRangeEntityRequest = new OperationRangeEntityRequest();
                operationRangeEntityRequest.setStartIndex(parsing.parseListOfIndexToken(startIndices));
                operationRangeEntityRequest.setEndIndex(parsing.parseListOfIndexToken(endIndices));
                operationRangeEntityRequest.setOperation(parsing.parseListOfOperationToken(operations));

                List<OperationRangeEntity> ranges = new OperationRangeEntityMapper().toEntity(operationRangeEntityRequest, funny_id);
                for (OperationRangeEntity operationRange : ranges) {
                    dbManager.insert(operationRange);
                }
                out.println("inserted funny_string in database");
            }

            case GET_FUNRANGEBYID:
                long id = Long.parseLong(in.readLine().trim());

                FunnyStringEntity funnyStringEntity = (FunnyStringEntity) dbManager.getById(id, FunnyStringEntity.class);
                if (funnyStringEntity == null) {
                    out.println("No data found for ID " + id);
//                    System.out.println("No data found for id " + id);
                    return;
                } else {

                    FunnyStringEntityMapper funnyStringEntityMapper = new FunnyStringEntityMapper();
                    FunnyStringEntityRequest funnyStringEntityRequest = funnyStringEntityMapper.toRequest(funnyStringEntity);

                    out.println("Boring_string : " + funnyStringEntityRequest.getBoringString());
                    System.out.println(funnyStringEntityRequest.getBoringString());

                    out.println("Fun_Range : " + funnyStringEntityRequest.getFunRange());
                    System.out.println(funnyStringEntityRequest.getFunRange());

                    out.println("Funny_string : " + funnyStringEntityRequest.getFunnyString());
                    System.out.println(funnyStringEntityRequest.getFunnyString());
                }
                break;

//
//                    case GET_FUNRANGE:
//                        id = get id;
//                        createFunStringEntity
//                                dbManager.get(FunStringEntity);
//                        send to user the data;
        }

    }
}
