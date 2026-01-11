package org.example;

import org.example.database.DataBaseManager;
import org.example.dto.StringFunifierRequest;
import org.example.dto.StringFunifierResponse;
import org.example.entity.FunnyStringEntity;
import org.example.entity.OperationRangeEntity;
import org.example.factory.FactoryDependency;
import org.example.mapper.FunnyStringEntityMapper;
import org.example.operator.Operation;
import org.example.parsingg.IParsing;
import org.example.parsingg.Parsing;
import org.example.socket_v2.server.ClientOption;
import org.example.strategy.InputStrategy;
import org.example.strategy.OutputStrategy;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Service {

    private final IParsing parsing;
    private final StringFunifier funnyString;
    private final DataBaseManager dbManager;
    private final FunnyStringEntityMapper mapper;
    private FunnyStringEntity funnyStringEntity;
    private OperationRangeEntity operationRangeEntity;


    public Service() {
        this.parsing = FactoryDependency.getDependency(Parsing.class);
        this.funnyString = FactoryDependency.getDependency(StringFunifier.class);
        this.dbManager = FactoryDependency.getDependency(DataBaseManager.class);
        this.mapper = FactoryDependency.getDependency(FunnyStringEntityMapper.class);
    }

    public void execute(
            InputStrategy inputStrategy,
            OutputStrategy outputStrategy
    ) throws IOException, InvocationTargetException, InstantiationException, IllegalAccessException {

        while (true) {
            String option = inputStrategy.read().toUpperCase();
            switch (ClientOption.valueOf(option)) {
                case FUNRANGE -> {
                    String boringString = inputStrategy.read();
                    String start = inputStrategy.read();
                    String end = inputStrategy.read();

                    StringFunifierRequest stringFunifierRequest = new StringFunifierRequest();
                    stringFunifierRequest.setBoringString(boringString);
                    stringFunifierRequest.setStartIndices(start);
                    stringFunifierRequest.setEndIndices(end);

//                    StringFunifierResponse response = FunRangeScenario(stringFunifierRequest);
                    StringFunifierResponse response = scenario(stringFunifierRequest,option);
                    outputStrategy.print("FunnyId: " + response.getFunnyId());
                    outputStrategy.print("BoringString: " + response.getBoringString());
                    outputStrategy.print("FunRange: " + response.getFunRange());
                    outputStrategy.print("FunnyString: " + response.getFunnyString());
                }
                case FUNNYSTRING -> {
                    String boringString = inputStrategy.read();
                    String start = inputStrategy.read();
                    String end = inputStrategy.read();
                    String op = inputStrategy.read();

                    StringFunifierRequest stringFunifierRequest = new StringFunifierRequest();
                    stringFunifierRequest.setBoringString(boringString);
                    stringFunifierRequest.setStartIndices(start);
                    stringFunifierRequest.setEndIndices(end);
                    stringFunifierRequest.setOperations(op);

//                    StringFunifierResponse response = FunnyStringScenario(stringFunifierRequest);
                    StringFunifierResponse response = scenario(stringFunifierRequest,option);
                    outputStrategy.print("FunnyId: " + response.getFunnyId());
                    outputStrategy.print("BoringString: " + response.getBoringString());
                    outputStrategy.print("FunnyString: " + response.getFunnyString());
                    outputStrategy.print("FunRange: " + response.getFunRange());
                }
                case GET_FUNRANGEBYID -> {
                    String id = inputStrategy.read();

                    StringFunifierRequest stringFunifierRequest = new StringFunifierRequest();
                    stringFunifierRequest.setFunnyId(id);
                    StringFunifierResponse response = GetFunifierStringByIdScenario(stringFunifierRequest);
                    outputStrategy.print("FunnyId: " + response.getFunnyId());
                    outputStrategy.print("BoringString: " + response.getBoringString());
                    outputStrategy.print("FunRange: " + response.getFunRange());
                    outputStrategy.print("FunnyString: " + response.getFunnyString());

                }
            }

        }
    }


    private StringFunifierResponse FunRangeScenario(StringFunifierRequest stringFunifierRequest) {
        String boringString = stringFunifierRequest.getBoringString();
        List<Integer> startList = parsing.parseListOfIndexToken(stringFunifierRequest.getStartIndices());
        List<Integer> endList = parsing.parseListOfIndexToken(stringFunifierRequest.getEndIndices());

        String funRange = funnyString.getFunRanges(boringString, startList, endList);


        funnyStringEntity = new FunnyStringEntity();
        funnyStringEntity.setBoringString(boringString);
        funnyStringEntity.setFunRange(funRange);

        dbManager.insert(funnyStringEntity);
        long funny_Id = dbManager.getFunnyId();


        StringFunifierResponse response = mapper.toResponse(funnyStringEntity, funny_Id);

        operationRangeEntity = new OperationRangeEntity();

        for (int i = 0; i < startList.size(); i++) {
            operationRangeEntity.setStartIndex(startList.get(i));
            operationRangeEntity.setEndIndex(endList.get(i));
        }
        operationRangeEntity.setFunnyStringId(funny_Id);
        dbManager.insert(operationRangeEntity);


        return response;
    }


    private StringFunifierResponse FunnyStringScenario(StringFunifierRequest stringFunifierRequest) {
        String boringString = stringFunifierRequest.getBoringString();
        List<Integer> startList = parsing.parseListOfIndexToken(stringFunifierRequest.getStartIndices());
        List<Integer> endList = parsing.parseListOfIndexToken(stringFunifierRequest.getEndIndices());
        List<Operation> opsList = parsing.parseListOfOperationToken(stringFunifierRequest.getOperations());

        String stringFunny = funnyString.getFunnyString(boringString, startList, endList, opsList);

        funnyStringEntity = new FunnyStringEntity();
        funnyStringEntity.setBoringString(boringString);
        funnyStringEntity.setFunnyString(stringFunny);

        dbManager.insert(funnyStringEntity);
        long funny_Id = dbManager.getFunnyId();

        StringFunifierResponse response = mapper.toResponse(funnyStringEntity, funny_Id);


        operationRangeEntity = new OperationRangeEntity();

        for (int i = 0; i < startList.size(); i++) {
            operationRangeEntity.setStartIndex(startList.get(i));
            operationRangeEntity.setEndIndex(endList.get(i));
        }
        operationRangeEntity.setFunnyStringId(funny_Id);
        dbManager.insert(operationRangeEntity);


        return response;
    }

    private StringFunifierResponse GetFunifierStringByIdScenario(StringFunifierRequest stringFunifierRequest) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        long id = Long.parseLong(stringFunifierRequest.getFunnyId());
        funnyStringEntity = (FunnyStringEntity) dbManager.getById(id, FunnyStringEntity.class);

        if (funnyStringEntity == null) {
            throw new Error("No data found for id " + id);
        }


        return mapper.toResponse(funnyStringEntity, id);
    }


    private StringFunifierResponse scenario(StringFunifierRequest request,String option){
        String boringString = request.getBoringString();
        List<Integer> startList = parsing.parseListOfIndexToken(request.getStartIndices());
        List<Integer> endList = parsing.parseListOfIndexToken(request.getEndIndices());
        List <Operation>  operations = new ArrayList<>() ;
        if (request.getOperations() != null) {
            operations = parsing.parseListOfOperationToken(request.getOperations());
        }else {
            request.setOperations(null);
        }


        if (ClientOption.valueOf(option) == ClientOption.FUNRANGE) {
            String funRange = funnyString.getFunRanges(boringString, startList, endList);
            funnyStringEntity = new FunnyStringEntity();
            funnyStringEntity.setBoringString(boringString);
            funnyStringEntity.setFunRange(funRange);
        }
        else if (ClientOption.valueOf(option)== ClientOption.FUNNYSTRING) {
            String stringFunny = funnyString.getFunnyString(boringString, startList, endList, operations);
            funnyStringEntity = new FunnyStringEntity();
            funnyStringEntity.setBoringString(boringString);
            funnyStringEntity.setFunnyString(stringFunny);
        }

        dbManager.insert(funnyStringEntity);
        long funny_Id = dbManager.getFunnyId();

        StringFunifierResponse response = mapper.toResponse(funnyStringEntity, funny_Id);


        operationRangeEntity = new OperationRangeEntity();

        for (int i = 0; i < startList.size(); i++) {
            operationRangeEntity.setStartIndex(startList.get(i));
            operationRangeEntity.setEndIndex(endList.get(i));
            if (request.getOperations() != null) {
                operationRangeEntity.setOperation(operations.get(i).name());
            }else{
                operationRangeEntity.setOperation(null);
            }

        }
        operationRangeEntity.setFunnyStringId(funny_Id);
        dbManager.insert(operationRangeEntity);


        return response;



    }
}

