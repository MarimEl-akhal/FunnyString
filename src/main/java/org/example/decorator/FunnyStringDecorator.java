package org.example.decorator;


import org.example.StringFunifier;
import org.example.database.DataBaseManager;
import org.example.dto.request.FunnyStringRequest;
import org.example.dto.response.FunnyStringResponse;
import org.example.entity.FunnyStringEntity;
import org.example.entity.OperationRangeEntity;
import org.example.factory.FactoryDependency;
import org.example.mapper.FunnyStringMapper;
import org.example.operator.Operation;
import org.example.parsingg.IParsing;
import org.example.parsingg.Parsing;
import org.example.socket_v2.server.ClientOption;
import org.example.strategy.input.InputStrategy;
import org.example.strategy.output.OutputStrategy;

import java.io.IOException;
import java.util.List;

public class FunnyStringDecorator implements RouterStrategy<FunnyStringRequest, FunnyStringResponse> {
    private final IParsing parsing;
    private final StringFunifier funnyString;
    private final DataBaseManager dbManager;
    private final FunnyStringMapper mapper;

    private FunnyStringRequest funnyStringRequest;

    private FunnyStringEntity funnyStringEntity;

    public FunnyStringDecorator() {
        this.parsing = FactoryDependency.getDependency(Parsing.class);
        this.funnyString = FactoryDependency.getDependency(StringFunifier.class);
        this.dbManager = FactoryDependency.getDependency(DataBaseManager.class);
        this.mapper =  FactoryDependency.getDependency(FunnyStringMapper.class);
    }


    @Override
    public ClientOption getOptionName() {
        return ClientOption.FUNNYSTRING;
    }

 @Override
    public FunnyStringRequest setInput(InputStrategy inputStrategy) throws IOException {
        String boringString = inputStrategy.read();
        String startIndices = inputStrategy.read();
        String endIndices = inputStrategy.read();
        String operations = inputStrategy.read();

        funnyStringRequest = new FunnyStringRequest();
        funnyStringRequest.setBoringString(boringString);
        funnyStringRequest.setStartIndices(startIndices);
        funnyStringRequest.setEndIndices(endIndices);
        funnyStringRequest.setOperations(operations);

        return funnyStringRequest;
    }

@Override
    public FunnyStringResponse executeScenario(FunnyStringRequest request) {
        String boringString = funnyStringRequest.getBoringString();
        List<Integer> startList = parsing.parseListOfIndexToken(funnyStringRequest.getStartIndices());
        List<Integer> endList = parsing.parseListOfIndexToken(funnyStringRequest.getEndIndices());
        List<Operation> opsList = parsing.parseListOfOperationToken(funnyStringRequest.getOperations());

        String stringFunny = funnyString.getFunnyString(boringString, startList, endList, opsList);

        saveFunnyStringEntityData(boringString, stringFunny);
        long funnyId = dbManager.getFunnyId();

        FunnyStringResponse response = mapper.toResponse(funnyStringEntity, funnyId);
        saveOperationRangeEntityData(startList, endList, opsList, funnyId);

        return response;
    }

@Override
    public void sendOutPutMessage(FunnyStringResponse response, OutputStrategy outputStrategy) {
        outputStrategy.print("FunnyId: " + response.getFunnyId());
        outputStrategy.print("BoringString: " + response.getBoringString());
        outputStrategy.print("FunnyString: " + response.getFunnyString());
    }

    private void saveFunnyStringEntityData(String boringString, String stringFunny) {
        funnyStringEntity = new FunnyStringEntity();
        funnyStringEntity.setBoringString(boringString);
        funnyStringEntity.setFunnyString(stringFunny);

        dbManager.insert(funnyStringEntity);
    }

    private void saveOperationRangeEntityData(List<Integer> startList, List<Integer> endList, List<Operation> operationList, long id) {

        OperationRangeEntity operationRangeEntity = new OperationRangeEntity();
        for (int i = 0; i < startList.size(); i++) {
            operationRangeEntity.setStartIndex(startList.get(i));
            operationRangeEntity.setEndIndex(endList.get(i));
            operationRangeEntity.setOperation(operationList.get(i).name());
        }
        operationRangeEntity.setFunnyStringId(id);
        dbManager.insert(operationRangeEntity);

    }


}
