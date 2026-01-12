package org.example.stringStrategy;

import org.example.StringFunifier;
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
import org.example.strategy.input.InputStrategy;
import org.example.strategy.output.OutputStrategy;

import java.io.IOException;
import java.util.List;

public class FunnyStringStrategy implements Strategy {
    private final IParsing parsing;
    private final StringFunifier funnyString;
    private final DataBaseManager dbManager;
    private final FunnyStringEntityMapper mapper;

    private StringFunifierRequest stringFunifierRequest;

    private FunnyStringEntity funnyStringEntity;

    public FunnyStringStrategy() {
        this.parsing = FactoryDependency.getDependency(Parsing.class);
        this.funnyString = FactoryDependency.getDependency(StringFunifier.class);
        this.dbManager = FactoryDependency.getDependency(DataBaseManager.class);
        this.mapper = FactoryDependency.getDependency(FunnyStringEntityMapper.class);

    }

    @Override
    public void setInput(InputStrategy inputStrategy) throws IOException {
        String boringString = inputStrategy.read();
        String startIndices = inputStrategy.read();
        String endIndices = inputStrategy.read();
        String operations = inputStrategy.read();

        stringFunifierRequest = new StringFunifierRequest();
        stringFunifierRequest.setBoringString(boringString);
        stringFunifierRequest.setStartIndices(startIndices);
        stringFunifierRequest.setEndIndices(endIndices);
        stringFunifierRequest.setOperations(operations);
    }

    @Override
    public StringFunifierResponse executeScenario(StringFunifierRequest request) {
        String boringString = stringFunifierRequest.getBoringString();
        List<Integer> startList = parsing.parseListOfIndexToken(stringFunifierRequest.getStartIndices());
        List<Integer> endList = parsing.parseListOfIndexToken(stringFunifierRequest.getEndIndices());
        List<Operation> opsList = parsing.parseListOfOperationToken(stringFunifierRequest.getOperations());

        String stringFunny = funnyString.getFunnyString(boringString, startList, endList, opsList);

        saveFunnyStringEntityData(boringString, stringFunny);
        long funnyId = dbManager.getFunnyId();

        StringFunifierResponse response = mapper.toResponse(funnyStringEntity, funnyId);
        saveOperationRangeEntityData(startList, endList, opsList, funnyId);

        return response;
    }

    @Override
    public void receiveOutPutMessage(OutputStrategy outputStrategy) {
        StringFunifierResponse response = executeScenario(stringFunifierRequest);
        outputStrategy.print("FunnyId: " + response.getFunnyId());
        outputStrategy.print("BoringString: " + response.getBoringString());
        outputStrategy.print("FunnyString: " + response.getFunnyString());
        outputStrategy.print("FunRange: " + response.getFunRange());
    }

    @Override
    public void run(InputStrategy inputStrategy, OutputStrategy outputStrategy) throws IOException {
        setInput(inputStrategy);
        executeScenario(stringFunifierRequest);
        receiveOutPutMessage(outputStrategy);
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
