package org.example.routerStrategyDecorator.stringFunifierStrategy;


import org.example.StringFunifier;
import org.example.database.DataBaseManager;
import org.example.dto.request.FunnyStringRequest;
import org.example.dto.response.FunnyStringResponse;
import org.example.entity.FunnyStringEntity;
import org.example.entity.OperationRangeEntity;
import org.example.factory.FactoryDependency;
import org.example.mapper.FunnyStringMapper;
import org.example.stringFunifierOperator.Operation;
import org.example.stringTokenToListParsing.IParsing;
import org.example.stringTokenToListParsing.Parsing;
import org.example.serverWithMultiClient.server.ClientOption;
import org.example.inputOutputSystem.input.InputStrategy;
import org.example.inputOutputSystem.output.OutputStrategy;

import java.io.IOException;
import java.util.List;

public class FunnyStringStrategy implements RouterStrategy<FunnyStringRequest, FunnyStringResponse> {
    private final IParsing parsing;
    private final StringFunifier funnyString;
    private final DataBaseManager dbManager;
    private final FunnyStringMapper mapper;


    public FunnyStringStrategy() {
        this.parsing = FactoryDependency.getDependency(Parsing.class);
        this.funnyString = FactoryDependency.getDependency(StringFunifier.class);
        this.dbManager = FactoryDependency.getDependency(DataBaseManager.class);
        this.mapper = FactoryDependency.getDependency(FunnyStringMapper.class);
    }


    @Override
    public ClientOption getOptionName() {
        return ClientOption.FUNNYSTRING;
    }

    @Override
    public FunnyStringRequest mapInputToRequestBody(InputStrategy inputStrategy) throws IOException {
        String boringString = inputStrategy.read();
        String startIndices = inputStrategy.read();
        String endIndices = inputStrategy.read();
        String operations = inputStrategy.read();

        FunnyStringRequest funnyStringRequest = new FunnyStringRequest();
        funnyStringRequest.setBoringString(boringString);
        funnyStringRequest.setStartIndices(startIndices);
        funnyStringRequest.setEndIndices(endIndices);
        funnyStringRequest.setOperations(operations);

        return funnyStringRequest;
    }

    @Override
    public FunnyStringResponse executeScenario(FunnyStringRequest request) {
        String boringString = request.getBoringString();
        List<Integer> startList = parsing.parseListOfIndexToken(request.getStartIndices());
        List<Integer> endList = parsing.parseListOfIndexToken(request.getEndIndices());
        List<Operation> opsList = parsing.parseListOfOperationToken(request.getOperations());

        String stringFunny = funnyString.getFunnyString(boringString, startList, endList, opsList);

        FunnyStringEntity funnyStringEntity = new FunnyStringEntity();
        funnyStringEntity.setBoringString(boringString);
        funnyStringEntity.setFunnyString(stringFunny);

        dbManager.insert(funnyStringEntity);
        long funnyId = dbManager.getFunnyId();


        for (int i = 0; i < startList.size(); i++) {
            OperationRangeEntity operationRangeEntity = new OperationRangeEntity();
            operationRangeEntity.setStartIndex(startList.get(i));
            operationRangeEntity.setEndIndex(endList.get(i));
            operationRangeEntity.setOperation(opsList.get(i).name());
            operationRangeEntity.setFunnyStringId(funnyId);
            dbManager.insert(operationRangeEntity);
        }

        return mapper.toResponse(funnyStringEntity, funnyId);
    }

    @Override
    public void sendOutPutMessage(FunnyStringResponse response, OutputStrategy outputStrategy) {
        outputStrategy.print("FunnyId: " + response.getFunnyId());
        outputStrategy.print("BoringString: " + response.getBoringString());
        outputStrategy.print("FunnyString: " + response.getFunnyString());
    }


}
